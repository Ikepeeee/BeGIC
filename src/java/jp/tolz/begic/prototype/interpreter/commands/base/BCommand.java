package jp.tolz.begic.prototype.interpreter.commands.base;

import jp.tolz.begic.prototype.interpreter.canvas.BCanvas;

/**
 * BeGIC�ŗp����R�}���h�̊��N���X�B
 * �S�ẴR�}���h��Command���p������K�v������B
 * @author toru ikeda
 *
 */
public abstract class BCommand{
	public static BCanvas canvas = null;
	public BArgs bargs = null;
	
	public BCommand(BArgs bargs){
		this.bargs = bargs;
	}
	
	/**
	 * �R�}���h�̎��s���\�b�h
	 */
	public abstract void exec();

}