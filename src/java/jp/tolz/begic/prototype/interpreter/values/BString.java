package jp.tolz.begic.prototype.interpreter.values;

import jp.tolz.begic.prototype.interpreter.values.base.BValue;

public class BString extends BValue {
	private String value = null;
	
	public BString(String value){
		this.value = value;
	}
	
	@Override
	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public BValue getValue() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return null;
	}

	@Override
	public int type() {
		return BSTRING;
	}

	@Override
	public String toString() {
		return value.replaceAll("^\"|\"$", "");
	}

}
