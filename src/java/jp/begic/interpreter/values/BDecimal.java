package jp.begic.interpreter.values;

import java.math.BigDecimal;
import java.math.BigInteger;

import jp.begic.interpreter.exception.BegicRunTimeException;

public class BDecimal extends BValue<BigDecimal> {
	public static final BDecimal ZERO = new BDecimal(0);
	public static final BDecimal ONE = new BDecimal(1);
	
	public BDecimal(String value) {
		setValue(new BigDecimal(value));
	}

	public BDecimal(float value) {
		setValue(new BigDecimal(value));
	}

	public BDecimal(double value) {
		setValue(new BigDecimal(value));
	}

	public BDecimal(int value) {
		setValue(new BigDecimal(value));
	}

	public BDecimal(long value) {
		setValue(new BigDecimal(value));
	}

	public BDecimal(BigInteger value) {
		setValue(new BigDecimal(value.toString()));
	}

	public BDecimal(BigDecimal add) {
		setValue(add);
	}

	@Override
	public String toString() {
		return value.toString();
	}

	@Override
	public int type() {
		return BDECIMAL;
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
		if (other.type() != BDECIMAL)
			return new BBoolean(false);
		return new BBoolean(this.value.compareTo((BigDecimal) other.value) == 0);
	}

	@Override
	public BValue neq(BValue other) throws BegicRunTimeException {
		if (other.type() != BDECIMAL)
			return new BBoolean(true);
		return new BBoolean(this.value.compareTo((BigDecimal) other.value) != 0);
	}

	@Override
	public BValue ge(BValue other) throws BegicRunTimeException {
		if (other.type() != BDECIMAL)
			throw new BegicRunTimeException();
		return new BBoolean(this.value.compareTo((BigDecimal) other.value) >= 0);
	}

	@Override
	public BValue le(BValue other) throws BegicRunTimeException {
		if (other.type() != BDECIMAL)
			throw new BegicRunTimeException();
		return new BBoolean(this.value.compareTo((BigDecimal) other.value) <= 0);
	}

	@Override
	public BValue gt(BValue other) throws BegicRunTimeException {
		if (other.type() != BDECIMAL)
			throw new BegicRunTimeException();
		return new BBoolean(this.value.compareTo((BigDecimal) other.value) > 0);
	}

	@Override
	public BValue lt(BValue other) throws BegicRunTimeException {
		if (other.type() != BDECIMAL)
			throw new BegicRunTimeException();
		return new BBoolean(this.value.compareTo((BigDecimal) other.value) < 0);
	}

	@Override
	public BValue add(BValue other) throws BegicRunTimeException {
		switch (other.type()) {
		case BDECIMAL:
			return new BDecimal(this.value.add((BigDecimal) other.value));
		case BSTRING:
			return new BString(this.value.toString().concat(other.toString()));
		default:
			throw new BegicRunTimeException();
		}
	}

	@Override
	public BValue sub(BValue other) throws BegicRunTimeException {
		if (other.type() == BDECIMAL)
			return new BDecimal(this.value.subtract((BigDecimal) other.value));
		throw new BegicRunTimeException();
	}

	@Override
	public BValue mul(BValue other) throws BegicRunTimeException {
		switch (other.type()) {
		case BDECIMAL:
			return new BDecimal(this.value.multiply((BigDecimal) other.value));
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
		if (other.type() != BDECIMAL)
			throw new BegicRunTimeException();
		return new BDecimal(this.value.divide((BigDecimal) other.value, BigDecimal.ROUND_HALF_EVEN));
	}

	@Override
	public BValue mod(BValue other) throws BegicRunTimeException {
		if (other.type() != BDECIMAL)
			throw new BegicRunTimeException();
		return new BDecimal(this.value.toBigInteger().mod(
				((BigDecimal) other.value).toBigInteger()));
	}

	@Override
	public BValue pow(BValue other) throws BegicRunTimeException {
		if (other.type() != BDECIMAL)
			throw new BegicRunTimeException();
		int n = Integer.valueOf(((BigDecimal) other.value).toString().replaceAll("\\..*", ""));
		return new BDecimal(this.value.pow(n));
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
	
	@Override
	public BValue additiveIdentity() throws BegicRunTimeException {
		return ZERO;
	}

}
