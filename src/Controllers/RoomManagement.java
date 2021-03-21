package Controllers;

import Commons.FuncWritingReading;
import Commons.Validation;
import Models.House;
import Models.Room;
import Models.Villa;

import java.util.*;

public class RoomManagement implements CRUDService<Room> {
    Validation validation = new Validation();
    Scanner scanner = new Scanner(System.in);
    FuncWritingReading funcWritingReading = new FuncWritingReading();
    ServiceManagement serviceManagement = new ServiceManagement();

    @Override
    public List<Room> read() {
        List<String[]> list = funcWritingReading.readFromFile("Room.csv");
        List<Room> roomList = new ArrayList<>();
        for (String[] roomInfo : list) {
            Room room = new Room(roomInfo);
            roomList.add(room);
        }
        return roomList;
    }

    @Override
    public void show() {
        List<Room> roomList = read();
        int count = 1;
        System.out.println("|OrderNo|**|ServiceID|**|ServiceName|**|UseArea|**|RentalPrice|**|MaxCustomer|**|RentalType|**|FreeService|");
        for (Room room : roomList) {
            System.out.println("\t" + count + "\t\t" + room.showInfo());
            count++;
        }
    }

    public void showNotDuplicate() {
        List<String[]> list = funcWritingReading.readFromFile("Room.csv");
        Set<Room> roomTreeSet = new TreeSet<>();
        for (String[] roomInfo : list) {
            Room villa = new Room(roomInfo);
            roomTreeSet.add(villa);
        }
        int count = 1;
        for (Room room : roomTreeSet) {
            System.out.println("|OrderNo|**|ServiceID|**|ServiceName|**|UseArea|**|RentalPrice|**|MaxCustomer|**|RentalType|**|FreeService|");
            System.out.println("\t" + count + "\t\t" + room.showInfo());
            count++;
        }
    }

    @Override
    public void searchById() {
        List<Room> roomList = read();
        do {
            System.out.println("Enter the Room Id");
            String idRoom = scanner.nextLine();
            for (Room room : roomList) {
                if (idRoom.equals(room.getServiceId())) {
                    System.out.println("The room information of Villa " + idRoom + " want to search is: ");
                    System.out.println(room.showInfo());
                    return;
                }
            }
            System.out.println("The Id Room not available");
        } while (true);
    }


    @Override
    public void add() {
        List<Room> roomList = new ArrayList<>();
        List<String> list = serviceManagement.addProperties();
        boolean exit = false;
        do {
            String serviceId = inputServiceId();
            list.add(0, serviceId);
            String freeService = serviceManagement.inputFreeService();
            list.add(freeService);
            String[] roomInfo = list.toArray(new String[list.size()]);
            Room room = new Room(roomInfo);
            roomList.add(room);
            System.out.println("Do you want to continue (Y/N)? User chooses Y to continues, if you chooses N, the program returns main screen\n" +
                    "and saved the all value to systems.");
            String choice = scanner.nextLine();
            if ("N".equals(choice)) {
                System.out.println("Exporting 10%..20%..30%..40%..50%..60%..70%..80%..90%..Done!");
                System.out.println("Villa have been add to systems");
                exit = true;
            } else if ("Y".equals(choice)) {
                exit = false;
            }
        } while (!exit);
        funcWritingReading.writeToFile("Room.csv", roomList, true);
    }

    public Room choiceRoom() {
        System.out.println("Room list");
        List<Room> roomList = read();
        if (roomList.size() == 0) {
            System.out.println("Room list is empty");
            return null;
        }
        show();
        int index = 0;
        while (true) {
            System.out.println("Choice a customer");
            try {
                index = Integer.parseInt(scanner.nextLine());
                if (index > 0 && index <= roomList.size()) {
                    return roomList.get(index - 1);
                } else {
                    System.out.println("You must to choice in list");
                }
            } catch (NumberFormatException e) {
                System.err.println("Please enter a integer number");
            }
        }
    }

    @Override
    public void update() {
        List<Room> roomList = read();
        do {
            System.out.println("Enter Room id");
            String roomId = scanner.nextLine();
            for (int i = 0; i < roomList.size(); i++) {
                if (roomId.equals(roomList.get(i).getServiceId())) {
                    System.out.println("Please update the room " + roomId + " with new information");
                    String serviceId = roomId;
                    List<String> listPropeties = serviceManagement.addProperties();
                    listPropeties.add(0, serviceId);
                    String freeService = serviceManagement.inputFreeService();
                    listPropeties.add(freeService);
                    String[] roomInfo = listPropeties.toArray(new String[0]);
                    Room room = new Room(roomInfo);
                    roomList.set(i, room);
                    funcWritingReading.writeToFile("Room.csv", roomList, false);
                    System.out.println("Have been updated");
                    return;
                }
            }
            System.out.println("The Room Id not available");
        } while (true);
    }

    @Override
    public void delete() {
        List<Room> roomList = read();
        do {
            System.out.println("Enter Room id");
            String roomId = scanner.nextLine();
            for (int i = 0; i < roomList.size(); i++) {
                if (roomId.equals(roomList.get(i).getServiceId())) {
                    roomList.remove(i);
                    funcWritingReading.writeToFile("Room.csv", roomList, false);
                    System.out.println("Have been deleted");
                    return;
                }
            }
            System.out.println("The Room Id not available");
        } while (true);
    }

    public String inputServiceId() {
        do {
            System.out.println("Enter room id");
            String id = scanner.nextLine();
            if (validation.validateIdRoom(id)) {
                return id;
            }
        } while (true);
    }
}
