package utils;

import configs.ConfigReader;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;

import java.util.Properties;

public class BaseClass {
    private Properties configProperties;
    private final ConfigReader configReader = ConfigReader.getInstance();

    public BaseClass() {
        this.configProperties = configReader.getProperties();
    }

    @BeforeMethod
    public void setUpEnvironment() {
        String baseUrl = configProperties.getProperty("baseUrl");
        RestAssured.baseURI = baseUrl;
    }
}
