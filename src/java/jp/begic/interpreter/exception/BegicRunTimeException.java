package jp.begic.interpreter.exception;

public class BegicRunTimeException extends Exception {
	public BegicRunTimeException() {
		super("���s���G���[");
	}
	public BegicRunTimeException(String m) {
		super(m);
	}
}
