package jp.begic.interpreter.commands;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import jp.begic.interpreter.commands.base.BCommand;
import jp.begic.interpreter.exception.BegicRunTimeException;

/**
 * コマンドのインスタンス管理を行います。
 * 
 * @author Toru Ikeda
 *
 */
public class BCommandFactory {

	/* flyweight */
	HashMap<String, BCommand> commands = new HashMap<String, BCommand>(){
		{
			put("print", new BPrint());
			put("puts", new BPuts());
			put("line", new BLine());
			put("window", new BWindow());
			put("have", new BHave());
			put("point", new BPoint());
			put("circle", new BCircle());
			put("box", new BBox());
			put("background", new BBackground());
			put("sleep", new BSleep());
		}	
	};

	/* singleton */
	private BCommandFactory() {
	}

	private static BCommandFactory instance = new BCommandFactory();

	public static BCommandFactory getInstance() {
		return instance;
	}

	/**
	 * コマンドを取得します。
	 * @param commandName
	 * @return
	 * @throws BegicRunTimeException
	 */
	public BCommand getCommand(String commandName) throws BegicRunTimeException {
//		リファクタリングはパフォーマンスと安全性を損なう可能性がある。
//		try {
//			Class<BCommand> cmd = (Class<BCommand>) Class.forName(commandName);
//		} catch (ClassNotFoundException e) {
//			throw new BegicRunTimeException("『" + commandName + "』" + "コマンドは未定義です。");
//		} 
		

		if (!commands.containsKey(commandName))
			throw new BegicRunTimeException("『" + commandName + "』" + "コマンドは未定義です。");
		
		// コマンドの使用が解除されるまで待機
		while(commands.get(commandName).isInUse());
		
		return commands.get(commandName);
		
	}
}
