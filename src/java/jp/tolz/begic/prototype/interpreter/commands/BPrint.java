package jp.tolz.begic.prototype.interpreter.commands;

import jp.tolz.begic.prototype.interpreter.commands.base.BArgs;

/**
 * BeGICの標準出力命令です。<br>
 * 書式例<br>
 * print "文字数は",num,"です" // "文字数はnumです"が標準出力される。
 * 
 * @author toru ikeda
 *
 */
class BPrint extends BCommand {

	public BPrint() {
		super();
	}

	@Override
	public void exec(BArgs args) {
		for(int i = 0; i < args.size(); i++){
			System.out.print(args.get(i));
		}
	}

}