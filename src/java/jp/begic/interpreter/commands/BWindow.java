package jp.begic.interpreter.commands;

import java.awt.Dimension;

import javax.swing.JFrame;

import jp.begic.interpreter.canvas.BCanvas;
import jp.begic.interpreter.commands.base.BArgs;
import jp.begic.interpreter.commands.base.BDrawCommand;
import jp.begic.interpreter.values.BDecimal;

/**
 * �`��p�̃E�C���h�E�̃T�C�Y�̕ύX���s���܂��B �E�C���h�E�̕\���͎��s���Ɏ����I�ɐ�������܂��B
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
			throw new RuntimeException("window�R�}���h��2�x�g���܂���B");

	}

	@Override
	public void draw() {

	}

	@Override
	public boolean isInUse() {
		return false;
	}

}
