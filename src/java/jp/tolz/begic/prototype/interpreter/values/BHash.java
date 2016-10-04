package jp.tolz.begic.prototype.interpreter.values;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import jp.tolz.begic.prototype.interpreter.exception.BegicRunTimeException;
import jp.tolz.begic.prototype.interpreter.values.base.IBCollection;

public class BHash extends BValue<LinkedHashMap<BValue, BValue>> implements IBCollection {

	public BHash() {
		setValue(new LinkedHashMap<BValue, BValue>());
	}

	public BHash(BValue[] values) {
		setValue(new LinkedHashMap<BValue, BValue>());
		this.push(values);
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
			if (((String) this.value.get(key).neq(((BHash) other).value.get(key)).value)
					.equals("false"))
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
			if (((String) this.value.get(key).neq(((BHash) other).value.get(key)).value)
					.equals("true"))
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
		if(other.type() != BValue.BHASH)
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
	public BValue push(BValue[] values) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public BValue push(BValue value) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public BValue unshift(BValue value) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public BValue unshift(BValue[] values) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public BValue pop() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public BValue shift() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public BValue last() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public BValue first() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public BValue get(int i) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}
