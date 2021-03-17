package Controllers;

import Commons.FuncWritingReading;
import Commons.Validation;
import Models.Customer;
import Models.Villa;

import java.util.*;

public class VillaManagement implements CRUDService<Villa> {
    Validation validation = new Validation();
    Scanner scanner = new Scanner(System.in);
    FuncWritingReading funcWritingReading = new FuncWritingReading();
    ServiceManagement serviceManagement = new ServiceManagement();

    @Override
    public List<Villa> read() {
        List<String[]> list = funcWritingReading.readFromFile("Villa.csv");
        List<Villa> villaList = new ArrayList<>();
        for (String[] villaInfo : list) {
            Villa villa = new Villa(villaInfo);
            villaList.add(villa);
        }
        return villaList;
    }

    @Override
    public void show() {
        List<Villa> villaList = read();
        int count = 1;
        for (Villa villa : villaList) {
            System.out.println(count + ".\t" + villa.showInfo());
            count++;
        }
    }

    public void showNotDuplicate() {
        List<String[]> list = funcWritingReading.readFromFile("Villa.csv");
        Set<Villa> villaTreeSet = new TreeSet<>();
        for (String[] villaInfo : list) {
            Villa villa = new Villa(villaInfo);
            villaTreeSet.add(villa);
        }
        int count = 1;
        for (Villa villa : villaTreeSet) {
            System.out.println(count + ".\t" + villa.showInfo());
            count++;
        }
    }

    @Override
    public void searchById() {
        List<Villa> villaList = read();
        String idServiceSearch = inputServiceId();
        for (Villa villa : villaList) {
            if (villa.getServiceId().equals(idServiceSearch)) {
                System.out.println("The villa information you want to search is: ");
                System.out.println(villa.showInfo());
                return;
            }
        }
        System.out.println("The id service not available");
    }

    @Override
    public List<Villa> create() {
        String serviceId = inputServiceId();
        List<String> list = serviceManagement.addProperties();
        list.add(0, serviceId);
        String roomStandard = serviceManagement.inputRoomStandard();
        list.add(roomStandard);
        String otherUtilities = serviceManagement.inputOtherUtilities();
        list.add(otherUtilities);
        String areaOfPool = serviceManagement.inputAreaOfPool();
        list.add(areaOfPool);
        String noOfFloors = serviceManagement.inputNoOfFloors();
        list.add(noOfFloors);
        String[] villaInfo = list.toArray(new String[0]);
        List<Villa> villaList = new ArrayList<>();
        Villa villa = new Villa(villaInfo);
        villaList.add(villa);
        return villaList;
    }

    @Override
    public void add() {
        List<Villa> villaList = create();
        funcWritingReading.writeToFile("Villa.csv", villaList, true);
    }

    public Villa choiceVilla() {
        System.out.println("Villa list");
        List<Villa> villaList = read();
        if (villaList.size() == 0) {
            System.out.println("Villa list is empty");
            return null;
        }
        show();
        int index = 0;
        while (true) {
            System.out.println("Choice a customer");
            try {
                index = Integer.parseInt(scanner.nextLine());
                if (index > 0 && index <= villaList.size()) {
                    return villaList.get(index - 1);
                } else {
                    System.out.println("You must to choice in list");
                }
            } catch (NumberFormatException e) {
                System.err.println("Please enter a integer number");
            }
        }
    }


    @Override
    public void update(Villa villa, String id) {

    }

    @Override
    public void delete(String id) {

    }

    public String inputServiceId() {
        do {
            System.out.println("Enter villa id");
            String id = scanner.nextLine();
            if (validation.validateIdVilla(id)) {
                return id;
            }
        } while (true);
    }

}
