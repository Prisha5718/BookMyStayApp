import java.util.Arrays;
import java.util.List;

public class BookingValidator {

    private static final List<String>
            validRoomTypes =
            Arrays.asList(
                    "Single Room",
                    "Double Room",
                    "Suite Room"
            );

    public void validateBooking(
            Reservation reservation,
            int availableRooms
    ) throws InvalidBookingException {

        // Check room type
        if (!validRoomTypes.contains(
                reservation.getRoomType())) {

            throw new InvalidBookingException(
                    "Invalid room type selected."
            );
        }

        // Check guest name
        if (reservation.getGuestName() == null
                || reservation.getGuestName()
                .trim().isEmpty()) {

            throw new InvalidBookingException(
                    "Guest name cannot be empty."
            );
        }

        // Check inventory
        if (availableRooms <= 0) {

            throw new InvalidBookingException(
                    "No rooms available."
            );
        }
    }
}
