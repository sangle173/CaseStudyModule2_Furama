package Models;

public class Villa extends Service {
    private String roomStandard;
    private String otherUtilities;
    private double areaOfPool;
    private int noOfFloors;

    public Villa() {
    }

    public Villa(String roomStandard, String otherUtilities, double areaOfPool, int noOfFloors) {
        this.roomStandard = roomStandard;
        this.otherUtilities = otherUtilities;
        this.areaOfPool = areaOfPool;
        this.noOfFloors = noOfFloors;
    }

    public Villa(String serviceId, String serviceName, double usingArea, double rentalPrice, int maxOfCustomer, String rentalType, String roomStandard, String otherUtilities, double areaOfPool, int noOfFloors) {
        super(serviceId, serviceName, usingArea, rentalPrice, maxOfCustomer, rentalType);
        this.roomStandard = roomStandard;
        this.otherUtilities = otherUtilities;
        this.areaOfPool = areaOfPool;
        this.noOfFloors = noOfFloors;
    }

    public Villa(String[] villaInfo) {
        super(villaInfo[0], villaInfo[1], Double.parseDouble(villaInfo[2]), Double.parseDouble(villaInfo[3]), Integer.parseInt(villaInfo[4]), villaInfo[5]);
        this.roomStandard = villaInfo[6];
        this.otherUtilities = villaInfo[7];
        this.areaOfPool = Double.parseDouble(villaInfo[8]);
        this.noOfFloors = Integer.parseInt(villaInfo[9]);
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

    public double getAreaOfPool() {
        return areaOfPool;
    }

    public void setAreaOfPool(double areaOfPool) {
        this.areaOfPool = areaOfPool;
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
                areaOfPool + COMMA +
                noOfFloors;
    }

    @Override
    public String showInfo() {
        return "Villa{ServiceId= " + super.getServiceId() + "," +
                " ServiceName= " + super.getServiceName() + "," +
                " UsingArea= " + super.getUsingArea() + "m2," +
                " RentalPrice= " + super.getRentalPrice() + "$," +
                " MaxOfCustomer= " + super.getMaxOfCustomer() + " people," +
                " RentalType= " + super.getRentalType() + "," +
                " RoomStandard= " + getRoomStandard() + "," +
                " OtherUtilities= " + getOtherUtilities() + "," +
                " AreaOfPool= " + getAreaOfPool() + "," +
                " NoOfFloors= " + getNoOfFloors() + "}";
    }

    @Override
    public int compareTo(Service o) {
        return this.getServiceName().compareTo(o.getServiceName());
    }
}
