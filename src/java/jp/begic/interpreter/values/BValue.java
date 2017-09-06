package jp.begic.interpreter.values;

import java.io.Serializable;

import jp.begic.interpreter.values.base.IBValue;

/**
 * BeGIC実装用基底クラス。
 * @author Toru Ikeda
 *
 * @param <T>
 */
public abstract class BValue<T> implements IBValue, Serializable {
	public static final int BVALUE = 1000;
	public static final int BBLOCK = 1001;
	public static final int BBOOLEAN = 1002;
	public static final int BCOLOR = 1003;
	public static final int BFLOAT = 1004;
	public static final int BSTRING = 1005;
	public static final int BLIST = 1006;
	public static final int BHASH = 1007;
	public static final int BEMPTY = 9001;

	protected T value = null;

	public void setValue(T value) {
		this.value = value;
	}

	public T getValue() {
		return value;
	}
	
	public abstract int type();

}
