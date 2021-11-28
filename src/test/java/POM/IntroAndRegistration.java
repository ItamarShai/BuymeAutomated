package POM;

import ToolsAndInterfaces.WebpageParent;
import org.openqa.selenium.By;

public class IntroAndRegistration extends WebpageParent {

    //    Press on homepage login button
    public void clickOnLogin() {
        clickElement(By.id("seperator-link"));
    }

    //    Press on signup button
    public void clickOnSignuo() {
        clickElement(By.cssSelector("span[class='text-link theme']"));
    }

    //    Enter first name for signup
    public void enterFirstName() {
        sendKeysToElement(By.cssSelector("input[id='ember1493']"),"איתמר");
    }

    //    Enter email address for signup
    public void enterEmailAddress() {
        sendKeysToElement(By.cssSelector("input[id='ember1496']"), "123ita.mar@gmail.com");
    }

    //    Enter password for signup
    public void enterPasswordForSignup() {
        sendKeysToElement(By.cssSelector("input[id='valPass']"), "Coding1234");
    }

    //    Confirm password for signup
    public void confirmPassword() {
        sendKeysToElement(By.cssSelector("input[id='ember1502']"), "Coding1234");
    }

//    Press signup, will stay commented out until actual testing
//    public void signUp() {
//        clickElement(By.cssSelector("span[class='label']"));
//    }
}
