package jp.tolz.begic.prototype.interpreter.commands;

import jp.tolz.begic.prototype.interpreter.commands.base.BArgs;
import jp.tolz.begic.prototype.interpreter.values.BColor;

class BHave extends BCommand {

	@Override
	public void exec(BArgs bargs) {
		g.setColor(((BColor) bargs.get(0)).getValue()); 
	}

}
