public class ConcurrentBookingProcessor {

    private RoomInventory inventory;

    public ConcurrentBookingProcessor(
            RoomInventory inventory
    ) {
        this.inventory = inventory;
    }

    // Critical section
    public synchronized void processBooking(
            Reservation reservation
    ) {

        String roomType =
                reservation.getRoomType();

        int available =
                inventory.getAvailability(
                        roomType
                );

        if (available > 0) {

            System.out.println(
                    Thread.currentThread()
                            .getName()
                            + " processing "
                            + reservation.getGuestName()
            );

            inventory.updateAvailability(
                    roomType,
                    available - 1
            );

            System.out.println(
                    "Booking confirmed for "
                            + reservation.getGuestName()
            );

        } else {

            System.out.println(
                    "No rooms available for "
                            + reservation.getGuestName()
            );
        }
    }
}
