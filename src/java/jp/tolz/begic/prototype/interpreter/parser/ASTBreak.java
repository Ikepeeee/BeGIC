/* Generated By:JJTree: Do not edit this line. ASTBreak.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package jp.tolz.begic.prototype.interpreter.parser;

public
class ASTBreak extends SimpleNode {
  public ASTBreak(int id) {
    super(id);
  }

  public ASTBreak(BegicParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(BegicParserVisitor visitor, Object data) {

    return
    visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=c11cba1d4878db7e32d12026929b9b64 (do not edit this line) */