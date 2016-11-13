package jp.tolz.begic.prototype.interpreter.canvas;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;

import jp.tolz.begic.prototype.interpreter.commands.BCommand;
import jp.tolz.begic.prototype.interpreter.commands.BCommandFactory;
import jp.tolz.begic.prototype.interpreter.commands.base.BArgs;
import jp.tolz.begic.prototype.interpreter.parser.BegicParser;
import jp.tolz.begic.prototype.interpreter.parser.ParseException;
import jp.tolz.begic.prototype.interpreter.process.BegicVisitor;

/**
 * BeGIC�p�̃L�����p�X�ł��B BDrawer���ق��ĕ`�ʂ����܂��B
 * 
 * @author Toru Ikeda
 *
 */
public class BCanvas extends Canvas {
	private JFrame frame = null;
	private InputStream code = null;
	private List<DrawProperty> drawList = null;
	private boolean addable = false;

	public BCanvas(JFrame frame, InputStream code) {
		this.frame = frame;
		this.code = code;
		this.setBackground(Color.WHITE);
	}

	public void add(String command, BArgs args) {
		if(addable)
			drawList.add(new DrawProperty(command, args));
	}

	@Override
	public void paint(Graphics g) {
		if (drawList == null) {
			drawList = new ArrayList<DrawProperty>();
			addable = true;
			// �`�ʂ̌Ăяo��
			BegicParser parser = new BegicParser(code);
			BegicVisitor visitor = new BegicVisitor();
			BCommand.set(frame, this, g);
			try {
				parser.Program().jjtAccept(visitor, null);
			} catch (ParseException e) {
				System.err.println("�\���G���[");
				e.printStackTrace();
				System.exit(0);
			}
			addable = false;
		} else {
			BCommand.set(frame, this, g);
			for (int i = 0; i < drawList.size(); i++) {
				try {
					BCommandFactory.getInstance()
							.getCommand(drawList.get(i).command)
							.exec(drawList.get(i).args);
				} catch (Exception e) {
					// TODO �����������ꂽ catch �u���b�N
					e.printStackTrace();
				}
			}
		}
	}

	private class DrawProperty {
		private String command = null;
		private BArgs args = null;

		private DrawProperty(String command, BArgs args) {
			this.command = command;
			this.args = args;
		}
	}
}
