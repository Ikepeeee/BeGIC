package jp.begic.interpreter.commands;

import jp.begic.interpreter.commands.base.BArgs;
import jp.begic.interpreter.commands.base.BDrawCommand;
import jp.begic.interpreter.values.BFloat;

/**
 * ê¸ÇÃï`é ÇçsÇ¢Ç‹Ç∑ÅB
 * 
 * @author toru
 *
 */
class BLine extends BDrawCommand {
	private BArgs bargs = null;
	
	@Override
	public void exec(BArgs bargs) {
		this.bargs = bargs;
		canvas.push(this);
	}

	@Override
	public void draw() {
		g.drawLine(((BFloat) bargs.get(0)).getValue().intValue(),
				((BFloat) bargs.get(1)).getValue().intValue(),
				((BFloat) bargs.get(2)).getValue().intValue(),
				((BFloat) bargs.get(3)).getValue().intValue());
		bargs = null;
	}

	@Override
	public boolean isInUse() {
		return bargs != null;
	}

}
