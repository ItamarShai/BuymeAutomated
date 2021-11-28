package POM;

import ToolsAndInterfaces.WebpageParent;
import org.openqa.selenium.By;
import org.testng.Assert;

import static MainTestArea.Tests.driver;

public class PickBusiness extends WebpageParent {

//    Assert url for picking business
    public void assertUrl() {
        String intendedURL = "https://buyme.co.il/search?budget=3&category=22&region=9";
        String actualCurrentURL = driver.getCurrentUrl();
        Assert.assertSame(intendedURL, actualCurrentURL);
    }

//    Pick a business
    public void pickBusiness() {
        clickElement(By.cssSelector("div[class='top']"));
    }

//    Enter amount of money to give
    public void enterAmount() {
        sendKeysToElement(By.cssSelector("input[placeholder='הכנס סכום']"), "200");
    }

//    Choose amount
    public void chooseAmount() {
        clickElement(By.cssSelector("button[class='ember-view bm-btn no-reverse main md stretch']"));
    }
}
