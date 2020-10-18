package FixController;

import DataClass.DictionaryManagement;
import DictionaryApplication.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.TextFields;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

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
