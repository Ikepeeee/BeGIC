package jp.tolz.begic.prototype.interpreter.commands.base;

import jp.tolz.begic.prototype.interpreter.canvas.BCanvas;

/**
 * BeGIC�ŗp����R�}���h�̊��N���X�B
 * �S�ẴR�}���h��Command���p������K�v������B
 * @author toru ikeda
 *
 */
public abstract class BCommand{
	public static BCanvas canvas;
	
	public BCommand(BArgs bargs){
	}
	
	/**
	 * �R�}���h�̎��s���\�b�h
	 */
	public abstract void exec();

}