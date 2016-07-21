package jp.tolz.begic.prototype.interpreter.commands;

import jp.tolz.begic.prototype.interpreter.commands.base.Command;

/**
 * 描画用のウインドウのサイズの変更を行います。
 * ウインドウの表示は実行時に自動的に生成されます。<br>
 * 書式例<br>
 * window(0,0)-(200,200)
 * window -100,-100,100,100
 * @author toru ikeda
 *
 */
public class BWindow extends Command {

	public BWindow(String[] args) {
		super(args);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	public String[] exec() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}
