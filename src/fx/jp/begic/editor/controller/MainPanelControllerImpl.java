package jp.begic.editor.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public interface MainPanelControllerImpl {
	@FXML
	public void newFile(ActionEvent e);
	
	@FXML
	public void openFile(ActionEvent e);
	
	@FXML
	public void quit(ActionEvent e);
	
	
}
