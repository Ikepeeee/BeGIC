package jp.begic.interpreter.canvas;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.swing.JFrame;

import jp.begic.interpreter.commands.BCommand;
import jp.begic.interpreter.parser.BegicParser;
import jp.begic.interpreter.parser.ParseException;
import jp.begic.interpreter.process.BegicVisitor;

/**
 * BeGIC�p�̃L�����p�X�ł��B BDrawer���ق��ĕ`�ʂ����܂��B
 * 
 * @author Toru Ikeda
 *
 */
public class BCanvas extends Canvas {
	private String code = null;
	private JFrame frame = null;
	
	public BCanvas(JFrame frame, String code) {
		this.frame = frame;
		this.code = code;
		this.setBackground(Color.WHITE);
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(Color.black);

		// �`�ʂ̌Ăяo��
		InputStream stream = new ByteArrayInputStream(code.getBytes());
		BegicParser parser = new BegicParser(stream);
		BegicVisitor visitor = new BegicVisitor();
		BCommand.set(frame, this, g);
		try {
			parser.Program().jjtAccept(visitor, null);

		} catch (ParseException e) {
			System.err.println("�\���G���[");
			e.printStackTrace();
			System.exit(0);
		}

	}

}