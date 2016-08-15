package jp.tolz.begic.prototype.interpreter.canvas;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import jp.tolz.begic.prototype.interpreter.commands.BLine;
import jp.tolz.begic.prototype.interpreter.commands.base.BArgs;
import jp.tolz.begic.prototype.interpreter.commands.base.Command;

/**
 * BeGIC�p�̃L�����p�X�ł��B
 * BDrawer���ق��ĕ`�ʂ����܂��B
 * @author Toru Ikeda
 *
 */
public class BCanvas extends Canvas{
	
	public void paint(Graphics g){
		g.setColor(Color.BLACK);
		Command line = new BLine(new BArgs(new Object[]{}));
		line.exec();
	}
}
