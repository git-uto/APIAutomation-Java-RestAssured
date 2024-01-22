package configs;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EndPointReader {
    private static final Logger logger = Logger.getLogger(EndPointReader.class.getName());
    private Properties properties;
    private static EndPointReader instance;
    public Properties initProp()
    {
        String filePath ="src/main/resources/endpoint.properties";
        properties = new Properties();
        try(FileInputStream fileInputStream = new FileInputStream(filePath))
        {
            properties.load(fileInputStream);
        }
        catch (IOException ioException)
        {
            logger.log(Level.INFO, "Failed to load Configuration file", ioException);
        }
        return properties;
    }
    public static EndPointReader getInstance()
    {
        if (instance == null)
        {
            instance = new EndPointReader();
            instance.initProp();
        }
        return instance;
    }
    public Properties getProperties()
    {
        return  properties;
    }
}
