package jp.tolz.begic.prototype.interpreter.values;

import jp.tolz.begic.prototype.interpreter.exception.BegicRunTimeException;


public class BColor extends BValue {
	public static BColor RED, BLUE, YELLOW, GREEN, BLACK, WHITE;
	
	public BColor(int r, int g, int b) {

	}
	
	public BColor(String color){
		
	}
	
	/**
	 * 色の足し算を行います。
	 * @param other 足す色
	 * @return
	 */
	public BColor add(BColor other){
		return null;
	}
	
	/**
	 * 色の引き算を行います。
	 * @param other 引く色
	 * @return 引いた色
	 */
	public BColor sub(BColor other){
		return null;
	}

	@Override
	public int type() {
		return BCOLOR;
	}

	@Override
	public String toString() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public BValue and(BValue other) throws BegicRunTimeException {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public BValue or(BValue other) throws BegicRunTimeException {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public BValue not() throws BegicRunTimeException {
		// TODO 自動生成されたメソッド・スタブ
		return null;
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
}
