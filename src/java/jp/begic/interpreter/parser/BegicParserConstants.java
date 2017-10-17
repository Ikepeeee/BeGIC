/* Generated By:JJTree&JavaCC: Do not edit this line. BegicParserConstants.java */
package jp.begic.interpreter.parser;


/**
 * Token literal values and constants.
 * Generated by org.javacc.parser.OtherFilesGen#start()
 */
public interface BegicParserConstants {

  /** End of File. */
  int EOF = 0;
  /** RegularExpression Id. */
  int EQ = 6;
  /** RegularExpression Id. */
  int NEQ = 7;
  /** RegularExpression Id. */
  int ASSIGN = 8;
  /** RegularExpression Id. */
  int CONSTANT_ASSIGN = 9;
  /** RegularExpression Id. */
  int EXCHANGE = 10;
  /** RegularExpression Id. */
  int GT = 11;
  /** RegularExpression Id. */
  int LT = 12;
  /** RegularExpression Id. */
  int LE = 13;
  /** RegularExpression Id. */
  int GE = 14;
  /** RegularExpression Id. */
  int PUSH = 15;
  /** RegularExpression Id. */
  int NOT = 16;
  /** RegularExpression Id. */
  int QUESTION = 17;
  /** RegularExpression Id. */
  int OR = 18;
  /** RegularExpression Id. */
  int AND = 19;
  /** RegularExpression Id. */
  int PLUS = 20;
  /** RegularExpression Id. */
  int MINUS = 21;
  /** RegularExpression Id. */
  int STAR = 22;
  /** RegularExpression Id. */
  int SLASH = 23;
  /** RegularExpression Id. */
  int POWER = 24;
  /** RegularExpression Id. */
  int MOD = 25;
  /** RegularExpression Id. */
  int BCOMMAND = 26;
  /** RegularExpression Id. */
  int IF = 27;
  /** RegularExpression Id. */
  int ELSIF = 28;
  /** RegularExpression Id. */
  int ELSE = 29;
  /** RegularExpression Id. */
  int WHILE = 30;
  /** RegularExpression Id. */
  int LOOP = 31;
  /** RegularExpression Id. */
  int FOR = 32;
  /** RegularExpression Id. */
  int BREAK = 33;
  /** RegularExpression Id. */
  int NEXT = 34;
  /** RegularExpression Id. */
  int TO = 35;
  /** RegularExpression Id. */
  int STEP = 36;
  /** RegularExpression Id. */
  int DO = 37;
  /** RegularExpression Id. */
  int END = 38;
  /** RegularExpression Id. */
  int CALL = 39;
  /** RegularExpression Id. */
  int BFUNCTION = 40;
  /** RegularExpression Id. */
  int SINGLE_LINE_COMMENT = 44;
  /** RegularExpression Id. */
  int FORMAL_COMMENT = 45;
  /** RegularExpression Id. */
  int MULTI_LINE_COMMENT = 46;
  /** RegularExpression Id. */
  int STRING = 48;
  /** RegularExpression Id. */
  int DECIMAL = 49;
  /** RegularExpression Id. */
  int COLOR = 50;
  /** RegularExpression Id. */
  int BOOLEAN = 51;
  /** RegularExpression Id. */
  int EMPTY = 52;
  /** RegularExpression Id. */
  int IDENTIFIER = 53;

  /** Lexical state. */
  int DEFAULT = 0;
  /** Lexical state. */
  int IN_SINGLE_LINE_COMMENT = 1;
  /** Lexical state. */
  int IN_FORMAL_COMMENT = 2;
  /** Lexical state. */
  int IN_MULTI_LINE_COMMENT = 3;

  /** Literal token values. */
  String[] tokenImage = {
    "<EOF>",
    "\" \"",
    "\"\\t\"",
    "\"\\n\"",
    "\"\\r\"",
    "\"\\f\"",
    "\"==\"",
    "\"!=\"",
    "\"=\"",
    "\":=\"",
    "\"<->\"",
    "\">\"",
    "\"<\"",
    "\"<=\"",
    "\">=\"",
    "\"<<\"",
    "\"not\"",
    "\"?\"",
    "\"or\"",
    "\"and\"",
    "\"+\"",
    "\"-\"",
    "\"*\"",
    "\"/\"",
    "\"^\"",
    "\"mod\"",
    "<BCOMMAND>",
    "\"if\"",
    "\"elsif\"",
    "\"else\"",
    "\"while\"",
    "\"loop\"",
    "\"for\"",
    "\"break\"",
    "\"next\"",
    "\"to\"",
    "\"step\"",
    "\"do\"",
    "\"end\"",
    "\"call\"",
    "<BFUNCTION>",
    "\"//\"",
    "<token of kind 42>",
    "\"/*\"",
    "<SINGLE_LINE_COMMENT>",
    "\"*/\"",
    "\"*/\"",
    "<token of kind 47>",
    "<STRING>",
    "<DECIMAL>",
    "<COLOR>",
    "<BOOLEAN>",
    "\"empty\"",
    "<IDENTIFIER>",
    "\";\"",
    "\"(\"",
    "\",\"",
    "\")\"",
    "\"{\"",
    "\"}\"",
    "\"[\"",
    "\"]\"",
    "\":\"",
  };

}
