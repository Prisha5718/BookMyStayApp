import java.util.HashMap;
import java.util.Map;

/**
 * UC3 - Centralized Room Inventory Management
 * 
 * Manages room availability using HashMap.
 * Acts as a single source of truth.
 * 
 * @author Prisha5718
 * @version 1.0
 */
public class RoomInventory {

    private HashMap<String, Integer> inventory;

    // Constructor
    public RoomInventory() {
        inventory = new HashMap<>();

        // Initialize room availability
        inventory.put("Single Room", 10);
        inventory.put("Double Room", 5);
        inventory.put("Suite Room", 2);
    }

    // Get availability
    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    // Update availability
    public void updateAvailability(String roomType, int count) {
        inventory.put(roomType, count);
    }

    // Return all room data (IMPORTANT FOR UC4)
    public Map<String, Integer> getAllRooms() {
        return inventory;
    }

    // Display all rooms
    public void displayInventory() {
        System.out.println("\nRoom Inventory:");

        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + " → Available: " + entry.getValue());
        }
    }
}