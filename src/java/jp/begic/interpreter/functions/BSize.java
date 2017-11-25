package jp.begic.interpreter.functions;

import jp.begic.interpreter.commands.base.BArgs;
import jp.begic.interpreter.exception.BegicRunTimeException;
import jp.begic.interpreter.values.BHash;
import jp.begic.interpreter.values.BList;
import jp.begic.interpreter.values.BValue;
import jp.begic.interpreter.values.base.IBCollection;

class BSize implements BFunction {

	@Override
	public BValue<?> calc(BArgs args) throws BegicRunTimeException {
		if(!((args.get(0) instanceof BList) || (args.get(0) instanceof BHash)) || args.size() != 1)
			throw new BegicRunTimeException("sizeの引数はコレクションのみです。");
		return ((IBCollection) args.get(0)).size();
	}

	@Override
	public int[] argsType() {
		return null;
	}

	@Override
	public int returnType() {
		return BValue.BDECIMAL;
	}

}
