package orderapp.controller;

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
import orderapp.cart.CartItems;
import orderapp.cart.CartItemsDao;

import java.io.IOException;
import java.util.Random;

public class OrderController {
    @FXML
    private Label errorName;
    @FXML
    private Label errorAddress;
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

    private CartItemsDao cartItemsDao;

    public boolean clicked;
    public double percentValue = 0.0;


    public void payableCalculation() {
        payable.setText(String.valueOf(1000));

        if ((base1.isSelected() && !base2.isSelected()) || (!base1.isSelected() && base2.isSelected())) {
            payable.setText(String.valueOf((Double.parseDouble(payable.getText()) + 100)));
        }

        if ((cheese1.isSelected() && !cheese2.isSelected() && !cheese3.isSelected() && !cheese4.isSelected())
            || (!cheese1.isSelected() && cheese2.isSelected() && !cheese3.isSelected() && !cheese4.isSelected())
            || (!cheese1.isSelected() && !cheese2.isSelected() && cheese3.isSelected() && !cheese4.isSelected())
            || (!cheese1.isSelected() && !cheese2.isSelected() && !cheese3.isSelected() && cheese4.isSelected())) {

            payable.setText(String.valueOf((Double.parseDouble(payable.getText()) + 100)));
        }

        if (topping1.isSelected()) { payable.setText(String.valueOf((Double.parseDouble(payable.getText()) + 100))); }
        if (topping2.isSelected()) { payable.setText(String.valueOf((Double.parseDouble(payable.getText()) + 100))); }
        if (topping3.isSelected()) { payable.setText(String.valueOf((Double.parseDouble(payable.getText()) + 100))); }
        if (topping4.isSelected()) { payable.setText(String.valueOf((Double.parseDouble(payable.getText()) + 100))); }
        if (topping5.isSelected()) { payable.setText(String.valueOf((Double.parseDouble(payable.getText()) + 100))); }
        if (topping6.isSelected()) { payable.setText(String.valueOf((Double.parseDouble(payable.getText()) + 100))); }
        if (topping7.isSelected()) { payable.setText(String.valueOf((Double.parseDouble(payable.getText()) + 100))); }
        if (topping8.isSelected()) { payable.setText(String.valueOf((Double.parseDouble(payable.getText()) + 100))); }
    }

    public void payableAction(ActionEvent event) throws IOException {
        payableCalculation();
    }

    private String pizzaItems() {
        String re = "";
        if (base1.isSelected()) { re = re + base1.getText() + ";"; }
        if (base2.isSelected()) { re = re + base2.getText() + ";"; }

        if (cheese1.isSelected()) { re = re + cheese1.getText() + ";"; }
        if (cheese2.isSelected()) { re = re + cheese2.getText() + ";"; }
        if (cheese3.isSelected()) { re = re + cheese3.getText() + ";"; }
        if (cheese4.isSelected()) { re = re + cheese4.getText() + ";"; }

        if (topping1.isSelected()) { re = re + ";" + topping1.getText() + ";"; }
        if (topping2.isSelected()) { re = re + ";" + topping2.getText() + ";"; }
        if (topping3.isSelected()) { re = re + ";" + topping3.getText() + ";"; }
        if (topping4.isSelected()) { re = re + ";" + topping4.getText() + ";"; }
        if (topping5.isSelected()) { re = re + ";" + topping5.getText() + ";"; }
        if (topping6.isSelected()) { re = re + ";" + topping6.getText() + ";"; }
        if (topping7.isSelected()) { re = re + ";" + topping7.getText() + ";"; }
        if (topping8.isSelected()) { re = re + ";" + topping8.getText() + ";"; }

        return re;
    }

    public CartItems createGameResult() {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/fxml/launch.fxml"));
        String s = fxmlLoader.<LaunchController>getController().nameInLaunch.getText();
        String a = fxmlLoader.<LaunchController>getController().addressInLaunch.getText();

        return CartItems.builder()
                .name(s)
                .address(a)
                .pizza(pizzaItems())
                .cost(payable.getText())
                .build();
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

            //log.debug("Saving order to database..");
            cartItemsDao = new CartItemsDao();
            cartItemsDao.persist(createGameResult());

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
    }


    public void restartAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/order.fxml"));
        Parent root = fxmlLoader.load();
        stage.setScene(new Scene(root));
        stage.show();
    }

    private void oneSpin() {
        Text trash = new Text();

        trash.setText(zero.getText());
        zero.setText(ten.getText());
        ten.setText(five.getText());
        five.setText(three.getText());
        three.setText(trash.getText());

        percentValue = Double.parseDouble(zero.getText());
        winPercent.setText(zero.getText());
    }

    public void spinAction(ActionEvent actionEvent) throws IOException {
        Random rand = new Random();
        for (int i = 0; i < rand.nextInt(9); i++) {
            oneSpin();
        }

        spinButton.setOnAction(e-> { clicked = true; });
        payable.setText(String.valueOf(Double.parseDouble(payable.getText()) * (1-percentValue*0.01)));
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
    }

}
