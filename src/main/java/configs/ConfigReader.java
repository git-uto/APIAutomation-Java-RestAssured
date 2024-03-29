package configs;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConfigReader {
    private static final Logger logger = Logger.getLogger(ConfigReader.class.getName());
    private Properties properties;
    private static ConfigReader instance;
    public Properties initProp()
    {
        String filePath = "src/main/resources/config.properties";
        properties = new Properties();
        try(FileInputStream fileInputStream = new FileInputStream(filePath))
        {
            properties.load(fileInputStream);
        }
        catch (IOException ioException)
        {
            logger.log(Level.INFO, "Failed to load Configuration file!", ioException);
        }
        return properties;
    }
    public static ConfigReader getInstance()
    {
        if (instance==null)
        {
            instance = new ConfigReader();
            instance.initProp();
        }
        return instance;
    }
    public Properties getProperties ()
    {
        return properties;
    }


}
