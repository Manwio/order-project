package orderapp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.tinylog.Logger;

import java.io.*;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class SuccessfullOrderController {

    private static void copy(File src, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(src);
            os = new FileOutputStream(dest);
            byte[] buf = new byte[1024];
            int bytesRead;
            while ((bytesRead = is.read(buf)) > 0) {
                os.write(buf, 0, bytesRead); }
        } finally { is.close(); os.close(); }
    }


    private void saveOrder() throws IOException {
        File save = new File(System.getProperty("user.home") + File.separator + "ordersave" + ZonedDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss")) + ".json");
        save.createNewFile();
        File order = new File(System.getProperty("user.home") + File.separator + "order.json");
        copy(order, save);

        order.deleteOnExit();
        if(order.delete())
        {
            Logger.debug("Rendelés mentése ...");
        }
    }

    public void endAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
        Logger.debug("{} gomb megnyomva.", ((Button)actionEvent.getSource()).getText());
        Logger.info("Fizetés, kilépés ...");
        saveOrder();
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
