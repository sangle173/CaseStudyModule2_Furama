package Models;

public class House extends Service {
    private String roomStandard;
    private String otherUtilities;
    private int noOfFloors;

    public House() {
    }

    public House(String roomStandard, String otherUtilities, int noOfFloors) {
        this.roomStandard = roomStandard;
        this.otherUtilities = otherUtilities;
        this.noOfFloors = noOfFloors;
    }

    public House(String serviceId, String serviceName, double usingArea, double rentalPrice, int maxOfCustomer, String rentalType, String roomStandard, String otherUtilities, int noOfFloors) {
        super(serviceId, serviceName, usingArea, rentalPrice, maxOfCustomer, rentalType);
        this.roomStandard = roomStandard;
        this.otherUtilities = otherUtilities;
        this.noOfFloors = noOfFloors;
    }

    public House(String[] houseInfo) {
        super(houseInfo[0], houseInfo[1], Double.parseDouble(houseInfo[2]), Double.parseDouble(houseInfo[3]), Integer.parseInt(houseInfo[4]), houseInfo[5]);
        this.roomStandard = houseInfo[6];
        this.otherUtilities = houseInfo[7];
        this.noOfFloors = Integer.parseInt(houseInfo[8]);

    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public String getOtherUtilities() {
        return otherUtilities;
    }

    public void setOtherUtilities(String otherUtilities) {
        this.otherUtilities = otherUtilities;
    }

    public int getNoOfFloors() {
        return noOfFloors;
    }

    public void setNoOfFloors(int noOfFloors) {
        this.noOfFloors = noOfFloors;
    }

    @Override
    public String toString() {
        return super.toString() + COMMA +
                roomStandard + COMMA +
                otherUtilities + COMMA +
                noOfFloors;
    }

    @Override
    public String showInfo() {
        return "House{ServiceId= " + super.getServiceId() + "," +
                " ServiceName= " + super.getServiceName() + "," +
                " UsingArea= " + super.getUsingArea() + "m2," +
                " RentalPrice= " + super.getRentalPrice() + "$," +
                " MaxOfCustomer= " + super.getMaxOfCustomer() + " people," +
                " RentalType= " + super.getRentalType() + "," +
                " RoomStandard= " + getRoomStandard() + "," +
                " OtherUtilities= " + getOtherUtilities() + "," +
                " NoOfFloors= " + getNoOfFloors() + "}";
    }

    @Override
    public int compareTo(Service o) {
        return this.getServiceName().compareTo(o.getServiceName());
    }
}
