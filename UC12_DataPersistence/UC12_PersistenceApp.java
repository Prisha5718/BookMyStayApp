import java.util.ArrayList;
import java.util.List;

public class UC12_PersistenceApp {

    public static void main(String[] args) {

        PersistenceService service =
                new PersistenceService();

        RoomInventory inventory =
                new RoomInventory();

        List<Reservation> bookings =
                new ArrayList<>();

        bookings.add(
                new Reservation(
                        "Prisha",
                        "Single Room"
                )
        );

        bookings.add(
                new Reservation(
                        "Riya",
                        "Double Room"
                )
        );

        SystemState state =
                new SystemState(
                        inventory,
                        bookings
                );

        // SAVE
        service.saveState(state);

        // LOAD
        SystemState recovered =
                service.loadState();

        if (recovered != null) {

            System.out.println(
                    "\nRecovered Bookings:"
            );

            for (Reservation r :
                    recovered.getBookings()) {

                r.displayReservation();
            }

            System.out.println(
                    "\nRecovered Inventory:"
            );

            recovered.getInventory()
                    .displayInventory();
        }
    }
}
