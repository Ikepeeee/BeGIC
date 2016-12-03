package jp.tolz.begic.prototype.interpreter.canvas;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.swing.JFrame;

import jp.tolz.begic.prototype.interpreter.commands.BCommand;
import jp.tolz.begic.prototype.interpreter.parser.BegicParser;
import jp.tolz.begic.prototype.interpreter.parser.ParseException;
import jp.tolz.begic.prototype.interpreter.process.BegicVisitor;

/**
 * BeGIC用のキャンパスです。 BDrawerを雇って描写させます。
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

		// 描写の呼び出し
		InputStream stream = new ByteArrayInputStream(code.getBytes());
		BegicParser parser = new BegicParser(stream);
		BegicVisitor visitor = new BegicVisitor();
		BCommand.set(frame, this, g);
		try {
			parser.Program().jjtAccept(visitor, null);

		} catch (ParseException e) {
			System.err.println("構文エラー");
			e.printStackTrace();
			System.exit(0);
		}

	}

}
