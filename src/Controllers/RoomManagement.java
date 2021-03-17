package Controllers;

import Commons.FuncWritingReading;
import Commons.Validation;
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
        for (Room room : roomList) {
            System.out.println(count + ".\t" + room.showInfo());
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
            System.out.println(count + ".\t" + room.showInfo());
            count++;
        }
    }

    @Override
    public void searchById() {
        List<Room> roomList = read();
        String idServiceSearch = inputServiceId();
        for (Room room : roomList) {
            if (room.getServiceId().equals(idServiceSearch)) {
                System.out.println("The room information you want to search is: ");
                System.out.println(room.showInfo());
                return;
            }
        }
        System.out.println("The id service not available");
    }

    @Override
    public List<Room> create() {
        String serviceId = inputServiceId();
        List<String> list = serviceManagement.addProperties();
        list.add(0, serviceId);
        String freeService = serviceManagement.inputFreeService();
        list.add(freeService);
        String[] roomInfo = list.toArray(new String[0]);
        List<Room> roomList = new ArrayList<>();
        Room room = new Room(roomInfo);
        roomList.add(room);
        return roomList;
    }

    @Override
    public void add() {
        List<Room> roomList = create();
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
    public void update(Room room, String id) {

    }

    @Override
    public void delete(String id) {

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
