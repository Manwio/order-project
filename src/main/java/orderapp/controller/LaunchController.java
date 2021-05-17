package orderapp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.tinylog.Logger;

import java.io.IOException;

public class LaunchController {

    @FXML
    public TextField nameInLaunch;
    @FXML
    public TextField addressInLaunch;

    @FXML
    Label errorName;
    @FXML
    Label errorAddress;


    public void orderAction(ActionEvent event) throws IOException {
        if (nameInLaunch.getText().isEmpty()) {
            errorName.setText("Üres mező!");
        }

        else { errorName.setText(""); }

        if (addressInLaunch.getText().isEmpty()) {
            errorAddress.setText("Üres mező!");
        }

        else { errorAddress.setText(""); }

        if (!addressInLaunch.getText().isEmpty() && !nameInLaunch.getText().isEmpty()) {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/order.fxml"));
            Parent root = fxmlLoader.load();
            fxmlLoader.<OrderController>getController().setOrderNameForSave(nameInLaunch.getText());
            fxmlLoader.<OrderController>getController().setOrderAddressForSave(addressInLaunch.getText());

            stage.setScene(new Scene(root));
            stage.show();
        }
        Logger.debug("{} gomb megnyomva.", ((Button)event.getSource()).getText());
        Logger.info("A megrendelő nevének és címének beállítása, a következőkre: {}, {}.",nameInLaunch.getText(), addressInLaunch.getText());
    }

    public void endAction(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
        Logger.debug("{} gomb megnyomva.", ((Button)event.getSource()).getText());
        Logger.info("Kilépés ...");
    }
}
