package Commons;

public class Standardized {
    public String standardizedDate(String string) {
        string = string.trim();
        string = string.replaceAll("\\s+", " ");
        String temp[] = string.split(" ");
        string = "";
        for (int i = 0; i < temp.length; i++) {
            string += String.valueOf(temp[i].charAt(0)).toUpperCase() + temp[i].substring(1);
            if (i < temp.length - 1) {
                string += " ";
            }
        }
        return string;
    }

    public static void main(String[] args) {
        String str = "    nguyen     van     quan   7826    ";
        Standardized standardized = new Standardized();
        str = standardized.standardizedDate(str);
        System.out.println(str);
    }
}
