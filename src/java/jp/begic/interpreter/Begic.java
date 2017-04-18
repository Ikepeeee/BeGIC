package jp.begic.interpreter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import jp.begic.executer.BExecuter;

/**
 * �t�@�C��������s�p�̃N���X�ł��B �\�[�X�t�@�C����ǂݍ��݂܂��B
 * 
 * @author Toru Ikeda
 *
 */
public class Begic {
	private static final String releaseDate = "2017/04/18";
	private static final String version = "1.0.0 (pre.1)";
	private static final String buildBy = "jdk1.8.0_121";
	private static final String name = "BeGIC";

	public static void main(String[] args) {

		if (args[0].matches("-.*")) {
			switch (args[0]) {
			case "-v":
			case "--version":
				System.out.println(version());
				System.exit(0);
				break;
			default:
				System.out.println("Unrecognized option: " + args[0]);
				break;
			}
		} else {
			try {
				new Begic(args[0]);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

	public Begic(String path) throws FileNotFoundException {
		InputStream code = new FileInputStream(new File(path));
		BExecuter exe = new BExecuter();
		exe.exec(code);
	}
	
	public static String version(){
		return name + " version " + version + " (" + releaseDate + ") [" + buildBy + "]";
	}

}
