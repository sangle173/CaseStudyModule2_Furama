package Commons;

import Controllers.HouseManagement;
import Controllers.RoomManagement;
import Controllers.VillaManagement;
import Models.House;
import Models.Room;
import Models.Villa;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    private static final String ID_VILLA_REGEX = "^SVVL-\\d{4}$";
    private static final String ID_HOUSE_REGEX = "^SVHO-\\d{4}$";
    private static final String ID_ROOM_REGEX = "^SVRO-\\d{4}$";
    private static final String TEXT_REGEX = "^[A-Z][a-z]*(\\s[A-Z][a-z]*)*$";
    private static final String FREE_SERVICE_REGEX = "^(massage|karaoke|food|drink|car)$";
    private static final String BIRTHDAY_REGEX = "^(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)$";
    private static final String GENDER_REGEX = "^(male|female|unknown)$";
    private static final String ID_CARD_REGEX = "^[0-9]{3}[0-9]{3}[0-9]{3}$";
    private static final String PHONE_REGEX = "^0{1}[0-9]{9}$";
    //    private static final String EMAIL_REGEX = "^[a-z][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$";
    private static final String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public boolean validateIdVilla(String id) {
        try {
            if (Pattern.matches(ID_VILLA_REGEX, id)) {
                List<Villa> villaList = new VillaManagement().read();
                for (Villa villa : villaList) {
                    if (id.equals(villa.getServiceId())) {
                        throw new Exception("Id service is available, you must to input other Id");
                    }
                }
                return true;
            }
            throw new Exception("Id service must be SVVL-YYYY with X is a number 0 to 9");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean validateIdHouse(String id) {
        try {
            if (Pattern.matches(ID_HOUSE_REGEX, id)) {
                List<Room> roomList = new RoomManagement().read();
                for (Room room : roomList) {
                    if (room.getServiceId().equals(id)) {
                        throw new Exception("Id service is available");
                    }
                }
                return true;
            }
            throw new Exception("Id service must be SVHO-YYYY with X is a number 0 to 9");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean validateIdRoom(String id) {
        try {
            if (Pattern.matches(ID_ROOM_REGEX, id)) {
                List<House> houseList = new HouseManagement().read();
                for (House house : houseList) {
                    if (house.getServiceId().equals(id)) {
                        throw new Exception("Id service is available");
                    }
                }
                return true;
            }
            throw new Exception("Id service must be SVRO-YYYY with X is a number 0 to 9");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean validateText(String text) {
        try {
            if (Pattern.matches(TEXT_REGEX, text)) {
                return true;
            }
            throw new Exception("The text must be capitalized first letter of each word");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean validateAreaUsingAndPool(String area) {
        try {
            if (Double.parseDouble(area) > 30) {
                return true;
            }
            throw new Exception("The value must be larger than 30");
        } catch (NumberFormatException e) {
            System.out.println("The value must be a number");
            return false;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean validateRentalPrice(String rentalPrice) {
        try {
            if (Double.parseDouble(rentalPrice) > 0) {
                return true;
            }
            throw new Exception("The rental price must be greater than 0");
        } catch (NumberFormatException e) {
            System.out.println("The rental price must be a number");
            return false;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean validateMaxOfCustomer(String maxOfCustomer) {
        try {
            int num = Integer.parseInt(maxOfCustomer);
            if (num > 0 && num < 20) {
                return true;
            }
            throw new Exception("Max of customer must be a positive integer within greater than 0 and less than 20");
        } catch (NumberFormatException e) {
            System.out.println("Max of customer must be an integer");
            return false;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean validateNoOfFloors(String noOfFloors) {
        try {
            int num = Integer.parseInt(noOfFloors);
            if (num > 0) {
                return true;
            }
            throw new Exception("No of floors must be a positive greater than 0");
        } catch (NumberFormatException e) {
            System.out.println("No of floors must be an integer");
            return false;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean validateFreeService(String freeService) {
        try {
            if (Pattern.matches(FREE_SERVICE_REGEX, freeService)) {
                return true;
            }
            throw new Exception("The free service need to be in list");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean nameException(String name) throws NameException {
        try {
            if (Pattern.matches(TEXT_REGEX, name)) {
                return true;
            }
            throw new NameException(" the text must be capitalized first letter of each word", "CustomerManagement");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    public boolean validateCustomerBirthday(String date) throws BirthdayException {
        Pattern pattern = Pattern.compile(BIRTHDAY_REGEX);
        Matcher matcher = pattern.matcher(date);
        try {
            if (matcher.matches()) {
                matcher.reset();
                if (matcher.find()) {
                    String day = matcher.group(1);
                    String month = matcher.group(2);
                    int year = Integer.parseInt(matcher.group(3));
                    if (year < 1900 || year > 2003) {
                        throw new BirthdayException("The year must to from 1900 to 2003", "CustomerManagement");
                    }
                    if (day.equals("31") && (month.equals("4") || month.equals("6") || month.equals("9") || month.equals("11") || month.equals("04") || month.equals("06") || month.equals("09"))) {
//                    System.out.println("only 1,3,5,7,8,10,12 has 31 days");
                        throw new BirthdayException("only 1,3,5,7,8,10,12 has 31 days", "CustomerManagement");
                    } else if (month.equals("2") || month.equals("02")) {
                        //leap year
                        if (year % 4 == 0) {

                            if (day.equals("30") || day.equals("31")) {
                                throw new BirthdayException("February just has 29 or 28 day/per month", "CustomerManagement");
                            } else {
                                return true;
                            }
                        } else if (day.equals("29") || day.equals("30") || day.equals("31")) {
                            throw new BirthdayException("The year " + year + " not a leap year so February just has 28/per month", "CustomerManagement");
                        } else {
                            return true;
                        }
                    } else {
                        return true;
                    }
                } else {
                    throw new BirthdayException("Birthday must to be same format dd/MM/yyyy", "CustomerManagement");
                }
            } else {
                throw new BirthdayException("Birthday must to be same format dd/MM/yyyy with dd from 1-31, MM from 1-12, yyyy form 1900- 2003", "CustomerManagement");
            }
        } catch (BirthdayException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    public boolean validateCustomerGender(String customerGender) throws GenderException {
        try {
            if (Pattern.matches(GENDER_REGEX, customerGender)) {
                return true;
            }
            throw new GenderException("The gender of customer need to be in list 'male ,female or unknown'", " CustomerManagement");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    public boolean validateCustomerIdCard(String idCustomer) throws IdCardException {
        try {
            if (Pattern.matches(ID_CARD_REGEX, idCustomer)) {
                return true;
            }
            throw new IdCardException("The id card must to be XXXXXXXXX", " CustomerManagement");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    public boolean validateCustomerPhone(String customerPhone) {
        try {
            if (Pattern.matches(PHONE_REGEX, customerPhone)) {
                return true;
            }
            throw new Exception("The phone number must to be 0XXXXXXXXX");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    public boolean validateCustomerEmail(String customerEmail) throws EmailException {
        try {
            if (Pattern.matches(EMAIL_REGEX, customerEmail)) {
                return true;
            }
            throw new EmailException("The email format must to be 'abc@abc.abc'", " CustomerManagement");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

}
