package jp.tolz.begic.prototype.interpreter.values;

import jp.tolz.begic.prototype.interpreter.exception.BegicRunTimeException;

public class BBoolean extends BValue {

	public BBoolean(String bool){
		
	}
	
	public BBoolean(boolean b) {
		setValue(b ? "true" : "false");
	}

	@Override
	public int type() {
		return BBOOLEAN;
	}

	@Override
	public String toString() {
		return (String) value;
	}

	@Override
	public BValue and(BValue other) throws BegicRunTimeException {
		if(other.type() != BBOOLEAN)
			throw new BegicRunTimeException();
		if(((String) this.value).equals("false")){
			return new BBoolean("false");
		}else if (((String) other.value).equals("false")){
			return new BBoolean("false");
		}
		return new BBoolean("true");
	}

	@Override
	public BValue or(BValue other) throws BegicRunTimeException {
		if(other.type() != BBOOLEAN)
			throw new BegicRunTimeException();
		if(((String) this.value).equals("true")){
			return new BBoolean("true");
		}else if (((String) other.value).equals("true")){
			return new BBoolean("true");
		}
		return new BBoolean("false");
	}

	@Override
	public BValue not() throws BegicRunTimeException {
		return new BBoolean(((String) value).equals("false"));
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
		throw new BegicRunTimeException();
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
	public BValue eq(BValue other) throws BegicRunTimeException {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public BValue neq(BValue other) throws BegicRunTimeException {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}
