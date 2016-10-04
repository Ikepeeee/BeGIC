package jp.tolz.begic.prototype.interpreter.values;

import jp.tolz.begic.prototype.interpreter.exception.BegicRunTimeException;

public class BString extends BValue<String> {

	public BString(String value) {
		setValue(value);
	}

	@Override
	public int type() {
		return BSTRING;
	}

	@Override
	public String toString() {
		return value.replaceAll("^\"|\"$", "");
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
		if (other.type() != BValue.BSTRING)
			throw new BegicRunTimeException();
		return new BBoolean(this.value.equals((String) other.value));
	}

	@Override
	public BValue ge(BValue other) throws BegicRunTimeException {
		if (other.type() != BValue.BSTRING)
			throw new BegicRunTimeException();
		return new BBoolean(this.value.compareTo((String) other.value) >= 0);
	}

	@Override
	public BValue neq(BValue other) throws BegicRunTimeException {
		if (other.type() != BValue.BSTRING)
			throw new BegicRunTimeException();
		return new BBoolean(!this.value.equals((String) other.value));
	}

	@Override
	public BValue le(BValue other) throws BegicRunTimeException {
		if (other.type() != BValue.BSTRING)
			throw new BegicRunTimeException();
		return new BBoolean(this.value.compareTo((String) other.value) <= 0);
	}

	@Override
	public BValue gt(BValue other) throws BegicRunTimeException {
		if (other.type() != BValue.BSTRING)
			throw new BegicRunTimeException();
		return new BBoolean(this.value.compareTo((String) other.value) > 0);
	}

	@Override
	public BValue lt(BValue other) throws BegicRunTimeException {
		if (other.type() != BValue.BSTRING)
			throw new BegicRunTimeException();
		return new BBoolean(this.value.compareTo((String) other.value) < 0);
	}

	@Override
	public BValue add(BValue other) throws BegicRunTimeException {
		if (other.type() != BValue.BSTRING)
			throw new BegicRunTimeException();
		return new BString(this.value.concat(((String) other.value)));
	}

	/**
	 * �������Ɋ܂܂�镶�����󕶎��ɒu������
	 */
	@Override
	public BValue sub(BValue other) throws BegicRunTimeException {
		if (other.type() != BValue.BSTRING)
			throw new BegicRunTimeException();
		return new BString(this.value.replaceAll((String) value, ""));
	}

	@Override
	public BValue mul(BValue other) throws BegicRunTimeException {
		if (other.type() != BValue.BFLOAT)
			throw new BegicRunTimeException();
		String ret = "";
		for (int i = 0; i < (Integer) other.value; i++)
			ret = ret.concat((String) value);
		return new BString(ret);
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
