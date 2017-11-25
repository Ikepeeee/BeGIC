package jp.begic.interpreter.commands;

import jp.begic.interpreter.commands.base.BArgs;
import jp.begic.interpreter.commands.base.BDrawCommand;
import jp.begic.interpreter.values.BDecimal;

public class BFillCircle extends BDrawCommand {

	private BArgs bargs = null;

	@Override
	public void exec(BArgs bargs) {
		this.bargs = bargs;
		canvas.push(this);
	}

	@Override
	public void draw() {
		int x = ((BDecimal) bargs.get(0)).getValue().intValue();
		int y = ((BDecimal) bargs.get(1)).getValue().intValue();
		int r = ((BDecimal) bargs.get(2)).getValue().intValue();
		g.fillArc(x - r, y - r, r * 2, r * 2, 0, 360);
		bargs = null;
	}

	@Override
	public boolean isInUse() {
		return bargs != null;
	}

}

