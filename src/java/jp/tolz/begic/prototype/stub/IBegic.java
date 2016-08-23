package jp.tolz.begic.prototype.stub;

import java.awt.Canvas;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * スタブのクラスです。こちらのクラスを利用してエディタを作成してください。 ファイルから実行を行います。
 * 
 * @author Toru Ikeda
 *
 */
public class IBegic {
	private Frame frame = new Frame();
	private Canvas canvas = new Canvas() {
		@Override
		public void paint(Graphics g) {
			draw(g);
		}
	};
	private ArrayList<Drawer> drawList = new ArrayList<Drawer>();

	/**
	 * BeGICのソースファイルを受付て実行します。 第一引数にソースファイルのパスを指定してください。
	 * 
	 * @param args
	 *            BeGICソースファイルパス
	 */
	public static void main(String[] args) throws FileNotFoundException {
		FileReader fr = null;
		Scanner br = null;
		String srcFile = args[0];
		ArrayList<String> script = new ArrayList<String>();
		try {
			fr = new FileReader(srcFile);
			br = new Scanner(fr);
			while(br.hasNextLine()){
				script.add(br.nextLine());
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		new IBegic(script);
	}

	/**
	 * スクリプトを実行します。
	 * 
	 * @param script
	 *            スクリプトを一行ごとに分割した配列。
	 */
	public IBegic(ArrayList<String> script) {
		String[] command = null;
		for (String line : script) {
			line = line.replaceAll("//.*", "");
			command = line.split("[(), \t]+");
			if ("window".equals(command[0])) {
				window(Integer.valueOf(command[1]), Integer.valueOf(command[2]));
			} else if ("line".equals(command[0])) {
				drawList.add(new Line(Integer.valueOf(command[1]), Integer
						.valueOf(command[2]), Integer.valueOf(command[3]),
						Integer.valueOf(command[4])));
			} else if ("write".equals(command[0])) {
				drawList.add(new Write(command[1].replaceAll("\"", ""), Integer
						.valueOf(command[2]), Integer.valueOf(command[3])));
			} else if ("puts".equals(command[0])) {
				drawList.add(new Puts(command[1].replaceAll("\"", "")));
			}
		}
		frame.add(canvas);
		frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
		frame.setVisible(true);
	}

	private void draw(Graphics g) {
		for (Drawer d : drawList) {
			d.g = g;
			d.draw();
		}
	}

	private void window(int width, int height) {
		frame.setSize(width, height);
	}

	private abstract class Drawer {
		public Graphics g;

		public abstract void draw();
	}

	private class Line extends Drawer {
		private int x1, y1, x2, y2;

		public Line(int x1, int y1, int x2, int y2) {
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
		}

		public void draw() {
			g.drawLine(x1, y1, x2, y2);
		}
	}

	private class Write extends Drawer {
		private String str;
		private int x, y;

		public Write(String str, int x, int y) {
			this.str = str;
			this.x = x;
			this.y = y;
		}

		@Override
		public void draw() {
			g.drawString(str, x, y);
		}

	}

	private class Puts extends Drawer {
		private String str;

		public Puts(String str) {
			this.str = str;
		}

		@Override
		public void draw() {
			System.out.print(str);

		}

	}
}
