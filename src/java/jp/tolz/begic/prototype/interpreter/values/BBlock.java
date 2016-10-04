package jp.tolz.begic.prototype.interpreter.values;

import jp.tolz.begic.prototype.interpreter.exception.BegicRunTimeException;
import jp.tolz.begic.prototype.interpreter.parser.ASTBlock;

public class BBlock extends BValue {
	private ASTBlock node = null;

	public void setValue(ASTBlock block){
		this.node = block;
	}

	@Override
	public int type() {
		return BBLOCK;
	}

	@Override
	public String toString() {
		return "block : ".concat(node.toString());
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
