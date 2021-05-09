package order.orderr;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.io.IOException;

public class OrderController {
    @FXML
    private Label errorName;
    @FXML
    private Label errorName2;

    @FXML
    TextField name;
    @FXML
    TextField address;


    public void startAction(ActionEvent actionEvent) throws IOException {
        if (name.getText().isEmpty()) {
            errorName.setText("ÜRES BAZDMEG!!!!!!!!!!!!!!!!");
        }
        if (address.getText().isEmpty()) {
            errorName2.setText("ÜRES BAZDMEG!!!!!!!!!!!!!!!!");
        }

        if (!name.getText().isEmpty() && !address.getText().isEmpty()) {
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/successfulorder.fxml"));
            Parent root = fxmlLoader.load();
            stage.setScene(new Scene(root));
            stage.show();
        }
    }

}
