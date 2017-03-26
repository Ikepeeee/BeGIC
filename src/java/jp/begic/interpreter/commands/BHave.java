package jp.begic.interpreter.commands;

import jp.begic.interpreter.commands.base.BArgs;
import jp.begic.interpreter.values.BColor;

class BHave extends BCommand {

	@Override
	public void exec(BArgs bargs) {
		g.setColor(((BColor) bargs.get(0)).getValue()); 
	}

}
