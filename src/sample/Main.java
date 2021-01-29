package sample;

import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.nio.file.Paths;


public class Main extends Application {




    @Override
    public void start(Stage primaryStage) throws Exception{



        Parent root = FXMLLoader.load(getClass().getResource("ui/ui.fxml"));



        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("images/coding.png")));
        primaryStage.setTitle("Project UI");
        primaryStage.setScene(new Scene(root, 900, 690));
        primaryStage.show();

    }



    public static void main(String[] args) {
        launch(args);
    }


}
