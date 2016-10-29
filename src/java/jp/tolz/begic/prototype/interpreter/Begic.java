package jp.tolz.begic.prototype.interpreter;

import java.awt.Color;
import java.awt.Frame;

import jp.tolz.begic.prototype.interpreter.canvas.BCanvas;
import jp.tolz.begic.prototype.interpreter.commands.BCommand;
import jp.tolz.begic.prototype.interpreter.commands.base.BArgs;

/**
 * �t�@�C��������s�p�̃N���X�ł��B �\�[�X�t�@�C����ǂݍ��݂܂��B
 * 
 * @author Toru Ikeda
 *
 */
public class Begic {

	public static void main(String[] args) {
		new Begic();
	}

	public Begic() {
		BCanvas bcanvas = new BCanvas();

		Frame frame = new Frame();// Frame���쐬
		frame.add(bcanvas);
		bcanvas.setSize(100, 100);
		frame.setSize(bcanvas.getWidth(), bcanvas.getHeight());
		//frame.setSize(240, 240);// �T�C�Y���w��
		frame.setVisible(true);// �\��

		bcanvas.repaint();
	}

}
