import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.IOException;


public class Testing {
    WebDriver driver;
    LoginPage login;
    VictimSpam victim;
    DataProperties DataP;
    TakingScreenShot Tscreenshot;
    ReadingFromExcel excelData;
    CrossBrower crossBr;

    @Test
    public void test() throws IOException {
       // System.out.println("uuuuyyyyykkkkkk");
        DataP = new DataProperties(driver);
        excelData = new ReadingFromExcel(driver);
        crossBr = new CrossBrower(driver);
        String BrPath = DataP.Reading("ChromePath");
        WebDriver  driver = crossBr.SetUpCrossBrowser("chrome",BrPath);
        login = new LoginPage(driver);
        login.NavigateToFaceBook(DataP.Reading("FaceBookUrl"));
        String mail = DataP.Reading("email");
        login.EnterUserName(mail);
        String pass = DataP.Reading("password");
        login.EnterPassWord(pass);
        Tscreenshot = new TakingScreenShot(driver);
        Tscreenshot.captureScreenShot();
     /*   login.ClickOnLogin();
        victim = new VictimSpam(driver);
        String VictimUrl =  excelData.ReadingExcel(1,0);
        victim.GoToVictimUrl(VictimUrl);
        login.EnterUserName(mail);
        login.EnterPassWord(pass);
        victim.AnotherLoginButton();
        String SpamMessage =  excelData.ReadingExcel(0,0);
        victim.SendaSpam(SpamMessage);*/
        driver.quit();

    }

}
