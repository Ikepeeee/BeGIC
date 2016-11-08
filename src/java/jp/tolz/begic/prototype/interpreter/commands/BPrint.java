package jp.tolz.begic.prototype.interpreter.commands;

import jp.tolz.begic.prototype.interpreter.commands.base.BArgs;

/**
 * BeGIC�̕W���o�͖��߂ł��B<br>
 * ������<br>
 * print "��������",num,"�ł�" // "��������num�ł�"���W���o�͂����B
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