package jp.begic.interpreter.commands;

import jp.begic.interpreter.commands.base.BArgs;
import jp.begic.interpreter.values.BFloat;

/**
 * ü‚Ì•`Ê‚ğs‚¢‚Ü‚·B
 * 
 * @author toru
 *
 */
class BLine extends BCommand {

	@Override
	public void exec(BArgs bargs) {
		g.drawLine(((BFloat) bargs.get(0)).getValue().intValue(),
				((BFloat) bargs.get(1)).getValue().intValue(),
				((BFloat) bargs.get(2)).getValue().intValue(),
				((BFloat) bargs.get(3)).getValue().intValue());
	}

}
