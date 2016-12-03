package jp.tolz.begic.prototype.interpreter.commands;

import jp.tolz.begic.prototype.interpreter.commands.base.BArgs;
import jp.tolz.begic.prototype.interpreter.values.BFloat;

class BPoint extends BCommand {

	@Override
	public void exec(BArgs bargs) {
		g.drawLine(((BFloat) bargs.get(0)).getValue().intValue(),
				((BFloat) bargs.get(1)).getValue().intValue(),
				((BFloat) bargs.get(0)).getValue().intValue(),
				((BFloat) bargs.get(1)).getValue().intValue());
	}

}
