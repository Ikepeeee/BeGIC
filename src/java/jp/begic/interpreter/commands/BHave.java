package jp.begic.interpreter.commands;

import jp.begic.interpreter.commands.base.BArgs;
import jp.begic.interpreter.commands.base.BDrawCommand;
import jp.begic.interpreter.values.BColor;

class BHave extends BDrawCommand {
	private BArgs bargs = null;

	@Override
	public void exec(BArgs bargs) {
		this.bargs = bargs;
		canvas.push(this);
	}
	
	@Override
	public void draw() {
		g.setColor(((BColor) bargs.get(0)).getValue());
		bargs = null;
	}

	@Override
	public boolean isInUse() {
		return bargs != null;
	}

}
