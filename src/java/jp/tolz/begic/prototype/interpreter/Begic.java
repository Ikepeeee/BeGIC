package jp.tolz.begic.prototype.interpreter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import jp.tolz.begic.prototype.executer.BExecuter;

/**
 * ファイルから実行用のクラスです。 ソースファイルを読み込みます。
 * 
 * @author Toru Ikeda
 *
 */
public class Begic {

	public static void main(String[] args) {

		switch (args[0]) {
		case "-v":
		case "--version":
			System.out.println("BeGIC 0.0.0 (2016/11/01) [jdk1.8.0_91]");
			System.exit(0);
			break;
		}
		String path = args[0];
		try {
			new Begic(path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Begic(String path) throws FileNotFoundException {
		InputStream code = new FileInputStream(new File(path));
		BExecuter exe = new BExecuter();
		exe.exec(code);
	}

}
