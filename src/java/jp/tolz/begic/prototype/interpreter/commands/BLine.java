package jp.tolz.begic.prototype.interpreter.commands;


import jp.tolz.begic.prototype.interpreter.commands.base.BArgs;
import jp.tolz.begic.prototype.interpreter.commands.base.Command;

/**
 * ü‚Ì•`Ê‚ğs‚¢‚Ü‚·B
 * @author toru
 *
 */
public class BLine extends Command {

	public BLine(BArgs bargs) {
		super(bargs);
	}

	@Override
	public void exec() {
		canvas.getGraphics().drawLine(0, 0, 100, 100);
	}

}
