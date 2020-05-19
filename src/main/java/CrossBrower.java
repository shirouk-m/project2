import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

public class CrossBrower {
    WebDriver driver;
    public CrossBrower(WebDriver driver)
    {
        this.driver=driver;
    }
    public WebDriver SetUpCrossBrowser(String BrowserName ,String BrowserExePath)
    {

        if(BrowserName.equalsIgnoreCase("firefox"))
        {

            System.setProperty("webdriver.gecko.driver", BrowserExePath);
            driver= new FirefoxDriver();
            System.out.println("FF is opened");

        }
        else if(BrowserName.equalsIgnoreCase("chrome"))
        {
            System.setProperty("webdriver.chrome.driver", BrowserExePath);
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            driver = new ChromeDriver(options);
            System.out.println("chrome is opened");
        }
        else if(BrowserName.equalsIgnoreCase("IE")) {

            System.setProperty("webdriver.ie.driver", BrowserExePath);
            driver = new InternetExplorerDriver();
        }
        else if (BrowserName.equalsIgnoreCase("chrome-headless"))
        {
            System.setProperty("webdriver.chrome.driver", BrowserExePath);
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            options.addArguments("--headless");
            options.addArguments("--window-size=1920,1080");
            driver = new ChromeDriver(options);
            System.out.println("chrome-headless is running");

        }
        else if (BrowserName.equalsIgnoreCase("headless"))
        {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setJavascriptEnabled(true);
            caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
                    System.getProperty(BrowserExePath));
            String[] PhantomJsArgs = {"--web-security=no","--ignore-ssl-errors=yes"};
            caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS,PhantomJsArgs);
            driver = new PhantomJSDriver(caps);
        }
         return driver;
    }
}
