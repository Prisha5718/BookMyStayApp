import java.io.Serializable;
import java.util.List;

public class SystemState
        implements Serializable {

    private RoomInventory inventory;
    private List<Reservation> bookings;

    public SystemState(
            RoomInventory inventory,
            List<Reservation> bookings
    ) {
        this.inventory = inventory;
        this.bookings = bookings;
    }

    public RoomInventory getInventory() {
        return inventory;
    }

    public List<Reservation> getBookings() {
        return bookings;
    }
}