package Models;

public class Room extends Service {
    private String freeService;

    public Room() {
    }


    public Room(String freeService) {
        this.freeService = freeService;
    }

    public Room(String serviceId, String serviceName, double usingArea, double rentalPrice, int maxOfCustomer, String rentalType, String freeService) {
        super(serviceId, serviceName, usingArea, rentalPrice, maxOfCustomer, rentalType);
        this.freeService = freeService;
    }

    public Room(String[] roomInfo) {
        super(roomInfo[0], roomInfo[1], Double.parseDouble(roomInfo[2]), Double.parseDouble(roomInfo[3]), Integer.parseInt(roomInfo[4]), roomInfo[5]);
        this.freeService = roomInfo[6];
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public String toString() {
        return super.toString() + COMMA +
                freeService;
    }

    @Override
    public String showInfo() {
        return super.getServiceId() + "\t\t" +
                super.getServiceName() + "\t\t" +
                super.getUsingArea() + "m2\t\t" +
                super.getRentalPrice() + "$\t\t\t" +
                super.getMaxOfCustomer() + "people\t\t\t" +
                super.getRentalType() + "\t\t\t" +
                getFreeService();
    }

    @Override
    public int compareTo(Service o) {
        return this.getServiceName().compareTo(o.getServiceName());
    }
}
