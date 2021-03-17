package Models;

public class Booking {
    public static final String COMMA = ",";
    private Customer customer;
    private Service service;

    public Booking(Customer customer, Service service) {

        this.customer = customer;
        this.service = service;
    }

    public Booking(String[] bookingInfo) {
        this.customer = new Customer(bookingInfo[0], bookingInfo[1], bookingInfo[2], bookingInfo[3], bookingInfo[4], bookingInfo[5], bookingInfo[6], bookingInfo[7]);
        if (bookingInfo.length == 18) {
            this.service = new Villa(bookingInfo[8], bookingInfo[9], Double.parseDouble(bookingInfo[10]), Double.parseDouble(bookingInfo[11]),
                    Integer.parseInt(bookingInfo[12]), bookingInfo[13], bookingInfo[14], bookingInfo[15], Double.parseDouble(bookingInfo[16]), Integer.parseInt(bookingInfo[17]));
        } else if (bookingInfo.length == 17) {
            this.service = new House(bookingInfo[8], bookingInfo[9], Double.parseDouble(bookingInfo[10]), Double.parseDouble(bookingInfo[11]),
                    Integer.parseInt(bookingInfo[12]), bookingInfo[13], bookingInfo[14], bookingInfo[15], Integer.parseInt(bookingInfo[16]));
        } else if (bookingInfo.length == 15) {
            this.service = new Room(bookingInfo[8], bookingInfo[9], Double.parseDouble(bookingInfo[10]), Double.parseDouble(bookingInfo[11]),
                    Integer.parseInt(bookingInfo[12]), bookingInfo[13], bookingInfo[14]);
        }
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    @Override
    public String toString() {
        return customer.toString() + COMMA +
                service.toString();
    }

    public String showBooking() {
        return "Customer Information :" + customer.showInfo() + ", Your service " +
                service.showInfo();
    }
}
