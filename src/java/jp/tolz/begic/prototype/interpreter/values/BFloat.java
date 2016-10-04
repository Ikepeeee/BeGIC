package jp.tolz.begic.prototype.interpreter.values;

import java.math.BigDecimal;

import jp.tolz.begic.prototype.interpreter.exception.BegicRunTimeException;


public class BFloat extends BValue {
	
	public BFloat(String value){
		setValue(new BigDecimal(value));
	}
	
	public BFloat(float value){
		setValue(new BigDecimal(value));
	}
	
	public BFloat(double value) {
		setValue(new BigDecimal(value));
	}
	
	public BFloat(int value){
		setValue(new BigDecimal(value));
	}
	
	public BFloat(long value){
		setValue(new BigDecimal(value));
	}

	@Override
	public String toString(){
		return (String) value;
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
		
		return new BBoolean(null);
	}

	@Override
	public BValue ge(BValue other) throws BegicRunTimeException {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public BValue le(BValue other) throws BegicRunTimeException {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public BValue gt(BValue other) throws BegicRunTimeException {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public BValue lt(BValue other) throws BegicRunTimeException {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public BValue add(BValue other) throws BegicRunTimeException {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public BValue sub(BValue other) throws BegicRunTimeException {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public BValue mul(BValue other) throws BegicRunTimeException {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public BValue div(BValue other) throws BegicRunTimeException {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public BValue mod(BValue other) throws BegicRunTimeException {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public BValue pow(BValue other) throws BegicRunTimeException {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public BValue abs() throws BegicRunTimeException {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public BValue neq(BValue other) throws BegicRunTimeException {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
}
