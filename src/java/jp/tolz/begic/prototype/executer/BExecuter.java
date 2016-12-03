package jp.tolz.begic.prototype.executer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

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
	public void exec(InputStream stream) {
		BufferedReader br = new BufferedReader(new InputStreamReader(stream));

		String code = "";
		String line = null;

		try {
			while ((line = br.readLine()) != null)
				code = code.concat("\n".concat(line));
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		JFrame frame = new JFrame("BeGIC Canvas");
		BCanvas canvas = new BCanvas(frame, code);
		frame.add(canvas);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.add(canvas);
	}

}
