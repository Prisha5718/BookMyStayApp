public class UC6_RoomAllocationApp {

    public static void main(String[] args) {

        RoomInventory inventory = new RoomInventory();

        BookingRequestQueue queue =
                new BookingRequestQueue();

        BookingService bookingService =
                new BookingService(inventory);

        queue.addRequest(
                new Reservation("Prisha", "Single Room"));
        queue.addRequest(
                new Reservation("Riya", "Double Room"));
        queue.addRequest(
                new Reservation("Aman", "Suite Room"));

        while (!queue.isEmpty()) {
            Reservation reservation =
                    queue.getNextRequest();

            bookingService.confirmReservation(
                    reservation
            );
        }

        System.out.println("\nUpdated Inventory:");
        inventory.displayInventory();
    }
}