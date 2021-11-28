package ToolsAndInterfaces;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import static MainTestArea.Tests.driver;
import static MainTestArea.Tests.test;

public class WebpageParent implements ITakeScreenshot {

//    Parent method to click an element
    public void clickElement(By locator) {
        try {
            getWebElement(locator).click();
            test.log(Status.PASS, "Passed");
        } catch (NoSuchElementException e){
            test.log(Status.FAIL, "Element not found");
            test.info(MediaEntityBuilder.createScreenCaptureFromPath(ITakeScreenshot.takeScreenShot(driver, "picName")).build());
        }
    }

//    Parent method to send keys to an element
    public void sendKeysToElement(By locator, String text) {
        try {
            getWebElement(locator).sendKeys(text);
            test.log(Status.PASS, "Passed");
        } catch (NoSuchElementException e){
            test.log(Status.FAIL, "Element not found");
            test.info(MediaEntityBuilder.createScreenCaptureFromPath(ITakeScreenshot.takeScreenShot(driver, "picName")).build());
        }
    }

//    Parent method to clear a text field element
    public void clearTextFieldElement(By locator){
        try {
            getWebElement(locator).clear();
            test.log(Status.PASS, "Passed");
        } catch (NoSuchElementException e){
            test.log(Status.FAIL, "Element not found");
            test.info(MediaEntityBuilder.createScreenCaptureFromPath(ITakeScreenshot.takeScreenShot(driver, "picName")).build());
        }
    }

//    In-class method to get a web element to interact with, using DriverSingleton
    private WebElement getWebElement(By locator) {
        return DriverSingleton.getDriverInstance().findElement(locator);
    }
}
