package jp.tolz.begic.prototype.interpreter.commands;

import jp.tolz.begic.prototype.interpreter.commands.base.BArgs;

class BPuts extends BCommand {

	@Override
	public void exec(BArgs args) {
		for(int i = 0; i < args.size(); i++){
			System.out.println(args.get(i));
		}
	}
}
