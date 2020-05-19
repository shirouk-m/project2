import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DataProperties {
    WebDriver driver;
    public DataProperties(WebDriver driver)
    {
        this.driver=driver;
    }
    public String Reading(String x)
    {
        //to read from properties file (email and password)
        File file = new File("C:\\Users\\lenovo\\MyFrameWork\\src\\main\\resources\\data.Properties");
        Properties prop = new Properties();
        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //load properties file
        try {
            prop.load(fileInput);
        } catch (IOException e) {
            e.printStackTrace();
        }

       String y = prop.getProperty(x);
        return y ;

    }

}
