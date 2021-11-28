package ToolsAndInterfaces;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WebpageParent {
    public void clickElement(By locator) {
        getWebElement(locator).click();
    }

    public void sendKeysToElement(By locator, String text) {
        getWebElement(locator).sendKeys(text);
    }

    private WebElement getWebElement(By locator) {
        return DriverSingleton.getDriverInstance().findElement(locator);
    }
}
