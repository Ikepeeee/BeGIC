package jp.tolz.begic.prototype.interpreter.values;

import jp.tolz.begic.prototype.interpreter.exception.BegicRunTimeException;


public class BColor extends BValue {
	public static BColor RED, BLUE, YELLOW, GREEN, BLACK, WHITE;
	
	public BColor(int r, int g, int b) {

	}
	
	public BColor(String color){
		
	}
	
	/**
	 * �F�̑����Z���s���܂��B
	 * @param other �����F
	 * @return
	 */
	public BColor add(BColor other){
		return null;
	}
	
	/**
	 * �F�̈����Z���s���܂��B
	 * @param other �����F
	 * @return �������F
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
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return null;
	}

	@Override
	public BValue and(BValue other) throws BegicRunTimeException {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return null;
	}

	@Override
	public BValue or(BValue other) throws BegicRunTimeException {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return null;
	}

	@Override
	public BValue not() throws BegicRunTimeException {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return null;
	}

	@Override
	public BValue eq(BValue other) throws BegicRunTimeException {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return null;
	}

	@Override
	public BValue neq(BValue other) throws BegicRunTimeException {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return null;
	}

	@Override
	public BValue ge(BValue other) throws BegicRunTimeException {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return null;
	}

	@Override
	public BValue le(BValue other) throws BegicRunTimeException {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return null;
	}

	@Override
	public BValue gt(BValue other) throws BegicRunTimeException {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return null;
	}

	@Override
	public BValue lt(BValue other) throws BegicRunTimeException {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return null;
	}

	@Override
	public BValue add(BValue other) throws BegicRunTimeException {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return null;
	}

	@Override
	public BValue sub(BValue other) throws BegicRunTimeException {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return null;
	}

	@Override
	public BValue mul(BValue other) throws BegicRunTimeException {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return null;
	}

	@Override
	public BValue div(BValue other) throws BegicRunTimeException {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return null;
	}

	@Override
	public BValue mod(BValue other) throws BegicRunTimeException {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return null;
	}

	@Override
	public BValue pow(BValue other) throws BegicRunTimeException {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return null;
	}

	@Override
	public BValue abs() throws BegicRunTimeException {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return null;
	}
}
