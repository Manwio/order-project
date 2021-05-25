package modell;

import java.util.ArrayList;
import java.util.Random;

public class Pizza {

    public ArrayList<Boolean> pizzaModell;
    public double payable;
    public double percentValue;
    public String zero = "0", ten = "10", five = "5", three = "3";
    public String orderCode;

    /**
     * Paraméter nélküli konstruktor.
     */
    public Pizza() {}

    /**
     * Konstruktor.
     */
    public Pizza(ArrayList<Boolean> p) {
        p = pizzaModell;
    }

    /**
     * A metódus vissza adja, hogy miket kért rá a vásárló.
     */
    public String whatsOnPizza(ArrayList<Integer> p) {
        String re = "";
        if (p.get(0) == 1) re += "Paradicsom";
        if (p.get(1) == 1) re += "Tejföl";

        if (p.get(2) == 1) re += "Trapista";
        if (p.get(3) == 1) re += "Cheddar";
        if (p.get(4) == 1) re += "Parmezán";
        if (p.get(5) == 1) re += "Mozzarella";

        if (p.get(6) == 1) re += "Szalámi";
        if (p.get(7) == 1) re += "Sonka";
        if (p.get(8) == 1) re += "Bacon";
        if (p.get(9) == 1) re += "Kukorica";
        if (p.get(10) == 1) re += "Gomba";
        if (p.get(11) == 1) re += "Tojás";
        if (p.get(12) == 1) re += "Madársaláta";
        if (p.get(13) == 1) re += "Paradicsom";

        return re;
    }


    /**
     * A függvény egy cserét hajt végre, ami egyel további szöveg érték átadást jelent.
     * A függvény egy pörgetésnek felel meg.
     */
    public double oneSpin() {
        String trash = "";

        trash = zero;
        zero = ten;
        ten = five;
        five = three;
        three = trash;

        percentValue = Double.parseDouble(zero);

        return percentValue;
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
    public double payableCalculation(ArrayList<Boolean> itemPiece) {
        payable = 1000.0;

        double hundredPlus = itemPiece.size() * 100.0;
        payable += hundredPlus;

        return payable * (1- (percentValue*0.01));
    }

}
