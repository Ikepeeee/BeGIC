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
import jp.tolz.begic.prototype.interpreter.parser.ASTNotOp;
import jp.tolz.begic.prototype.interpreter.parser.ASTOperation;
import jp.tolz.begic.prototype.interpreter.parser.ASTOrOp;
import jp.tolz.begic.prototype.interpreter.parser.ASTProgram;
import jp.tolz.begic.prototype.interpreter.parser.ASTSingleAddMnsOp;
import jp.tolz.begic.prototype.interpreter.parser.ASTString;
import jp.tolz.begic.prototype.interpreter.parser.ASTWhileStatement;
import jp.tolz.begic.prototype.interpreter.parser.BegicParserVisitor;
import jp.tolz.begic.prototype.interpreter.parser.SimpleNode;
import jp.tolz.begic.prototype.interpreter.values.BBoolean;
import jp.tolz.begic.prototype.interpreter.values.BColor;
import jp.tolz.begic.prototype.interpreter.values.BFloat;
import jp.tolz.begic.prototype.interpreter.values.BString;
import jp.tolz.begic.prototype.interpreter.values.BValue;

/**
 * 
 * @author Toru Ikeda
 *
 */
public class BegicVisitor implements BegicParserVisitor {

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
		return data;
	}

	@Override
	public Object visit(ASTCommand node, Object data) {
		// 引数の有無を確認。
		int num = node.jjtGetNumChildren();
		String command = (String) node.jjtGetValue();
		if(num == 2){
			BValue[] args = (BValue[]) node.jjtGetChild(1).jjtAccept(this, data);
			
		}else{
			
		}
		return data;
	}
	

	@Override
	public Object visit(ASTArgs node, Object data) {
		int num = node.jjtGetNumChildren();
		BValue[] args = new BValue[num];
		for(int i = 0; i < num; i++){
			args[i] = (BValue) node.jjtGetChild(i).jjtAccept(this, data);
		}
		return args;
	}

	@Override
	public Object visit(ASTIfStatement node, Object data) {
		int num = node.jjtGetNumChildren();
		for (int i = 0; i < num; i += 2) {
			if (((BBoolean) node.jjtGetChild(i).jjtAccept(this, null)).toString()
					.equals("true")) {
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
		node.childrenAccept(this, data);
		return null;
	}

	@Override
	public Object visit(ASTLoopStatement node, Object data) {
		node.jjtGetChild(0).jjtAccept(this, data);
		return null;
	}

	@Override
	public Object visit(ASTWhileStatement node, Object data) {
		while(((BBoolean) node.jjtGetChild(0)).toString().equals("true")){
			node.jjtGetChild(1).jjtAccept(this, data);
		}
		return null;
	}

	@Override
	public Object visit(ASTForStatement node, Object data) {
		int num = node.jjtGetNumChildren();
		for (int i = 0; i < num; i++) {
			node.jjtGetChild(i).jjtAccept(this, null);
		}
		return data;
	}

	@Override
	public Object visit(ASTBlock node, Object data) {
		int num = node.jjtGetNumChildren();
		for (int i = 0; i < num; i++) {
			node.jjtGetChild(i).jjtAccept(this, null);
		}
		return data;
	}

	@Override
	public Object visit(ASTAssingment node, Object data) {
		int num = node.jjtGetNumChildren();
		for (int i = 0; i < num; i++) {
			node.jjtGetChild(i).jjtAccept(this, null);
		}
		return data;
	}

	@Override
	public Object visit(ASTExpression node, Object data) {
		int num = node.jjtGetNumChildren();
		for (int i = 0; i < num; i++) {
			data = node.jjtGetChild(i).jjtAccept(this, null);
		}
		return data;
	}

	@Override
	public Object visit(ASTList node, Object data) {
		int num = node.jjtGetNumChildren();
		for (int i = 0; i < num; i++) {
			node.jjtGetChild(i).jjtAccept(this, null);
		}
		return data;
	}

	@Override
	public Object visit(ASTHash node, Object data) {
		int num = node.jjtGetNumChildren();
		for (int i = 0; i < num; i++) {
			node.jjtGetChild(i).jjtAccept(this, null);
		}
		return data;
	}

	@Override
	public Object visit(ASTListHashFactor node, Object data) {
		int num = node.jjtGetNumChildren();
		for (int i = 0; i < num; i++) {
			node.jjtGetChild(i).jjtAccept(this, null);
		}
		return data;
	}

	@Override
	public Object visit(ASTFloat node, Object data) {
		System.out.println(node);
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
		return new BBoolean((String) node.jjtGetValue());
	}

	@Override
	public Object visit(ASTAddMnsOp node, Object data) {
		BValue val1 = (BValue) node.jjtGetChild(0).jjtAccept(this, null);
		BValue val2 = (BValue) node.jjtGetChild(1).jjtAccept(this, null);
		return AddOp.eval(val1, val2);
	}

	@Override
	public Object visit(ASTOperation node, Object data) {
		int num = node.jjtGetNumChildren();
		for (int i = 0; i < num; i++) {
			node.jjtGetChild(i).jjtAccept(this, null);
		}
		return data;
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
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public Object visit(ASTAndOp node, Object data) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public Object visit(ASTNotOp node, Object data) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public Object visit(ASTCompOp node, Object data) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public Object visit(ASTAddMns node, Object data) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public Object visit(ASTMulDiv node, Object data) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public Object visit(ASTModPowOp node, Object data) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public Object visit(ASTModPow node, Object data) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public Object visit(ASTComp node, Object data) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public Object visit(ASTIdentifier node, Object data) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public Object visit(ASTBreak node, Object data) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public Object visit(ASTNext node, Object data) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public Object visit(ASTSingleAddMnsOp node, Object data) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public Object visit(ASTFunction node, Object data) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}
