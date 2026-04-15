public class UC10_CancellationApp {

    public static void main(String[] args) {

        RoomInventory inventory =
                new RoomInventory();

        BookingHistory history =
                new BookingHistory();

        Reservation booking =
                new Reservation(
                        "Prisha",
                        "Single Room"
                );

        history.addBooking(booking);

        CancellationService cancelService =
                new CancellationService(
                        inventory,
                        history
                );

        cancelService.cancelBooking(booking);

        inventory.displayInventory();

        cancelService.displayRollbackHistory();
    }
}
