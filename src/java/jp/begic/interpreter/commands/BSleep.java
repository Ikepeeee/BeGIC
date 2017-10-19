package jp.begic.interpreter.commands;

import jp.begic.interpreter.commands.base.BArgs;
import jp.begic.interpreter.commands.base.BCommand;
import jp.begic.interpreter.values.BDecimal;

public class BSleep extends BCommand {

	@Override
	public void exec(BArgs bargs) {
//		long st = System.currentTimeMillis();
//		long time = ((BDecimal) bargs.get(0)).getValue().toBigInteger().longValue();
//		while((System.currentTimeMillis() - st) < time);

		try {
			Thread.sleep(((BDecimal) bargs.get(0)).getValue().toBigInteger().longValue());
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean isInUse() {
		return false;
	}

}
