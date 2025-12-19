import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public enum Meal {
    MARGARITA(
            "magarita",
            new HashSet<>(Arrays.asList("classic-pizza", "default-pizza", "pizza")),
            new HashSet<>(Arrays.asList(Ingredient.DOUGH, Ingredient.TOMATO_SAUCE, Ingredient.MOZZARELLA, Ingredient.BASIL))),

    BURGER(
            "burger",
            new HashSet<>(Arrays.asList("cheese-burger")),
            new HashSet<>(Arrays.asList(Ingredient.PATTY, Ingredient.CHEDDAR, Ingredient.MOZZARELLA, Ingredient.BUN))),

    SPAGHETTI_BOLOGNESE(
            "spaghetti bolognese",
            new HashSet<>(Arrays.asList("bolognese", "spaghetti", "noodles", "pasta")),
            new HashSet<>(Arrays.asList(Ingredient.SPAGHETTI, Ingredient.BEEF, Ingredient.TOMATO_SAUCE)));

    /* ################################### */
    /* Here other meals can be defined */
    /* ################################### */

    /** A string representation of the meal name. The "primary name" of the meal*/
    String m_name;
    /** The aliases under which the meal is known */
    HashSet<String> m_aliases;

    /** The ingredients of the meal */
    HashSet<Ingredient> m_ingredients;

    /** The labels of the ingredient (e.g. vegan, vegetarian, etc.) */
    HashSet<Label> m_labels;

    Meal(String p_name, HashSet<String> p_aliases, HashSet<Ingredient> p_ingredients) {
        m_name = p_name;
        m_aliases = p_aliases;
        /* Add the name of the enum if it is not present in the alias set */
        m_aliases.add(p_name);
        m_ingredients = p_ingredients;
        m_labels = new HashSet<>();
        /* Set labels based on ingredient labels */
        for (Ingredient i: m_ingredients) {
            if (!i.m_labels.isEmpty()) {
                m_labels.addAll(i.m_labels);
            }
        }
    }
}
