package jp.tolz.begic.prototype.interpreter.process;

import jp.tolz.begic.prototype.interpreter.exception.BegicRunTimeException;
import jp.tolz.begic.prototype.interpreter.namespace.NameSpace;
import jp.tolz.begic.prototype.interpreter.parser.ASTAddMns;
import jp.tolz.begic.prototype.interpreter.parser.ASTAddMnsOp;
import jp.tolz.begic.prototype.interpreter.parser.ASTAndOp;
import jp.tolz.begic.prototype.interpreter.parser.ASTArgs;
import jp.tolz.begic.prototype.interpreter.parser.ASTAssingment;
import jp.tolz.begic.prototype.interpreter.parser.ASTBlock;
import jp.tolz.begic.prototype.interpreter.parser.ASTBoolean;
import jp.tolz.begic.prototype.interpreter.parser.ASTBreak;
import jp.tolz.begic.prototype.interpreter.parser.ASTCall;
import jp.tolz.begic.prototype.interpreter.parser.ASTColor;
import jp.tolz.begic.prototype.interpreter.parser.ASTCommand;
import jp.tolz.begic.prototype.interpreter.parser.ASTComp;
import jp.tolz.begic.prototype.interpreter.parser.ASTCompOp;
import jp.tolz.begic.prototype.interpreter.parser.ASTExchange;
import jp.tolz.begic.prototype.interpreter.parser.ASTExpression;
import jp.tolz.begic.prototype.interpreter.parser.ASTFloat;
import jp.tolz.begic.prototype.interpreter.parser.ASTForStatement;
import jp.tolz.begic.prototype.interpreter.parser.ASTFunction;
import jp.tolz.begic.prototype.interpreter.parser.ASTHash;
import jp.tolz.begic.prototype.interpreter.parser.ASTIdentifier;
import jp.tolz.begic.prototype.interpreter.parser.ASTIfStatement;
import jp.tolz.begic.prototype.interpreter.parser.ASTList;
import jp.tolz.begic.prototype.interpreter.parser.ASTListHashFactor;
import jp.tolz.begic.prototype.interpreter.parser.ASTLoopStatement;
import jp.tolz.begic.prototype.interpreter.parser.ASTModPow;
import jp.tolz.begic.prototype.interpreter.parser.ASTModPowOp;
import jp.tolz.begic.prototype.interpreter.parser.ASTMulDiv;
import jp.tolz.begic.prototype.interpreter.parser.ASTMulDivOp;
import jp.tolz.begic.prototype.interpreter.parser.ASTNext;
import jp.tolz.begic.prototype.interpreter.parser.ASTNot;
import jp.tolz.begic.prototype.interpreter.parser.ASTNotOp;
import jp.tolz.begic.prototype.interpreter.parser.ASTOperation;
import jp.tolz.begic.prototype.interpreter.parser.ASTOrOp;
import jp.tolz.begic.prototype.interpreter.parser.ASTProgram;
import jp.tolz.begic.prototype.interpreter.parser.ASTString;
import jp.tolz.begic.prototype.interpreter.parser.ASTWhileStatement;
import jp.tolz.begic.prototype.interpreter.parser.BegicParser;
import jp.tolz.begic.prototype.interpreter.parser.BegicParserVisitor;
import jp.tolz.begic.prototype.interpreter.parser.SimpleNode;
import jp.tolz.begic.prototype.interpreter.parser.Token;
import jp.tolz.begic.prototype.interpreter.values.BBoolean;
import jp.tolz.begic.prototype.interpreter.values.BColor;
import jp.tolz.begic.prototype.interpreter.values.BFloat;
import jp.tolz.begic.prototype.interpreter.values.BHash;
import jp.tolz.begic.prototype.interpreter.values.BList;
import jp.tolz.begic.prototype.interpreter.values.BString;
import jp.tolz.begic.prototype.interpreter.values.BValue;
import jp.tolz.begic.prototype.interpreter.values.base.IBCollection;
import jp.tolz.begic.prototype.interpreter.values.base.IBValue;

/**
 * 
 * @author Toru Ikeda
 *
 */
public class BegicVisitor implements BegicParserVisitor {
	private NameSpace nameSpace = new NameSpace();

	// 通常は使われない。
	@Override
	public Object visit(SimpleNode node, Object data) {
		return null;
	}

	@Override
	public Object visit(ASTProgram node, Object data) {
		int num = node.jjtGetNumChildren();
		for (int i = 0; i < num; i++) {
			node.jjtGetChild(i).jjtAccept(this, data);
		}
		return null;
	}

	@Override
	public Object visit(ASTCommand node, Object data) {
		// 引数の有無を確認。
		int num = node.jjtGetNumChildren();
		String command = (String) node.jjtGetValue();
		if (num == 2) {
			BValue<?>[] args = (BValue<?>[]) node.jjtGetChild(1).jjtAccept(
					this, data);

		} else {

		}
		return null;
	}

	@Override
	public Object visit(ASTArgs node, Object data) {
		int num = node.jjtGetNumChildren();
		BValue<?>[] args = new BValue<?>[num];
		for (int i = 0; i < num; i++) {
			args[i] = (BValue<?>) node.jjtGetChild(i).jjtAccept(this, data);
		}
		return args;
	}

	@Override
	public Object visit(ASTIfStatement node, Object data) {
		int num = node.jjtGetNumChildren();
		for (int i = 0; i < num; i += 2) {
			if (((BBoolean) node.jjtGetChild(i).jjtAccept(this, null))
					.toString().equals("true")) {
				node.jjtGetChild(i + 1).jjtAccept(this, data);
				return null;
			}
		}
		if (num % 2 == 1) {
			node.jjtGetChild(num - 1).jjtAccept(this, data);
		}
		return null;
	}

	@Override
	public Object visit(ASTCall node, Object data) {
		ASTBlock block = (ASTBlock) node.jjtGetChild(0).jjtAccept(this, data);
		block.jjtAccept(this, data);
		return null;
	}

	@Override
	public Object visit(ASTLoopStatement node, Object data) {
		Integer sign = BegicParser.NEXT;
		while (sign == BegicParser.NEXT)
			sign = (Integer) node.jjtGetChild(0).jjtAccept(this, data);
		return null;
	}

	@Override
	public Object visit(ASTWhileStatement node, Object data) {
		while (((BBoolean) node.jjtGetChild(0)).toString().equals("true")) {
			Integer sign = (Integer) node.jjtGetChild(1).jjtAccept(this, data);
			if (sign == BegicParser.BREAK)
				break;
		}
		return null;
	}

	@Override
	public Object visit(ASTForStatement node, Object data) {
		Token i = (Token) node.jjtGetValue();
		BValue<?> first = (BValue<?>) node.jjtGetChild(0);
		BValue<?> last = (BValue<?>) node.jjtGetChild(1);
		BValue<?> step = (BValue<?>) node.jjtGetChild(2);
		try {
			for (nameSpace.setValue(i.image, first); ((String) nameSpace
					.getValue(i.image).lt(last).getValue()).equals("true"); nameSpace
					.getValue(i.image).add(step)) {
				Integer sign = (Integer) node.jjtGetChild(3).jjtAccept(this,
						data);
				if (sign == BegicParser.NEXT)
					continue;
				if (sign == BegicParser.BREAK)
					break;
			}
		} catch (BegicRunTimeException e) {
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public Object visit(ASTBlock node, Object data) {
		int num = node.jjtGetNumChildren();
		for (int i = 0; i < num; i++) {
			Object o = node.jjtGetChild(i).jjtAccept(this, data);
			if (o.getClass() == Token.class) {
				if (((Token) o).kind == BegicParser.BREAK)
					return BegicParser.BREAK;
				if (((Token) o).kind == BegicParser.NEXT)
					return BegicParser.NEXT;
			}
		}
		return null;
	}

	@Override
	public Object visit(ASTBreak node, Object data) {
		return node.jjtGetValue();
	}

	@Override
	public Object visit(ASTNext node, Object data) {
		return node.jjtGetValue();
	}

	@Override
	public Object visit(ASTAssingment node, Object data) {
		Token t = (Token) node.jjtGetValue();
		BValue<?> value = (BValue<?>) node.jjtGetChild(1).jjtAccept(this, data);
		nameSpace.setValue(t.image, value);
		return value;
	}

	@Override
	public Object visit(ASTExpression node, Object data) {
		return node.jjtGetChild(0).jjtAccept(this, data);
	}

	@Override
	public Object visit(ASTList node, Object data) {
		int num = node.jjtGetNumChildren();
		BList list = new BList();
		for (int i = 0; i < num; i++) {
			// エラー出力ある!!!
			list.push(null,
					(BValue<?>) node.jjtGetChild(i).jjtAccept(this, null));
		}
		return list;
	}

	@Override
	public Object visit(ASTHash node, Object data) {
		int num = node.jjtGetNumChildren();
		BHash hash = new BHash();
		for (int i = 0; i < num; i += 2) {
			try {
				hash.push(
						(BValue<?>) node.jjtGetChild(i).jjtAccept(this, null),
						(BValue<?>) node.jjtGetChild(i + 1).jjtAccept(this,
								null));
			} catch (BegicRunTimeException e) {
				e.printStackTrace();
				System.exit(0);
			}
		}
		return data;
	}

	@Override
	public Object visit(ASTListHashFactor node, Object data) {
		IBCollection col = (IBCollection) node.jjtGetChild(1).jjtAccept(this,
				data);
		BValue<?> key = (BValue<?>) node.jjtGetChild(1).jjtAccept(this, data);
		BValue<?> val = null;
		try {
			val = col.get(key);
		} catch (BegicRunTimeException e) {
			e.printStackTrace();
			System.exit(0);
		}
		return val;
	}

	@Override
	public Object visit(ASTFloat node, Object data) {
		return new BFloat((String) node.jjtGetValue());
	}

	@Override
	public Object visit(ASTString node, Object data) {
		return new BString((String) node.jjtGetValue());
	}

	@Override
	public Object visit(ASTColor node, Object data) {
		return new BColor((String) node.jjtGetValue());
	}

	@Override
	public Object visit(ASTBoolean node, Object data) {
		BValue<?> value = null;
		try {
			value = new BBoolean((String) node.jjtGetValue());
		} catch (BegicRunTimeException e) {
			e.printStackTrace();
			System.exit(0);
		}
		return value;
	}

	@Override
	public Object visit(ASTAddMnsOp node, Object data) {
		return null;
	}

	@Override
	public Object visit(ASTOperation node, Object data) {
		return node.jjtGetChild(0).jjtAccept(this, data);
	}

	@Override
	public Object visit(ASTMulDivOp node, Object data) {
		int num = node.jjtGetNumChildren();
		for (int i = 0; i < num; i++) {
			data = node.jjtGetChild(i).jjtAccept(this, null);
		}
		return data;
	}

	@Override
	public Object visit(ASTOrOp node, Object data) {
		int n = node.jjtGetNumChildren();
		BValue<?> v = (BValue<?>) node.jjtGetChild(0).jjtAccept(this, data);
		try {
			for (int i = 1; i < n; i++) {
				v = v.or((BValue<?>) node.jjtGetChild(i).jjtAccept(this, data));
			}
		} catch (BegicRunTimeException e) {
			e.printStackTrace();
			System.exit(0);
		}
		return v;
	}

	@Override
	public Object visit(ASTAndOp node, Object data) {
		int n = node.jjtGetNumChildren();
		BValue<?> v = (BValue<?>) node.jjtGetChild(0).jjtAccept(this, data);
		try {
			for (int i = 1; i < n; i++) {
				v = v.and((BValue<?>) node.jjtGetChild(i).jjtAccept(this, data));
			}
		} catch (BegicRunTimeException e) {
			e.printStackTrace();
			System.exit(0);
		}
		return v;
	}

	@Override
	public Object visit(ASTNotOp node, Object data) {
		int n = node.jjtGetNumChildren();
		BValue<?> v = (BValue<?>) node.jjtGetChild(n - 1).jjtAccept(this, data);
		try {
			if (n % 2 == 0) {
				// notが奇数個
				v = v.not();
			}
		} catch (BegicRunTimeException e) {
			e.printStackTrace();
			System.exit(0);
		}
		return v;
	}

	@Override
	public Object visit(ASTCompOp node, Object data) {
		int n = node.jjtGetNumChildren();
		BValue<?> v = (BValue<?>) node.jjtGetChild(0).jjtAccept(this, data);
		try {
			if (n == 3) {
				Token o = (Token) node.jjtGetChild(1).jjtAccept(this, data);

				if (o.kind == BegicParser.EQ) {
					v = v.eq((BValue<?>) node.jjtGetChild(2).jjtAccept(this,
							data));
				} else if (o.kind == BegicParser.NEQ) {
					v = v.neq((BValue<?>) node.jjtGetChild(2).jjtAccept(this,
							data));
				} else if (o.kind == BegicParser.GE) {
					v = v.ge((BValue<?>) node.jjtGetChild(2).jjtAccept(this,
							data));
				} else if (o.kind == BegicParser.LE) {
					v = v.le((BValue<?>) node.jjtGetChild(2).jjtAccept(this,
							data));
				} else if (o.kind == BegicParser.GT) {
					v = v.gt((BValue<?>) node.jjtGetChild(2).jjtAccept(this,
							data));
				} else if (o.kind == BegicParser.LT) {
					v = v.lt((BValue<?>) node.jjtGetChild(2).jjtAccept(this,
							data));
				}
			}
		} catch (BegicRunTimeException e) {
			e.printStackTrace();
			System.exit(0);
		}
		return v;
	}

	@Override
	public Object visit(ASTAddMns node, Object data) {
		return node.jjtGetValue();
	}

	@Override
	public Object visit(ASTMulDiv node, Object data) {
		return node.jjtGetValue();
	}

	@Override
	public Object visit(ASTModPowOp node, Object data) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public Object visit(ASTModPow node, Object data) {
		return node.jjtGetValue();
	}

	@Override
	public Object visit(ASTComp node, Object data) {
		return node.jjtGetValue();
	}

	@Override
	public Object visit(ASTIdentifier node, Object data) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public Object visit(ASTFunction node, Object data) {
		String func = ((Token) node.jjtGetValue()).image;
		return null;
	}

	@Override
	public Object visit(ASTExchange node, Object data) {
		String right = (String) ((Token) node.jjtGetChild(0).jjtAccept(this, data)).image;
		String left = (String) ((Token) node.jjtGetChild(1).jjtAccept(this, data)).image;
		IBValue rv = nameSpace.getValue(right);
		IBValue lv = nameSpace.getValue(left);
		nameSpace.setValue(left, rv);
		nameSpace.setValue(right, lv);
		return null;
	}

	@Override
	public Object visit(ASTNot node, Object data) {
		return node.jjtGetValue();
	}

}
