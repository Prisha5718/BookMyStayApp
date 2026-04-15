import java.util.Stack;

public class CancellationService {

    private RoomInventory inventory;
    private BookingHistory history;
    private Stack<String> rollbackStack;

    public CancellationService(
            RoomInventory inventory,
            BookingHistory history
    ) {
        this.inventory = inventory;
        this.history = history;
        rollbackStack = new Stack<>();
    }

    public void cancelBooking(
            Reservation reservation
    ) {

        boolean found = false;

        for (Reservation r :
                history.getBookingHistory()) {

            if (r.getGuestName().equals(
                    reservation.getGuestName())
                    &&
                    r.getRoomType().equals(
                            reservation.getRoomType())) {

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println(
                    "Cancellation failed: Booking not found."
            );
            return;
        }

        String roomId =
                generateRollbackId(
                        reservation.getRoomType()
                );

        rollbackStack.push(roomId);

        int current =
                inventory.getAvailability(
                        reservation.getRoomType()
                );

        inventory.updateAvailability(
                reservation.getRoomType(),
                current + 1
        );

        System.out.println(
                "\nBooking cancelled successfully"
        );

        System.out.println(
                "Released Room ID: " + roomId
        );

        System.out.println(
                "Inventory restored."
        );
    }

    private String generateRollbackId(
            String roomType
    ) {
        String prefix =
                roomType.substring(0, 2)
                        .toUpperCase();

        return prefix + "_CANCELLED";
    }

    public void displayRollbackHistory() {
        System.out.println(
                "\nRollback Stack: "
                        + rollbackStack
        );
    }
}