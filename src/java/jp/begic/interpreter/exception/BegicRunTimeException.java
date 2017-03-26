package jp.begic.interpreter.exception;

public class BegicRunTimeException extends Exception {
	public BegicRunTimeException() {
		super("実行時エラー");
	}
	public BegicRunTimeException(String m) {
		super(m);
	}
}
