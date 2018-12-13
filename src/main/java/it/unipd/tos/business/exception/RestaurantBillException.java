////////////////////////////////////////////////////////////////////
// [Nicolò] [Vergari] [1047617]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business.exception;

public class RestaurantBillException extends Throwable {

    private String message;

    @Override
    public String getMessage() {
        return message;
    }
    public RestaurantBillException(String message) {
        this.message = message;
    }
}
