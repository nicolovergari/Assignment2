////////////////////////////////////////////////////////////////////
// [Nicolò] [Vergari] [1047617]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business;

import it.unipd.tos.business.exception.RestaurantBillException;
import it.unipd.tos.model.MenuItem;

import java.util.List;

public class BillCalculator implements RestaurantBill {

    @Override
    public double getOrderPrice(List<MenuItem> itemsOrdered) throws RestaurantBillException {
        double billTot =0;

        for (MenuItem m : itemsOrdered) {
            billTot += m.getPrice();
        }
        return billTot;
    }
}
