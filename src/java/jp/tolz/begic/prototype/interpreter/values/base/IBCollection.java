package jp.tolz.begic.prototype.interpreter.values.base;

import jp.tolz.begic.prototype.interpreter.values.BValue;

public interface IBCollection {
	public BValue push(BValue[] values);
	public BValue push(BValue value);
	public BValue unshift(BValue value);
	public BValue unshift(BValue[] values);
	public BValue pop();
	public BValue shift();
	public BValue last();
	public BValue first();
	public BValue get(int i);
}
