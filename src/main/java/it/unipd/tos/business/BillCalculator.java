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

        int count = 0;
        double min = Integer.MAX_VALUE;

        for (MenuItem m : itemsOrdered) {
            billTot += m.getPrice();
            if (m.getType() == MenuItem.itemType.PIZZE) {
                count++;
                if (m.getPrice() < min) {
                    min = m.getPrice();
                }
            }
        }
        if (count > 10) {
            billTot -= min;
        }

        if (billTot > 100) {
            billTot = billTot * 0.95;
        }
        return billTot;
    }
}
