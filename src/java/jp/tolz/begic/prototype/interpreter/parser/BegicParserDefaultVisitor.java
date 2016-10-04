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
  public Object visit(ASTArgs node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTCall node, Object data){
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
  public Object visit(ASTBreak node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTNext node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTAssingment node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTOperation node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTOrOp node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTAndOp node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTNotOp node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTCompOp node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTComp node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTAddMnsOp node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTAddMns node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTMulDivOp node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTMulDiv node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTModPowOp node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTModPow node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTSingleAddMnsOp node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTExpression node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTFunction node, Object data){
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
  public Object visit(ASTIdentifier node, Object data){
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
/* JavaCC - OriginalChecksum=6ddda1ef85ac87e9a1d570963e49fc64 (do not edit this line) */
