package Controllers;

import Commons.FuncWritingReading;
import Commons.Validation;
import Models.Service;
import Models.Villa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ServiceManagement {
    Validation validation = new Validation();
    Scanner scanner = new Scanner(System.in);

    public List<String> addProperties() {
        List<String> list = new ArrayList<>();
        String serviceName = inputServiceName();
        list.add(serviceName);
        String usingArea = inputUsingArea();
        list.add(usingArea);
        String rentalPrice = inputRentalPrice();
        list.add(rentalPrice);
        String maxOfCustomer = inputMaxOfCustomer();
        list.add(maxOfCustomer);
        String rentalType = inputRentalType();
        list.add(rentalType);
        return list;
    }


    public String inputRentalType() {
        do {
            System.out.println("Enter rental type");
            String text = scanner.nextLine().trim();
            if (validation.validateText(text)) {
                return text;
            }
        } while (true);
    }

    public String inputMaxOfCustomer() {
        do {
            System.out.println("Enter maximum of customer");
            String maxOfCustomer = scanner.nextLine().trim();
            if (validation.validateMaxOfCustomer(maxOfCustomer)) {
                return maxOfCustomer;
            }
        } while (true);
    }

    public String inputRentalPrice() {
        do {
            System.out.println("Enter rental price");
            String rentalPrice = scanner.nextLine().trim();
            if (validation.validateRentalPrice(rentalPrice)) {
                return rentalPrice;
            }
        } while (true);
    }

    public String inputUsingArea() {
        do {
            System.out.println("Enter area of using");
            String areaUsing = scanner.nextLine().trim();
            if (validation.validateAreaUsingAndPool(areaUsing)) {
                return areaUsing;
            }
        } while (true);
    }

    public String inputServiceName() {
        do {
            System.out.println("Enter service name");
            String text = scanner.nextLine().trim();
            if (validation.validateText(text)) {
                return text;
            }
        } while (true);
    }


    public String inputNoOfFloors() {
        do {
            System.out.println("Enter no of floors");
            String noOfFloors = scanner.nextLine().trim();
            if (validation.validateNoOfFloors(noOfFloors)) {
                return noOfFloors;
            }
        } while (true);
    }

    public String inputAreaOfPool() {
        do {
            System.out.println("Enter area of pool");
            String areaPool = scanner.nextLine().trim();
            if (validation.validateAreaUsingAndPool(areaPool)) {
                return areaPool;
            }
        } while (true);
    }

    public String inputOtherUtilities() {
        do {
            System.out.println("Enter other utilities");
            String text = scanner.nextLine().trim();
            if (validation.validateText(text)) {
                return text;
            }
        } while (true);
    }

    public String inputRoomStandard() {
        do {
            System.out.println("Enter room standard");
            String text = scanner.nextLine().trim();
            if (validation.validateText(text)) {
                return text;
            }
        } while (true);
    }

    public String inputFreeService() {
        do {
            System.out.println("Enter free service in list 'massage, karaoke, food, drink or car'");
            String freeService = scanner.nextLine().trim();
            if (validation.validateFreeService(freeService)) {
                return freeService;
            }
        } while (true);
    }
}
