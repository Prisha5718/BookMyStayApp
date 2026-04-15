import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddOnServiceManager {

    private Map<String, List<AddOnService>> serviceMap;

    public AddOnServiceManager() {
        serviceMap = new HashMap<>();
    }

    public void addService(String reservationId,
                           AddOnService service) {

        serviceMap
                .computeIfAbsent(
                        reservationId,
                        k -> new ArrayList<>())
                .add(service);

        System.out.println(
                service.getServiceName()
                        + " added to "
                        + reservationId
        );
    }

    public void displayServices(String reservationId) {

        List<AddOnService> services =
                serviceMap.get(reservationId);

        if (services == null) {
            System.out.println("No services selected.");
            return;
        }

        System.out.println(
                "\nServices for "
                        + reservationId + ":"
        );

        for (AddOnService service : services) {
            service.displayService();
        }
    }

    public double getTotalCost(String reservationId) {

        List<AddOnService> services =
                serviceMap.get(reservationId);

        double total = 0;

        if (services != null) {
            for (AddOnService service : services) {
                total += service.getCost();
            }
        }

        return total;
    }
}