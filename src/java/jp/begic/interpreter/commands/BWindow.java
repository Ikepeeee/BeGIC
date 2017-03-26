package jp.begic.interpreter.commands;

import java.awt.Dimension;

import javax.swing.JFrame;

import jp.begic.interpreter.commands.base.BArgs;
import jp.begic.interpreter.values.BFloat;

/**
 * 描画用のウインドウのサイズの変更を行います。 ウインドウの表示は実行時に自動的に生成されます。
 * 
 * @author toru ikeda
 *
 */
class BWindow extends BCommand {

	@Override
	public void exec(BArgs bargs) {
		frame.setVisible(true);
		if (frame.getContentPane().getPreferredSize().getWidth() != ((BFloat) bargs
				.get(0)).getValue().intValue()
				|| frame.getContentPane().getPreferredSize().getHeight() != ((BFloat) bargs
						.get(1)).getValue().intValue()) {
			frame.setResizable(true);
			frame.getContentPane().setPreferredSize(
					new Dimension(
							((BFloat) bargs.get(0)).getValue().intValue(),
							((BFloat) bargs.get(1)).getValue().intValue()));
			frame.pack();
			frame.setResizable(false);
		}
	}

}
