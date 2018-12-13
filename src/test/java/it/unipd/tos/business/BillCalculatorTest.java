////////////////////////////////////////////////////////////////////
// [Nicolò] [Vergari] [1047617]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business;

import it.unipd.tos.business.exception.RestaurantBillException;
import it.unipd.tos.model.MenuItem;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BillCalculatorTest {

    @org.junit.Test
    public void testSum() {
        List<MenuItem> itemsOrdered = new ArrayList<MenuItem>();
        itemsOrdered.add(new MenuItem(MenuItem.itemType.PRIMI, "Amatriciana", 6));
        itemsOrdered.add(new MenuItem(MenuItem.itemType.PIZZE, "Capricciosa", 8.50));
        itemsOrdered.add(new MenuItem(MenuItem.itemType.PIZZE, "Marghrita", 7));
        BillCalculator bill = new BillCalculator();
        try {
            double tot = bill.getOrderPrice(itemsOrdered);
            assertEquals(21.50, tot, 0.0);
        } catch (RestaurantBillException e) {
            e.getMessage();
        }
    }

}