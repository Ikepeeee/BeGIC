package jp.tolz.begic.prototype.interpreter.values;

import java.util.ArrayList;
import java.util.Arrays;

import jp.tolz.begic.prototype.interpreter.exception.BegicRunTimeException;
import jp.tolz.begic.prototype.interpreter.values.base.IBCollection;

public class BList extends BValue<ArrayList<BValue>> implements IBCollection {

	public BList() {
		setValue(new ArrayList<BValue>());
	}

	public BList(BValue[] values) {
		setValue(new ArrayList<BValue>());
		this.push(values);
	}

	public BValue push(BValue[] values) {
		Arrays.asList(values).forEach(this::push);
		return new BList(values);
	}

	public BValue push(BValue value) {
		this.value.add(value);
		return value;
	}

	public BValue unshift(BValue value) {
		this.value.add(0, value);
		return value;
	}

	public BValue unshift(BValue[] values) {
		Arrays.asList(values).forEach(val -> this.value.add(0, val));
		return new BList(values);
	}

	public BValue pop() {
		BValue t = this.value.get(this.value.size() - 1);
		this.value.remove(this.value.size() - 1);
		return t;
	}

	public BValue shift() {
		BValue t = this.value.get(0);
		this.value.remove(0);
		return t;
	}

	public BValue last() {
		return this.value.get(this.value.size());
	}

	public BValue first() {
		return this.value.get(0);
	}

	public BValue get(int i) {
		return this.value.get(i);
	}

	public BValue size() {
		return new BFloat(this.value.size());
	}

	@Override
	public int type() {
		return BLIST;
	}

	@Override
	public String toString() {
		return this.value.toString();
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
		if (other.type() != BLIST)
			return new BBoolean("false");
		if (this.value.size() != (((ArrayList<BValue>) other.value).size()))
			return new BBoolean("false");
		for (int i = 0; i < this.value.size(); i++) {
			if (((String) this.get(i).neq(((BList) other).get(i)).value)
					.equals("false"))
				return new BBoolean("false");
		}
		return new BBoolean("true");
	}

	@Override
	public BValue neq(BValue other) throws BegicRunTimeException {
		if (other.type() != BLIST)
			return new BBoolean("true");
		if (this.value.size() != (((ArrayList<BValue>) other.value).size()))
			return new BBoolean("true");
		for (int i = 0; i < this.value.size(); i++) {
			if (((String) this.get(i).neq(((BList) other).get(i)).value)
					.equals("false"))
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

	@Override
	public BValue add(BValue other) throws BegicRunTimeException {
		if (other.type() != BLIST)
			throw new BegicRunTimeException();
		BList newBList = new BList(this.value.toArray(new BValue[this.value
				.size()]));
		newBList.push((((ArrayList<BValue>) other.value)
				.toArray(new BValue[((ArrayList<BValue>) other.value).size()])));
		return newBList;
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

}
