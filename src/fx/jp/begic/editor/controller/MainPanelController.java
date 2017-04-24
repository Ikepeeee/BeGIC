package jp.begic.editor.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class MainPanelController implements IMainPanelController {
	@FXML
	private TextArea codeTextArea;
	
	@Override
	public void newFile(ActionEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void openFile(ActionEvent e) {
		// TODO 自動生成されたメソッド・スタブ
	}
	
	@Override
	public void saveFile(ActionEvent e){
		System.out.println(codeTextArea.getText());
	}

	@Override
	public void quit(ActionEvent e) {
		// 終了の方法は検討
		System.exit(0);
	}

}
