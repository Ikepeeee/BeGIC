package jp.tolz.begic.prototype.interpreter.commands;

import jp.tolz.begic.prototype.interpreter.canvas.BCanvas;
import jp.tolz.begic.prototype.interpreter.commands.base.BArgs;

/**
 * BeGICで用いるコマンドの基底クラス。
 * 全てのコマンドはCommandを継承する必要がある。
 * @author toru ikeda
 *
 */
public abstract class BCommand{
	protected static BCanvas canvas = null;
	
	/**
	 * コマンドの実行メソッド
	 */
	public abstract void exec(BArgs bargs);

}