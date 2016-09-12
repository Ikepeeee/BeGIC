package jp.tolz.begic.prototype.interpreter.process;

import jp.tolz.begic.prototype.interpreter.exception.BegicRunTimeException;
import jp.tolz.begic.prototype.interpreter.namespace.NameSpace;
import jp.tolz.begic.prototype.interpreter.parser.ASTAbs;
import jp.tolz.begic.prototype.interpreter.parser.ASTAssingment;
import jp.tolz.begic.prototype.interpreter.parser.ASTBlock;
import jp.tolz.begic.prototype.interpreter.parser.ASTBoolean;
import jp.tolz.begic.prototype.interpreter.parser.ASTColor;
import jp.tolz.begic.prototype.interpreter.parser.ASTCommand;
import jp.tolz.begic.prototype.interpreter.parser.ASTExpression;
import jp.tolz.begic.prototype.interpreter.parser.ASTFloat;
import jp.tolz.begic.prototype.interpreter.parser.ASTForStatement;
import jp.tolz.begic.prototype.interpreter.parser.ASTHash;
import jp.tolz.begic.prototype.interpreter.parser.ASTIdentigier;
import jp.tolz.begic.prototype.interpreter.parser.ASTIfStatement;
import jp.tolz.begic.prototype.interpreter.parser.ASTList;
import jp.tolz.begic.prototype.interpreter.parser.ASTListHashFactor;
import jp.tolz.begic.prototype.interpreter.parser.ASTLoopStatement;
import jp.tolz.begic.prototype.interpreter.parser.ASTProgram;
import jp.tolz.begic.prototype.interpreter.parser.ASTString;
import jp.tolz.begic.prototype.interpreter.parser.ASTWhileStatement;
import jp.tolz.begic.prototype.interpreter.parser.ASTaddOp;
import jp.tolz.begic.prototype.interpreter.parser.ASTdivOp;
import jp.tolz.begic.prototype.interpreter.parser.ASTmnsOp;
import jp.tolz.begic.prototype.interpreter.parser.ASTmodOp;
import jp.tolz.begic.prototype.interpreter.parser.ASTmulOp;
import jp.tolz.begic.prototype.interpreter.parser.ASTpowOp;
import jp.tolz.begic.prototype.interpreter.parser.BegicParserVisitor;
import jp.tolz.begic.prototype.interpreter.parser.SimpleNode;
import jp.tolz.begic.prototype.interpreter.values.BBoolean;
import jp.tolz.begic.prototype.interpreter.values.BColor;
import jp.tolz.begic.prototype.interpreter.values.BFloat;
import jp.tolz.begic.prototype.interpreter.values.BString;
import jp.tolz.begic.prototype.interpreter.values.base.BValue;



public class BegicVisitor implements BegicParserVisitor {

	@Override
	public Object visit(SimpleNode node, Object data) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public Object visit(ASTProgram node, Object data) {
		int num = node.jjtGetNumChildren();
		for(int i = 0; i < num; i++){
			node.jjtGetChild(i).jjtAccept(this, null);
		}
		return data;
	}

	@Override
	public Object visit(ASTCommand node, Object data) {
		int num = node.jjtGetNumChildren();
		for(int i = 0; i < num; i++){
			node.jjtGetChild(i).jjtAccept(this, null);
		}
		return data;
	}

	@Override
	public Object visit(ASTIfStatement node, Object data) {
		int num = node.jjtGetNumChildren();
		for(int i = 0; i < num; i++){
			node.jjtGetChild(i).jjtAccept(this, null);
		}
		return data;
	}

	@Override
	public Object visit(ASTLoopStatement node, Object data) {
		int num = node.jjtGetNumChildren();
		for(int i = 0; i < num; i++){
			node.jjtGetChild(i).jjtAccept(this, null);
		}
		return data;
	}

	@Override
	public Object visit(ASTWhileStatement node, Object data) {
		int num = node.jjtGetNumChildren();
		for(int i = 0; i < num; i++){
			node.jjtGetChild(i).jjtAccept(this, null);
		}
		return data;
	}

	@Override
	public Object visit(ASTForStatement node, Object data) {
		int num = node.jjtGetNumChildren();
		for(int i = 0; i < num; i++){
			node.jjtGetChild(i).jjtAccept(this, null);
		}
		return data;
	}

	@Override
	public Object visit(ASTBlock node, Object data) {
		int num = node.jjtGetNumChildren();
		for(int i = 0; i < num; i++){
			node.jjtGetChild(i).jjtAccept(this, null);
		}
		return data;
	}

	@Override
	public Object visit(ASTAssingment node, Object data) {
		int num = node.jjtGetNumChildren();
		for(int i = 0; i < num; i++){
			node.jjtGetChild(i).jjtAccept(this, null);
		}
		return data;
	}

	@Override
	public Object visit(ASTExpression node, Object data) {
		int num = node.jjtGetNumChildren();
		for(int i = 0; i < num; i++){
			node.jjtGetChild(i).jjtAccept(this, null);
		}
		return data;
	}

	@Override
	public Object visit(ASTAbs node, Object data) {
		int num = node.jjtGetNumChildren();
		for(int i = 0; i < num; i++){
			node.jjtGetChild(i).jjtAccept(this, null);
		}
		return data;
	}

	@Override
	public Object visit(ASTList node, Object data) {
		int num = node.jjtGetNumChildren();
		for(int i = 0; i < num; i++){
			node.jjtGetChild(i).jjtAccept(this, null);
		}
		return data;
	}

	@Override
	public Object visit(ASTHash node, Object data) {
		int num = node.jjtGetNumChildren();
		for(int i = 0; i < num; i++){
			node.jjtGetChild(i).jjtAccept(this, null);
		}
		return data;
	}

	@Override
	public Object visit(ASTListHashFactor node, Object data) {
		int num = node.jjtGetNumChildren();
		for(int i = 0; i < num; i++){
			node.jjtGetChild(i).jjtAccept(this, null);
		}
		return data;
	}

	@Override
	public Object visit(ASTIdentigier node, Object data) {
		return NameSpace.getValue((String) node.jjtGetValue());
	}

	@Override
	public Object visit(ASTFloat node, Object data) {
		return new BFloat((String)node.jjtGetValue());
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
	public Object visit(ASTaddOp node, Object data){
		BValue val1 = (BValue) node.jjtGetChild(0);
		BValue val2 = (BValue) node.jjtGetChild(1);
		if(val1.type() == BValue.BFLOAT && val2.type() == BValue.BFLOAT){
			
		}else if(val1.type() == BValue.BSTRING && val2.type() == BValue.BSTRING){
			
		}else if(val1.type() == BValue.BSTRING && val2.type() == BValue.BFLOAT){
			
		}else if(val1.type() == BValue.BFLOAT && val2.type() == BValue.BSTRING){
			
		}else if(val1.type() == BValue.BLIST && val2.type() == BValue.BLIST){
			
		}else{
			System.err.println("定義されない演算です。");
		}
		return null;
	}

	@Override
	public Object visit(ASTmnsOp node, Object data) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public Object visit(ASTmulOp node, Object data) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public Object visit(ASTdivOp node, Object data) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public Object visit(ASTmodOp node, Object data) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public Object visit(ASTpowOp node, Object data) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
	
}
