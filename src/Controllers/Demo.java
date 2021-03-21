package Controllers;

import java.util.Scanner;

public class Demo {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choose;
        do {
            choose=getChoice();
            switch (choose) {
                case 1:
                    System.out.println("A");
                    break;
                case 2:
                    System.out.println("A");
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter an number");
            }
        } while (true);
    }

    public static int getChoice() {
        int choice = 0;
        while (true) {
            try {
                System.out.println("Enter your choice");
                choice = Integer.parseInt(scanner.nextLine());
                if (choice>=0){
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("The choice must to a number");
            }
        }
        return choice;
    }
}
