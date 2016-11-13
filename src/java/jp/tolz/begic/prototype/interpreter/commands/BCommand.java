package jp.tolz.begic.prototype.interpreter.commands;

import java.awt.Graphics;

import javax.swing.JFrame;

import jp.tolz.begic.prototype.interpreter.canvas.BCanvas;
import jp.tolz.begic.prototype.interpreter.commands.base.BArgs;

/**
 * BeGICで用いるコマンドの基底クラス。
 * 全てのコマンドはCommandを継承する必要がある。
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
	 * コマンドの実行メソッド
	 */
	public abstract void exec(BArgs bargs);

}