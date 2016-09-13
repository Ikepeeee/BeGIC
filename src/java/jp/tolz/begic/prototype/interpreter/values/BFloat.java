package jp.tolz.begic.prototype.interpreter.values;

import jp.tolz.begic.prototype.interpreter.values.base.BValue;

public class BFloat extends BValue {
	private double val;
	public BFloat(String value){
		val = Double.valueOf(value);
	}
	
	public BFloat(double i) {
		val = i;
	}

	@Override
	public String toString(){
		return String.valueOf(val);
	}

	@Override
	public void setValue(String value) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public BValue getValue() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public int type() {
		return BFLOAT;
	}
}
