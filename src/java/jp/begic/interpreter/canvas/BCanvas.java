package jp.begic.interpreter.canvas;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Deque;
import java.util.concurrent.LinkedBlockingDeque;

import javax.swing.JFrame;

import jp.begic.interpreter.commands.base.BDrawCommand;

/**
 * BeGIC用のキャンバスです。 BDrawerを雇って描写させます。
 * 
 * @author Toru Ikeda
 *
 */
public class BCanvas extends Canvas {
	private JFrame frame = null;
	private Deque<BDrawCommand> drawList = new LinkedBlockingDeque<>();
	private boolean ret = false;

	public BCanvas(JFrame frame) {
		this.frame = frame;
		this.setBackground(Color.WHITE);
	}

	public void push(BDrawCommand cmd) {
		while (!drawList.offer(cmd))
			;
	}
	
	public void unshift(BDrawCommand cmd) {
		drawList.addFirst(cmd)
			;
	}
	
	/**
	 * 今の描写処理が終了後、paint関数を抜け出します。
	 */
	public synchronized void returnPaint(boolean b){
		ret = b;
	}

	private BDrawCommand pop() {
		BDrawCommand cmd = null;
		while ((cmd = drawList.poll()) == null)
			;
		return cmd;
	}

	@Override
	public void paint(Graphics g) {
		ret = false;
		g.setColor(Color.black);
		// コマンドがキャンバスを編集できる情報を提供
		BDrawCommand.set(frame, this, g);
		while (true) {
			BDrawCommand cmd = pop();
			cmd.draw();
			if(ret)
				break;
		}

	}

}
