package jp.begic.interpreter.canvas;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Deque;
import java.util.concurrent.LinkedBlockingDeque;

import javax.swing.JFrame;

import jp.begic.interpreter.commands.base.BDrawCommand;

/**
 * BeGIC�p�̃L�����o�X�ł��B BDrawer���ق��ĕ`�ʂ����܂��B
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
	 * ���̕`�ʏ������I����Apaint�֐��𔲂��o���܂��B
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
		// �R�}���h���L�����o�X��ҏW�ł�������
		BDrawCommand.set(frame, this, g);
		while (true) {
			BDrawCommand cmd = pop();
			cmd.draw();
			if(ret)
				break;
		}

	}

}
