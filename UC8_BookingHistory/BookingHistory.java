import java.util.ArrayList;
import java.util.List;

public class BookingHistory {

    private List<Reservation> bookingList;

    public BookingHistory() {
        bookingList = new ArrayList<>();
    }

    // Add confirmed booking
    public void addBooking(Reservation reservation) {
        bookingList.add(reservation);

        System.out.println(
                "Booking stored for: "
                        + reservation.getGuestName()
        );
    }

    // Return history
    public List<Reservation> getBookingHistory() {
        return bookingList;
    }
}