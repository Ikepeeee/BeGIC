/* Generated By:JJTree: Do not edit this line. ASTHash.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package jp.begic.interpreter.parser;

public
class ASTHash extends SimpleNode {
  public ASTHash(int id) {
    super(id);
  }

  public ASTHash(BegicParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(BegicParserVisitor visitor, Object data) {

    return
    visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=3f57b26ce9d16a064de8518724ca1021 (do not edit this line) */
