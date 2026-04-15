public class GuestBookingThread
        extends Thread {

    private ConcurrentBookingProcessor processor;
    private Reservation reservation;

    public GuestBookingThread(
            ConcurrentBookingProcessor processor,
            Reservation reservation
    ) {
        this.processor = processor;
        this.reservation = reservation;
    }

    @Override
    public void run() {
        processor.processBooking(
                reservation
        );
    }
}