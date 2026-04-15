/**
 * UC4 - Room Search Application Entry
 *
 * @author Prisha5718
 * @version 1.0
 */
public class UC4_RoomSearchApp {

    public static void main(String[] args) {

        // Create inventory object
        RoomInventory inventory = new RoomInventory();

        // Create search service
        RoomSearchService searchService =
                new RoomSearchService(inventory);

        // Display available rooms
        searchService.displayAvailableRooms();
    }
}