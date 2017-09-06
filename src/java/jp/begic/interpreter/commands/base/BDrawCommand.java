package jp.begic.interpreter.commands.base;

import java.awt.Graphics;

import javax.swing.JFrame;

import jp.begic.interpreter.canvas.BCanvas;

public abstract class BDrawCommand extends BCommand {
	protected static JFrame frame = null;
	protected static BCanvas canvas = null;
	protected static Graphics g = null;

	public static void set(JFrame frame, BCanvas canvas, Graphics g){
		BDrawCommand.frame = frame;
		BDrawCommand.canvas = canvas;
		BDrawCommand.g = g;
	}
	
	public abstract void draw();
}
