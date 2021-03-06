package jp.begic.interpreter.commands;

import jp.begic.interpreter.commands.base.BArgs;
import jp.begic.interpreter.commands.base.BDrawCommand;
import jp.begic.interpreter.values.BDecimal;

class BPoint extends BDrawCommand {
	private BArgs bargs = null;

	@Override
	public void exec(BArgs bargs) {
		this.bargs = bargs;
		canvas.push(this);
	}

	@Override
	public void draw() {
		g.drawLine(((BDecimal) bargs.get(0)).getValue().intValue(), ((BDecimal) bargs.get(1)).getValue().intValue(),
				((BDecimal) bargs.get(0)).getValue().intValue(), ((BDecimal) bargs.get(1)).getValue().intValue());
		bargs = null;
	}

	@Override
	public boolean isInUse() {
		return bargs != null;
	}

}
