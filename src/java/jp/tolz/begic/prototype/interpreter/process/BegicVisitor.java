package jp.tolz.begic.prototype.interpreter.process;

import java.util.ArrayList;
import java.util.List;

import jp.tolz.begic.prototype.interpreter.commands.BCommandFactory;
import jp.tolz.begic.prototype.interpreter.commands.base.BArgs;
import jp.tolz.begic.prototype.interpreter.exception.BegicRunTimeException;
import jp.tolz.begic.prototype.interpreter.functions.BFunction;
import jp.tolz.begic.prototype.interpreter.functions.BFunctionFactory;
import jp.tolz.begic.prototype.interpreter.namespace.NameSpace;
import jp.tolz.begic.prototype.interpreter.parser.ASTAddMns;
import jp.tolz.begic.prototype.interpreter.parser.ASTAddMnsOp;
import jp.tolz.begic.prototype.interpreter.parser.ASTAndOp;
import jp.tolz.begic.prototype.interpreter.parser.ASTArgs;
import jp.tolz.begic.prototype.interpreter.parser.ASTAssignment;
import jp.tolz.begic.prototype.interpreter.parser.ASTBlock;
import jp.tolz.begic.prototype.interpreter.parser.ASTBoolean;
import jp.tolz.begic.prototype.interpreter.parser.ASTBreak;
import jp.tolz.begic.prototype.interpreter.parser.ASTCall;
import jp.tolz.begic.prototype.interpreter.parser.ASTColor;
import jp.tolz.begic.prototype.interpreter.parser.ASTCommand;
import jp.tolz.begic.prototype.interpreter.parser.ASTComp;
import jp.tolz.begic.prototype.interpreter.parser.ASTCompOp;
import jp.tolz.begic.prototype.interpreter.parser.ASTConstantAssignment;
//import jp.tolz.begic.prototype.interpreter.parser.ASTEnpty;
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
import jp.tolz.begic.prototype.interpreter.parser.Node;
import jp.tolz.begic.prototype.interpreter.parser.SimpleNode;
import jp.tolz.begic.prototype.interpreter.parser.Token;
import jp.tolz.begic.prototype.interpreter.values.BBlock;
import jp.tolz.begic.prototype.interpreter.values.BBoolean;
import jp.tolz.begic.prototype.interpreter.values.BColor;
import jp.tolz.begic.prototype.interpreter.values.BEnpty;
import jp.tolz.begic.prototype.interpreter.values.BFloat;
import jp.tolz.begic.prototype.interpreter.values.BHash;
import jp.tolz.begic.prototype.interpreter.values.BList;
import jp.tolz.begic.prototype.interpreter.values.BString;
import jp.tolz.begic.prototype.interpreter.values.BValue;
import jp.tolz.begic.prototype.interpreter.values.base.IBCollection;

/**
 * 
 * @author Toru Ikeda
 *
 */
public class BegicVisitor implements BegicParserVisitor {
	private NameSpace nameSpace = new NameSpace();

	@Override
	public Object visit(ASTProgram node, Object data) {
		int num = node.jjtGetNumChildren();
		for (int i = 0; i < num; i++) {
			node.jjtGetChild(i).jjtAccept(this, data);
		}
		return null;
	}

	@Override
	public Object visit(ASTIfStatement node, Object data) {
		int num = node.jjtGetNumChildren();
		for (int i = 1; i < num; i += 2) {
			if (((BBoolean) node.jjtGetChild(i - 1).jjtAccept(this, null))
					.getValue()) {
				return node.jjtGetChild(i).jjtAccept(this, true);

			}
		}
		if (num % 2 == 1) {
			return node.jjtGetChild(num - 1).jjtAccept(this, true);
		}
		return null;
	}

	@Override
	public Object visit(ASTLoopStatement node, Object data) {
		while (true) {
			Token sign = (Token) node.jjtGetChild(0).jjtAccept(this, true);
			if (sign != null) {
				if (sign.kind == BegicParser.BREAK)
					break;
				else if (sign.kind == BegicParser.NEXT)
					continue;
			}
		}
		return null;
	}

	@Override
	public Object visit(ASTWhileStatement node, Object data) {
		while (((BBoolean) node.jjtGetChild(0).jjtAccept(this, data))
				.toString().equals("true")) {
			Token sign = (Token) node.jjtGetChild(1).jjtAccept(this, true);
			if (sign != null) {
				if (sign.kind == BegicParser.BREAK)
					break;
				else if (sign.kind == BegicParser.NEXT)
					continue;
			}
		}
		return null;
	}

	@Override
	public Object visit(ASTForStatement node, Object data) {
		Token i = (Token) node.jjtGetValue();
		BValue<?> first = (BValue<?>) node.jjtGetChild(0).jjtAccept(this, data);
		BValue<?> last = (BValue<?>) node.jjtGetChild(1).jjtAccept(this, data);
		BValue<?> step = (BValue<?>) node.jjtGetChild(2).jjtAccept(this, data);
		try {
			for (nameSpace.setValue(i.image, first); ((String) nameSpace
					.getValue(i.image).neq(last).getValue().toString())
					.equals("true"); nameSpace.setValue(i.image, nameSpace
					.getValue(i.image).add(step))) {
				Token sign = (Token) node.jjtGetChild(3).jjtAccept(this, true);
				if (sign != null) {
					if (sign.kind == BegicParser.NEXT)
						continue;
					if (sign.kind == BegicParser.BREAK)
						break;
				}
			}
		} catch (BegicRunTimeException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return data;
	}

	@Override
	public Object visit(ASTCommand node, Object data) {
		// 引数の有無を確認。
		int num = node.jjtGetNumChildren();
		String command = ((Token) node.jjtGetValue()).image;
		try {
			if (num == 1) {
				BArgs args = (BArgs) node.jjtGetChild(0).jjtAccept(this, data);
				BCommandFactory.getInstance().getCommand(command).exec(args);
			} else if (num == 0) {
				BCommandFactory.getInstance().getCommand(command).exec(null);
			}
		} catch (BegicRunTimeException e) {
			e.printStackTrace();
			System.exit(1);
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
		return new BArgs(args);
	}

	@Override
	public Object visit(ASTCall node, Object data) {
		BBlock block = (BBlock) node.jjtGetChild(0).jjtAccept(this, false);
		((Node) block.getValue()).jjtAccept(this, true);
		return null;
	}

	@Override
	public Object visit(ASTBlock node, Object data) {
		// dataにより実行するかしないかを決める。
		if ((Boolean) data) {
			int num = node.jjtGetNumChildren();
			for (int i = 0; i < num; i++) {
				Object o = node.jjtGetChild(i).jjtAccept(this, data);
				if (o != null) {
					if (o.getClass() == Token.class) {
						if (((Token) o).kind == BegicParser.BREAK)
							return o;
						if (((Token) o).kind == BegicParser.NEXT)
							return o;
					}
				}
			}
		} else {
			return new BBlock(node);
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
	public Object visit(ASTAssignment node, Object data) {
		int num = node.jjtGetNumChildren();
		Token t = (Token) ((ASTIdentifier) node.jjtGetChild(0)).jjtGetValue();
		BValue<?> value = (BValue<?>) node.jjtGetChild(num - 1).jjtAccept(this,
				false);

		if (num == 2) {
			// 変数に代入。
			nameSpace.setValue(t.image, value);
		} else {
			// 添え字付きコレクションに代入。
			try {
				IBCollection col = (IBCollection) nameSpace.getValue(t.image);
				for (int i = 1; i < num - 2; i++) {
					col = (IBCollection) col.get((BValue<?>) node
							.jjtGetChild(i).jjtAccept(this, false));
				}
				col.set((BValue<?>) node.jjtGetChild(num - 2).jjtAccept(this,
						false), value);
			} catch (BegicRunTimeException e) {
				e.printStackTrace();
				System.exit(1);
			}
		}

		return value;
	}

	@Override
	public Object visit(ASTConstantAssignment node, Object data) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public Object visit(ASTExchange node, Object data) {
		BValue<?> right = (BValue<?>) node.jjtGetChild(0).jjtAccept(this, data);
		BValue<?> left = (BValue<?>) node.jjtGetChild(1).jjtAccept(this, data);
		String ri = nameSpace.getIdentifer(right);
		String li = nameSpace.getIdentifer(left);
		nameSpace.setValue(ri, left);
		nameSpace.setValue(li, right);
		return null;
	}

	@Override
	public Object visit(ASTOperation node, Object data) {
		return node.jjtGetChild(0).jjtAccept(this, data);
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
			System.exit(1);
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
			System.exit(1);
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
			System.exit(1);
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
			System.exit(1);
		}
		return v;
	}

	@Override
	public Object visit(ASTAddMnsOp node, Object data) {
		int num = node.jjtGetNumChildren();
		// - (num % 2) + 1 01反転。第2項が始まる番号+1
		int first = num % 2;
		BValue<?> value = null;
		Token op = null;
		try {
			value = first == 0 ? ((BValue<?>) node.jjtGetChild(1).jjtAccept(
					this, data)).additiveIdentity() : (BValue<?>) node
					.jjtGetChild(0).jjtAccept(this, data);
			for (int i = first; i < num; i += 2) {
				op = (Token) node.jjtGetChild(i).jjtAccept(this, data);
				BValue<?> other = (BValue<?>) node.jjtGetChild(i + 1)
						.jjtAccept(this, data);
				switch (op.kind) {
				case BegicParser.PLUS:
					value = value.add(other);
					break;
				case BegicParser.MINUS:
					value = value.sub(other);
					break;
				default:
					throw new BegicRunTimeException("AddMnsOp-default");
				}
			}
		} catch (BegicRunTimeException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return value;
	}

	@Override
	public Object visit(ASTMulDivOp node, Object data) {
		int num = node.jjtGetNumChildren();
		BValue<?> value = (BValue<?>) node.jjtGetChild(0).jjtAccept(this, data);
		try {
			for (int i = 1; i < num; i += 2) {
				Token op = (Token) node.jjtGetChild(i).jjtAccept(this, data);
				BValue<?> other = (BValue<?>) node.jjtGetChild(i + 1)
						.jjtAccept(this, data);
				switch (op.kind) {
				case BegicParser.STAR:
					value = value.mul(other);
					break;
				case BegicParser.SLASH:
					value = value.div(other);
					break;
				default:
					throw new BegicRunTimeException("AddMnsOp-default");
				}
			}
		} catch (BegicRunTimeException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return value;
	}

	@Override
	public Object visit(ASTModPowOp node, Object data) {
		int num = node.jjtGetNumChildren();
		BValue<?> value = (BValue<?>) node.jjtGetChild(0).jjtAccept(this, data);
		try {
			for (int i = 1; i < num; i += 2) {
				Token op = (Token) node.jjtGetChild(i).jjtAccept(this, data);
				BValue<?> other = (BValue<?>) node.jjtGetChild(i + 1)
						.jjtAccept(this, data);
				switch (op.kind) {
				case BegicParser.MOD:
					value = value.mod(other);
					break;
				case BegicParser.POWER:
					value = value.pow(other);
					break;
				default:
					throw new BegicRunTimeException("AddMnsOp-default");
				}
			}
		} catch (BegicRunTimeException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return value;
	}

	@Override
	public Object visit(ASTNot node, Object data) {
		return node.jjtGetValue();
	}

	@Override
	public Object visit(ASTComp node, Object data) {
		return node.jjtGetValue();
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
	public Object visit(ASTModPow node, Object data) {
		return node.jjtGetValue();
	}

	@Override
	public Object visit(ASTExpression node, Object data) {
		return node.jjtGetChild(0).jjtAccept(this, data);
	}

	@Override
	public Object visit(ASTIdentifier node, Object data) {
		return nameSpace.getValue(((Token) node.jjtGetValue()).image);
	}

	@Override
	public Object visit(ASTFunction node, Object data) {
		int num = node.jjtGetNumChildren();
		String funcName = ((Token) node.jjtGetValue()).image;
		BFunction func = BFunctionFactory.getInstance().getFunction(funcName);
		List<BValue<?>> args = new ArrayList<BValue<?>>();
		for (int i = 0; i < num; i++) {
			args.add((BValue<?>) node.jjtGetChild(i).jjtAccept(this, data));
		}
		BValue<?> ret = null;
		try {
			ret = func
					.calc(new BArgs(args.toArray(new BValue<?>[args.size()])));
		} catch (BegicRunTimeException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return ret;
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
				System.exit(1);
			}
		}
		return hash;
	}

	@Override
	public Object visit(ASTListHashFactor node, Object data) {
		int num = node.jjtGetNumChildren();

		IBCollection col = (IBCollection) node.jjtGetChild(0).jjtAccept(this,
				data);
		BValue<?> val = null;
		for (int i = 1; i < num; i++) {
			BValue<?> key = (BValue<?>) node.jjtGetChild(i).jjtAccept(this,
					data);

			try {
				val = col.get(key);
			} catch (BegicRunTimeException e) {
				e.printStackTrace();
				System.exit(0);
			}
			if (i < num - 1)
				col = (IBCollection) val;
		}
		return val;
	}

	@Override
	public Object visit(ASTFloat node, Object data) {
		return new BFloat((((Token) node.jjtGetValue()).image));
	}

	@Override
	public Object visit(ASTString node, Object data) {
		return new BString(((Token) node.jjtGetValue()).image.substring(1,
				((Token) node.jjtGetValue()).image.length() - 1));
	}

	@Override
	public Object visit(ASTBoolean node, Object data) {
		BValue<?> value = null;
		try {
			value = new BBoolean(((Token) node.jjtGetValue()).image);
		} catch (BegicRunTimeException e) {
			e.printStackTrace();
			System.exit(0);
		}
		return value;
	}

	// @Override
	// public Object visit(ASTEnpty node, Object data) {
	// return new BEnpty();
	// }

	@Override
	public Object visit(ASTColor node, Object data) {
		return new BColor(((Token) node.jjtGetValue()).image);
	}

	// 通常は使われない。
	@Override
	public Object visit(SimpleNode node, Object data) {
		return null;
	}

}
