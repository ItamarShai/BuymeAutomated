package POM;

import ToolsAndInterfaces.WebpageParent;
import org.openqa.selenium.By;

public class LoginScreen extends WebpageParent {

    //    Call clickOnLogin from IntroAndRegistration when intending to log in

    //    Enter email for login
    public void enterLoginEmail() {
        sendKeysToElement(By.cssSelector("input[placeholder='מייל']"), "123ita.mar@gmail.com");
    }

    //    Enter password for log in
    public void enterLoginPassword() {
        sendKeysToElement(By.cssSelector("input[placeholder='סיסמה']"), "Coding1234");
    }

    //    Log in to "Buyme"
    public void clickEnterBuyme() {
        clickElement(By.cssSelector("button[type='submit']"));
    }
}
