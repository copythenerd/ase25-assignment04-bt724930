import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public enum Ingredient {

    DOUGH(
            "dough",
            new HashSet<>(Arrays.asList("base", "crust")),
            new HashSet<>(List.of(Label.VEGAN))
    ),

    TOMATO_SAUCE(
    "tomato-sauce",
            new HashSet<>(List.of("red-sauce")),
            new HashSet<>(List.of(Label.VEGAN, Label.GLUTEN_FREE))
            ),

    MOZZARELLA(
    "mozzarella",
            new HashSet<>(List.of("pizza-cheese", "cheese")),
            new HashSet<>(List.of(Label.BIO))
            ),

    BASIL(
    "basil",
            new HashSet<>(List.of("herbs")),
            new HashSet<>(List.of(Label.VEGAN, Label.BIO, Label.GLUTEN_FREE))
            ),

    PATTY(
    "patty",
            new HashSet<>(List.of("burger-patty")),
            new HashSet<>(List.of(Label.VEGAN))
            ),

    CHEDDAR(
    "cheddar-cheese",
            new HashSet<>(List.of("yellow-cheese", "cheddar")),
            new HashSet<>(List.of(Label.VEGAN))
            ),

    BUN(
    "burger-bun",
            new HashSet<>(List.of("sandwich-bun", "bun")),
            new HashSet<>(List.of(Label.VEGAN))
            ),

    SPAGHETTI(
    "spaghetti",
            new HashSet<>(List.of("noodles", "pasta")),
            new HashSet<>(List.of(Label.VEGAN))
            ),

    BEEF(
    "beef",
            new HashSet<>(Arrays.asList("minced-beef", "ground-beef")),
            new HashSet<>(List.of(Label.BIO))
            ),

    PASSATA(
    "passata",
            new HashSet<>(List.of("red sauce")),
            new HashSet<>(List.of(Label.VEGAN))
            );

    /* ################################### */
    /* Here other ingredients can be defined */
    /* ################################### */

    /** A string representation of the ingredient name. The "primary name" of the ingredient*/
    String m_name;
    /** The aliases under which the ingredient is known */
    HashSet<String> m_aliases;

    /** The labels of the ingredient (e.g. vegan, vegetarian, etc.) */
    HashSet<Label> m_labels;

    Ingredient(String p_name, HashSet<String> p_aliases, HashSet<Label> p_labels){
        m_name = p_name;
        m_aliases = p_aliases;
        /* Add the name of the enum if it is not present in the alias set */
        m_aliases.add(p_name);

        m_labels = p_labels;
    }

}
