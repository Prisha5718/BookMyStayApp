public class UC11_ConcurrentBookingApp {

    public static void main(String[] args) {

        RoomInventory inventory =
                new RoomInventory();

        // Set only 1 room for testing
        inventory.updateAvailability(
                "Single Room",
                1
        );

        ConcurrentBookingProcessor processor =
                new ConcurrentBookingProcessor(
                        inventory
                );

        GuestBookingThread guest1 =
                new GuestBookingThread(
                        processor,
                        new Reservation(
                                "Prisha",
                                "Single Room"
                        )
                );

        GuestBookingThread guest2 =
                new GuestBookingThread(
                        processor,
                        new Reservation(
                                "Riya",
                                "Single Room"
                        )
                );

        guest1.start();
        guest2.start();

        try {
            guest1.join();
            guest2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(
                "\nFinal Inventory:"
        );

        inventory.displayInventory();
    }
}