package jp.begic.interpreter.commands;

import jp.begic.interpreter.commands.base.BArgs;
import jp.begic.interpreter.commands.base.BCommand;

class BPuts extends BCommand {

	@Override
	public void exec(BArgs args) {
		for(int i = 0; i < args.size(); i++){
			System.out.println(args.get(i));
		}
	}

	@Override
	public boolean isInUse() {
		return false;
	}
}
