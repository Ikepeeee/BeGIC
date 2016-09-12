package jp.tolz.begic.prototype.interpreter.values;

import jp.tolz.begic.prototype.interpreter.values.base.BValue;

public class BColor extends BValue {
	static BColor RED, BLUE, YELLOW, GREEN, BLACK, WHITE;
	
	public BColor(int r, int g, int b) {

	}
	
	public BColor(String color){
		
	}
	
	/**
	 * 色の足し算を行います。
	 * @param other 足す色
	 * @return
	 */
	public BColor add(BColor other){
		return null;
	}
	
	/**
	 * 色の引き算を行います。
	 * @param other 引く色
	 * @return 引いた色
	 */
	public BColor sub(BColor other){
		return null;
	}

	@Override
	public void setValue(String value) {
		
	}

	@Override
	public BValue getValue() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public int type() {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}
}
