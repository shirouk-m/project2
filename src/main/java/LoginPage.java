import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class LoginPage {
WebDriver driver;


public LoginPage(WebDriver driver)
{
    this.driver=driver;
}
  public void NavigateToFaceBook(String FaceBookUrl)
    {
        driver.get(FaceBookUrl);
    }
    public void EnterUserName(String Username)
    {
        WebElement Email = driver.findElement(By.xpath("//input[@id=\"email\"]")) ;
        Email.sendKeys(Username);
    }
    public void EnterPassWord(String Pass)
    {
        WebElement enterpassword = driver.findElement(By.xpath("//input[@id=\"pass\"]"));
        enterpassword.sendKeys(Pass);
        driver.manage().timeouts().pageLoadTimeout(10L, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(3L, TimeUnit.SECONDS);

    }
    public void ClickOnLogin()
    {
        WebElement loginbutton =driver.findElement(By.xpath("//input[@id=\"u_0_b\"]"));;
        loginbutton.click();

        driver.manage().timeouts().pageLoadTimeout(50L, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(3L, TimeUnit.SECONDS);

    }

}
