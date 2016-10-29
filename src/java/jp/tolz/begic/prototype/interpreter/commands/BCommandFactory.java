package jp.tolz.begic.prototype.interpreter.commands;

import java.util.HashMap;

import jp.tolz.begic.prototype.interpreter.commands.base.BArgs;
import jp.tolz.begic.prototype.interpreter.exception.BegicRunTimeException;

/**
 * �R�}���h�̃C���X�^���X�Ǘ����s���܂��B
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
	 * �R�}���h���擾���܂��B
	 * @param commandName
	 * @return
	 * @throws BegicRunTimeException
	 */
	public BCommand getCommand(String commandName) throws BegicRunTimeException {
//		���t�@�N�^�����O�̓p�t�H�[�}���X�ƈ��S���𑹂Ȃ��\��������B
//		try {
//			Class<BCommand> cmd = (Class<BCommand>) Class.forName(commandName);
//		} catch (ClassNotFoundException e) {
//			throw new BegicRunTimeException("�w" + commandName + "�x" + "�R�}���h�͖���`�ł��B");
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
		case "input":
			if (!commands.containsKey("input"))
				commands.put("input", new BInput());
			return commands.get("input");
		case "line":
			if (!commands.containsKey("line"))
				commands.put("line", new BLine());
			return commands.get("line");
		default:
			break;
		}
		throw new BegicRunTimeException("�w" + commandName + "�x" + "�R�}���h�͖���`�ł��B");
	}
}
