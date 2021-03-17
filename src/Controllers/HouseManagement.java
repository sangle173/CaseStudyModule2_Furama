package Controllers;

import Commons.FuncWritingReading;
import Commons.Validation;
import Models.House;
import Models.Villa;

import java.util.*;

public class HouseManagement implements CRUDService<House> {
    Validation validation = new Validation();
    Scanner scanner = new Scanner(System.in);
    FuncWritingReading funcWritingReading = new FuncWritingReading();
    ServiceManagement serviceManagement = new ServiceManagement();

    @Override
    public List<House> read() {
        List<String[]> list = funcWritingReading.readFromFile("House.csv");
        List<House> houseList = new ArrayList<>();
        for (String[] houseInfo : list) {
            House house = new House(houseInfo);
            houseList.add(house);
        }
        return houseList;
    }

    @Override
    public void show() {
        List<House> houseList = read();
        int count = 1;
        for (House house : houseList) {
            System.out.println(count + ".\t" + house.showInfo());
            count++;
        }
    }

    public void showNotDuplicate() {
        List<String[]> list = funcWritingReading.readFromFile("House.csv");
        Set<House> houseTreeSet = new TreeSet<>();
        for (String[] houseInfo : list) {
            House house = new House(houseInfo);
            houseTreeSet.add(house);
        }
        int count = 1;
        for (House house : houseTreeSet) {
            System.out.println(count + ".\t" + house.showInfo());
            count++;
        }
    }

    @Override
    public void searchById() {
        List<House> houseList = read();
        do {
            System.out.println("Enter the House Id");
            String idHouse = scanner.nextLine();
            for (House house : houseList) {
                if (idHouse.equals(house.getServiceId())) {
                    System.out.println("The room information of Villa " + idHouse + " want to search is: ");
                    System.out.println(house.showInfo());
                    return;
                }
            }
            System.out.println("The Id House not available");
        } while (true);
    }


    @Override
    public List<House> create() {
        String serviceId = inputServiceId();
        List<String> list = serviceManagement.addProperties();
        list.add(0, serviceId);
        String roomStandard = serviceManagement.inputRoomStandard();
        list.add(roomStandard);
        String otherUtilities = serviceManagement.inputOtherUtilities();
        list.add(otherUtilities);
        String noOfFloors = serviceManagement.inputNoOfFloors();
        list.add(noOfFloors);
        String[] houseInfo = list.toArray(new String[0]);
        List<House> houseList = new ArrayList<>();
        House house = new House(houseInfo);
        houseList.add(house);
        return houseList;
    }

    @Override
    public void add() {
        List<House> houseList = create();
        funcWritingReading.writeToFile("House.csv", houseList, true);
    }

    public House choicehouse() {
        System.out.println("House list");
        List<House> houseList = read();
        if (houseList.size() == 0) {
            System.out.println("House list is empty");
            return null;
        }
        show();
        int index = 0;
        while (true) {
            System.out.println("Choice a customer");
            try {
                index = Integer.parseInt(scanner.nextLine());
                if (index > 0 && index <= houseList.size()) {
                    return houseList.get(index - 1);
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
        List<House> houseList = read();
        do {
            System.out.println("Enter House id");
            String houseId = scanner.nextLine();
            for (int i = 0; i < houseList.size(); i++) {
                if (houseId.equals(houseList.get(i).getServiceId())) {
                    System.out.println("Please update the house " + houseId + " with new information");
                    String serviceId = houseId;
                    List<String> listPropeties = serviceManagement.addProperties();
                    listPropeties.add(0, serviceId);
                    String roomStandard = serviceManagement.inputRoomStandard();
                    listPropeties.add(roomStandard);
                    String otherUtilities = serviceManagement.inputOtherUtilities();
                    listPropeties.add(otherUtilities);
                    String noOfFloors = serviceManagement.inputNoOfFloors();
                    listPropeties.add(noOfFloors);
                    String[] houseInfo = listPropeties.toArray(new String[0]);
                    House house = new House(houseInfo);
                    houseList.set(i, house);
                    funcWritingReading.writeToFile("House.csv", houseList, false);
                    System.out.println("Have been updated");
                    return;
                }
            }
            System.out.println("The House Id not available");
        } while (true);
    }

    @Override
    public void delete() {
        List<House> houseList = read();
        do {
            System.out.println("Enter House id");
            String houseId = scanner.nextLine();
            for (int i = 0; i < houseList.size(); i++) {
                if (houseId.equals(houseList.get(i).getServiceId())) {
                    houseList.remove(i);
                    funcWritingReading.writeToFile("Villa.csv", houseList, false);
                    System.out.println("Have been deleted");
                    return;
                }
            }
            System.out.println("The House Id not available");
        } while (true);
    }

    public String inputServiceId() {
        do {
            System.out.println("Enter house id");
            String id = scanner.nextLine();
            if (validation.validateIdHouse(id)) {
                return id;
            }
        } while (true);
    }

}
