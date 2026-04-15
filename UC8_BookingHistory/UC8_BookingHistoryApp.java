public class UC8_BookingHistoryApp {

    public static void main(String[] args) {

        BookingHistory history =
                new BookingHistory();

        history.addBooking(
                new Reservation(
                        "Prisha",
                        "Single Room"
                )
        );

        history.addBooking(
                new Reservation(
                        "Riya",
                        "Double Room"
                )
        );

        history.addBooking(
                new Reservation(
                        "Aman",
                        "Suite Room"
                )
        );

        BookingReportService report =
                new BookingReportService(
                        history
                );

        report.displayReport();
    }
}
