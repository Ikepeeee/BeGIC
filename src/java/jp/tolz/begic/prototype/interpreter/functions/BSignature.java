package jp.tolz.begic.prototype.interpreter.functions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jp.tolz.begic.prototype.interpreter.commands.base.BArgs;

/**
 * �V�O�l�`����\������N���X�B
 * 
 * @author Toru Ikeda
 *
 */
public class BSignature {
	private List<Integer> returnTypes = new ArrayList<Integer>();
	private List<Integer[]> argsTypes = new ArrayList<Integer[]>();

	/**
	 * ���������̃V�O�l�`���ƍ��v���邩���ʂ��܂��B
	 * 
	 * @return ���v����Ȃ�ture.�����łȂ��ꍇ��false.
	 */
	public boolean check(BArgs args) {
		return false;
	}

	/**
	 * �V�����V�O�l�`����ǉ����܂��B
	 * 
	 * @param returnType
	 * @param argsType
	 */
	public void add(int returnType, int[] argsType) {
		if (returnTypes.indexOf(returnType) != -1
				&& argsTypes.indexOf(argsType) != -1) {
			returnTypes.add(Integer.valueOf(returnType));
			argsTypes.add(Arrays.asList(argsType).toArray(new Integer[argsType.length]));
		}
	}

	/**
	 * �V�O�l�`���̎�ނ̐���ԋp���܂��B
	 * 
	 * @return
	 */
	public int getNumOfSignature() {
		return returnTypes.size();
	}
}
