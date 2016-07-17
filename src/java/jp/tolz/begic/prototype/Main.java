package jp.tolz.begic.prototype;

import jp.tolz.begic.prototype.interpreter.parser.BegicParser;
import jp.tolz.begic.prototype.interpreter.parser.SimpleNode;
import jp.tolz.begic.prototype.interpreter.parser.Token;

public class Main {
	public static void main(String[] args) {

		System.out.println("Reading from standard input...");
		System.out.print("Enter an expression like \"1+(2+3)*var;\" :");
		BegicParser parser = new BegicParser(System.in);
		try {
			parser.doParse();
			System.out.println("Thank you.");
		} catch (Exception e) {
			System.out.println("Oops.");
			System.out.println(e.getMessage());
		}
	}

}