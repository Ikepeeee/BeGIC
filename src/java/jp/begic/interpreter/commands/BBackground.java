package jp.begic.interpreter.commands;

import java.awt.Color;

import jp.begic.interpreter.commands.base.BArgs;
import jp.begic.interpreter.commands.base.BDrawCommand;
import jp.begic.interpreter.values.BColor;

public class BBackground extends BDrawCommand {

	private BArgs bargs = null;

	@Override
	public void exec(BArgs bargs) {
		this.bargs = bargs;
		canvas.push(this);
	}

	@Override
	public void draw() {
		Color col = ((BColor) bargs.get(0)).getValue();
		Color pre = g.getColor();
		g.setColor(col);
		g.fillRect(0, 0, (int) Math.ceil(canvas.getBounds().getWidth()),
				(int) Math.ceil(canvas.getBounds().getHeight()));
		g.setColor(pre);
		bargs = null;
	}

	@Override
	public boolean isInUse() {
		return bargs != null;
	}

}
