package jp.tolz.begic.prototype.interpreter.commands;

import jp.tolz.begic.prototype.interpreter.commands.base.BArgs;
import jp.tolz.begic.prototype.interpreter.commands.base.BCommand;

/**
 * BeGIC�̕W���o�͖��߂ł��B<br>
 * ������<br>
 * print "��������",num,"�ł�" // "��������num�ł�"���W���o�͂����B
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