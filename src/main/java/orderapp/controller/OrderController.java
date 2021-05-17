package orderapp.controller;

import cartdata.CartItems;
import cartdata.CartSerializer;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import modell.Pizza;
import org.tinylog.Logger;

import java.io.IOException;
import java.util.Random;

public class OrderController {

    @FXML
    private Label errorBase;
    @FXML
    private Label errorCheese;
    @FXML
    private Label errorSpin;


    @FXML
    public TextField payable;


    @FXML
    CheckBox base1;
    @FXML
    CheckBox base2;
    @FXML
    CheckBox cheese1;
    @FXML
    CheckBox cheese2;
    @FXML
    CheckBox cheese3;
    @FXML
    CheckBox cheese4;
    @FXML
    CheckBox topping1;
    @FXML
    CheckBox topping2;
    @FXML
    CheckBox topping3;
    @FXML
    CheckBox topping4;
    @FXML
    CheckBox topping5;
    @FXML
    CheckBox topping6;
    @FXML
    CheckBox topping7;
    @FXML
    CheckBox topping8;


    @FXML
    Text zero;
    @FXML
    Text three;
    @FXML
    Text five;
    @FXML
    Text ten;
    @FXML
    Text winPercent;


    @FXML
    Button spinButton;

    public boolean clicked;
    public double percentValue = 0.0;

    //////////
    public String orderName;
    public String orderAddress;
    /////////

    //#############
    public Pizza pizzaM;
    Random rand = new Random();
    public String orderCode = String.valueOf(rand.nextInt(9999));
    //#############

    public void setOrderNameForSave(String orderName) { this.orderName = orderName; }

    public void setOrderAddressForSave(String orderAddress) { this.orderAddress = orderAddress; }

    private void setPizza() {
        pizzaM = new Pizza(base1, base2,
                cheese1, cheese2, cheese3, cheese4,
                topping1, topping2, topping3, topping4, topping5, topping6, topping7, topping8);
    }

    private void setOrderCode(String orderCode) {
        pizzaM.orderCode = this.orderCode;
    }

    private void setPercentValue(double percentValue) { pizzaM.percentValue = this.percentValue; }

    private void setPercentTexts(Text zero, Text ten, Text five, Text three, Text winPercent) {
        pizzaM.zero = this.zero;
        pizzaM.ten = this.ten;
        pizzaM.five = this.five;
        pizzaM.three = this.three;
        pizzaM.winPercent = this.winPercent;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void initialize(){
        Platform.runLater(()->{
            setPizza();
            pizzaM.whatsOnPizza();
            pizzaM.payableCalculation();
            setOrderCode(orderCode);
            setPercentValue(percentValue);
            setPercentTexts(zero, ten, five, three, winPercent);
        });
    }

    public void payableAction(ActionEvent event) throws IOException {
        pizzaM.payableCalculation();

    }


    public void startAction(ActionEvent actionEvent) throws IOException {
        if (base1.isSelected() && base2.isSelected()) {
            errorBase.setText("Csak egy alap választható!");
        }

        if (!base1.isSelected() && !base2.isSelected()) {
            errorBase.setText("Válassz egy alapot!");
        }

        if (cheese1.isSelected() || cheese2.isSelected() || cheese3.isSelected() || cheese4.isSelected()) {
            errorCheese.setText("Csak egy sajt választható!");
        }

        if (!cheese1.isSelected() && !cheese2.isSelected() && !cheese3.isSelected() && !cheese4.isSelected()) {
            errorCheese.setText("Válassz sajtot!");
        }

        if (!spinButton.isDisable()) {
            errorSpin.setText("Ne felejtsen el pörgetni!");
        }

        else { errorSpin.setText(""); }


        if (((base1.isSelected() && !base2.isSelected()) || (!base1.isSelected() && base2.isSelected()))
                && ((cheese1.isSelected() && !cheese2.isSelected() && !cheese3.isSelected() && !cheese4.isSelected())
                        || (!cheese1.isSelected() && cheese2.isSelected() && !cheese3.isSelected() && !cheese4.isSelected())
                        || (!cheese1.isSelected() && !cheese2.isSelected() && cheese3.isSelected() && !cheese4.isSelected())
                        || (!cheese1.isSelected() && !cheese2.isSelected() && !cheese3.isSelected() && cheese4.isSelected()))
                && spinButton.isDisable()) {
            Logger.debug("{} gomb megnyomva.", ((Button)actionEvent.getSource()).getText());
            saveOrder();
            Logger.info("Kosár elemeinek mentése ...");
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/successfulorder.fxml"));
            Parent root = fxmlLoader.load();
            stage.setScene(new Scene(root));
            stage.show();
        }
    }


    public void endAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
        Logger.debug("{} gomb megnyomva.", ((Button)actionEvent.getSource()).getText());
        Logger.info("Kilépés ...");
    }


    public void restartAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/order.fxml"));
        Parent root = fxmlLoader.load();
        stage.setScene(new Scene(root));
        stage.show();
        Logger.debug("{} gomb megnyomva.", ((Button)event.getSource()).getText());
        Logger.info("Megrendelés újrakezdése ...");
    }


    public void spinAction(ActionEvent actionEvent) throws IOException {
        pizzaM.spinRandom(pizzaM.randGen());

        spinButton.setOnAction(e-> { clicked = true; });

        payable.setText(String.valueOf(pizzaM.payableCalculation()));

        spinButton.setDisable(true);

        base1.setDisable(true);
        base2.setDisable(true);
        cheese1.setDisable(true);
        cheese2.setDisable(true);
        cheese3.setDisable(true);
        cheese4.setDisable(true);
        topping1.setDisable(true);
        topping2.setDisable(true);
        topping3.setDisable(true);
        topping4.setDisable(true);
        topping5.setDisable(true);
        topping6.setDisable(true);
        topping7.setDisable(true);
        topping8.setDisable(true);
        Logger.debug("{} gomb megnyomva.", ((Button)actionEvent.getSource()).getText());
        Logger.info("Pörgetés, fizetendő érték kiszámítása...");
    }

    public void saveOrder() {
        CartItems result = new CartItems(orderCode, orderName, orderAddress, pizzaM.whatsOnPizza(), pizzaM.payableCalculation());
        CartSerializer.serialize(result);
    }


}
