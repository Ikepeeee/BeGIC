/* Generated By:JJTree: Do not edit this line. ASTModPowOp.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package jp.begic.interpreter.parser;

public
class ASTModPowOp extends SimpleNode {
  public ASTModPowOp(int id) {
    super(id);
  }

  public ASTModPowOp(BegicParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(BegicParserVisitor visitor, Object data) {

    return
    visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=de1c4c2d64eeed06be4e7d6e65681fd7 (do not edit this line) */
