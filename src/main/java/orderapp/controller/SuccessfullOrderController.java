package orderapp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.tinylog.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class SuccessfullOrderController {

    private static void copyFile(File source, File dest) throws IOException {
        Files.copy(source.toPath(), dest.toPath());
    }

    private void saveOrder() throws IOException {
        File save = new File(System.getProperty("user.dir")
                +File.separator+"order-save" +".json");
        save.createNewFile();
        File order = new File("./order.json");
        copyFile(order, save);

        File clean = new File("./clean.json");
        copyFile(clean, order);
    }

    public void endAction(ActionEvent actionEvent) throws IOException {
        //saveOrder();
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
        Logger.debug("{} gomb megnyomva.", ((Button)actionEvent.getSource()).getText());
        Logger.info("Fizetés, kilépés ...");
    }

    public void newAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/order.fxml"));
        Parent root = fxmlLoader.load();
        stage.setScene(new Scene(root));
        stage.show();
        Logger.debug("{} gomb megnyomva.", ((Button)actionEvent.getSource()).getText());
        Logger.info("Új rendelés ...");
    }

    public void orderlistAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/cartlist.fxml"));
        Parent root = fxmlLoader.load();
        stage.setScene(new Scene(root));
        stage.show();
        Logger.debug("{} gomb megnyomva.", ((Button)event.getSource()).getText());
        Logger.info("Kosár tartalmának betöltése ...");
    }
}
