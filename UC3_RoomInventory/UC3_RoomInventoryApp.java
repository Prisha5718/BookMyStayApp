/**
 * UC3 - Application to demonstrate centralized inventory
 */
public class UC3_RoomInventoryApp {

    public static void main(String[] args) {

        // Initialize inventory
        RoomInventory inventory = new RoomInventory();

        // Display initial inventory
        inventory.displayInventory();

        // Update availability
        inventory.updateAvailability("Single Room", 8);

        System.out.println("\nAfter Update:");

        // Display updated inventory
        inventory.displayInventory();
    }
}