/* Generated By:JJTree: Do not edit this line. ASTOrOp.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package jp.begic.interpreter.parser;

public
class ASTOrOp extends SimpleNode {
  public ASTOrOp(int id) {
    super(id);
  }

  public ASTOrOp(BegicParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(BegicParserVisitor visitor, Object data) {

    return
    visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=6d4e4f9252db0cf5ff9adbf0be9d5d82 (do not edit this line) */