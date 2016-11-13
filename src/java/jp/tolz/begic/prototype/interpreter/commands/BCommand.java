package jp.tolz.begic.prototype.interpreter.commands;

import java.awt.Graphics;

import javax.swing.JFrame;

import jp.tolz.begic.prototype.interpreter.canvas.BCanvas;
import jp.tolz.begic.prototype.interpreter.commands.base.BArgs;

/**
 * BeGIC�ŗp����R�}���h�̊��N���X�B
 * �S�ẴR�}���h��Command���p������K�v������B
 * @author toru ikeda
 *
 */
public abstract class BCommand{
	protected static JFrame frame = null;
	protected static BCanvas canvas = null;
	protected static Graphics g = null;
	
	public static void set(JFrame frame, BCanvas canvas, Graphics g){
		BCommand.frame = frame;
		BCommand.canvas = canvas;
		BCommand.g = g;
	}
	
	/**
	 * �R�}���h�̎��s���\�b�h
	 */
	public abstract void exec(BArgs bargs);

}