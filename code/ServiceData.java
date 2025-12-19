import java.util.*;

public class ServiceData {
    /** The scanner of servicedata */
    Scanner m_scanner = new Scanner(System.in);

    /** Set of all labels that have been set by the user at runtime */
    HashSet<Label> m_labels = new HashSet<>();

    /** Map between Integer and Label for menu */
    HashMap<Integer, Label> m_menu = new HashMap<>();

    /** Searches the ingredient based on a given alias. Assume that the name is spelled correctly */
    void searchForIngredient() {
        System.out.println("Current Labels: " + m_labels);
        System.out.print("Enter the name of the ingredient: ");
        String alias = m_scanner.next();
        boolean found = false;
        for (Ingredient i : Ingredient.values())
        {
            if (i.m_aliases.contains(alias))
            {
                /* the right side condition evaluates to true, if the two sets are not disjoint */
                if (m_labels.isEmpty() || !Collections.disjoint(m_labels, i.m_labels)) {
                    if (!found)
                    {
                        System.out.println("Found the following ingredients:\n " + i.m_name);
                    } else
                    {
                        System.out.println(i.m_name);
                    }
                    found = true;
                }

            }
        }
        if (!found)
        {
            System.out.println("This ingredient does not exist.");
        }
    }

    /** Searches the meal based on a given alias. Assume that the name is spelled correctly */
    void searchForMeal() {
        System.out.println("Current Labels: " + m_labels);
        System.out.print("Enter the name of the meal: ");
        String alias = m_scanner.next();
        boolean found = false;
        for (Meal m : Meal.values())
        {
            if (m.m_aliases.contains(alias))
            {
                if (m_labels.isEmpty() || !Collections.disjoint(m_labels, m.m_labels)) {
                    if (!found)
                    {
                        System.out.println("Found the following meals:\n " + m.m_name);
                    } else
                    {
                        System.out.println(m.m_name);
                    }
                    found = true;
                }
            }
            if (!found)
            {
                System.out.println("This meal does not exist.");
            }
        }
    }

    /** Add label to search*/
    void adjustLabel() {
        System.out.println("Current labels: ");
        for (Label l : m_labels) {
            System.out.println(l.m_name);
        }
        System.out.println("What label do you want to add?");
        for (int i : m_menu.keySet()) {
            System.out.println(i + ". " + m_menu.get(i).m_name);
        }
        System.out.println(m_menu.size() + ". Quit");
        boolean loop = true;
        while (loop) {
            int input = m_scanner.nextInt();
            if (m_menu.containsKey(input)) {
                m_labels.add(m_menu.get(input));
                System.out.println("Added label " + m_menu.get(input).m_name.toUpperCase() + " to search");
                loop = false;
            }
            else if (input == m_menu.size()){
                loop = false;
            } else {
                System.out.println("Invalid input. Try again.");
            }
        }
    }

    /** Function to display all ingredients based on current labels */
    void displayIngredients(){
        if (!m_labels.isEmpty())
        {
            System.out.println("These are all ingredients that match the labels " + m_labels);
            for (Ingredient i : Ingredient.values()) {
                if (!Collections.disjoint(m_labels, i.m_labels)) {
                    System.out.println(i.m_name);
                }
            }
        } else {
            System.out.println("These are all ingredients");
            for (Ingredient i : Ingredient.values()) {
                System.out.println(i.m_name);
            }
        }
    }

    /** Function to display all meals based on current labels */
    void displayMeals(){
        if (!m_labels.isEmpty())
        {
            System.out.println("These are all meals that match the labels " + m_labels);
            for (Meal m : Meal.values()) {
                if (!Collections.disjoint(m_labels, m.m_labels)) {
                    System.out.println(m.m_name);
                }
            }
        } else {
            System.out.println("These are all meals");
            for (Meal m : Meal.values()) {
                System.out.println(m.m_name);
            }
        }
    }

    ServiceData(Scanner p_scanner) {
        m_scanner = p_scanner;
        int i = 0;
        for (Label l : Label.values()) {
            m_menu.put(i, l);
            i++;
        }
    }
}
