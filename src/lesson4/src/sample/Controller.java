package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private Button butPress;

    @FXML
    private Label chartList;

    @FXML
    private TextArea textList;

    @FXML
    private TextField inputText;
    @FXML
    public  void  onMyPress(){
        if(inputText.getText().length() == 0) return;
        textList.appendText(inputText.getText() + "\n");
        inputText.setText("");
    }
    @FXML
    public void onTextField(ActionEvent actionEvent) {
        if(inputText.getText().length() == 0) return;
        textList.appendText(inputText.getText() + "\n");

        inputText.setText("");

    }
}
