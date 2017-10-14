package jp.begic.interpreter.functions;

import java.math.BigDecimal;

import jp.begic.interpreter.commands.base.BArgs;
import jp.begic.interpreter.exception.BegicRunTimeException;
import jp.begic.interpreter.values.BDecimal;
import jp.begic.interpreter.values.BValue;

class BTan implements BFunction {

	private int[] types = new int[] { BValue.BDECIMAL };

	@Override
	public BValue<?> calc(BArgs args) throws BegicRunTimeException {
		if (args.size() != types.length) 
			throw new BegicRunTimeException("tan�̈����̐����s���ł��B");
		if (args.get(0).type() != types[0])
			throw new BegicRunTimeException("tan�̈����̌^���s���ł��B");
		BigDecimal arg = (BigDecimal) args.get(0).getValue();
		return new BDecimal(new BigDecimal(Math.tan(arg.doubleValue())));
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
