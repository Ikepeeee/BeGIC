package jp.begic.interpreter.commands.base;

/**
 * BeGIC�ŗp����R�}���h�̊��N���X�B
 * �S�ẴR�}���h��Command���p������K�v������B
 * @author toru ikeda
 *
 */
public abstract class BCommand{
	/**
	 * �R�}���h�̎��s���\�b�h
	 */
	public abstract void exec(BArgs bargs);
	
	/**
	 * �R�}���h���g�p���ł��邩�𒲂ׂ܂��B
	 * @return
	 */
	public abstract boolean isInUse();

}