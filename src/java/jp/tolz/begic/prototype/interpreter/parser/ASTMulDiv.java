/* Generated By:JJTree: Do not edit this line. ASTMulDiv.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package jp.tolz.begic.prototype.interpreter.parser;

public
class ASTMulDiv extends SimpleNode {
  public ASTMulDiv(int id) {
    super(id);
  }

  public ASTMulDiv(BegicParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(BegicParserVisitor visitor, Object data) {

    return
    visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=60128bb0522131ae2d4e52b502a7044f (do not edit this line) */