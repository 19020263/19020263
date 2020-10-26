package DictionaryApplication;

import DataClass.Dictionary;
import DataClass.DictionaryManagement;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Collections;

public class DictionaryApplication extends Application {

    public static void main(String[] args) {
        launch(args);
        Collections.sort(Dictionary.getWords());
    }

    @Override
    public void start(Stage primaryStage) {
        try{
            DictionaryManagement.insertFromFile();
            Parent root = FXMLLoader.load(this.getClass().getResource("DictionaryApplication.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);

            primaryStage.show();

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
