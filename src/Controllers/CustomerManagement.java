package Controllers;

import Commons.FuncWritingReading;
import Commons.Validation;
import Models.Customer;
import Models.Villa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CustomerManagement implements CRUDService<Customer> {
    FuncWritingReading funcWritingReading = new FuncWritingReading();
    Scanner scanner = new Scanner(System.in);
    Validation validation = new Validation();

    @Override
    public List<Customer> read() {
        List<String[]> list = funcWritingReading.readFromFile("Customer.csv");
        List<Customer> customerList = new ArrayList<>();
        for (String[] customerInfo : list) {
            Customer customer = new Customer(customerInfo);
            customerList.add(customer);
        }
        Collections.sort(customerList);
        return customerList;
    }

    @Override
    public void show() {
        List<Customer> customerList = read();
        int count = 1;
        for (Customer customer : customerList) {
            System.out.println(count + ".\t" + customer.showInfo());
            count++;
        }
    }

    @Override
    public void searchById() {

    }

    @Override
    public List<Customer> create() {
        List<String> list = new ArrayList<>();
        String customerName = inputCustomerName();
        list.add(customerName);
        String customerBirthDay = inputCustomerBirthday();
        list.add(customerBirthDay);
        String customerGender = inputCustomerGender();
        list.add(customerGender);
        String customerIdCard = inputCustomerIdCard();
        list.add(customerIdCard);
        String customerPhone = inputCustomerPhone();
        list.add(customerPhone);
        String customerEmail = inputCustomerEmail();
        list.add(customerEmail);
        String customerType = inputCustomerType();
        list.add(customerType);
        String customerAddress = inputCustomerAddress();
        list.add(customerAddress);
        String[] customerInfo = list.toArray(new String[0]);
        List<Customer> customerList = new ArrayList<>();
        Customer customer = new Customer(customerInfo);
        customerList.add(customer);
        return customerList;
    }


    @Override
    public void add() {
        List<Customer> customerList = create();
        Collections.sort(customerList);
        funcWritingReading.writeToFile("Customer.csv", customerList, true);
    }

    @Override
    public void update(Customer customer, String id) {

    }

    @Override
    public void delete(String id) {

    }

    public Customer choiceCustomer() {
        System.out.println("Customer list");
        List<Customer> customerList = read();
        if (customerList.size() == 0) {
            System.out.println("Customer list is empty");
            return null;
        }
        show();
        int index = 0;
        while (true) {
            System.out.println("Choice a customer");
            try {
                index = Integer.parseInt(scanner.nextLine());
                if (index > 0 && index <= customerList.size()) {
                    return customerList.get(index - 1);
                } else {
                    System.out.println("You must to choice in list");
                }
            } catch (NumberFormatException e) {
                System.err.println("Please enter a integer number");
            }
        }
    }

    public String inputCustomerAddress() {
        do {
            System.out.println("Enter customer address");
            String customerAddress = scanner.nextLine().trim();
            if (validation.validateText(customerAddress)) {
                return customerAddress;
            }
        } while (true);
    }

    public String inputCustomerType() {
        do {
            System.out.println("Enter customer type");
            String customerType = scanner.nextLine().trim();
            if (validation.validateText(customerType)) {
                return customerType;
            }
        } while (true);
    }

    public String inputCustomerEmail() {
        do {
            System.out.println("Enter customer email");
            String customerEmail = scanner.nextLine().trim();
            if (validation.validateCustomerEmail(customerEmail)) {
                return customerEmail;
            }
        } while (true);
    }

    public String inputCustomerPhone() {
        do {
            System.out.println("Enter customer phone number");
            String customerPhoneNumber = scanner.nextLine().trim();
            if (validation.validateCustomerPhone(customerPhoneNumber)) {
                return customerPhoneNumber;
            }
        } while (true);
    }

    public String inputCustomerIdCard() {
        do {
            System.out.println("Enter customer id card");
            String customerIdCard = scanner.nextLine().trim();
            if (validation.validateCustomerIdCard(customerIdCard)) {
                return customerIdCard;
            }
        } while (true);
    }

    public String inputCustomerGender() {
        do {
            System.out.println("Enter customer gender");
            String customerGender = scanner.nextLine().trim();
            if (validation.validateCustomerGender(customerGender)) {
                return customerGender;
            }
        } while (true);
    }

    public String inputCustomerBirthday() {
        do {
            System.out.println("Enter customer birthday");
            String customerBirthDay = scanner.nextLine().trim();
            if (validation.validateCustomerBirthday(customerBirthDay)) {
                return customerBirthDay;
            }
        } while (true);

    }

    public String inputCustomerName() {
        do {
            System.out.println("Enter customer name");
            String text = scanner.nextLine().trim();
            if (validation.validateText(text)) {
                return text;
            }
        } while (true);
    }
}
