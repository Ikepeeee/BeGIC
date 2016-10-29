package jp.tolz.begic.prototype.interpreter.commands;

import jp.tolz.begic.prototype.interpreter.canvas.BCanvas;
import jp.tolz.begic.prototype.interpreter.commands.base.BArgs;

/**
 * BeGIC�ŗp����R�}���h�̊��N���X�B
 * �S�ẴR�}���h��Command���p������K�v������B
 * @author toru ikeda
 *
 */
public abstract class BCommand{
	protected static BCanvas canvas = null;
	
	/**
	 * �R�}���h�̎��s���\�b�h
	 */
	public abstract void exec(BArgs bargs);

}