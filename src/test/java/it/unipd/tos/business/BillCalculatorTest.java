////////////////////////////////////////////////////////////////////
// [Nicolò] [Vergari] [1047617]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business;

import it.unipd.tos.business.exception.RestaurantBillException;
import it.unipd.tos.model.MenuItem;

import java.util.ArrayList;
import java.util.List;

import static it.unipd.tos.model.MenuItem.itemType.PIZZE;
import static it.unipd.tos.model.MenuItem.itemType.PRIMI;
import static org.junit.Assert.*;

public class BillCalculatorTest {

    @org.junit.Test
    public void testSum() {
        List<MenuItem> itemsOrdered = new ArrayList<MenuItem>();
        itemsOrdered.add(new MenuItem(PRIMI, "Amatriciana", 6));
        itemsOrdered.add(new MenuItem(PIZZE, "Capricciosa", 8.50));
        itemsOrdered.add(new MenuItem(PIZZE, "Marghrita", 7));
        BillCalculator bill = new BillCalculator();
        try {
            double tot = bill.getOrderPrice(itemsOrdered);
            assertEquals(21.50, tot, 0.0);
        } catch (RestaurantBillException e) {
            e.getMessage();
        }
    }

    @org.junit.Test
    public void testMoreThan10Pizza1IsFree() {
        List<MenuItem> itemsOrdered = new ArrayList<>();
        itemsOrdered.add(new MenuItem(PIZZE, "Margherita", 4.0));
        itemsOrdered.add(new MenuItem(PIZZE, "Capricciosa", 5.50));
        itemsOrdered.add(new MenuItem(PIZZE, "Diavola", 5.0));
        itemsOrdered.add(new MenuItem(PIZZE, "Margherita", 4.0));
        itemsOrdered.add(new MenuItem(PIZZE, "Margherita", 4.0));
        itemsOrdered.add(new MenuItem(PIZZE, "Diavola", 5.0));
        itemsOrdered.add(new MenuItem(PIZZE, "Viennese", 5.50));
        itemsOrdered.add(new MenuItem(PIZZE, "Margherita", 4.0));
        itemsOrdered.add(new MenuItem(PIZZE, "Viennese", 5.50));
        itemsOrdered.add(new MenuItem(PIZZE, "Bufala", 5.0));
        itemsOrdered.add(new MenuItem(PIZZE, "Margherita", 4.0));
        itemsOrdered.add(new MenuItem(PRIMI, "Carbonara", 6));
        BillCalculator bill = new BillCalculator();
        try {
            double tot = bill.getOrderPrice(itemsOrdered);
            assertEquals((53.50), tot, 0.0);
        } catch (RestaurantBillException e) {
            e.getMessage();
        }
    }

    @org.junit.Test
    public void testDiscountIfOrderIsMoreThan100Euros() {
        List<MenuItem> itemsOrdered = new ArrayList<>();
        itemsOrdered.add(new MenuItem(PRIMI, "PastaCostosa", 50));
        itemsOrdered.add(new MenuItem(PIZZE,"PizzaCostosa", 60));
        BillCalculator bill = new BillCalculator();
        try {
            double tot = bill.getOrderPrice(itemsOrdered);
            assertEquals(104.5,tot,0);
        } catch (RestaurantBillException e) {
            e.getMessage();
        }
    }

}