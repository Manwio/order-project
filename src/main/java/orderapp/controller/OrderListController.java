package orderapp.controller;

import cartdata.CartDeserializer;
import cartdata.CartItems;
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

import java.io.IOException;
import java.util.List;


public class OrderListController {

    @FXML
    private TableView<CartItems> orderListTable;

    @FXML
    private TableColumn<CartItems, String> pizzaItems;

    @FXML
    private TableColumn<CartItems, String> payValue;


    @FXML
    private void initialize() throws IOException {
        List<CartItems> orderListList = CartDeserializer.deserialize();

        payValue.setCellValueFactory(new PropertyValueFactory<CartItems, String>("pay"));
        pizzaItems.setCellValueFactory(new PropertyValueFactory<>("pizza"));

        ObservableList<CartItems> observableList = FXCollections.observableArrayList();
        observableList.addAll(orderListList);
        orderListTable.setItems(observableList);
    }



    public void backAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/successfulorder.fxml"));
        Parent root = fxmlLoader.load();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
