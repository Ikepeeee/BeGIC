package jp.begic.interpreter.values;

import jp.begic.interpreter.exception.BegicRunTimeException;

public class BBoolean extends BValue<Boolean> {

	public BBoolean(String bool) throws BegicRunTimeException {
		if (bool.equals("true"))
			setValue(true);
		else if (bool.equals("false"))
			setValue(false);
		else
			throw new BegicRunTimeException();
	}

	public BBoolean(boolean b) {
		setValue(b);
	}

	@Override
	public int type() {
		return BBOOLEAN;
	}

	@Override
	public String toString() {
		return value.toString();
	}

	@Override
	public BValue and(BValue other) throws BegicRunTimeException {
		if (other.type() != BBOOLEAN)
			throw new BegicRunTimeException();
		return new BBoolean(this.value && ((BBoolean) other).value);
	}

	@Override
	public BValue or(BValue other) throws BegicRunTimeException {
		if (other.type() != BBOOLEAN)
			throw new BegicRunTimeException();
		return new BBoolean(this.value || ((BBoolean) other).value);
	}

	@Override
	public BValue not() throws BegicRunTimeException {
		return new BBoolean(!this.value);
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
		if (other.type() == BValue.BSTRING)
			return new BString(this.value.toString().concat(
					((BString) other).value.toString()));
		else
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
		if (other.type() != BBOOLEAN)
			return new BBoolean(false);
		return new BBoolean(this.value.equals(other.value));
	}

	@Override
	public BValue neq(BValue other) throws BegicRunTimeException {
		if (other.type() != BBOOLEAN)
			return new BBoolean(true);
		return new BBoolean(!this.value.equals(other.value));
	}

	@Override
	public BValue additiveIdentity() throws BegicRunTimeException {
		throw new BegicRunTimeException();
	}

}
