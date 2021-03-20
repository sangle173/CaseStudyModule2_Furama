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
        do {
            System.out.println("Enter the Villa Id");
            String idVilla = scanner.nextLine();
            for (Villa villa : villaList) {
                if (idVilla.equals(villa.getServiceId())) {
                    System.out.println("The villa information of Villa " + idVilla + " want to search is: ");
                    System.out.println(villa.showInfo());
                    return;
                }
            }
            System.out.println("The Id Villa not available");
        } while (true);
    }

    @Override
    public void add() {
        List<Villa> villaList;
        boolean exit = false;
        do {
            villaList = new ArrayList<>();
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
            Villa villa = new Villa(villaInfo);
            villaList.add(villa);
            funcWritingReading.writeToFile("Villa.csv", villaList, true);
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
    public void update() {
        List<Villa> villaList = read();
        do {
            System.out.println("Enter Villa id");
            String villaId = scanner.nextLine();
            for (int i = 0; i < villaList.size(); i++) {
                if (villaId.equals(villaList.get(i).getServiceId())) {
                    System.out.println("Please update the villa " + villaId + " with new information");
                    String serviceId = villaId;
                    List<String> listPropeties = serviceManagement.addProperties();
                    listPropeties.add(0, serviceId);
                    String roomStandard = serviceManagement.inputRoomStandard();
                    listPropeties.add(roomStandard);
                    String otherUtilities = serviceManagement.inputOtherUtilities();
                    listPropeties.add(otherUtilities);
                    String areaOfPool = serviceManagement.inputAreaOfPool();
                    listPropeties.add(areaOfPool);
                    String noOfFloors = serviceManagement.inputNoOfFloors();
                    listPropeties.add(noOfFloors);
                    String[] villaInfo = listPropeties.toArray(new String[0]);
                    Villa villa = new Villa(villaInfo);
                    villaList.set(i, villa);
                    funcWritingReading.writeToFile("Villa.csv", villaList, false);
                    System.out.println("Have been updated");
                    return;
                }
            }
            System.out.println("The Villa Id not available");
        } while (true);
    }

    @Override
    public void delete() {
        List<Villa> villaList = read();
        do {
            System.out.println("Enter Villa id");
            String villaId = scanner.nextLine();
            for (int i = 0; i < villaList.size(); i++) {
                if (villaId.equals(villaList.get(i).getServiceId())) {
                    villaList.remove(i);
                    funcWritingReading.writeToFile("Villa.csv", villaList, false);
                    System.out.println("Have been deleted");
                    return;
                }
            }
            System.out.println("The Villa Id not available");
        } while (true);
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
