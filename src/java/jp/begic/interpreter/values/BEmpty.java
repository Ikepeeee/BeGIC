package jp.begic.interpreter.values;

import jp.begic.interpreter.exception.BegicRunTimeException;

/**
 * 空値を表すクラス。識別子に該当する値がないことを示します。
 * @author Toru Ikeda
 *
 */
public class BEmpty extends BValue<Object> {
	
	public BEmpty() {
		setValue(null);
	}
	
	@Override
	public BValue and(BValue other) throws BegicRunTimeException {
		throw new BegicRunTimeException("operation with enpty object.");
	}

	@Override
	public BValue or(BValue other) throws BegicRunTimeException {
		throw new BegicRunTimeException("operation with enpty object.");
	}

	@Override
	public BValue not() throws BegicRunTimeException {
		throw new BegicRunTimeException("operation with enpty object.");
	}

	@Override
	public BValue eq(BValue other) throws BegicRunTimeException {
		return new BBoolean(other.type() == BEMPTY);
	}

	@Override
	public BValue neq(BValue other) throws BegicRunTimeException {
		return new BBoolean(other.type() != BEMPTY);
	}

	@Override
	public BValue ge(BValue other) throws BegicRunTimeException {
		throw new BegicRunTimeException("operation with enpty object.");
	}

	@Override
	public BValue le(BValue other) throws BegicRunTimeException {
		throw new BegicRunTimeException("operation with enpty object.");
	}

	@Override
	public BValue gt(BValue other) throws BegicRunTimeException {
		throw new BegicRunTimeException("operation with enpty object.");
	}

	@Override
	public BValue lt(BValue other) throws BegicRunTimeException {
		throw new BegicRunTimeException("operation with enpty object.");
	}

	@Override
	public BValue add(BValue other) throws BegicRunTimeException {
		throw new BegicRunTimeException("operation with enpty object.");
	}

	@Override
	public BValue sub(BValue other) throws BegicRunTimeException {
		throw new BegicRunTimeException("operation with enpty object.");
	}

	@Override
	public BValue mul(BValue other) throws BegicRunTimeException {
		throw new BegicRunTimeException("operation with enpty object.");
	}

	@Override
	public BValue div(BValue other) throws BegicRunTimeException {
		throw new BegicRunTimeException("operation with enpty object.");
	}

	@Override
	public BValue mod(BValue other) throws BegicRunTimeException {
		throw new BegicRunTimeException("operation with enpty object.");
	}

	@Override
	public BValue pow(BValue other) throws BegicRunTimeException {
		throw new BegicRunTimeException("operation with enpty object.");
	}

	@Override
	public BValue abs() throws BegicRunTimeException {
		throw new BegicRunTimeException("operation with enpty object.");
	}

	@Override
	public int type() {
		return BEMPTY;
	}
	
	@Override
	public BValue additiveIdentity() throws BegicRunTimeException {
		throw new BegicRunTimeException();
	}

}
