import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.lang.Object;
import java.util.AbstractCollection;
import java.util.AbstractList;
import java.util.ArrayList;

import jp.tolz.begic.prototype.stub.Begic;
import jp.tolz.begic.prototype.stub.IBegic;

public class App extends Application{
    Label label;
    Button button;
    //TextField text;
    TextArea text;
    IBegic ibg = new IBegic();
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception{
        //text = new TextField();
        text = new TextArea();
        Label label = new Label("BeGIC");
        button = new Button("コンパイル"); //文字化けの場所
        button.setOnAction(new EventHandler<ActionEvent>(){
           @Override
           public void handle(ActionEvent e){
               //String script = text.getText();
               String script = text.getText(); //getting string
               String[] strs = script.split("\n"); //split string
               for(int i=0;i<strs.length;i++){
                ibg.eval(strs[i]); //send string
               }
               text.setText(""); //clear TextArea
           }
       });
        BorderPane pane = new BorderPane();
        pane.setTop(label);
        pane.setCenter(text);
        pane.setBottom(button);


        Scene scene = new Scene(pane, 320,240);
        stage.setScene(scene);
        stage.show();
    }
}
