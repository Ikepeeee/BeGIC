package jp.tolz.begic.prototype.interpreter.commands;

import java.awt.Color;

import jp.tolz.begic.prototype.interpreter.commands.base.BArgs;
import jp.tolz.begic.prototype.interpreter.values.BFloat;

/**
 * ê¸ÇÃï`é ÇçsÇ¢Ç‹Ç∑ÅB
 * 
 * @author toru
 *
 */
class BLine extends BCommand {

	@Override
	public void exec(BArgs bargs) {
		canvas.add("line", bargs);
		g.setColor(Color.BLACK);
		g.drawLine(((BFloat) bargs.get(0)).getValue().intValue(),
				((BFloat) bargs.get(1)).getValue().intValue(),
				((BFloat) bargs.get(2)).getValue().intValue(),
				((BFloat) bargs.get(3)).getValue().intValue());
	}

}
