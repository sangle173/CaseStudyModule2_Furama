package Controllers;

import Commons.FuncWritingReading;
import Models.Booking;
import Models.Customer;
import Models.Service;
import Models.Villa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookingManagement {
    CustomerManagement customerManagement = new CustomerManagement();
    FuncWritingReading funcWritingReading = new FuncWritingReading();
    Scanner scanner = new Scanner(System.in);

    public void add(Customer customer, Service service) {
        List<Booking> bookingList = new ArrayList<>();
        Booking booking = new Booking(customer, service);
        bookingList.add(booking);
        funcWritingReading.writeToFile("Booking.csv", bookingList, true);
    }

    public List<Booking> read() {
        List<String[]> list = funcWritingReading.readFromFile("Booking.csv");
        List<Booking> bookingList = new ArrayList<>();
        for (String[] bookingInfo : list) {
            Booking booking = new Booking(bookingInfo);
            bookingList.add(booking);
        }
        return bookingList;
    }

    public void show() {
        List<Booking> bookingList = read();
        int count = 1;
        for (Booking booking : bookingList) {
            System.out.println(count + ".\t" + booking.showBooking());
            count++;
        }
    }
}
