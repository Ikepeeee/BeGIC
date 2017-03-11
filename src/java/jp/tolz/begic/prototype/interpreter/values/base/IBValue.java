package jp.tolz.begic.prototype.interpreter.values.base;

import jp.tolz.begic.prototype.interpreter.exception.BegicRunTimeException;
import jp.tolz.begic.prototype.interpreter.values.BValue;

public interface IBValue {
	public abstract String toString();
	/**
	 * 加法単位元を取得します。
	 * @return 
	 * @throws BegicRunTimeException 定義されない場合
	 */
	public abstract BValue additiveIdentity() throws BegicRunTimeException;
	public abstract BValue and(BValue other) throws BegicRunTimeException;
	public abstract BValue or(BValue other) throws BegicRunTimeException;
	public abstract BValue not() throws BegicRunTimeException;
	public abstract BValue eq(BValue other) throws BegicRunTimeException;
	public abstract BValue neq(BValue other) throws BegicRunTimeException;
	public abstract BValue ge(BValue other) throws BegicRunTimeException;
	public abstract BValue le(BValue other) throws BegicRunTimeException;
	public abstract BValue gt(BValue other) throws BegicRunTimeException;
	public abstract BValue lt(BValue other) throws BegicRunTimeException;
	public abstract BValue add(BValue other) throws BegicRunTimeException;
	public abstract BValue sub(BValue other) throws BegicRunTimeException;
	public abstract BValue mul(BValue other) throws BegicRunTimeException;
	public abstract BValue div(BValue other) throws BegicRunTimeException;
	public abstract BValue mod(BValue other) throws BegicRunTimeException;
	public abstract BValue pow(BValue other) throws BegicRunTimeException;
	public abstract BValue abs() throws BegicRunTimeException;
}
