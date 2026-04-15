import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BookingService {

    private RoomInventory inventory;
    private Set<String> allocatedRoomIds;
    private Map<String, Set<String>> roomAllocations;

    public BookingService(RoomInventory inventory) {
        this.inventory = inventory;
        allocatedRoomIds = new HashSet<>();
        roomAllocations = new HashMap<>();
    }

    public void confirmReservation(Reservation reservation) {

        String roomType = reservation.getRoomType();
        int available = inventory.getAvailability(roomType);

        if (available <= 0) {
            System.out.println("No rooms available for "
                    + reservation.getGuestName());
            return;
        }

        String roomId = generateRoomId(roomType);

        allocatedRoomIds.add(roomId);

        roomAllocations
                .computeIfAbsent(roomType, k -> new HashSet<>())
                .add(roomId);

        inventory.updateAvailability(roomType, available - 1);

        System.out.println("\nReservation Confirmed");
        System.out.println("Guest: "
                + reservation.getGuestName());
        System.out.println("Room Type: "
                + roomType);
        System.out.println("Assigned Room ID: "
                + roomId);
    }

    private String generateRoomId(String roomType) {

        String prefix = roomType.substring(0, 2).toUpperCase();
        int count = allocatedRoomIds.size() + 1;

        String roomId = prefix + count;

        while (allocatedRoomIds.contains(roomId)) {
            count++;
            roomId = prefix + count;
        }

        return roomId;
    }
}
