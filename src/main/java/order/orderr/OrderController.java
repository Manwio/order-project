package order.orderr;

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
import java.util.Random;


import java.io.IOException;

public class OrderController {
    @FXML
    private Label errorName;
    @FXML
    private Label errorName2;
    @FXML
    private Label errorBase;
    @FXML
    private Label errorCheese;


    @FXML
    TextField name;
    @FXML
    TextField address;
    @FXML
    TextField payable;


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
    Button spinButton;

    public void payableCalculation() {
        payable.setText(String.valueOf(1000));

        if ((base1.isSelected() && !base2.isSelected()) || (!base1.isSelected() && base2.isSelected())) {
            payable.setText(String.valueOf(Integer.parseInt(payable.getText()) + 100));
        }

        if ((cheese1.isSelected() && !cheese2.isSelected() && !cheese3.isSelected() && !cheese4.isSelected())
            || (!cheese1.isSelected() && cheese2.isSelected() && !cheese3.isSelected() && !cheese4.isSelected())
            || (!cheese1.isSelected() && !cheese2.isSelected() && cheese3.isSelected() && !cheese4.isSelected())
            || (!cheese1.isSelected() && !cheese2.isSelected() && !cheese3.isSelected() && cheese4.isSelected())) {

            payable.setText(String.valueOf(Integer.parseInt(payable.getText()) + 100));
        }

        if (topping1.isSelected()) { payable.setText(String.valueOf(Integer.parseInt(payable.getText()) + 100)); }
        if (topping2.isSelected()) { payable.setText(String.valueOf(Integer.parseInt(payable.getText()) + 100)); }
        if (topping3.isSelected()) { payable.setText(String.valueOf(Integer.parseInt(payable.getText()) + 100)); }
        if (topping4.isSelected()) { payable.setText(String.valueOf(Integer.parseInt(payable.getText()) + 100)); }
        if (topping5.isSelected()) { payable.setText(String.valueOf(Integer.parseInt(payable.getText()) + 100)); }
        if (topping6.isSelected()) { payable.setText(String.valueOf(Integer.parseInt(payable.getText()) + 100)); }
        if (topping7.isSelected()) { payable.setText(String.valueOf(Integer.parseInt(payable.getText()) + 100)); }
        if (topping8.isSelected()) { payable.setText(String.valueOf(Integer.parseInt(payable.getText()) + 100)); }
    }

    public void payableAction(ActionEvent event) throws IOException {
        payableCalculation();
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

        if (name.getText().isEmpty()) {
            errorName.setText("Üres mező!");
        }
        if (address.getText().isEmpty()) {
            errorName2.setText("Üres mező!");
        }

        if (!name.getText().isEmpty() && !address.getText().isEmpty() &&
                ((base1.isSelected() && !base2.isSelected()) || (!base1.isSelected() && base2.isSelected()))) {
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/successfulorder.fxml"));
            Parent root = fxmlLoader.load();
            stage.setScene(new Scene(root));
            stage.show();
        }
    }

    private void oneSpin() {
        Text trash = new Text();

        trash.setText(zero.getText());
        zero.setText(ten.getText());
        ten.setText(five.getText());
        five.setText(three.getText());
        three.setText(trash.getText());

    }

    public void spinAction(ActionEvent actionEvent) throws IOException {
        Random rand = new Random();
        for (int i = 0; i < rand.nextInt(19); i++) {
            oneSpin();
        }

        spinButton.setDisable(true);
    }

}
