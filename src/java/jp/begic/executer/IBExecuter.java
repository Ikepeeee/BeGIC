package jp.begic.executer;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import jp.begic.interpreter.parser.BegicParser;
import jp.begic.interpreter.parser.ParseException;
import jp.begic.interpreter.process.BegicVisitor;

/**
 * BeGIC実行者です。 複数回の実行を行います。
 * 
 * @author Toru Ikeda
 *
 */
public class IBExecuter implements Executer {

	@Override
	public void exec(InputStream stream) {

		BegicVisitor visitor = new BegicVisitor();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			while (true) {
				String line = null;
				System.out.print("begic > ");
				try {
					line = br.readLine();
				} catch (IOException e) {
					e.printStackTrace();
					System.exit(0);
				}

				if (line.matches("exit.*"))
					break;
				BegicParser parser = new BegicParser(new ByteArrayInputStream(
						line.getBytes()));
				parser.Program().jjtAccept(visitor, null);
			}
		} catch (ParseException e) {
			System.err.println("構文エラー");
			e.printStackTrace();
			System.exit(0);
		}

	}

}
