package jp.tolz.begic.prototype.executer;

/**
 * 実行者が実装すべきインターフェイスです。
 * コードを受け取って実行します。
 * @author Toru Ikeda
 *
 */
public interface Executer {
	public void exec(String code);
}
