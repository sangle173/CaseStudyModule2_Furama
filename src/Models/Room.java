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
        return super.toString() + "," +
                freeService;
    }

    @Override
    public String showInfo() {
        return "Room{ServiceId= " + super.getServiceId() + "," +
                " ServiceName= " + super.getServiceName() + "," +
                " UsingArea= " + super.getUsingArea() + "m2," +
                " RentalPrice= " + super.getRentalPrice() + "$," +
                " MaxOfCustomer= " + super.getMaxOfCustomer() + " people," +
                " RentalType= " + super.getRentalType() + "," +
                " FreeService= " + getFreeService() + "}";
    }
    @Override
    public int compareTo(Service o) {
        return this.getServiceName().compareTo(o.getServiceName());
    }
}
