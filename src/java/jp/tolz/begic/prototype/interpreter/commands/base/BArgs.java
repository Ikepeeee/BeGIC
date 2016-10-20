package jp.tolz.begic.prototype.interpreter.commands.base;

import jp.tolz.begic.prototype.interpreter.values.BValue;

/**
 * Command�̈����󂯓n���p�N���X�ł��B
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
