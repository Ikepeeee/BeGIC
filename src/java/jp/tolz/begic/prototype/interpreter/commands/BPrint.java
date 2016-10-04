package jp.tolz.begic.prototype.interpreter.commands;

import jp.tolz.begic.prototype.interpreter.commands.base.BArgs;
import jp.tolz.begic.prototype.interpreter.commands.base.BCommand;

/**
 * BeGICの標準出力命令です。<br>
 * 書式例<br>
 * print "文字数は",num,"です" // "文字数はnumです"が標準出力される。
 * 
 * @author toru ikeda
 *
 */
class BPrint extends BCommand {
	private BArgs args;

	public BPrint(BArgs args) {
		super(args);
		this.args = args;
	}

	public void exec() {
		System.out.print(args);
	}

}