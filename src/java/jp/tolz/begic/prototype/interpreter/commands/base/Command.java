package jp.tolz.begic.prototype.interpreter.commands.base;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

import jp.tolz.begic.prototype.interpreter.canvas.BCanvas;

/**
 * BeGIC�ŗp����R�}���h�̊��N���X�B
 * �S�ẴR�}���h��Command���p������K�v������B
 * @author toru ikeda
 *
 */
abstract public class Command{
	public static BCanvas canvas;
	
	public Command(BArgs bargs){
	}
	
	/**
	 * �R�}���h�̎��s���\�b�h
	 */
	abstract public void exec();

}