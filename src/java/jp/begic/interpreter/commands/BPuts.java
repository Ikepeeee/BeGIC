package jp.begic.interpreter.commands;

import jp.begic.interpreter.commands.base.BArgs;

class BPuts extends BCommand {

	@Override
	public void exec(BArgs args) {
		for(int i = 0; i < args.size(); i++){
			System.out.println(args.get(i));
		}
	}
}
