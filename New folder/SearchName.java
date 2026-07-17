import java.util.Scanner;

public class SearchName {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] names = {
            "Somchai",
            "Somsak",
            "Suda",
            "Mana",
            "Mali"
        };

        System.out.print("Enter name to search: ");
        String searchName = input.nextLine();

        boolean found = false;

        for (String name : names) {
            if (name.equalsIgnoreCase(searchName)) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Found");
        } else {
            System.out.println("Not Found");
        }

        input.close();
    }
}
