package jp.begic.interpreter.functions;

import jp.begic.interpreter.commands.base.BArgs;
import jp.begic.interpreter.exception.BegicRunTimeException;
import jp.begic.interpreter.values.BDecimal;
import jp.begic.interpreter.values.BValue;

public class BAsDecimal implements BFunction {

	private int[] types = new int[] { BValue.BSTRING };

	@Override
	public BValue<?> calc(BArgs args) throws BegicRunTimeException {
		if (args.size() != types.length)
			throw new BegicRunTimeException("asDecimalの引数の数が不正です。");
		if (args.get(0).type() != types[0])
			throw new BegicRunTimeException("asDecimalの引数の型が不正です。");
		return new BDecimal((String) args.get(0).getValue());
	}

	@Override
	public int[] argsType() {
		return types;
	}

	@Override
	public int returnType() {
		return BValue.BDECIMAL;
	}

}
