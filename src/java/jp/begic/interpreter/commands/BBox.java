package jp.begic.interpreter.commands;

import jp.begic.interpreter.commands.base.BArgs;
import jp.begic.interpreter.commands.base.BDrawCommand;
import jp.begic.interpreter.values.BDecimal;

/**
 * â~Çï`é ÇµÇ‹Ç∑ÅB
 * @author toru
 *
 */
public class BBox extends BDrawCommand {

	private BArgs bargs = null;

	@Override
	public void exec(BArgs bargs) {
		this.bargs = bargs;
		canvas.push(this);
	}

	@Override
	public void draw() {
		int x1 = ((BDecimal) bargs.get(0)).getValue().intValue();
		int y1 = ((BDecimal) bargs.get(1)).getValue().intValue();
		int x2 = ((BDecimal) bargs.get(2)).getValue().intValue();
		int y2 = ((BDecimal) bargs.get(3)).getValue().intValue();
		if(x2 < x1) {
			int temp = x1;
			x1 = x2;
			x2 = temp;
		}
		if(y2 < y1) {
			int temp = y1;
			y1 = y2;
			y2 = temp;
		}
		g.drawRect(x1, y1, x2 - x1, y2 - y1);

		bargs = null;
	}

	@Override
	public boolean isInUse() {
		return bargs != null;
	}

}
