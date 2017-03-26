package jp.begic.interpreter.values;

import java.util.ArrayList;
import java.util.Arrays;

import jp.begic.interpreter.exception.BegicRunTimeException;
import jp.begic.interpreter.values.base.IBCollection;

public class BList extends BValue<ArrayList<BValue>> implements IBCollection {

	public BList() {
		setValue(new ArrayList<BValue>());
	}

	public BList(BValue[] values) {
		setValue(new ArrayList<BValue>());
		this.push(values);
	}

	public BValue push(BValue[] values) {
		Arrays.asList(values).forEach(val -> this.push(null ,val));
		return new BList(values);
	}

	@Override
	public BValue push(BValue key, BValue value) {
		this.value.add(value);
		return value;
	}

	@Override
	public BValue unshift(BValue key, BValue value) {
		this.value.add(0, value);
		return value;
	}

	public BValue unshift(BValue[] values) {
		Arrays.asList(values).forEach(val -> this.value.add(0, val));
		return new BList(values);
	}

	@Override
	public BValue pop() {
		BValue t = this.value.get(this.value.size() - 1);
		this.value.remove(this.value.size() - 1);
		return t;
	}

	@Override
	public BValue shift() {
		BValue t = this.value.get(0);
		this.value.remove(0);
		return t;
	}

	@Override
	public BValue last() {
		return this.value.get(this.value.size());
	}

	@Override
	public BValue first() {
		return this.value.get(0);
	}

	public BValue get(int i){
		return this.value.get(i);
	}
	
	@Override
	public BValue get(BValue i) throws BegicRunTimeException {
		if(i.type() != BFLOAT)
			throw new BegicRunTimeException();
		return this.value.get(Integer.valueOf(i.toString()));
	}
	
	@Override
	public BValue set(BValue key, BValue value) throws BegicRunTimeException {
		if(key.type() != BFLOAT)
			throw new BegicRunTimeException();
		this.value.set(Integer.valueOf(key.toString()), value);
		return value;
	}

	@Override
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
		if (this.value.size() != ((BList) other).value.size())
			throw new BegicRunTimeException("定義されない配列の演算です。");
		int size = this.value.size();
		BList newlist = new BList();
		for(int i = 0; i < size; i++){
			newlist.push(null, this.get(i).add(((BList) other).get(i)));
		}
		return newlist;
	}

	@Override
	public BValue sub(BValue other) throws BegicRunTimeException {
		throw new BegicRunTimeException();
	}

	@Override
	public BValue mul(BValue other) throws BegicRunTimeException {
		if (other.type() != BLIST)
			throw new BegicRunTimeException();
		if (this.value.size() != ((BList) other).value.size())
			throw new BegicRunTimeException("定義されない配列の演算です。");
		int size = this.value.size();
		BList newlist = new BList();
		for(int i = 0; i < size; i++){
			newlist.push(null, this.get(i).mul(((BList) other).get(i)));
		}
		return newlist;
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
	public BValue additiveIdentity() throws BegicRunTimeException {
		throw new BegicRunTimeException();
	}

}
