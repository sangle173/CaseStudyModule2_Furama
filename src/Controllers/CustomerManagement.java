package Controllers;

import Commons.*;
import Models.Customer;
import Models.Room;
import Models.Villa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CustomerManagement implements CRUDService<Customer> {
    FuncWritingReading funcWritingReading = new FuncWritingReading();
    Scanner scanner = new Scanner(System.in);
    Standardized standardized = new Standardized();
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
        List<Customer> customerList = read();
        do {
            System.out.println("Enter the Customer Id Card");
            String customerIdCard = scanner.nextLine();
            for (Customer customer : customerList) {
                if (customerIdCard.equals(customer.getCustomerIdCard())) {
                    System.out.println("The customer information of " + customerIdCard + " want to search is: ");
                    System.out.println(customer.showInfo());
                    return;
                }
            }
            System.out.println("The Id Card of Customer not available");
        } while (true);
    }

    @Override
    public void add() throws NameException, EmailException, GenderException, IdCardException, BirthdayException {
        List<Customer> customerList;
        boolean exit = false;
        List<String> list = new ArrayList<>();
        do {
            customerList = new ArrayList<>();
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
            Customer customer = new Customer(customerInfo);
            customerList.add(customer);
            Collections.sort(customerList);
            funcWritingReading.writeToFile("Customer.csv", customerList, true);
            System.out.println("Do you want to continue (Y/N)? User chooses Y to continues, if you chooses N, the program returns main screen\n" +
                    "and saved the all room to systems.");
            String choice = scanner.nextLine();
            if ("N".equals(choice)) {
                System.out.println("Loading 0% 10% 20% 30% 40%...........80% 90% 100%, done!");
                System.out.println("Villa have been add to systems");
                exit = true;
            } else if ("Y".equals(choice)) {
                exit = false;
            }
        } while (!exit);
    }

    @Override
    public void update() throws NameException, BirthdayException, GenderException, IdCardException, EmailException {
        List<Customer> customerList = read();
        do {
            System.out.println("Enter Customer Id Card");
            String customerIdCard = scanner.nextLine();
            for (int i = 0; i < customerList.size(); i++) {
                if (customerIdCard.equals(customerList.get(i).getCustomerIdCard())) {
                    System.out.println("Please update the customer information of customer's " + customerIdCard + " with new information");
                    List<String> listProperties = new ArrayList<>();
                    String customerName = inputCustomerName();
                    listProperties.add(customerName);
                    String customerBirthDay = inputCustomerBirthday();
                    listProperties.add(customerBirthDay);
                    String customerGender = inputCustomerGender();
                    listProperties.add(customerGender);
                    listProperties.add(customerIdCard);
                    String customerPhone = inputCustomerPhone();
                    listProperties.add(customerPhone);
                    String customerEmail = inputCustomerEmail();
                    listProperties.add(customerEmail);
                    String customerType = inputCustomerType();
                    listProperties.add(customerType);
                    String customerAddress = inputCustomerAddress();
                    listProperties.add(customerAddress);
                    String[] customerInfo = listProperties.toArray(new String[0]);
                    Customer customer = new Customer(customerInfo);
                    customerList.set(i, customer);
                    funcWritingReading.writeToFile("Customer.csv", customerList, false);
                    System.out.println("Have been updated");
                    return;
                }
            }
            System.out.println("The Id Card of customer is not available");
        } while (true);
    }

    @Override
    public void delete() {
        List<Customer> customerList = read();
        do {
            System.out.println("Enter Customer Id Card");
            String customerIdCard = scanner.nextLine();
            for (int i = 0; i < customerList.size(); i++) {
                if (customerIdCard.equals(customerList.get(i).getCustomerIdCard())) {
                    customerList.remove(i);
                    funcWritingReading.writeToFile("Customer.csv", customerList, false);
                    System.out.println("Have been deleted");
                    return;
                }
            }
            System.out.println("The Customer Id Card is not available");
        } while (true);
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

    public String inputCustomerEmail() throws EmailException {
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

    public String inputCustomerIdCard() throws IdCardException {
        do {
            System.out.println("Enter customer id card");
            String customerIdCard = scanner.nextLine().trim();
            if (validation.validateCustomerIdCard(customerIdCard)) {
                return customerIdCard;
            }
        } while (true);
    }

    public String inputCustomerGender() throws GenderException {
        do {
            System.out.println("Enter customer gender");
            String customerGender = scanner.nextLine().trim();
            if (validation.validateCustomerGender(customerGender)) {
                return standardized.standardizedDate(customerGender);
            }
        } while (true);
    }

    public String inputCustomerBirthday() throws BirthdayException {
        do {
            System.out.println("Enter customer birthday");
            String customerBirthDay = scanner.nextLine().trim();
            if (validation.validateCustomerBirthday(customerBirthDay)) {
                return customerBirthDay;
            }
        } while (true);

    }

    public String inputCustomerName() throws NameException {
        do {
            System.out.println("Enter customer name");
            String name = scanner.nextLine().trim();
            if (validation.nameException(name)) {
                return name;
            }
        } while (true);
    }
}
