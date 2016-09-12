/* Generated By:JavaCC: Do not edit this line. BegicParserDefaultVisitor.java Version 6.0_1 */
package jp.tolz.begic.prototype.interpreter.parser;

public class BegicParserDefaultVisitor implements BegicParserVisitor{
  public Object defaultVisit(SimpleNode node, Object data){
    node.childrenAccept(this, data);
    return data;
  }
  public Object visit(SimpleNode node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTProgram node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTCommand node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTIfStatement node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTLoopStatement node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTWhileStatement node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTForStatement node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTBlock node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTAssingment node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTExpression node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTaddOp node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTmnsOp node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTmulOp node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTdivOp node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTmodOp node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTpowOp node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTAbs node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTList node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTHash node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTListHashFactor node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTIdentigier node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTBoolean node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTFloat node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTString node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTColor node, Object data){
    return defaultVisit(node, data);
  }
}
/* JavaCC - OriginalChecksum=060c09565d9ef2c18f4c0c43f71e1c8b (do not edit this line) */
