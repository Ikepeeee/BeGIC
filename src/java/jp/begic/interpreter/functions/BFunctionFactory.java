package jp.begic.interpreter.functions;

import java.util.HashMap;

/**
 * 関数のインスタンス管理を行います。SingletonとFlyweightパターンを利用しています。
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

	private BFunction createFunction(String name) {
		switch (name) {
		case "sin":
			return new BSin();
		case "cos":
			return new BCos();
		case "tan":
			return new BTan();
		case "sinh":
			return new BSinh();
		case "cosh":
			return new BCosh();
		case "tanh":
			return new BTanh();
		case "sqrt":
			return new BSqrt();
		case "exp":
			return new BExp();
		case "input":
			return new BInput();
		default:
			break;
		}
		return null;
	}

}
