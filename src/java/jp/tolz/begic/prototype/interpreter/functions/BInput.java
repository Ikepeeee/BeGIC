package jp.tolz.begic.prototype.interpreter.functions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import jp.tolz.begic.prototype.interpreter.commands.base.BArgs;
import jp.tolz.begic.prototype.interpreter.exception.BegicRunTimeException;
import jp.tolz.begic.prototype.interpreter.values.BString;
import jp.tolz.begic.prototype.interpreter.values.BValue;

class BInput implements BFunction {

	private int[] types = new int[0];
	
	@Override
	public BValue<?> calc(BArgs args) throws BegicRunTimeException {
		String s = null;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		try {
			s = new String(in.readLine());
		} catch (IOException e) {
			throw new BegicRunTimeException();
		}
		return new BString(s.concat("\n"));
	}

	@Override
	public int[] argsType() {
		return types;
	}

	@Override
	public int returnType() {
		return types.length;
	}

}
