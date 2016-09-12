package jp.tolz.begic.prototype.interpreter.values.base;

public abstract class BValue {
	public static final int BBLOCK = 1001;
	public static final int BBOOLEAN = 1002;
	public static final int BCOLOR = 1003;
	public static final int BFLOAT = 1004;
	public static final int BSTRING = 1005;
	public static final int BLIST = 1006;
	
	public abstract void setValue(String value);
	public abstract BValue getValue();
	public abstract int type();
}
