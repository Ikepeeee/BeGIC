package jp.tolz.begic.prototype.interpreter.values;

import jp.tolz.begic.prototype.interpreter.values.base.Values;

public class VColor extends Values {
	static VColor RED, BLUE, YELLOW, GREEN, BLACK, WHITE;
	
	public VColor(int r, int g, int b) {

	}
	
	/**
	 * 色の足し算を行います。
	 * @param other 足す色
	 * @return
	 */
	public VColor add(VColor other){
		return null;
	}
	
	/**
	 * 色の引き算を行います。
	 * @param other 引く色
	 * @return 引いた色
	 */
	public VColor sub(VColor other){
		return null;
	}
}
