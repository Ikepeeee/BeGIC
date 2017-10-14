package jp.begic.interpreter.functions;

import jp.begic.interpreter.commands.base.BArgs;
import jp.begic.interpreter.exception.BegicRunTimeException;
import jp.begic.interpreter.values.BString;
import jp.begic.interpreter.values.BValue;

public class BAsString implements BFunction {

private int[] types = new int[] { BValue.BVALUE };
	
	@Override
	public BValue<?> calc(BArgs args) throws BegicRunTimeException {
		if (args.size() != types.length) 
			throw new BegicRunTimeException("asString‚Ìˆø”‚Ì”‚ª•s³‚Å‚·B");
		return new BString(args.get(0).toString());
	}

	@Override
	public int[] argsType() {
		return types;
	}

	@Override
	public int returnType() {
		return BValue.BSTRING;
	}

}
