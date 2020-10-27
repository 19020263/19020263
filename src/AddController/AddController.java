package AddController;

import DataClass.Dictionary;
import DataClass.DictionaryManagement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddController implements Initializable {

    @FXML
    private javafx.scene.control.TextField word;
    @FXML
    private javafx.scene.control.TextField wordm;

    public void addNewWord(ActionEvent event) throws FileNotFoundException {
        DictionaryManagement.insertWord(word.getText(), wordm.getText());
        if(Dictionary.duplicateWord(word.getText())) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("New word is added successfully!");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("New word had already in the dictionary");
            alert.showAndWait();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
