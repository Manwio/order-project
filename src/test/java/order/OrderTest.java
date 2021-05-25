package order;


import modell.Pizza;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class OrderTest {

    ArrayList<Boolean> tList = new ArrayList<>();
    ArrayList<Boolean> p = new ArrayList<>();
    ArrayList<Integer> listZO = new ArrayList<>();

    boolean b1 = false, b2 = false, c1 = false, c2 = false, c3 = false, c4 = false,
            t1 = false, t2 = false, t3 = false, t4 = false,
            t5 = false, t6 = false, t7 = false, t8 = false;
    Pizza pizza;

    @BeforeEach
    void setUp() {
        b1 = true;
        c4 = true;

        //tList
        tList.add(b1); tList.add(c4);
        //p
        p.add(b1); p.add(b2); p.add(c1); p.add(c2); p.add(c3); p.add(c4);
        p.add(t1); p.add(t2); p.add(t3); p.add(t4);
        p.add(t5); p.add(t6); p.add(t7); p.add(t8);

        pizza = new Pizza(p);

        //listZO
        //Base
        listZO.add(1);listZO.add(0);
        //Cheese
        listZO.add(0);listZO.add(0);listZO.add(0);listZO.add(1);
        //Topping
        listZO.add(0);listZO.add(0);listZO.add(0);listZO.add(0);
        listZO.add(0);listZO.add(0);listZO.add(0);listZO.add(0);
    }

    @Test
    void testWhatsOnPizza() {
        assertEquals(pizza.whatsOnPizza(listZO), "ParadicsomMozzarella");
        assertNotEquals(pizza.whatsOnPizza(listZO), "MozzarellaParadicsom");
        assertNotEquals(pizza.whatsOnPizza(listZO), "TejfölMozzarella");
    }

    @Test
    void testOneSpin() {
        assertEquals(pizza.oneSpin(), 10.0);
        assertNotEquals(pizza.oneSpin(), 0.0);
    }

    @Test
    void testPayableCalculation() {
        pizza.percentValue = 5.0;
        assertEquals(pizza.payableCalculation(tList), 1140.0);
        assertNotEquals(pizza.payableCalculation(tList), 1200.0);

    }


}
