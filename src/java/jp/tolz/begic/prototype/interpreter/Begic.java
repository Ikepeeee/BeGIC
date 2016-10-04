package jp.tolz.begic.prototype.interpreter;

import java.awt.Color;
import java.awt.Frame;

import jp.tolz.begic.prototype.interpreter.canvas.BCanvas;
import jp.tolz.begic.prototype.interpreter.commands.base.BArgs;
import jp.tolz.begic.prototype.interpreter.commands.base.BCommand;

/**
 * ファイルから実行用のクラスです。
 * ソースファイルを読み込みます。
 * @author Toru Ikeda
 *
 */
public class Begic {
	
	
	
	public static void main(String[] args){
		new Begic();
	}
	
	public Begic(){
		BCanvas bcanvas = new BCanvas();
		
		Frame frame = new Frame();// Frameを作成
		frame.add(bcanvas);
		frame.setSize(240, 240);// サイズを指定
		frame.setVisible(true);// 表示
		
		bcanvas.repaint();
	}
	
	
	
}
