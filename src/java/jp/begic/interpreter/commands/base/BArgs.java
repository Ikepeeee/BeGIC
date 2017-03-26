package jp.begic.interpreter.commands.base;

import jp.begic.interpreter.values.BValue;

/**
 * Commandの引数受け渡し用クラスです。
 * 
 * @author Toru Ikeda
 *
 */
final public class BArgs {
	private BValue<?>[] args;
	
	public BArgs(BValue<?>[] args){
		this.args = args;
	}
	
	public BValue<?> get(int i){
		return args[i];
	}
	
	public int size(){
		return args.length;
	}
	
}
