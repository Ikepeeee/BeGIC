package jp.begic.interpreter.functions;

import java.math.BigDecimal;

import jp.begic.interpreter.commands.base.BArgs;
import jp.begic.interpreter.exception.BegicRunTimeException;
import jp.begic.interpreter.values.BDecimal;
import jp.begic.interpreter.values.BValue;

class BSin implements BFunction {
	private int[] types = new int[] { BValue.BDECIMAL };

	// optimize!!
	@Override
	public BValue<?> calc(BArgs args) throws BegicRunTimeException {
		if (args.size() != types.length) 
			throw new BegicRunTimeException("sinの引数の数が不正です。");
		if (args.get(0).type() != types[0])
			throw new BegicRunTimeException("sinの引数の型が不正です。");
		BigDecimal arg = (BigDecimal) args.get(0).getValue();
		return new BDecimal(new BigDecimal(Math.sin(arg.doubleValue())));
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
