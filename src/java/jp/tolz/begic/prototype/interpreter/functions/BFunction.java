package jp.tolz.begic.prototype.interpreter.functions;

import java.util.HashMap;

import jp.tolz.begic.prototype.interpreter.commands.base.BArgs;
import jp.tolz.begic.prototype.interpreter.exception.BegicRunTimeException;
import jp.tolz.begic.prototype.interpreter.values.BValue;

/**
 * SingletonとFlyweightパターンを利用しています。
 * @author Toru Ikeda
 *
 */
interface BFunction {
	BValue<?> calc(BArgs args) throws BegicRunTimeException;
	public int[] argsType();
	public int returnType();
}
