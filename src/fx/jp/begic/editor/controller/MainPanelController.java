package jp.begic.editor.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class MainPanelController implements IMainPanelController {
	@FXML
	private TextArea codeTextArea;
	
	@Override
	public void newFile(ActionEvent e) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		
	}

	@Override
	public void openFile(ActionEvent e) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
	}
	
	@Override
	public void saveFile(ActionEvent e){
		System.out.println(codeTextArea.getText());
	}

	@Override
	public void quit(ActionEvent e) {
		// �I���̕��@�͌���
		System.exit(0);
	}

}
