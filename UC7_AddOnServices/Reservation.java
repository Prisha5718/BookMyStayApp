/**
 * Represents a guest booking request
 *
 * @author Prisha5718
 * @version 1.0
 */
public class Reservation {

    private String guestName;
    private String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }

    public void displayReservation() {
        System.out.println("Guest: " + guestName +
                " | Requested Room: " + roomType);
    }
}