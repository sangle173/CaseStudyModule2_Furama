package Controllers;

import Commons.FuncWritingReading;
import Models.Customer;

import java.util.*;

public class CinemaBookingManager {
    CustomerManagement customerManagement = new CustomerManagement();

    public void saleTicket() {
        ArrayDeque<Customer> customerQueue = new ArrayDeque<>();
        int noOfTicket = 5;
        while (true) {
            if (noOfTicket > 0) {
                System.out.println("Welcome to Furama 4D cinema booking. We have " + noOfTicket + " ticket");
                Customer customer = customerManagement.choiceCustomer();
                customerQueue.offer(customer);
                System.out.println("Thank you so much for booking");
            } else {
                System.out.println("Tickets are sold out");
                System.out.println("Please check your seating number in list blow");
                while (!customerQueue.isEmpty()) {
                    System.out.println("Seating number is: " + "00" + (noOfTicket++ + 1) + ".\t" + customerQueue.removeFirst().showInfo());
                }
                break;
            }
            noOfTicket--;
        }

    }
}

