package jp.begic.interpreter.functions;

import java.util.Random;

import jp.begic.interpreter.commands.base.BArgs;
import jp.begic.interpreter.exception.BegicRunTimeException;
import jp.begic.interpreter.values.BDecimal;
import jp.begic.interpreter.values.BValue;

public class BRand implements BFunction {
	private int[] types = new int[] {};
	private Random rand = new Random(System.currentTimeMillis());

	@Override
	public BValue<?> calc(BArgs args) throws BegicRunTimeException {
		if(args.size() != types.length)
			throw new BegicRunTimeException("rand‚Íˆø”‚ğæ‚è‚Ü‚¹‚ñB");
		return new BDecimal(rand.nextDouble());
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
