package jp.begic.interpreter;

import jp.begic.executer.Executer;
import jp.begic.executer.IBExecuter;

/**
 * 即時実行用のクラスです。
 * 
 * @author Toru Ikeda
 *
 */
public class IBegic {
	private static final String releaseDate = "2017/11/25";
	private static final String version = "1.0.0";
	private static final String buildBy = "jdk1.8.0_91";
	private static final String name = "BeGIC";

	public static void main(String[] args) {
		
		if (args.length > 0 && args[0].matches("-.*")) {
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
			new IBegic();
		}
	}

	public IBegic() {
		Executer exe = new IBExecuter();
		
		exe.exec(System.in);
	}

	public static String version() {
		return name + " version " + version + " (" + releaseDate + ") ["
				+ buildBy + "]";
	}
}
