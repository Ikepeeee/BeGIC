package jp.tolz.begic.prototype.interpreter.commands.base;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

import jp.tolz.begic.prototype.interpreter.canvas.BCanvas;

/**
 * BeGICで用いるコマンドの基底クラス。
 * 全てのコマンドはCommandを継承する必要がある。
 * @author toru ikeda
 *
 */
abstract public class Command{
	public static BCanvas canvas;
	
	public Command(BArgs bargs){
	}
	
	/**
	 * コマンドの実行メソッド
	 */
	abstract public void exec();

}