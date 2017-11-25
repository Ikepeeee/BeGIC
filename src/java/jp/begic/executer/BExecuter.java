package jp.begic.executer;

import java.io.InputStream;

import jp.begic.interpreter.parser.BegicParser;
import jp.begic.interpreter.parser.ParseException;
import jp.begic.interpreter.process.BegicVisitor;

/**
 * BeGIC実行を行うクラス。 一回で実行される場合のタイプです。
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
			System.err.println("構文エラー");
			e.printStackTrace();
			System.exit(0);
		}
		
		
	}

}
