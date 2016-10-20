package jp.tolz.begic.prototype.interpreter.commands;


import jp.tolz.begic.prototype.interpreter.commands.base.BArgs;
import jp.tolz.begic.prototype.interpreter.commands.base.BCommand;

/**
 * ü‚Ì•`Ê‚ğs‚¢‚Ü‚·B
 * @author toru
 *
 */
class BLine extends BCommand {

	public BLine(BArgs bargs) {
		super(bargs);
	}

	@Override
	public void exec() {
		
//		canvas.getGraphics().drawLine(bargs.get(0).toString(), 0, 100, 100);
	}

}
