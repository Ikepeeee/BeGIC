package jp.tolz.begic.prototype.interpreter.values;

import java.math.BigDecimal;
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
		return replaceEscape(value.replaceAll("^\"|\"$", ""));
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
		if (other.type() != BValue.BSTRING)
			throw new BegicRunTimeException();
		return new BString(this.toString().concat(other.toString()));
	}

	/**
	 * ˆø‚­‘¤‚ÉŠÜ‚Ü‚ê‚é•¶Žš‚ð‹ó•¶Žš‚É’uŠ·‚·‚é
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
		for (BFloat i = new BFloat(0); (Boolean) i.lt(((BFloat) other)).getValue(); i = (BFloat) i.add(BFloat.ONE))
			ret = ret.concat(toString());
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
