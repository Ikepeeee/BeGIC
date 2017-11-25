package jp.begic.interpreter.commands;

import jp.begic.interpreter.commands.base.BArgs;
import jp.begic.interpreter.commands.base.BCommand;
import jp.begic.interpreter.values.BList;

public class BAdd extends BCommand {

	@Override
	public void exec(BArgs bargs) {
		((BList) bargs.get(0)).push(null, bargs.get(1));
	}

	@Override
	public boolean isInUse() {
		return false;
	}

}
