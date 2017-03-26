package jp.begic.interpreter.functions;

import jp.begic.interpreter.commands.base.BArgs;
import jp.begic.interpreter.exception.BegicRunTimeException;
import jp.begic.interpreter.values.BValue;

/**
 * Singleton��Flyweight�p�^�[���𗘗p���Ă��܂��B
 * 
 * @author Toru Ikeda
 *
 */
public interface BFunction {
	BValue<?> calc(BArgs args) throws BegicRunTimeException;

	public int[] argsType();

	public int returnType();
}
