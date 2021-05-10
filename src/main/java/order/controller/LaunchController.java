package order.controller;

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
import java.util.EventObject;

public class LaunchController {

    @FXML
    TextField name;
    @FXML
    TextField address;


    @FXML
    Label errorName;
    @FXML
    Label errorAddress;


    public void orderAction(ActionEvent event) throws IOException {
        if (name.getText().isEmpty()) {
            errorName.setText("Üres mező!");
        }

        else { errorName.setText(""); }

        if (address.getText().isEmpty()) {
            errorAddress.setText("Üres mező!");
        }

        else { errorAddress.setText(""); }

        if (!address.getText().isEmpty() && !name.getText().isEmpty()) {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/order.fxml"));
            Parent root = fxmlLoader.load();
            stage.setScene(new Scene(root));
            stage.show();
        }
    }

    public void endAction(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
}
