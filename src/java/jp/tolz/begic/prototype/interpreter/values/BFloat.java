package jp.tolz.begic.prototype.interpreter.values;

import jp.tolz.begic.prototype.interpreter.values.base.BValue;

public class BFloat extends BValue {
	private double val;
	public BFloat(String value){
		val = Double.valueOf(value);
	}
	
	@Override
	public String toString(){
		return String.valueOf(val);
	}

	@Override
	public void setValue(String value) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		
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
