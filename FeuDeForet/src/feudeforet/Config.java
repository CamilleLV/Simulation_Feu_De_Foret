
package feudeforet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

/**
 *
 * @author Camille LAVERIE
 */
public class Config {

    public static final String CONFIG_FILE_PATH = "./config.properties";

    public static int height = 20;
    public static int width = 30;
    public static double probabilite = 0.2;

    

    private Config() {}

    public static void open() {
        Properties properties = new Properties();
        try (InputStream input = Files.newInputStream(Paths.get(CONFIG_FILE_PATH))) { properties.load(input); }
        catch (IOException ignored) { save(); }
        height = parseToInt(properties.getProperty("HEIGHT"),height);
        width = parseToInt(properties.getProperty("WIDTH"),width);
        probabilite = parseToDouble(properties.getProperty("PROBABILITE"),probabilite);
    }

    public static void save() {
        try (OutputStream ouput = Files.newOutputStream(Paths.get(CONFIG_FILE_PATH))) {
            Properties properties = new Properties();
            properties.setProperty("HEIGHT", String.valueOf(height));
            properties.setProperty("WIDTH", String.valueOf(width));
            properties.setProperty("PROBABILITE", String.valueOf(probabilite));
            properties.store(ouput, null);
        }
        catch (IOException ignored) {}

    }

    public static int parseToInt(String stringToParse, int defaultValue) {
        try { return Integer.parseInt(stringToParse); }
        catch(NumberFormatException ex) { return defaultValue; }
    }
    
    public static double parseToDouble(String stringToParse, double defaultValue) {
        try { return Double.parseDouble(stringToParse); }
        catch(NumberFormatException ex) { return defaultValue; }
    }

}
