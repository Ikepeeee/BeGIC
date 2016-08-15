package jp.tolz.begic.prototype.interpreter.commands.base;

/**
 * Commandの引数受け渡し用クラスです。
 * 
 * @author Toru Ikeda
 *
 */
final public class BArgs {
	public Object[] args;
	
	public BArgs(Object[] args){
		this.args = args;
	}
}
