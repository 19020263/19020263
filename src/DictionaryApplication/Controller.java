package DictionaryApplication;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.TextFields;

import java.net.URL;
import java.util.*;

public class Controller implements Initializable {
    @FXML
    private TextField input;
    @FXML
    public TextArea textArea;

    Set<String> pwords = new HashSet<>();
    private AutoCompletionBinding<String> autoCompletionBinding;


    public String[] setListEng() {
        DictionaryManagement.insertFromFile();
        List<Word> words = Dictionary.getWords();
        String[] wordsArray = new String[words.size()];
        for (int i = 0; i < words.size(); i++) {
            wordsArray[i] = words.get(i).getWordtarget();
        }
        return wordsArray;
    }

    public String[] setListVie() {
        DictionaryManagement.insertFromFile();
        List<Word> words = Dictionary.getWords();
        String[] wordsArray = new String[words.size()];
        for (int i = 0; i < words.size(); i++) {
            wordsArray[i] = words.get(i).getWordexplain();
        }
        return wordsArray;
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Collections.addAll(pwords, setListEng());
        autoCompletionBinding = TextFields.bindAutoCompletion(input, pwords);

        input.setOnKeyPressed((KeyEvent e) ->{
            switch(e.getCode()) {
                case ENTER:
                    learnWord(input.getText());
                    break;
                default:
                    break;
            }
        });
    }

    private void learnWord(String text) {
        pwords.add(text);

        if(autoCompletionBinding != null) {
            autoCompletionBinding.dispose();
        }

        autoCompletionBinding = TextFields.bindAutoCompletion(input, pwords);
    }

    public void TextFieldChanged(ActionEvent event) {
        String[] Words = setListVie();
        String s = input.getText();
        for(int i = 0; i < Words.length; i++) {
            if(s.equalsIgnoreCase(setListEng()[i])) {
                textArea.setText(Words[i]);
            }
        }
    }
}