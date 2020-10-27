package FixController;

import DataClass.DictionaryManagement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.io.FileNotFoundException;

public class FixController {
    @FXML
    private TextField oword;
    @FXML
    private TextField word;
    @FXML
    private TextField wordm;

    public void fixWord(ActionEvent event) throws FileNotFoundException {
        DictionaryManagement.fixWord(oword.getText(), word.getText(), wordm.getText());
        DataClass.DictionaryManagement.insertFromFile();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText("' " + oword.getText() + "' is changed to ' " + word.getText() + "'");
        alert.showAndWait();
    }

}
