package jp.tolz.begic.prototype.interpreter.functions.base;

import jp.tolz.begic.prototype.interpreter.commands.base.BArgs;
import jp.tolz.begic.prototype.interpreter.values.BValue;

public interface IBFunction {
	public BValue calc(BArgs args);
}
