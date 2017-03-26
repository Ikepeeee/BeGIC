package jp.begic.interpreter.commands;

import java.util.HashMap;

import jp.begic.interpreter.exception.BegicRunTimeException;

/**
 * コマンドのインスタンス管理を行います。
 * 
 * @author Toru Ikeda
 *
 */
public class BCommandFactory {

	/* flyweight */
	HashMap<String, BCommand> commands = new HashMap<String, BCommand>();

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
		switch (commandName) {
		case "print":
			if (!commands.containsKey("print"))
				commands.put("print", new BPrint());
			return commands.get("print");
		case "puts":
			if (!commands.containsKey("puts"))
				commands.put("puts", new BPuts());
			return commands.get("puts");
		case "line":
			if (!commands.containsKey("line"))
				commands.put("line", new BLine());
			return commands.get("line");
		case "window":
			if (!commands.containsKey("window"))
				commands.put("window", new BWindow());
			return commands.get("window");
		case "have":
			if (!commands.containsKey("have"))
				commands.put("have", new BHave());
			return commands.get("have");
		case "point":
			if (!commands.containsKey("point"))
				commands.put("point", new BPoint());
			return commands.get("point");
		default:
			break;
		}
		throw new BegicRunTimeException("『" + commandName + "』" + "コマンドは未定義です。");
	}
}
