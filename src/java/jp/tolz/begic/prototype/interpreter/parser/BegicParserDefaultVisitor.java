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
  public Object visit(ASTAssingment node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTExpression node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTList node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTListHashFactor node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTHash node, Object data){
    return defaultVisit(node, data);
  }
}
/* JavaCC - OriginalChecksum=a1bab5b84482dd2cf442f401d0019c6c (do not edit this line) */
