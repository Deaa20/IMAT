package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application
{
    ImatMainController imatMainController;

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("ImatPrimaryStage.fxml"));
        primaryStage.setTitle("IMAT");
        primaryStage.setScene(new Scene(root, 1188, 794));
        primaryStage.show();
        primaryStage.setOnCloseRequest(event -> {
            System.out.println("Stage is closing");
            ImatMainController.iMatDataHandler.shutDown();
        });


    }

    public static void main(String[] args) {
        launch(args);
   
    }
}
