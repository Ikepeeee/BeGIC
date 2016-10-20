package jp.tolz.begic.prototype.interpreter.commands.base;

import jp.tolz.begic.prototype.interpreter.canvas.BCanvas;

/**
 * BeGICで用いるコマンドの基底クラス。
 * 全てのコマンドはCommandを継承する必要がある。
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
	 * コマンドの実行メソッド
	 */
	public abstract void exec();

}