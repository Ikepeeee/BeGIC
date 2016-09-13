package jp.tolz.begic.prototype.interpreter.values;

import java.util.ArrayList;
import java.util.Arrays;

import jp.tolz.begic.prototype.interpreter.values.base.BValue;

public class BList extends BValue {
	ArrayList<BValue> list;

	public BList() {
		list = new ArrayList<BValue>();
	}

	public BList(BValue[] values) {
		Arrays.asList(values).forEach(list::add);
	}

	public BValue push(BValue[] values) {
		Arrays.asList(values).forEach(list::add);
		return new BList(values);
	}

	public BValue push(BValue value) {
		list.add(value);
		return value;
	}

	public BValue unshift(BValue value) {
		list.add(0, value);
		return value;
	}

	public BValue unshift(BValue[] values) {
		Arrays.asList(values).forEach(val -> list.add(0, val));
		return new BList(values);
	}

	public BValue pop() {
		BValue t = list.get(list.size() - 1);
		list.remove(list.size() - 1);
		return t;
	}
	
	public BValue shift() {
		BValue t = list.get(0);
		list.remove(0);
		return t;
	}

	public BValue last() {
		return list.get(list.size());
	}

	public BValue first() {
		return list.get(0);
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
		return BLIST;
	}

	@Override
	public String toString() {
		return list.toString();
	}

}
