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
import java.util.ArrayList;
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

    public boolean bBase1 = false, bBase2 = false;
    public boolean bCheese1 = false, bCheese2 = false, bCheese3 = false, bCheese4 = false;
    public boolean bTopping1 = false, bTopping2 = false, bTopping3 = false, bTopping4 = false, bTopping5 = false, bTopping6 = false, bTopping7 = false, bTopping8 = false;
    public ArrayList<Boolean> pizza = new ArrayList<>();
    public ArrayList<Boolean> trueItems = new ArrayList<>();
    private ArrayList<Integer> pizzaItemZeroOne = new ArrayList<>();

    //#############

    private void setPizzaList() {
        bBase1 = base1.isSelected();
        bBase2 = base2.isSelected();
        bCheese1 = cheese1.isSelected();
        bCheese2 = cheese2.isSelected();
        bCheese3 = cheese3.isSelected();
        bCheese4 = cheese4.isSelected();
        bTopping1 = topping1.isSelected();
        bTopping2 = topping2.isSelected();
        bTopping3 = topping3.isSelected();
        bTopping4 = topping4.isSelected();
        bTopping5 = topping5.isSelected();
        bTopping6 = topping6.isSelected();
        bTopping7 = topping7.isSelected();
        bTopping8 = topping8.isSelected();
    }

    private void setOtherLists() {
        trueItems.clear();
        pizzaItemZeroOne.clear();

        if (base1.isSelected()) { bBase1 = true; trueItems.add(bBase1); pizzaItemZeroOne.add(1); } else { pizzaItemZeroOne.add(0); }
        if (base2.isSelected()) { bBase2 = true; trueItems.add(bBase2); pizzaItemZeroOne.add(1); } else { pizzaItemZeroOne.add(0); }
        if (cheese1.isSelected()) { bCheese1 = true; trueItems.add(bCheese1); pizzaItemZeroOne.add(1); } else { pizzaItemZeroOne.add(0); }
        if (cheese2.isSelected()) { bCheese2 = true; trueItems.add(bCheese2); pizzaItemZeroOne.add(1); } else { pizzaItemZeroOne.add(0); }
        if (cheese3.isSelected()) { bCheese3 = true; trueItems.add(bCheese3); pizzaItemZeroOne.add(1); } else { pizzaItemZeroOne.add(0); }
        if (cheese4.isSelected()) { bCheese4 = true; trueItems.add(bCheese4); pizzaItemZeroOne.add(1); } else { pizzaItemZeroOne.add(0); }
        if (topping1.isSelected()) { bTopping1 = true; trueItems.add(bTopping1); pizzaItemZeroOne.add(1); } else { pizzaItemZeroOne.add(0); }
        if (topping2.isSelected()) { bTopping2 = true; trueItems.add(bTopping2); pizzaItemZeroOne.add(1); } else { pizzaItemZeroOne.add(0); }
        if (topping3.isSelected()) { bTopping3 = true; trueItems.add(bTopping3); pizzaItemZeroOne.add(1); } else { pizzaItemZeroOne.add(0); }
        if (topping4.isSelected()) { bTopping4 = true; trueItems.add(bTopping4); pizzaItemZeroOne.add(1); } else { pizzaItemZeroOne.add(0); }
        if (topping5.isSelected()) { bTopping5 = true; trueItems.add(bTopping5); pizzaItemZeroOne.add(1); } else { pizzaItemZeroOne.add(0); }
        if (topping6.isSelected()) { bTopping6 = true; trueItems.add(bTopping6); pizzaItemZeroOne.add(1); } else { pizzaItemZeroOne.add(0); }
        if (topping7.isSelected()) { bTopping7 = true; trueItems.add(bTopping7); pizzaItemZeroOne.add(1); } else { pizzaItemZeroOne.add(0); }
        if (topping8.isSelected()) { bTopping8 = true; trueItems.add(bTopping8); pizzaItemZeroOne.add(1); } else { pizzaItemZeroOne.add(0); }

        pizza.add(bBase1); pizza.add(bBase2);
        pizza.add(bCheese1); pizza.add(bCheese2); pizza.add(bCheese3); pizza.add(bCheese4);
        pizza.add(bTopping1); pizza.add(bTopping2); pizza.add(bTopping3); pizza.add(bTopping4);
        pizza.add(bTopping5); pizza.add(bTopping6); pizza.add(bTopping7); pizza.add(bTopping8);
    }

    public void setPizza() { pizzaM.pizzaModell = this.pizza; }

    public void setOrderNameForSave(String orderName) { this.orderName = orderName; }

    public void setOrderAddressForSave(String orderAddress) { this.orderAddress = orderAddress; }

    private void setOrderCode() { this.orderCode = pizzaM.orderCode; }

    private void setPercentValue() { this.percentValue = pizzaM.percentValue; }

    private void setPercentTexts() {
        setPizzaList();
        zero.setText(pizzaM.zero);
        ten.setText(pizzaM.ten);
        five.setText(pizzaM.five);
        three.setText(pizzaM.three);

        winPercent.setText(pizzaM.zero);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void initialize(){
        Platform.runLater(()->{
            pizzaM = new Pizza(pizza);

            setPizzaList();
            setOtherLists();
            setPizza();
            pizzaM.whatsOnPizza(pizzaItemZeroOne);
            pizzaM.payableCalculation(trueItems);
            setOrderCode();
            setPercentValue();
            setPercentTexts();
        });
    }


    public void payableAction() {
        setOtherLists();
        pizzaM.payableCalculation(trueItems);
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


    public void endAction(ActionEvent actionEvent) {
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


    public void spinAction(ActionEvent actionEvent) {
        pizzaM.spinRandom(pizzaM.randGen());

        spinButton.setOnAction(e-> clicked = true);
        payable.setText(String.valueOf(pizzaM.payableCalculation(trueItems)));
        setPercentTexts();
        setPizzaList();

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
        CartItems result = new CartItems(orderCode, orderName, orderAddress, pizzaM.whatsOnPizza(pizzaItemZeroOne), pizzaM.payableCalculation(trueItems));
        CartSerializer.serialize(result);
    }


}
