package jp.begic.interpreter.values;

import jp.begic.interpreter.exception.BegicRunTimeException;

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
		return replaceEscape(value);
	}

	private String replaceEscape(String s) {
		return s.replaceAll("\\\\n", "\n").replaceAll("\\\\t", "\t")
				.replaceAll("\\\\b", "\b").replaceAll("\\\\r", "\r")
				.replaceAll("\\\\f", "\f").replaceAll("\\\\\\\\", "\\\\")
				.replaceAll("\\\\'", "'").replaceAll("\\\\\"", "\"");
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
		if (other.type() == BValue.BSTRING)
			return new BString(this.value.concat(((BString) other).value));
		else if (other.type() == BValue.BDECIMAL)
			return new BString(this.value.concat(((BDecimal) other).value.toString()));
		else if (other.type() == BValue.BBOOLEAN)
			return new BString(this.value.concat(((BBoolean) other).value.toString()));
		else
			throw new BegicRunTimeException();

	}

	/**
	 * 引く側に含まれる文字を空文字に置換する
	 */
	@Override
	public BValue sub(BValue other) throws BegicRunTimeException {
		if (other.type() != BValue.BSTRING)
			throw new BegicRunTimeException();
		return new BString(this.value.replaceAll((String) other.value, ""));
	}

	@Override
	public BValue mul(BValue other) throws BegicRunTimeException {
		if (other.type() != BValue.BDECIMAL)
			throw new BegicRunTimeException();
		String ret = "";
		for (BDecimal i = new BDecimal(0); (Boolean) i.lt(((BDecimal) other))
				.getValue(); i = (BDecimal) i.add(BDecimal.ONE))
			ret = ret.concat(value);
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

	@Override
	public BValue additiveIdentity() throws BegicRunTimeException {
		throw new BegicRunTimeException();
	}

}
