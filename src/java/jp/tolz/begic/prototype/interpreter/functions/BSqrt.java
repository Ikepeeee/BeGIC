package jp.tolz.begic.prototype.interpreter.functions;

import java.math.BigDecimal;

import jp.tolz.begic.prototype.interpreter.commands.base.BArgs;
import jp.tolz.begic.prototype.interpreter.exception.BegicRunTimeException;
import jp.tolz.begic.prototype.interpreter.values.BFloat;
import jp.tolz.begic.prototype.interpreter.values.BValue;

class BSqrt implements BFunction {

	private int[] types = new int[] { BValue.BFLOAT };

	@Override
	public BValue<?> calc(BArgs args) throws BegicRunTimeException {
		if (args.size() != types.length) 
			throw new BegicRunTimeException("sqrtの引数の数が不正です。");
		if (args.get(0).type() != types[0])
			throw new BegicRunTimeException("sqrtの引数の型が不正です。");
		BigDecimal arg = (BigDecimal) args.get(0).getValue();
		return new BFloat(new BigDecimal(Math.sqrt(arg.doubleValue())));
	}

	@Override
	public int[] argsType() {
		return types;
	}

	@Override
	public int returnType() {
		return BValue.BFLOAT;
	}

}
