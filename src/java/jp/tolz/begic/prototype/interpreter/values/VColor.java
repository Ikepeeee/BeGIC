package jp.tolz.begic.prototype.interpreter.values;

import jp.tolz.begic.prototype.interpreter.values.base.Values;

public class VColor extends Values {
	static VColor RED, BLUE, YELLOW, GREEN, BLACK, WHITE;
	
	public VColor(int r, int g, int b) {

	}
	
	/**
	 * �F�̑����Z���s���܂��B
	 * @param other �����F
	 * @return
	 */
	public VColor add(VColor other){
		return null;
	}
	
	/**
	 * �F�̈����Z���s���܂��B
	 * @param other �����F
	 * @return �������F
	 */
	public VColor sub(VColor other){
		return null;
	}
}
