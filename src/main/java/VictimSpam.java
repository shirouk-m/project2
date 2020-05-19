import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.Keys.ENTER;

public class VictimSpam {
    WebDriver driver;
    public VictimSpam(WebDriver driver)
    {
        this.driver=driver;
    }
    public void GoToVictimUrl(String Victimurl)
    {
        driver.get(Victimurl);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(70L, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(3L, TimeUnit.SECONDS);
    }
    public void AnotherLoginButton()
    {
        WebElement AnotherButton =  driver.findElement(By.xpath("//button[@id=\"loginbutton\"]"));
        AnotherButton.click();
        driver.manage().timeouts().pageLoadTimeout(50L, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(3L, TimeUnit.SECONDS);
    }
    public void SendaSpam(String Spam)
    {
        for(int i=1; i<10; i++)
        {
            WebElement textmsg = driver.findElement(By.xpath("//div[@class=\"_1mf _1mj\"]"));
            driver.manage().timeouts().pageLoadTimeout(20L, TimeUnit.SECONDS);
            driver.manage().timeouts().setScriptTimeout(3L, TimeUnit.SECONDS);
            textmsg.sendKeys(Spam, ENTER);
        }

    }
}
