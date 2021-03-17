package Controllers;

import Commons.*;
import Models.Customer;
import Models.House;
import Models.Room;
import Models.Villa;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class MainController {
    VillaManagement villaManagement = new VillaManagement();
    HouseManagement houseManagement = new HouseManagement();
    RoomManagement roomManagement = new RoomManagement();
    CustomerManagement customerManagement = new CustomerManagement();
    BookingManagement bookingManagement = new BookingManagement();
    EmployeeManagement employeeManagement = new EmployeeManagement();
    CinemaBookingManager cinemaBookingManager = new CinemaBookingManager();
    EmployeesCVManager employeesCVManager = new EmployeesCVManager();
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws NameException, EmailException, GenderException, IdCardException, BirthdayException {
        MainController mainController = new MainController();
        mainController.displayMain();
    }

    public void displayMain() throws NameException, EmailException, GenderException, IdCardException, BirthdayException {
        System.out.println("Furama resort booking Menu:\n" +
                "1.Add New Services\n" +
                "2.Show Services\n" +
                "3.Add New Customer\n" +
                "4.Show Information of Customer\n" +
                "5.Add New Booking\n" +
                "6.Show all Booking\n" +
                "7.Show Information of Employee\n" +
                "8.Cinema 4D booking\n" +
                "9.Employees File Cabinets\n" +
                "10.Update And Delete Service\n" +
                "11.Search Customer by Id Card\n" +
                "0.Exit");
        System.out.println("-----------------");
        System.out.println("Please choose: ");
        String choose = null;
        boolean exit = false;

        while (true) {
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    addNewServicesMenu();
                    break;
                case "2":
                    showServiceMenu();
                    break;
                case "3":
                    customerManagement.add();
                    break;
                case "4":
                    customerManagement.show();
                    break;
                case "5":
                    addBookingMenu();
                case "6":
                    bookingManagement.show();
                    break;
                case "7":
                    employeeManagement.show();
                    break;
                case "8":
                    cinemaBookingManager.saleTicket();
                    break;
                case "9":
                    employeesCVManager.searchEmployee();
                    break;
                case "10":
                    updateAndDeleteServiceMenu();
                    break;
                case "11":
                    searchCustomerByIdMenu();
                    break;
                case "0":
                    System.out.println("See you again!");
                    exit = true;
                    break;
                default:
                    System.err.println("Invalid! please choose action in below menu:");
            }
            if (exit) {
                break;
            }
            displayMain();
        }
    }



    public void addNewServicesMenu() throws NameException, EmailException, GenderException, IdCardException, BirthdayException {
        System.out.println("Menu Add New Services\n" +
                "1.Add New Villa\n" +
                "2.Add New House\n" +
                "3.Add New Room\n" +
                "4.Back To Menu\n" +
                "0.Exit");
        System.out.println("Please choose: ");
        String choose = null;
        boolean exit = false;

        while (true) {
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    villaManagement.add();
                    break;
                case "2":
                    houseManagement.add();
                    break;
                case "3":
                    roomManagement.add();
                    break;
                case "4":
                    displayMain();
                    break;
                case "0":
                    System.out.println("See you again!");
                    exit = true;
                    break;
                default:
                    System.err.println("Invalid! please choose action in below menu:");
                    break;
            }
            if (exit) {
                break;
            }
            addNewServicesMenu();
        }
    }

    public void showServiceMenu() throws NameException, EmailException, GenderException, IdCardException, BirthdayException {
        System.out.println("Menu:\n" +
                "1.Show all Villa\n" +
                "2.Show all House\n" +
                "3.Show all Room\n" +
                "4.Show all Name Villa Not Duplicate\n" +
                "5.Show all Name House Not Duplicate\n" +
                "6.Show all Name Room Not Duplicate\n" +
                "7.Back to Menu\n" +
                "0.Exit");
        System.out.println("Please choose: ");
        String choose = null;
        boolean exit = false;

        while (true) {
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    villaManagement.show();
                    break;
                case "2":
                    houseManagement.show();
                    break;
                case "3":
                    roomManagement.show();
                    break;
                case "4":
                    villaManagement.showNotDuplicate();
                    break;
                case "5":
                    houseManagement.showNotDuplicate();
                    break;
                case "6":
                    roomManagement.showNotDuplicate();
                    break;
                case "7":
                    displayMain();
                    break;
                case "0":
                    System.out.println("See you again!");
                    exit = true;
                    break;
                default:
                    System.err.println("Invalid! please choose action in below menu:");
                    break;
            }
            if (exit) {
                break;
            }
            showServiceMenu();
        }
    }

    public void addBookingMenu() throws NameException, EmailException, GenderException, IdCardException, BirthdayException {
        System.out.println("Booking menu");
        System.out.println("Please choice the customer with Customer Id in list blow");
        Customer customer = customerManagement.choiceCustomer();
        System.out.println("Choice a service you want to booking");
        System.out.println("1.Book Villa\n" +
                "2.Book House\n" +
                "3.Book Room\n" +
                "4.Back To Menu\n" +
                "0.Exit");
        System.out.println("Enter your choice: ");
        String choose = null;
        boolean exit = false;

        while (true) {
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    Villa villa = villaManagement.choiceVilla();
                    bookingManagement.add(customer, villa);
                    System.out.println("Your selection have been saved");
                    displayMain();
                    break;
                case "2":
                    House house = houseManagement.choicehouse();
                    bookingManagement.add(customer, house);
                    System.out.println("Your selection have been saved");
                    displayMain();
                    break;
                case "3":
                    Room room = roomManagement.choiceRoom();
                    bookingManagement.add(customer, room);
                    System.out.println("Your selection have been saved");
                    displayMain();
                    break;
                case "4":
                    displayMain();
                    break;
                case "0":
                    System.out.println("See you again!");
                    exit = true;
                    break;
                default:
                    System.err.println("Invalid! please choose action in below menu:");
                    break;
            }
            if (exit) {
                break;
            }
        }
    }
    public void updateAndDeleteServiceMenu() throws IdCardException, EmailException, GenderException, BirthdayException, NameException {
        System.out.println("Menu:\n" +
                "1.Update Villa\n" +
                "2.Update House\n" +
                "3.Update Room\n" +
                "4.Delete Villa\n" +
                "5.Delete House\n" +
                "6.Delete Room\n" +
                "7.Update Customer\n" +
                "8.Delete Customer\n" +
                "9.Back to Menu\n" +
                "0.Exit");
        System.out.println("Please choose: ");
        String choose = null;
        boolean exit = false;

        while (true) {
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    villaManagement.update();
                    break;
                case "2":
                    houseManagement.update();
                    break;
                case "3":
                    roomManagement.update();
                    break;
                case "4":
                    villaManagement.delete();
                    break;
                case "5":
                    houseManagement.delete();
                    break;
                case "6":
                    roomManagement.delete();
                    break;
                case "7":
                    customerManagement.update();
                    break;
                case "8":
                    customerManagement.delete();
                    break;
                case "9":
                    displayMain();
                    break;
                case "0":
                    System.out.println("See you again!");
                    exit = true;
                    break;
                default:
                    System.err.println("Invalid! please choose action in below menu:");
                    break;
            }
            if (exit) {
                break;
            }
            updateAndDeleteServiceMenu();
        }
    }
    public void searchCustomerByIdMenu() throws IdCardException, EmailException, GenderException, BirthdayException, NameException {
        System.out.println("Menu:\n" +
                "1.Search Villa\n" +
                "2.Search House\n" +
                "3.Search Room\n" +
                "4.Search Customer\n" +
                "5.Back to Menu\n" +
                "0.Exit");
        System.out.println("Please choose: ");
        String choose = null;
        boolean exit = false;

        while (true) {
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    villaManagement.searchById();
                    break;
                case "2":
                    houseManagement.searchById();
                    break;
                case "3":
                    roomManagement.searchById();
                    break;
                case "4":
                    customerManagement.searchById();
                    break;
                case "5":
                    displayMain();
                    break;
                case "0":
                    System.out.println("See you again!");
                    exit = true;
                    break;
                default:
                    System.err.println("Invalid! please choose action in below menu:");
                    break;
            }
            if (exit) {
                break;
            }
            searchCustomerByIdMenu();
        }
    }
}
