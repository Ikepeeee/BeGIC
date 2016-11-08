package jp.tolz.begic.prototype.interpreter.canvas;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.io.InputStream;

import jp.tolz.begic.prototype.interpreter.commands.BCommand;
import jp.tolz.begic.prototype.interpreter.commands.base.BArgs;
import jp.tolz.begic.prototype.interpreter.parser.BegicParser;
import jp.tolz.begic.prototype.interpreter.parser.ParseException;
import jp.tolz.begic.prototype.interpreter.process.BegicVisitor;

/**
 * BeGIC�p�̃L�����p�X�ł��B
 * BDrawer���ق��ĕ`�ʂ����܂��B
 * @author Toru Ikeda
 *
 */
public class BCanvas extends Canvas{
	public InputStream code = null;
	
	public BCanvas(InputStream code){
		this.code = code;
	}
	
	@Override
	public void paint(Graphics g){
		// �`�ʂ̌Ăяo��
		BegicParser parser = new BegicParser(code);
		BegicVisitor visitor = new BegicVisitor();
		try {
			parser.Program().jjtAccept(visitor, null);
		} catch (ParseException e) {
			System.err.println("�\���G���[");
			e.printStackTrace();
			System.exit(0);
		}
	}
}
