package jp.begic.executer;

import java.io.InputStream;

/**
 * ���s�҂��������ׂ��C���^�[�t�F�C�X�ł��B
 * �R�[�h���󂯎���Ď��s���܂��B
 * @author Toru Ikeda
 *
 */
public interface Executer {
	public void exec(InputStream code);
}
