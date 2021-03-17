package Models;

public class Customer implements Comparable<Customer> {
    public static final String COMMA = ",";
    private String customerName;
    private String customerBirthDay;
    private String customerGender;
    private String customerIdCard;
    private String customerPhone;
    private String customerEmail;
    private String customerType;
    private String customerAddress;
    private Service customerService;

    public Customer() {
    }

    public Customer(String customerName, String customerBirthDay, String customerGender, String customerIdCard,
                    String customerPhone, String customerEmail, String customerType, String customerAddress) {
        this.customerName = customerName;
        this.customerBirthDay = customerBirthDay;
        this.customerGender = customerGender;
        this.customerIdCard = customerIdCard;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.customerType = customerType;
        this.customerAddress = customerAddress;
    }

    public Customer(String customerName, String customerBirthDay, String customerGender, String customerIdCard, String customerPhone,
                    String customerEmail, String customerType, String customerAddress, Service customerService) {
        this.customerName = customerName;
        this.customerBirthDay = customerBirthDay;
        this.customerGender = customerGender;
        this.customerIdCard = customerIdCard;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.customerType = customerType;
        this.customerAddress = customerAddress;
        this.customerService = customerService;
    }

    public Customer(String[] customerInfo) {
        this.customerName = customerInfo[0];
        this.customerBirthDay = customerInfo[1];
        this.customerGender = customerInfo[2];
        this.customerIdCard = customerInfo[3];
        this.customerPhone = customerInfo[4];
        this.customerEmail = customerInfo[5];
        this.customerType = customerInfo[6];
        this.customerAddress = customerInfo[7];
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerBirthDay() {
        return customerBirthDay;
    }

    public void setCustomerBirthDay(String customerBirthDay) {
        this.customerBirthDay = customerBirthDay;
    }

    public String getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(String customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerIdCard() {
        return customerIdCard;
    }

    public void setCustomerIdCard(String customerIdCard) {
        this.customerIdCard = customerIdCard;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public Service getCustomerService() {
        return customerService;
    }

    public void setCustomerService(Service customerService) {
        this.customerService = customerService;
    }

    @Override
    public String toString() {
        String string = customerName + COMMA +
                customerBirthDay + COMMA +
                customerGender + COMMA +
                customerIdCard + COMMA +
                customerPhone + COMMA +
                customerEmail + COMMA +
                customerType + COMMA +
                customerAddress;
        if (customerService != null) {
            string = string + "," + customerService.getServiceId();
        }
        return string;
    }

    public String showInfo() {
        return "Customer{" +
                "CustomerName= " + customerName + ",\t" +
                "CustomerBirthday= " + customerBirthDay + ",\t" +
                "CustomerGender= " + customerGender + ",\t" +
                "CustomerIdCard= " + customerIdCard + ",\t" +
                "CustomerPhone= " + customerPhone + ",\t" +
                "CustomerEmail= " + customerEmail + ",\t" +
                "CustomerType= " + customerType + ",\t" +
                "CustomerAddress= " + customerAddress + "}";
    }

    @Override
    public int compareTo(Customer customer) {
        if (this.customerName.equals(customer.getCustomerName())) {
            return (this.customerBirthDay.substring(6, 10)).compareTo(customer.getCustomerBirthDay().substring(6, 10));
        }
        return this.customerName.compareTo(customer.getCustomerName());
    }
}
