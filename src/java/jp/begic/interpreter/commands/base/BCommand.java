package jp.begic.interpreter.commands.base;

/**
 * BeGICで用いるコマンドの基底クラス。
 * 全てのコマンドはCommandを継承する必要がある。
 * @author toru ikeda
 *
 */
public abstract class BCommand{
	/**
	 * コマンドの実行メソッド
	 */
	public abstract void exec(BArgs bargs);
	
	/**
	 * コマンドが使用中であるかを調べます。
	 * @return
	 */
	public abstract boolean isInUse();

}