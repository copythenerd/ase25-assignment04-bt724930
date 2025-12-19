import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class SmartCater {
    ServiceData m_serviceData = new ServiceData(new Scanner(System.in));

    static void main() {
        SmartCater smartCater = new SmartCater();
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        /* Set of Labels that can be set at runtime */
        HashSet<Label> m_label;
        while (loop) {
            System.out.println("######### Catering Service #########\nWhat would you like to do?\n1. Search for ingredients\n2. Search for meals\n3. Set Label\n4. Show all ingredients\n5. Show all meals\n6. Quit");
            System.out.print("Enter a number: ");
            int input = scanner.nextInt();
            switch (input) {
                case 1 -> {
                    smartCater.m_serviceData.searchForIngredient();
                break;
                }
                case 2 -> smartCater.m_serviceData.searchForMeal();
                case 3 -> smartCater.m_serviceData.adjustLabel();
                case 4 -> smartCater.m_serviceData.displayIngredients();
                case 5 -> smartCater.m_serviceData.displayMeals();
                case 6 -> {
                    loop = false;
                    System.out.println("Bye.");
                }
                default -> {
                    System.out.println("Invalid input. Try again.\n");
                }
            }
        }
    }
}
