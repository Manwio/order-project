package orderapp.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import orderapp.cart.CartItems;
import orderapp.cart.CartItemsDao;
import org.w3c.dom.Text;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.List;


public class OrderListController {

    private CartItemsDao cartItemsDao;

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

    @FXML
    private void initialize() {

        //log.debug("Loading orders...");
        cartItemsDao = new CartItemsDao();
        List<CartItems> orderListTable = cartItemsDao.findAll();

        pizza.setCellValueFactory(new PropertyValueFactory<>("pizza"));
        cost.setCellValueFactory(new PropertyValueFactory<>("cost"));

        ObservableList<CartItems> observableResult = FXCollections.observableArrayList();
        observableResult.addAll(orderListTable);

        //orderListTable.setItems(observableResult);
        //orderListTable.getColumns().clear();
        orderListTable.addAll(observableResult);
    }

    public void backAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/successfulorder.fxml"));
        Parent root = fxmlLoader.load();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
