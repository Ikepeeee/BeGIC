package jp.tolz.begic.prototype.interpreter.commands;

import jp.tolz.begic.prototype.interpreter.commands.base.BArgs;
import jp.tolz.begic.prototype.interpreter.values.BFloat;

/**
 * 描画用のウインドウのサイズの変更を行います。 ウインドウの表示は実行時に自動的に生成されます。
 * 
 * @author toru ikeda
 *
 */
class BWindow extends BCommand {

	@Override
	public void exec(BArgs bargs) {
		frame.setSize(((BFloat) bargs.get(0)).getValue().intValue(),
				((BFloat) bargs.get(1)).getValue().intValue());
	}

}
