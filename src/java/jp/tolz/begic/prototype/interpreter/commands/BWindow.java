package jp.tolz.begic.prototype.interpreter.commands;

import jp.tolz.begic.prototype.interpreter.commands.base.BArgs;
import jp.tolz.begic.prototype.interpreter.values.BFloat;

/**
 * �`��p�̃E�C���h�E�̃T�C�Y�̕ύX���s���܂��B �E�C���h�E�̕\���͎��s���Ɏ����I�ɐ�������܂��B
 * 
 * @author toru ikeda
 *
 */
class BWindow extends BCommand {

	@Override
	public void exec(BArgs bargs) {
		frame.setSize(((BFloat) bargs.get(0)).getValue().intValue(),
				((BFloat) bargs.get(1)).getValue().intValue());
	}

}
