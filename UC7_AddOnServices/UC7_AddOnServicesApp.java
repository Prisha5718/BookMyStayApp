public class UC7_AddOnServicesApp {

    public static void main(String[] args) {

        String reservationId = "RES101";

        AddOnServiceManager manager =
                new AddOnServiceManager();

        manager.addService(
                reservationId,
                new AddOnService("Breakfast", 500)
        );

        manager.addService(
                reservationId,
                new AddOnService("Airport Pickup", 1200)
        );

        manager.addService(
                reservationId,
                new AddOnService("Spa Access", 1500)
        );

        manager.displayServices(reservationId);

        System.out.println(
                "\nTotal Add-On Cost: ₹"
                        + manager.getTotalCost(
                        reservationId
                )
        );
    }
}
