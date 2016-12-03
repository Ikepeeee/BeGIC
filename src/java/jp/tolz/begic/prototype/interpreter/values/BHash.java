package jp.tolz.begic.prototype.interpreter.values;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import jp.tolz.begic.prototype.interpreter.exception.BegicRunTimeException;
import jp.tolz.begic.prototype.interpreter.values.base.IBCollection;

public class BHash extends BValue<LinkedHashMap<BValue, BValue>> implements
		IBCollection {

	public BHash() {
		setValue(new LinkedHashMap<BValue, BValue>());
	}

	public BHash(BValue[] keys, BValue[] values) throws BegicRunTimeException {
		setValue(new LinkedHashMap<BValue, BValue>());
		this.push(keys, values);
	}

	@Override
	public int type() {
		return BHASH;
	}

	@Override
	public String toString() {
		return value.toString();
	}

	@Override
	public BValue and(BValue other) throws BegicRunTimeException {
		throw new BegicRunTimeException();
	}

	@Override
	public BValue or(BValue other) throws BegicRunTimeException {
		throw new BegicRunTimeException();
	}

	@Override
	public BValue not() throws BegicRunTimeException {
		throw new BegicRunTimeException();
	}

	@Override
	public BValue eq(BValue other) throws BegicRunTimeException {
		if (other.type() != BHASH)
			return new BBoolean("false");
		if (this.value.size() != (((BHash) other).value.size()))
			return new BBoolean("false");

		for (BValue<?> key : this.value.keySet()) {
			if (((String) this.value.get(key).neq(
					((BHash) other).value.get(key)).value).equals("false"))
				return new BBoolean("false");
		}
		return new BBoolean("true");
	}

	@Override
	public BValue neq(BValue other) throws BegicRunTimeException {
		if (other.type() != BHASH)
			return new BBoolean("true");
		if (this.value.size() != (((BHash) other).value.size()))
			return new BBoolean("true");

		for (BValue<?> key : this.value.keySet()) {
			if (((String) this.value.get(key).neq(
					((BHash) other).value.get(key)).value).equals("true"))
				return new BBoolean("true");
		}
		return new BBoolean("false");
	}

	@Override
	public BValue ge(BValue other) throws BegicRunTimeException {
		throw new BegicRunTimeException();
	}

	@Override
	public BValue le(BValue other) throws BegicRunTimeException {
		throw new BegicRunTimeException();
	}

	@Override
	public BValue gt(BValue other) throws BegicRunTimeException {
		throw new BegicRunTimeException();
	}

	@Override
	public BValue lt(BValue other) throws BegicRunTimeException {
		throw new BegicRunTimeException();
	}

	// 未実装!!
	@Override
	public BValue add(BValue other) throws BegicRunTimeException {
		if (other.type() != BValue.BHASH)
			throw new BegicRunTimeException();
		return null;
	}

	@Override
	public BValue sub(BValue other) throws BegicRunTimeException {
		throw new BegicRunTimeException();
	}

	@Override
	public BValue mul(BValue other) throws BegicRunTimeException {
		throw new BegicRunTimeException();
	}

	@Override
	public BValue div(BValue other) throws BegicRunTimeException {
		throw new BegicRunTimeException();
	}

	@Override
	public BValue mod(BValue other) throws BegicRunTimeException {
		throw new BegicRunTimeException();
	}

	@Override
	public BValue pow(BValue other) throws BegicRunTimeException {
		throw new BegicRunTimeException();
	}

	@Override
	public BValue abs() throws BegicRunTimeException {
		throw new BegicRunTimeException();
	}

	@Override
	public BValue pop() {
		BValue<?> t = value.get(value.keySet().toArray()[value.size() - 1]);
		value.remove(value.keySet().toArray()[value.size() - 1]);
		return t;
	}

	@Override
	public BValue shift() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public BValue last() {
		return value.get(value.keySet().toArray()[value.size() - 1]);
	}

	@Override
	public BValue first() {
		if (value.size() > 0)
			return value.get(value.keySet().toArray()[0]);
		else
			return null;
	}

	@Override
	public BValue push(BValue key, BValue value) throws BegicRunTimeException {
		this.value.put(key, value);
		return value;
	}

	public void push(BValue[] keys, BValue[] values)
			throws BegicRunTimeException {
		if (keys.length != values.length)
			throw new BegicRunTimeException();
		int size = keys.length;
		for (int i = 0; i < size; i++) {
			push(keys[i], values[i]);
		}
	}

	@Override
	public BValue unshift(BValue key, BValue value)
			throws BegicRunTimeException {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	public void unshift(BValue[] keys, BValue[] values)
			throws BegicRunTimeException {
		if (keys.length != values.length)
			throw new BegicRunTimeException();
		int size = keys.length;
		for (int i = 0; i < size; i++) {
			unshift(keys[i], values[i]);
		}
	}

	@Override
	public BValue get(BValue key) throws BegicRunTimeException {
		for (BValue k : value.keySet()) {
			if (((BBoolean) k.eq(key)).value)
				return value.get(k);
		}
		return null;
	}

	@Override
	public BValue set(BValue key, BValue value) throws BegicRunTimeException {
		for (BValue k : this.value.keySet()) {
			if (((BBoolean) k.eq(key)).value)
				this.value.put(k, value);
		}
		return value;
	}

	@Override
	public BValue size() throws BegicRunTimeException {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}
