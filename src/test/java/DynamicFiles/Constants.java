package DynamicFiles;

import org.openqa.selenium.By;

import static MainTestArea.Tests.driver;

public class Constants {

//    Local files that can be changed in constants:
//    - Driver location
//    - Extent Reports location
//    - XML file location
//    - Image for upload on test 24

//    ChromeDriver location
    public static final String chromeDriverLocation = "C:\\Users\\ITAMAR\\IdeaProjects\\QA Experts\\BuymeAutomated\\chromedriver.exe";

//    XML file location
    public static final String XMLfileLocation = "C:\\Users\\ITAMAR\\IdeaProjects\\QA Experts\\BuymeAutomated\\src\\test\\java\\DynamicFiles\\data.xml";

//    Image for upload location
    public static final String imageLocation = "C:\\Users\\ITAMAR\\Pictures\\Saved Pictures\\a-show-winning-Silkie.jpg";

//    Intended Receiver phone number
    public static final String receiverNumber = "555123";

//    Intended Sender phone number
    public static final String senderNumber = "555456";

//    Actual receiver number
//    public static final String actualReceiverNumber = findElement(By.cssSelector("input[id=sms]")).getText();
    public static final String actualReceiverNumber = driver.findElement(By.cssSelector("input[id=sms]")).toString();

//    Actual sender number
//    public static final String actualSenderNumber = DriverSingleton.getDriverInstance().findElement(By.cssSelector("input[id=ember1651]")).getText();
    public static final String actualSenderNumber = driver.findElement(By.cssSelector("input[id=ember1651]")).toString();

}
