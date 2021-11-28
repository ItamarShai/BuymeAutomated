package POM;

import ToolsAndInterfaces.WebpageParent;
import org.openqa.selenium.By;
import org.testng.Assert;

import static DynamicFiles.Constants.*;

public class SenderAndReceiver extends WebpageParent {

//    **********************
//    Start of Receiver Screen
//    **********************

//    Choose to send to someone else
    public void toSomeoneElse() {
        clickElement(By.cssSelector("div[gtm='למישהו אחר']"));
    }

//    Enter gift receiver name
    public void enterReceiverName() {
        sendKeysToElement(By.cssSelector("input[class='ember-view ember-text-field']"), "Dad");
    }

//    Open event list
    public void openEventList() {
        clickElement(By.cssSelector("span[alt='לאיזה אירוע?']"));
    }

//    Pick event
    public void pickEvent() {
        clickElement(By.cssSelector("li[value='33']"));
    }

//    Clear greeting area
    public void clearGreetingArea() {
        clearTextFieldElement(By.cssSelector("textarea[placeholder=מזל טוב, תודה רבה או פשוט מלא אהבה? כאן כותבים מילים טובות ואיחולים שמחים]"));
    }

//    Enter a greeting
    public void enterGreeting() {
        sendKeysToElement(By.cssSelector("textarea[rows='4']"), "This code is killing it");
    }

//    Upload an image to greeting, image location is in Constants class
    public void uploadImage() {
        sendKeysToElement(By.cssSelector("input[name='logo']"), imageLocation);
    }

//    Press continue
    public void pressContinue() {
        clickElement(By.cssSelector("button[type='submit']"));
    }

//    **********************
//    End of Receiver Screen
//    **********************

//    **********************
//    Start of Sender Screen
//    **********************

//    Choose to send now
    public void pressNow() {
        clickElement(By.cssSelector("span[class='text']"));
    }

//    Choose to send via SMS
    public void chooseSMS() {
        clickElement(By.cssSelector("path[class='circle']"));
    }

//    Enter receiver phone number
    public void enterReceiverPhone() {
        sendKeysToElement(By.cssSelector("input[id=sms]"),  receiverNumber);
    }

//    Enter sender name
    public void enterSenderName() {
        sendKeysToElement(By.cssSelector("input[placeholder='שם שולח המתנה']"), "Me");
    }

//    Enter sender phone number
    public void enterSenderPhone() {
        sendKeysToElement(By.cssSelector("input[id=ember1651]"), senderNumber);
    }

//    Assert phone numbers for sender and receiver
    public void assertNumbers() {
        Assert.assertEquals(receiverNumber, actualReceiverNumber);
        Assert.assertEquals(senderNumber, actualSenderNumber);
    }

//    Continue to pay
    public void pressContinueToPay() {
        clickElement(By.cssSelector("button[type='submit']"));
    }
}
