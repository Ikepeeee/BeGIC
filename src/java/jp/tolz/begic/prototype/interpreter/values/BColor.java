package jp.tolz.begic.prototype.interpreter.values;

import jp.tolz.begic.prototype.interpreter.values.base.BValue;

public class BColor extends BValue {
	static BColor RED, BLUE, YELLOW, GREEN, BLACK, WHITE;
	
	public BColor(int r, int g, int b) {

	}
	
	public BColor(String color){
		
	}
	
	/**
	 * �F�̑����Z���s���܂��B
	 * @param other �����F
	 * @return
	 */
	public BColor add(BColor other){
		return null;
	}
	
	/**
	 * �F�̈����Z���s���܂��B
	 * @param other �����F
	 * @return �������F
	 */
	public BColor sub(BColor other){
		return null;
	}

	@Override
	public void setValue(String value) {
		
	}

	@Override
	public BValue getValue() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return null;
	}

	@Override
	public int type() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return 0;
	}
}
