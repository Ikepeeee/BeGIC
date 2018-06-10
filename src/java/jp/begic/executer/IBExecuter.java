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

		int lineNum = 1;
		while (true) {
			String line = null;
			System.out.printf("begic: %03dL > ", lineNum);
			try {
				line = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
				System.exit(0);
			}

			if (line.matches("exit.*"))
				break;
			
			while (line.matches(".*?//")) {
				try {
					System.out.printf("begic: %03dL > ", lineNum);
					line += br.readLine();
				} catch (IOException e) {
					e.printStackTrace();
					System.exit(0);
				}
			}
			line = line.replaceAll("//", "\n");
				
			BegicParser parser = new BegicParser(new ByteArrayInputStream(
					line.getBytes()));
			try {
				parser.Program().jjtAccept(visitor, null);
				lineNum++;
			} catch (ParseException e) {
				System.err.println("構文エラー");
				e.printStackTrace();
				// System.exit(0);
			}
		}

	}

}
