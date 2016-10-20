package jp.tolz.begic.prototype.interpreter.functions;

import java.util.HashMap;

import jp.tolz.begic.prototype.interpreter.values.BValue;

/**
 * �֐��̃C���X�^���X�Ǘ����s���܂��BSingleton��Flyweight�p�^�[���𗘗p���Ă��܂��B
 * 
 * @author Toru Ikeda
 *
 */
public class BFunctionFactory {
	private HashMap<String, BFunction> funcs = new HashMap<String, BFunction>();

	/**
	 * Singleton
	 */
	private BFunctionFactory() {
	}

	private static BFunctionFactory instace = new BFunctionFactory();

	public static BFunctionFactory getInstance() {
		return instace;
	}

	public BFunction getFunction(String funcName) {
		if (funcs.get(funcName) == null) {
			BFunction func = createFunction(funcName);
			funcs.put(funcName, func);
		}
		return funcs.get(funcName);
	}

	public BFunction createFunction(String name) {
		switch (name) {
		case "sin":
			return new BSin();
		default:
			break;
		}
		return null;
	}

}
