package jp.tolz.begic.prototype.interpreter.commands;

import jp.tolz.begic.prototype.interpreter.commands.base.Command;

/**
 * BeGIC�̕W���o�͖��߂ł��B<br>
 * ������<br>
 * print "��������",num,"�ł�" // "��������num�ł�"���W���o�͂����B
 * @author toru ikeda
 *
 */
public class BPrint extends Command{
	private String[] args;
	
	public BPrint(String[] args) {
		super(args);
		this.args = args;
	}
	
	public String[] exec(){
		for(String s: args){
			System.out.print(s);
		}
		return null;
	}
	
}