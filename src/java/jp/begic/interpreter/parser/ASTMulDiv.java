/* Generated By:JJTree: Do not edit this line. ASTMulDiv.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package jp.begic.interpreter.parser;

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
/* JavaCC - OriginalChecksum=8518aa7d3f12a8ce945546a3eb8d2b6b (do not edit this line) */
