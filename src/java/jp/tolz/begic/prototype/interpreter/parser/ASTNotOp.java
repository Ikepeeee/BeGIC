/* Generated By:JJTree: Do not edit this line. ASTNotOp.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package jp.tolz.begic.prototype.interpreter.parser;

public
class ASTNotOp extends SimpleNode {
  public ASTNotOp(int id) {
    super(id);
  }

  public ASTNotOp(BegicParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(BegicParserVisitor visitor, Object data) {

    return
    visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=4720252573486482f4379f7af94cc359 (do not edit this line) */