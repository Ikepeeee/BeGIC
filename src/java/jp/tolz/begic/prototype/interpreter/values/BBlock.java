package jp.tolz.begic.prototype.interpreter.values;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import jp.tolz.begic.prototype.interpreter.exception.BegicRunTimeException;
import jp.tolz.begic.prototype.interpreter.parser.ASTBlock;
import jp.tolz.begic.prototype.interpreter.parser.Node;

public class BBlock extends BValue<ASTBlock> {

	public BBlock(ASTBlock value) {
		setValue(value);
	}

	@Override
	public int type() {
		return BBLOCK;
	}

	@Override
	public String toString() {
		return "block : ".concat(value.toString());
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
		throw new BegicRunTimeException();
	}

	@Override
	public BValue neq(BValue other) throws BegicRunTimeException {
		throw new BegicRunTimeException();
	}

	@Override
	public BValue ge(BValue other) throws BegicRunTimeException {
		throw new BegicRunTimeException();
	}

	@Override
	public BValue le(BValue other) throws BegicRunTimeException {
		throw new BegicRunTimeException();
	}

	@Override
	public BValue gt(BValue other) throws BegicRunTimeException {
		throw new BegicRunTimeException();
	}

	@Override
	public BValue lt(BValue other) throws BegicRunTimeException {
		throw new BegicRunTimeException();
	}

	@Override
	public BValue add(BValue other) throws BegicRunTimeException {
		if (other.type() != BBLOCK)
			throw new BegicRunTimeException();
//		ASTBlock thisNode = (ASTBlock) deepCopy(this.value);
//		ASTBlock otherNode = (ASTBlock) deepCopy(other.value);
		ASTBlock thisNode = this.value;
		ASTBlock otherNode = (ASTBlock) other.value;
//		System.out.println(otherNode);
		for (int i = 0; i < otherNode.jjtGetNumChildren(); i++) {
			Node n = otherNode.jjtGetChild(i);
			thisNode.jjtAddChild(n, thisNode.jjtGetNumChildren());
		}
		return new BBlock(thisNode);
	}

	@Override
	public BValue sub(BValue other) throws BegicRunTimeException {
		throw new BegicRunTimeException();
	}

	@Override
	public BValue mul(BValue other) throws BegicRunTimeException {
		if (other.type() != BFLOAT)
			throw new BegicRunTimeException();
//		ASTBlock thisNode = (ASTBlock) deepCopy(this.value);
		ASTBlock thisNode = this.value;
		int size = thisNode.jjtGetNumChildren();
		int num = ((BFloat) other).value.intValue();
		for (int i = 0; i < num - 1; i++) {
//			ASTBlock copy = (ASTBlock) deepCopy(this.value);
			ASTBlock copy = this.value;
			for (int j = 0; j < size; j++) {
				Node n = copy.jjtGetChild(j);
				thisNode.jjtAddChild(n, thisNode.jjtGetNumChildren());
			}
		}
		return new BBlock(thisNode);
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

	private static Object deepCopy(Object o) {
		Object copy = null;

		try {
			// オブジェクトを符号化し、バイト配列に書き込み
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(o);

			// 符号化されたオブジェクトのデータを保持する配列を取得
			byte[] buff = baos.toByteArray();
			// バイト配列から、オブジェクトを複合化
			ByteArrayInputStream bais = new ByteArrayInputStream(buff);
			ObjectInputStream os = new ObjectInputStream(bais);
			copy = os.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return copy;

	}

	@Override
	public BValue additiveIdentity() throws BegicRunTimeException {
		throw new BegicRunTimeException();
	}
}
