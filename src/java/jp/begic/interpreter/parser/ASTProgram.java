/* Generated By:JJTree: Do not edit this line. ASTProgram.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package jp.begic.interpreter.parser;

public
class ASTProgram extends SimpleNode {
  public ASTProgram(int id) {
    super(id);
  }

  public ASTProgram(BegicParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(BegicParserVisitor visitor, Object data) {

    return
    visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=a28e05f29723a61702034369f52e7cf0 (do not edit this line) */
