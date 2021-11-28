package DynamicFiles;

import ToolsAndInterfaces.DriverSingleton;
import org.openqa.selenium.By;

public class Constants {

//    Image location
    public static final String imageLocation = "C:\\Users\\ITAMAR\\Pictures\\Saved Pictures\\a-show-winning-Silkie.jpg";

//    Intended Receiver phone number
    public static final String receiverNumber = "555123";

//    Intended Sender phone number
    public static final String senderNumber = "555456";

//    Actual receiver number
    public static final String actualReceiverNumber = DriverSingleton.getDriverInstance().findElement(By.cssSelector("input[id=sms]")).getText();

//    Actual sender number
    public static final String actualSenderNumber = DriverSingleton.getDriverInstance().findElement(By.cssSelector("input[id=ember1651]")).getText();

}
