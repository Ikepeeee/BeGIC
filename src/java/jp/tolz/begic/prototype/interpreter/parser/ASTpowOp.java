/* Generated By:JJTree: Do not edit this line. ASTpowOp.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package jp.tolz.begic.prototype.interpreter.parser;

public
class ASTpowOp extends SimpleNode {
  public ASTpowOp(int id) {
    super(id);
  }

  public ASTpowOp(BegicParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(BegicParserVisitor visitor, Object data) {

    return
    visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=b01b3b923446f5a464b32a272e5d3a0d (do not edit this line) */
