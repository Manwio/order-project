package modell;

import javafx.scene.control.CheckBox;
import javafx.scene.text.Text;

import java.util.Random;

public class Pizza {

    public CheckBox base1, base2;
    public CheckBox cheese1, cheese2, cheese3, cheese4;
    public CheckBox topping1, topping2, topping3, topping4, topping5, topping6, topping7, topping8;

    public double payable;
    public double percentValue;
    public Text zero, ten, five, three, winPercent;
    public String orderCode;


    /**
     * A metódus vissza adja, hogy miket kért rá a vásárló.
     */
    public String whatsOnPizza() {
        String re = "";
        if (base1.isSelected()) { re = re + base1.getText(); }
        if (base2.isSelected()) { re = re + base2.getText(); }

        if (cheese1.isSelected()) { re = re + cheese1.getText(); }
        if (cheese2.isSelected()) { re = re + cheese2.getText(); }
        if (cheese3.isSelected()) { re = re + cheese3.getText(); }
        if (cheese4.isSelected()) { re = re + cheese4.getText(); }

        if (topping1.isSelected()) { re = re + topping1.getText(); }
        if (topping2.isSelected()) { re = re + topping2.getText(); }
        if (topping3.isSelected()) { re = re + topping3.getText(); }
        if (topping4.isSelected()) { re = re + topping4.getText(); }
        if (topping5.isSelected()) { re = re + topping5.getText(); }
        if (topping6.isSelected()) { re = re + topping6.getText(); }
        if (topping7.isSelected()) { re = re + topping7.getText(); }
        if (topping8.isSelected()) { re = re + topping8.getText(); }

        return re;
    }

    /**
     * Paraméter nélküli konstruktor.
     */
    public Pizza() {}

    /**
     * Konstruktor.
     */
    public Pizza(CheckBox base1, CheckBox base2,
                 CheckBox cheese1, CheckBox cheese2, CheckBox cheese3, CheckBox cheese4,
                 CheckBox topping1,  CheckBox topping2, CheckBox topping3, CheckBox topping4, CheckBox topping5, CheckBox topping6, CheckBox topping7, CheckBox topping8) {
        this.base1 = base1; this.base2 = base2;
        this.cheese1 = cheese1;  this.cheese2 = cheese2;  this.cheese3 = cheese3;  this.cheese4 = cheese4;
        this.topping1 = topping1; this.topping2 = topping2;  this.topping3 = topping3;  this.topping4 = topping4; this.topping5 = topping5; this.topping6 = topping6; this.topping7 = topping7; this.topping8 = topping8;
    }

    /**
     * A függvény egy cserét hajt végre, ami egyel további szöveg érték átadást jelent.
     * A függvény egy pörgetésnek felel meg.
     */
    public void oneSpin() {
        Text trash = new Text();

        trash.setText(zero.getText());
        zero.setText(ten.getText());
        ten.setText(five.getText());
        five.setText(three.getText());
        three.setText(trash.getText());

        percentValue = Double.parseDouble(zero.getText());

    }

    /**
     * A metódus egy random számot generál és int értékként adja vissza.
     */
    public int randGen() {
        Random rand = new Random();
        return rand.nextInt(9);
    }

    /**
     * A függvény az oneSpin() függvényt futtatja egy random érték alapján.
     */
    public void spinRandom(int rand) {
        for (int i = 0; i < rand; i++) {
            oneSpin();
        }
    }

    /**
     * A metódus vissza adja, hogy mennyi a fizetendő érték, a kipörgetett %-okkal együtt.
     */
    public double payableCalculation() {
        payable = 1000.0;

        if ((base1.isSelected() && !base2.isSelected()) || (!base1.isSelected() && base2.isSelected())) {
            payable = (Double.parseDouble(String.valueOf(payable + 100)));
        }

        if ((cheese1.isSelected() && !cheese2.isSelected() && !cheese3.isSelected() && !cheese4.isSelected())
            || (!cheese1.isSelected() && cheese2.isSelected() && !cheese3.isSelected() && !cheese4.isSelected())
            || (!cheese1.isSelected() && !cheese2.isSelected() && cheese3.isSelected() && !cheese4.isSelected())
            || (!cheese1.isSelected() && !cheese2.isSelected() && !cheese3.isSelected() && cheese4.isSelected())) {

            payable = (Double.parseDouble(String.valueOf(payable + 100)));
        }

        if (topping1.isSelected()) { payable = (Double.parseDouble(String.valueOf(payable + 100))); }
        if (topping2.isSelected()) { payable = (Double.parseDouble(String.valueOf(payable + 100))); }
        if (topping3.isSelected()) { payable = (Double.parseDouble(String.valueOf(payable + 100))); }
        if (topping4.isSelected()) { payable = (Double.parseDouble(String.valueOf(payable + 100))); }
        if (topping5.isSelected()) { payable = (Double.parseDouble(String.valueOf(payable + 100))); }
        if (topping6.isSelected()) { payable = (Double.parseDouble(String.valueOf(payable + 100))); }
        if (topping7.isSelected()) { payable = (Double.parseDouble(String.valueOf(payable + 100))); }
        if (topping8.isSelected()) { payable = (Double.parseDouble(String.valueOf(payable + 100))); }

        return payable * (1- (percentValue*0.01));
    }

}
