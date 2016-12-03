package jp.tolz.begic.prototype.interpreter.functions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jp.tolz.begic.prototype.interpreter.commands.base.BArgs;

/**
 * シグネチャを表現するクラス。
 * 
 * @author Toru Ikeda
 *
 */
public class BSignature {
	private List<Integer> returnTypes = new ArrayList<Integer>();
	private List<Integer[]> argsTypes = new ArrayList<Integer[]>();

	/**
	 * 引数がこのシグネチャと合致するか判別します。
	 * 
	 * @return 合致するならture.そうでない場合はfalse.
	 */
	public boolean check(BArgs args) {
		return false;
	}

	/**
	 * 新しいシグネチャを追加します。
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
	 * シグネチャの種類の数を返却します。
	 * 
	 * @return
	 */
	public int getNumOfSignature() {
		return returnTypes.size();
	}
}
