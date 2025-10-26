package ma.ac.esi.nutritrack.model;

/**
 * Représente un ingrédient avec un identifiant, un nom et un nombre de calories.
 * Fournit également une méthode pour obtenir dynamiquement le nom du fichier image associé à cet ingrédient.
 */
public class Ingredient {
    /** Identifiant unique de l'ingrédient. */
    private int id;
    /** Nom de l'ingrédient. */
    private String name;
    /** Nombre de calories de l'ingrédient. */
    private int calories;

    /**
     * Constructeur par défaut (nécessaire pour les frameworks et JSP).
     */
    public Ingredient() {
        // Constructeur vide requis pour l'instanciation par les frameworks ou JSP (JavaBean).
    }

    /**
     * Constructeur permettant de créer un ingrédient avec un nom et un nombre de calories.
     * L'identifiant n'est pas défini dans ce cas (il pourra être attribué plus tard).
     *
     * @param name Nom de l'ingrédient.
     * @param calories Nombre de calories de l'ingrédient.
     */
    public Ingredient(String name, int calories) {
        this.name = name;
        this.calories = calories;
    }

    /**
     * Constructeur complet permettant de créer un ingrédient avec un identifiant, un nom et un nombre de calories.
     *
     * @param id Identifiant unique de l'ingrédient.
     * @param name Nom de l'ingrédient.
     * @param calories Nombre de calories de l'ingrédient.
     */
    public Ingredient(int id, String name, int calories) {
        this.id = id;
        this.name = name;
        this.calories = calories;
    }

    /**
     * Retourne l'identifiant de l'ingrédient.
     *
     * @return id de l'ingrédient.
     */
    public int getId() {
        return id;
    }

    /**
     * Définit l'identifiant de l'ingrédient.
     *
     * @param id Identifiant unique de l'ingrédient.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retourne le nom de l'ingrédient.
     *
     * @return Nom de l'ingrédient.
     */
    public String getName() {
        return name;
    }

    /**
     * Définit le nom de l'ingrédient.
     *
     * @param name Nom de l'ingrédient.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retourne le nombre de calories de l'ingrédient.
     *
     * @return Nombre de calories de l'ingrédient.
     */
    public int getCalories() {
        return calories;
    }

    /**
     * Définit le nombre de calories de l'ingrédient.
     *
     * @param calories Nombre de calories de l'ingrédient.
     */
    public void setCalories(int calories) {
        this.calories = calories;
    }

    /**
     * Génère dynamiquement le nom de fichier de l'image associée à cet ingrédient.
     * Le nom du fichier image est basé sur le nom de l'ingrédient sans les espaces, suivi de l'extension ".jpg".
     * Par exemple, pour un ingrédient nommé "Pomme de terre", cette méthode retournera "Pommedeterre.jpg".
     *
     * @return Le nom de fichier image correspondant à l'ingrédient (nom sans espaces suivi de ".jpg").
     */
    public String getImageFileName() {
        if (name == null) {
            return null;
        }
        // Retirer tous les espaces du nom et ajouter l'extension .jpg
        return name.trim().replace(" ", "") + ".jpg";
    }
}

