package feudeforet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * Classe Config permettant donc de récupérer la configuration des statistiques de départ depuis un fichier .properties,
 * Si le fichier .properties n'existe pas, alors cela le créera avec des valeurs par défaut. 
 * L'utilisateur pourra ensuite lire, modifier, sauvegarder ce fichier
 * et la classe récupérera les valeurs sauvegardées dans le but de la simulation.
 * @author Camille LAVERIE
 * @version 1.0
 */
public class Config {
//ATTRIBUTS
    //Instanciation de la constante correspondant au chemin alt. vers le fichier de configuration.
    public static final String CONFIG_FILE_PATH = "./config.properties";

    //Instanciation des variables qui deviendront des valeurs par défaut si il n'y a pas de fichier existant.
    public static int height = 20;
    public static int width = 30;
    public static double probabilite = 0.2;

    private Config() {
    }

//METHODES
    
    /**
     * La Méthode open permet de charger les proprietes depuis le fichier config.properties,
     * elle converties les valeurs qui sont au format textes en valeurs correspondants aux attributs.
     */
    public static void open() {
        Properties properties = new Properties();
        try (InputStream input = Files.newInputStream(Paths.get(CONFIG_FILE_PATH))) {
            properties.load(input);
        } catch (IOException ignored) {
            save();
        }
        height = parseToInt(properties.getProperty("HEIGHT"), height);
        width = parseToInt(properties.getProperty("WIDTH"), width);
        probabilite = parseToDouble(properties.getProperty("PROBABILITE"), probabilite);
    }

    /**
     * La Méthode save permet elle de modifier et sauvegarder les valeurs (sauvegarde donc celles par défaut si nécessaire).
     */
    public static void save() {
        try (OutputStream ouput = Files.newOutputStream(Paths.get(CONFIG_FILE_PATH))) {
            Properties properties = new Properties();
            properties.setProperty("HEIGHT", String.valueOf(height));
            properties.setProperty("WIDTH", String.valueOf(width));
            properties.setProperty("PROBABILITE", String.valueOf(probabilite));
            properties.store(ouput, null);
        } catch (IOException ignored) {
        }

    }

    public static int parseToInt(String stringToParse, int defaultValue) {
        try {
            return Integer.parseInt(stringToParse);
        } catch (NumberFormatException ex) {
            return defaultValue;
        }
    }

    public static double parseToDouble(String stringToParse, double defaultValue) {
        try {
            return Double.parseDouble(stringToParse);
        } catch (NumberFormatException ex) {
            return defaultValue;
        }
    }

}
