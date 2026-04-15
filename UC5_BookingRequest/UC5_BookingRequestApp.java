/**
 * UC5 - Booking Request Application
 *
 * @author Prisha5718
 * @version 1.0
 */
public class UC5_BookingRequestApp {

    public static void main(String[] args) {

        BookingRequestQueue queue = new BookingRequestQueue();

        queue.addRequest(new Reservation("Prisha", "Single Room"));
        queue.addRequest(new Reservation("Riya", "Double Room"));
        queue.addRequest(new Reservation("Aman", "Suite Room"));

        queue.displayQueue();
    }
}