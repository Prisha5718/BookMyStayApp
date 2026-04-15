import java.util.List;

public class BookingReportService {

    private BookingHistory history;

    public BookingReportService(
            BookingHistory history
    ) {
        this.history = history;
    }

    // Display all bookings
    public void displayReport() {

        List<Reservation> bookings =
                history.getBookingHistory();

        System.out.println(
                "\nBooking History Report"
        );

        for (Reservation reservation : bookings) {
            reservation.displayReservation();
        }

        System.out.println(
                "\nTotal Confirmed Bookings: "
                        + bookings.size()
        );
    }
}