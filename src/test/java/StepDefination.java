import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class StepDefination extends CrossBrower {
    public StepDefination(WebDriver driver) {
        super(driver);
    }
   // WebDriver driver;
    LoginPage login;
    VictimSpam victim;
    DataProperties DataP;
    TakingScreenShot Tscreenshot;
    ReadingFromExcel excelData;

    @Given("Open a Browser And Navigate To FaceBookPage")
    public void open_a_Browser_And_Navigate_To_FaceBookPage() {
        DataP = new DataProperties(driver);
        excelData = new ReadingFromExcel(driver);
        WebDriver driver = SetUpCrossBrowser("chrome", DataP.Reading("ChromePath"));
        login = new LoginPage(driver);
        login.NavigateToFaceBook(DataP.Reading("FaceBookUrl"));
        Tscreenshot = new TakingScreenShot(driver);
        victim = new VictimSpam(driver);
    }
    @When("user Enter Email and Password")
    public void user_Enter_Email_and_Password() {
        String mail = DataP.Reading("email");
        login.EnterUserName(mail);
        String pass = DataP.Reading("password");
        login.EnterPassWord(pass);
    }
    @Then("Login in faceBook")
    public void login_in_faceBook() {
        login.ClickOnLogin();
    }

    @Then("Take A Screensot To ensure Login Successfully")
    public void take_A_Screensot_To_ensure_Login_Successfully() throws IOException {
        Tscreenshot.captureScreenShot();
    }

    @Then("Navigate To Victim Url and Login Again")
    public void navigate_To_Victim_Url_and_Login_Again() throws IOException {
        String VictimUrl =  excelData.ReadingExcel(1,0);
        victim.GoToVictimUrl(VictimUrl);
        login.EnterUserName(DataP.Reading("email"));
        login.EnterPassWord( DataP.Reading("password"));
        victim.AnotherLoginButton();
    }

    @Then("Send Spam Message To Victim")
    public void send_Spam_Message_To_Victim() throws IOException {
        String SpamMessage =  excelData.ReadingExcel(0,0);
        victim.SendaSpam(SpamMessage);
    }

    @Then("Close Browser And export A report")
       public void close_Browser_And_export_A_report() {
        driver.quit();
    }

}
