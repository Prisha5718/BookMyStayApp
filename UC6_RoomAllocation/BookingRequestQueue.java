import java.util.LinkedList;
import java.util.Queue;

/**
 * Handles booking requests using FIFO Queue
 *
 * @author Prisha5718
 * @version 1.0
 */
public class BookingRequestQueue {

    private Queue<Reservation> requestQueue;

    public BookingRequestQueue() {
        requestQueue = new LinkedList<>();
    }

    // Add booking request
    public void addRequest(Reservation reservation) {
        requestQueue.offer(reservation);
        System.out.println("Request added for: "
                + reservation.getGuestName());
    }

    // Display all queued requests
    public void displayQueue() {
        System.out.println("\nBooking Request Queue:");

        for (Reservation reservation : requestQueue) {
            reservation.displayReservation();
        }
    }
}