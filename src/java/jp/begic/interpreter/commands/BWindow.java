package jp.begic.interpreter.commands;

import java.awt.Dimension;

import javax.swing.JFrame;

import jp.begic.interpreter.canvas.BCanvas;
import jp.begic.interpreter.commands.base.BArgs;
import jp.begic.interpreter.commands.base.BDrawCommand;
import jp.begic.interpreter.values.BDecimal;

/**
 * 描画用のウインドウのサイズの変更を行います。 ウインドウの表示は実行時に自動的に生成されます。
 * 
 * @author toru ikeda
 *
 */
class BWindow extends BDrawCommand {
	private BArgs args = null;
	private boolean ready = false;

	@Override
	public void exec(BArgs bargs) {
		if (frame == null) {
			Thread canvasThread = new Thread() {
				@Override
				public void run() {

					frame = new JFrame("BeGIC Canvas");
					canvas = new BCanvas(frame);
					frame.add(canvas);

					// if (frame.getContentPane().getPreferredSize().getWidth()
					// != ((BFloat) bargs.get(0)).getValue()
					// .intValue()
					// || frame.getContentPane().getPreferredSize().getHeight()
					// != ((BFloat) bargs.get(1))
					// .getValue().intValue()) {
					// frame.setResizable(true);
					// frame.getContentPane()
					// .setPreferredSize(new Dimension(((BFloat)
					// bargs.get(0)).getValue().intValue(),
					// ((BFloat) bargs.get(1)).getValue().intValue()));
					// frame.pack();
					// frame.setResizable(false);
					// }

					frame.setResizable(true);
					frame.getContentPane().setPreferredSize(new Dimension(((BDecimal) bargs.get(0)).getValue().intValue(),
							((BDecimal) bargs.get(1)).getValue().intValue()));
					frame.pack();
					frame.setResizable(false);

					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setVisible(true);

					ready = true;

				}
			};
			canvasThread.start();

			while (!ready)
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

		} else
			throw new RuntimeException("windowコマンドは2度使えません。");

	}

	@Override
	public void draw() {

	}

	@Override
	public boolean isInUse() {
		return false;
	}

}
