/* Generated By:JJTree: Do not edit this line. ASTAndOp.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package jp.tolz.begic.prototype.interpreter.parser;

public
class ASTAndOp extends SimpleNode {
  public ASTAndOp(int id) {
    super(id);
  }

  public ASTAndOp(BegicParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(BegicParserVisitor visitor, Object data) {

    return
    visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=7b9cc562a0ed64d38674ff57d748fd5d (do not edit this line) */