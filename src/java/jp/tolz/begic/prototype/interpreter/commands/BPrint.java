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
		// TODO �����������ꂽ�R���X�g���N�^�[�E�X�^�u
	}

	@Override
	public void exec(BArgs args) {
		System.out.print(args);
	}

}