package jp.tolz.begic.prototype.interpreter.commands.base;

/**
 * BeGIC�ŗp����R�}���h�̊��N���X�B
 * �S�ẴR�}���h��Command���p������K�v������B
 * @author toru ikeda
 *
 */
abstract public class Command{
	public Command(String[] args){
	}
	
	/**
	 * �R�}���h�̎��s���\�b�h
	 */
	abstract public String[] exec();
}