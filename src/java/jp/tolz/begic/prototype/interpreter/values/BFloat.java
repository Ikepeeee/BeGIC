package jp.tolz.begic.prototype.interpreter.values;

import java.math.BigDecimal;
import java.math.BigInteger;

import jp.tolz.begic.prototype.interpreter.exception.BegicRunTimeException;

public class BFloat extends BValue<BigDecimal> {
	public static final BFloat ZERO = new BFloat(0);
	public static final BFloat ONE = new BFloat(1);
	
	public BFloat(String value) {
		setValue(new BigDecimal(value));
	}

	public BFloat(float value) {
		setValue(new BigDecimal(value));
	}

	public BFloat(double value) {
		setValue(new BigDecimal(value));
	}

	public BFloat(int value) {
		setValue(new BigDecimal(value));
	}

	public BFloat(long value) {
		setValue(new BigDecimal(value));
	}

	public BFloat(BigInteger value) {
		setValue(new BigDecimal(value.toString()));
	}

	public BFloat(BigDecimal add) {
		setValue(add);
	}

	@Override
	public String toString() {
		return value.toString();
	}

	@Override
	public int type() {
		return BFLOAT;
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
		if (other.type() != BFLOAT)
			return new BBoolean(false);
		return new BBoolean(this.value.compareTo((BigDecimal) other.value) == 0);
	}

	@Override
	public BValue neq(BValue other) throws BegicRunTimeException {
		if (other.type() != BFLOAT)
			return new BBoolean(true);
		return new BBoolean(this.value.compareTo((BigDecimal) other.value) != 0);
	}

	@Override
	public BValue ge(BValue other) throws BegicRunTimeException {
		if (other.type() != BFLOAT)
			throw new BegicRunTimeException();
		return new BBoolean(this.value.compareTo((BigDecimal) other.value) >= 0);
	}

	@Override
	public BValue le(BValue other) throws BegicRunTimeException {
		if (other.type() != BFLOAT)
			throw new BegicRunTimeException();
		return new BBoolean(this.value.compareTo((BigDecimal) other.value) <= 0);
	}

	@Override
	public BValue gt(BValue other) throws BegicRunTimeException {
		if (other.type() != BFLOAT)
			throw new BegicRunTimeException();
		return new BBoolean(this.value.compareTo((BigDecimal) other.value) > 0);
	}

	@Override
	public BValue lt(BValue other) throws BegicRunTimeException {
		if (other.type() != BFLOAT)
			throw new BegicRunTimeException();
		return new BBoolean(this.value.compareTo((BigDecimal) other.value) < 0);
	}

	@Override
	public BValue add(BValue other) throws BegicRunTimeException {
		switch (other.type()) {
		case BFLOAT:
			return new BFloat(this.value.add((BigDecimal) other.value));
		case BSTRING:
			return new BString(this.value.toString().concat(other.toString()));
		default:
			throw new BegicRunTimeException();
		}
	}

	@Override
	public BValue sub(BValue other) throws BegicRunTimeException {
		if (other.type() == BFLOAT)
			return new BFloat(this.value.subtract((BigDecimal) other.value));
		throw new BegicRunTimeException();
	}

	@Override
	public BValue mul(BValue other) throws BegicRunTimeException {
		switch (other.type()) {
		case BFLOAT:
			return new BFloat(this.value.multiply((BigDecimal) other.value));
		case BSTRING:
			String s = "";
			for (BigDecimal i = new BigDecimal(0); i.compareTo(this.value) < 0; i = i
					.add(BigDecimal.ONE)) {
				s = s.concat(other.toString());
			}
			return new BString(s);
		case BCOLOR:
			
		default:
			throw new BegicRunTimeException();
		}
	}

	@Override
	public BValue div(BValue other) throws BegicRunTimeException {
		if (other.type() != BFLOAT)
			throw new BegicRunTimeException();
		return new BFloat(this.value.divide((BigDecimal) other.value, BigDecimal.ROUND_HALF_EVEN));
	}

	@Override
	public BValue mod(BValue other) throws BegicRunTimeException {
		if (other.type() != BFLOAT)
			throw new BegicRunTimeException();
		return new BFloat(this.value.toBigInteger().mod(
				((BigDecimal) other.value).toBigInteger()));
	}

	@Override
	public BValue pow(BValue other) throws BegicRunTimeException {
		if (other.type() != BFLOAT)
			throw new BegicRunTimeException();
		int n = Integer.valueOf(((BigDecimal) other.value).toString().replaceAll("\\..*", ""));
		return new BFloat(this.value.pow(n));
	}

	/**
	 * @deprecated 未実装
	 * @return
	 * @throws BegicRunTimeException
	 */
	@Override
	public BValue abs() throws BegicRunTimeException {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}
