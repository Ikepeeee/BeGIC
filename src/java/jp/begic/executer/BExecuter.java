package jp.begic.executer;

import java.io.InputStream;

import jp.begic.interpreter.parser.BegicParser;
import jp.begic.interpreter.parser.ParseException;
import jp.begic.interpreter.process.BegicVisitor;

/**
 * BeGIC���s���s���N���X�B ���Ŏ��s�����ꍇ�̃^�C�v�ł��B
 * 
 * @author Toru Ikeda
 *
 */
public class BExecuter implements Executer {

	@Override
	public void exec(InputStream stream) {

		BegicParser parser = new BegicParser(stream);
		BegicVisitor visitor = new BegicVisitor();

		try {
			parser.Program().jjtAccept(visitor, null);

		} catch (ParseException e) {
			System.err.println("�\���G���[");
			e.printStackTrace();
			System.exit(0);
		}
		
		
	}

}
