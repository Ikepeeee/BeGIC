/* Generated By:JJTree: Do not edit this line. ASTNot.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package jp.begic.interpreter.parser;

public
class ASTNot extends SimpleNode {
  public ASTNot(int id) {
    super(id);
  }

  public ASTNot(BegicParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(BegicParserVisitor visitor, Object data) {

    return
    visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=761ae6e990152f4bfbaf7c8497e45d22 (do not edit this line) */