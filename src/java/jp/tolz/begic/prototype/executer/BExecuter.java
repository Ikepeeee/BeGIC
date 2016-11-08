package jp.tolz.begic.prototype.executer;

import java.io.InputStream;

import javax.swing.JFrame;

import jp.tolz.begic.prototype.interpreter.canvas.BCanvas;

/**
 * BeGIC実行を行うクラス。 一回で実行される場合のタイプです。
 * 
 * @author Toru Ikeda
 *
 */
public class BExecuter implements Executer {

	@Override
	public void exec(InputStream code) {
		JFrame frame = new JFrame("BeGIC Canvas");
		BCanvas canvas = new BCanvas(code);
		frame.add(canvas);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 250);
		frame.setVisible(true);
	}

}
