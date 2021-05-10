package orderapp.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class OrderApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/launch.fxml"));
        stage.setTitle("Pizza Order");
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.show();
    }

}
