package DictionaryApplication;

import DataClass.Dictionary;
import DataClass.DictionaryCommandLine;
import DataClass.DictionaryManagement;
import DataClass.Word;
import impl.org.controlsfx.autocompletion.AutoCompletionTextFieldBinding;
import impl.org.controlsfx.autocompletion.SuggestionProvider;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.*;

public class Controller implements Initializable {
    @FXML
    private TextField input;
    @FXML
    public TextArea textArea;
    @FXML
    Button button1;
    @FXML
    Button button2;

    Stage primaryStage;

    private SuggestionProvider<String> provider;

    List<String> Engs = new ArrayList<>();

    public void setEngs(String s) {
        if (s.length() == 0) {
            return;
        }
        List<Word> lw = Dictionary.getWords();
        for (int i = 0; i < lw.size(); i++) {
            String word_target = lw.get(i).getWordtarget();
            if(word_target.indexOf(s) == 0) {
                Engs.add(word_target);
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void showAllWords() {
        textArea.setText(DictionaryCommandLine.showAllWords());
    }

    public void learnWord(String s) {
        if(Engs.size() != 0) {
            Engs.clear();
        }
        setEngs(s);

        if(provider != null) {
            provider.clearSuggestions();
        }
        Set<String> autoCompletions = new HashSet<>(Engs);
        provider = SuggestionProvider.create(autoCompletions);
        new AutoCompletionTextFieldBinding<>(input, provider);
    }

    public void TextFieldChanged() {
        String s = DictionaryManagement.dictionaryLookup(input.getText());
        textArea.setText(s);

    }

    public void changeAddWordScene(ActionEvent event) throws IOException {
        if (primaryStage == null) {
            primaryStage = new Stage();
        }
        if (event.getSource() == button1) {
            Parent root1 = FXMLLoader.load(this.getClass().getResource("../AddController/AddController.fxml"));
            Scene scene = new Scene(root1);
            primaryStage.setScene(scene);
            primaryStage.show();
        }
    }

    public void changeFixWordScene(ActionEvent event) throws IOException {
        if (primaryStage == null) {
            primaryStage = new Stage();
        }
        if (event.getSource() == button2) {
            Parent root2 = FXMLLoader.load(this.getClass().getResource("../FixController/FixController.fxml"));
            Scene scene = new Scene(root2);
            primaryStage.setScene(scene);
            primaryStage.show();
        }
    }

    public void DeleteWord() throws FileNotFoundException {
        DictionaryManagement.deleteWord(input.getText());
        DictionaryManagement.insertFromFile();
        setEngs(input.getText());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText("Word ' " + input.getText() + "'" + " is deleted!");
        alert.showAndWait();
        DictionaryManagement.insertFromFile();
        System.out.println(DictionaryCommandLine.showAllWords());
    }

    public void Speak() throws FileNotFoundException {
        String filename = new File("src/DictionaryApplication/Speak.vbs").getAbsolutePath();
        PrintWriter writer = new PrintWriter(filename);
        writer.print("");
        writer.close();
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {
            String data = "CreateObject(\"SAPI.SpVoice\").Speak(\"" + input.getText() + "\")";
            File file = new File(filename);
            // if file doesnt exists, then create it
            if (!file.exists()) file.createNewFile();
            // true = append file
            fw = new FileWriter(file.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);
            bw.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null)
                    bw.close();
                if (fw != null)
                    fw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        try {
            Runtime.getRuntime().exec("wscript src/DictionaryApplication/Speak.vbs");
        } catch (IOException e) {
            System.exit(0);
        }
    }

    public void findWord(KeyEvent keyEvent) {
        learnWord(input.getText());
        switch (keyEvent.getCode()) {
            case ENTER:
                TextFieldChanged();
                break;
            default:
                break;
        }
    }
}