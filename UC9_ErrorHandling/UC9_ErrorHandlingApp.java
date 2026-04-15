public class UC9_ErrorHandlingApp {

    public static void main(String[] args) {

        BookingValidator validator =
                new BookingValidator();

        Reservation reservation =
                new Reservation(
                        "Prisha",
                        "Luxury Room"
                );

        try {

            validator.validateBooking(
                    reservation,
                    2
            );

            System.out.println(
                    "Booking validation successful."
            );

        } catch (InvalidBookingException e) {

            System.out.println(
                    "Booking Failed: "
                            + e.getMessage()
            );
        }

        System.out.println(
                "\nSystem continues safely."
        );
    }
}
