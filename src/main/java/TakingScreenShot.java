import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class TakingScreenShot {
    WebDriver driver;
    public TakingScreenShot(WebDriver driver)
    {
        this.driver=driver;
    }
    public void captureScreenShot() throws IOException {

        //taking screen
        TakesScreenshot camera = (TakesScreenshot)driver;
        File screenshoot = camera.getScreenshotAs(OutputType.FILE);
        Files.move(screenshoot , new File("C:\\Users\\lenovo\\MyFrameWork\\src\\main\\resources\\ScreenShots\\test1.png"));
    }
}
