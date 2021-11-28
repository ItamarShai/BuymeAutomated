package ToolsAndInterfaces;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WebpageParent {

//    Parent method to click an element
    public void clickElement(By locator) {
        getWebElement(locator).click();
    }

//    Parent method to send keys to an element
    public void sendKeysToElement(By locator, String text) {
        getWebElement(locator).sendKeys(text);
    }

//    Parent method to clear a text field element
    public void clearTextFieldElement(By locator){
        getWebElement(locator).clear();
    }

//    In-class method to get a web element to interact with using DriverSingleton
    private WebElement getWebElement(By locator) {
        return DriverSingleton.getDriverInstance().findElement(locator);
    }
}
