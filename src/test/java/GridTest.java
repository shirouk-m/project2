import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class GridTest {
    @Test
    public void GridTest() throws MalformedURLException
    {
        DesiredCapabilities Cap = new DesiredCapabilities();
        Cap.setBrowserName("chrome");
        ChromeOptions options = new ChromeOptions();
        options.merge(Cap);
        String hubUrl = "http://192.168.1.8:4444/wd/hub";
        WebDriver driver = new RemoteWebDriver(new URL(hubUrl),options);

    }
}
