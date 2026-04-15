import java.util.Map;

/**
 * UC4 - Room Search Service
 * Handles read-only access to room inventory.
 *
 * @author Prisha5718
 * @version 1.0
 */
public class RoomSearchService {

    private RoomInventory inventory;

    // Constructor
    public RoomSearchService(RoomInventory inventory) {
        this.inventory = inventory;
    }

    // Display available rooms only
    public void displayAvailableRooms() {
        System.out.println("\nAvailable Rooms:\n");

        Map<String, Integer> allRooms = inventory.getAllRooms();

        for (Map.Entry<String, Integer> entry : allRooms.entrySet()) {

            String roomType = entry.getKey();
            int count = entry.getValue();

            // Defensive programming check
            if (count > 0) {

                Room room = createRoom(roomType);

                if (room != null) {
                    room.displayDetails();
                    System.out.println("Available Count: " + count);
                    System.out.println("---------------------------");
                }
            }
        }
    }

    // Create room objects
    private Room createRoom(String roomType) {

        switch (roomType) {
            case "Single Room":
                return new SingleRoom();

            case "Double Room":
                return new DoubleRoom();

            case "Suite Room":
                return new SuiteRoom();

            default:
                return null;
        }
    }
}
