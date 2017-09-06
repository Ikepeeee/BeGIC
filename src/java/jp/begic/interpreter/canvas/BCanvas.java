package jp.begic.interpreter.canvas;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

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
	private Queue<BDrawCommand> drawList = new LinkedBlockingQueue<>(1);
	
	public BCanvas(JFrame frame) {
		this.frame = frame;
		this.setBackground(Color.WHITE);
	}
	
	public void push(BDrawCommand cmd) {
		while(!drawList.offer(cmd));
	}
	
	private BDrawCommand pop() {
		BDrawCommand cmd = null;
		while((cmd = drawList.poll()) == null);
		return cmd;
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(Color.black);
		// コマンドがキャンバスを編集できる情報を提供
		BDrawCommand.set(frame, this, g);
		while (true) {
			BDrawCommand cmd = pop();
			cmd.draw();
		}

	}

}
