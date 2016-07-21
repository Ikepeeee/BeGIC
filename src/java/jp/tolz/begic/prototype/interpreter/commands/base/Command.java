package jp.tolz.begic.prototype.interpreter.commands.base;

/**
 * BeGICで用いるコマンドの基底クラス。
 * 全てのコマンドはCommandを継承する必要がある。
 * @author toru ikeda
 *
 */
abstract public class Command{
	public Command(String[] args){
	}
	
	/**
	 * コマンドの実行メソッド
	 */
	abstract public String[] exec();
}