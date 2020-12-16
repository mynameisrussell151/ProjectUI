package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;



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
