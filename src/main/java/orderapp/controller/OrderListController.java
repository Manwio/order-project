package orderapp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import orderapp.cart.CartItems;
import org.w3c.dom.Text;

import java.io.IOException;
import java.time.ZonedDateTime;


public class OrderListController {

    @FXML
    private TableView<CartItems> orderListTable;

    @FXML
    private TableColumn<CartItems, String> pizza;

    @FXML
    private TableColumn<CartItems, String> cost;
    //private GSSToken log;

    @FXML
    private TableColumn<CartItems, ZonedDateTime> created;

    @FXML
    Text orderName;
    @FXML
    Text orderAddress;
    /*
    @FXML
    private void initialize() {

        //log.debug("Loading orders...");
        cartItemsDao = new CartItemsDao();
        List<CartItems> orderListList = cartItemsDao.findAll();

        pizza.setCellValueFactory(new PropertyValueFactory<>("pizza"));
        cost.setCellValueFactory(new PropertyValueFactory<>("cost"));

        ObservableList<CartItems> observableResult = FXCollections.observableArrayList();
        observableResult.addAll(orderListList);

        orderListTable.setItems(observableResult);
    }
     */

    public void backAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/successfulorder.fxml"));
        Parent root = fxmlLoader.load();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
