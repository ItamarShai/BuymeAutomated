package MainTestArea;

import POM.HomeScreen;
import POM.IntroAndRegistration;
import POM.PickBusiness;
import POM.SenderAndReceiver;
import ToolsAndInterfaces.DriverSingleton;
import ToolsAndInterfaces.ITakeScreenshot;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.concurrent.TimeUnit;

import static DynamicFiles.Constants.XMLfileLocation;

public class Tests {

    public static WebDriver driver;
    public static ExtentReports extent= new ExtentReports();
    public static ExtentTest test = extent.createTest("Buyme Automated", "Sanity Tests for Buyme");

    @BeforeClass
    public static void beforeClass() throws Exception {

        String type = getData("browserType");
        if(type.equals("Chrome")) {
            try {
                driver = DriverSingleton.getDriverInstance();
                test.log(Status.PASS, "Driver established successfully");
            } catch (Exception e) {
                test.log(Status.FAIL, "Driver not found");
                test.info(MediaEntityBuilder.createScreenCaptureFromPath(ITakeScreenshot.takeScreenShot(driver, "picName")).build());
            }
        } else {
            test.log(Status.INFO, "Switch Driver");
        }
        driver.get(getData("url"));
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String cwd = System.getProperty("user.dir");
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(cwd + "\\extent.html");
        extent.attachReporter(htmlReporter);
    }

    private static String getData (String keyName) throws Exception{
        File fXmlFile = new File(XMLfileLocation);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(keyName).item(0).getTextContent();
    }


//    ***********************
//    Start of Intro and Registration Screen Tests
//    ***********************

    @Test (priority = 1)
    public void loginButtonTest() {
        IntroAndRegistration loginButton = new IntroAndRegistration();
        loginButton.clickOnLogin();
    }

    @Test (priority = 2)
    public void signupButtonTest() {
        IntroAndRegistration signupButton = new IntroAndRegistration();
        signupButton.clickOnSignup();
    }

    @Test (priority = 3)
    public void enterFirstNameForSignup() {
        IntroAndRegistration firstNameSU = new IntroAndRegistration();
        firstNameSU.enterFirstName();
    }

    @Test (priority = 4)
    public void enterEmailForSignup() {
        IntroAndRegistration emailSU = new IntroAndRegistration();
        emailSU.enterEmailAddress();
    }

    @Test (priority = 5)
    public void enterPasswordForSignup() {
        IntroAndRegistration passwordSU = new IntroAndRegistration();
        passwordSU.inventPassword();
    }

    @Test (priority = 6)
    public void confirmPasswordForSignup() {
        IntroAndRegistration confirmSU = new IntroAndRegistration();
        confirmSU.confirmPassword();
    }

//    Press signup*
//    *will stay commented out until actual testing

    @Test (priority = 7)
    public void signUpToBuyme() {
        IntroAndRegistration signUpSU = new IntroAndRegistration();
        signUpSU.signUp();
    }

//    ***********************
//    End of Intro and Registration Screen Tests
//    ***********************

//    ***********************
//    Start of Home Screen Tests
//    ***********************

    @Test (priority = 8)
    public void priceRangeMenuTest() {
        HomeScreen priceRangeDDMOpen = new HomeScreen();
        priceRangeDDMOpen.openPriceRangeMenu();
    }

    @Test (priority = 9)
    public void pickPriceRangeTest() {
        HomeScreen priceRangeDDMClick = new HomeScreen();
        priceRangeDDMClick.pickPriceRange();
    }

    @Test (priority = 10)
    public void regionMenuTest() {
        HomeScreen regionMenuDDMOpen = new HomeScreen();
        regionMenuDDMOpen.openRegionMenu();
    }

    @Test (priority = 11)
    public void pickRegionTest() {
        HomeScreen regionMenuDDMClick = new HomeScreen();
        regionMenuDDMClick.pickRegion();
    }

    @Test (priority = 12)
    public void categoryMenuTest() {
        HomeScreen categoryMenuDDMOpen = new HomeScreen();
        categoryMenuDDMOpen.openCategoryMenu();
    }

    @Test (priority = 13)
    public void pickCategoryTest() {
        HomeScreen categoryMenuDDMClick = new HomeScreen();
        categoryMenuDDMClick.pickCategory();
    }

    @Test (priority = 14)
    public void findGiftButtonTest() {
        HomeScreen pressFindNewGift = new HomeScreen();
        pressFindNewGift.findNewGift();
    }
//    ***********************
//    End of Home Screen Tests
//    ***********************

//    ***********************
//    Start of Pick Business Screen Tests
//    ***********************

    @Test (priority = 15)
    public void assertURLTest() {
        PickBusiness assertingURL = new PickBusiness();
        assertingURL.assertUrl();
    }

    @Test (priority = 16)
    public void pickBusinessTest() {
        PickBusiness pickingBusiness = new PickBusiness();
        pickingBusiness.pickBusiness();
    }

    @Test (priority = 17)
    public void enterAmountTest() {
        PickBusiness enteringAmount = new PickBusiness();
        enteringAmount.enterAmount();
    }

    @Test (priority = 18)
    public void chooseAmountTest() {
        PickBusiness choosingAmount = new PickBusiness();
        choosingAmount.chooseAmount();
    }

//    ***********************
//    End of Pick Business Screen Tests
//    ***********************

//    ***********************
//    Start of Sender and Receiver Screen Tests
//    ***********************

//    Start of first page of screen

    @Test (priority = 19)
    public void chooseToSomeoneElseTest() {
        SenderAndReceiver chooseSomeoneElse = new SenderAndReceiver();
        chooseSomeoneElse.toSomeoneElse();
    }

    @Test (priority = 20)
    public void enterReceiverNameTest() {
        SenderAndReceiver enterNameForReceiver = new SenderAndReceiver();
        enterNameForReceiver.enterReceiverName();
    }

    @Test (priority = 21)
    public void openEventListTest() {
        SenderAndReceiver openTheEventList= new SenderAndReceiver();
        openTheEventList.openEventList();
    }

    @Test (priority = 22)
    public void pickEventTest() {
        SenderAndReceiver pickAnEvent = new SenderAndReceiver();
        pickAnEvent.pickEvent();
    }

    @Test (priority = 23)
    public void clearGreetingAreaTest() {
        SenderAndReceiver clearTextAreaGreeting = new SenderAndReceiver();
        clearTextAreaGreeting.clearGreetingArea();
    }

    @Test (priority = 24)
    public void enterGreetingTest() {
        SenderAndReceiver writeGreeting= new SenderAndReceiver();
        writeGreeting.enterGreeting();
    }

    @Test (priority = 25)
    public void uploadImageTest() {
        SenderAndReceiver uploadAnImage = new SenderAndReceiver();
        uploadAnImage.uploadImage();
    }

    @Test (priority = 26)
    public void continueToSecondScreenTest() {
        SenderAndReceiver pressToContinue= new SenderAndReceiver();
        pressToContinue.pressContinue();
    }

//    End of first page of screen
//    Start of second page of screen

    @Test (priority = 27)
    public void chooseToSendNowTest() {
        SenderAndReceiver sendTheGiftNow = new SenderAndReceiver();
        sendTheGiftNow.pressNow();
    }

    @Test (priority = 28)
    public void sendViaSMSTest() {
        SenderAndReceiver chooseToSendViaSMS = new SenderAndReceiver();
        chooseToSendViaSMS.chooseSMS();
    }

    @Test (priority = 29)
    public void enterReceiverNumberTest() {
        SenderAndReceiver enterReceiverPhoneNumber = new SenderAndReceiver();
        enterReceiverPhoneNumber.enterReceiverPhone();
    }

    @Test (priority = 30)
    public void enterSenderNameTest() {
        SenderAndReceiver enterTheSenderName = new SenderAndReceiver();
        enterTheSenderName.enterSenderName();
    }

    @Test (priority = 31)
    public void enterSenderNumberTest() {
        SenderAndReceiver enterSenderPhoneNumber = new SenderAndReceiver();
        enterSenderPhoneNumber.enterSenderPhone();
    }

    @Test (priority = 32)
    public void assertPhoneNumbersTest() {
        SenderAndReceiver assertTheNumbers = new SenderAndReceiver();
        assertTheNumbers.assertNumbers();
    }

    @Test (priority = 33)
    public void continueToPaymentPageTest() {
        SenderAndReceiver pressContinueToPaymentPage = new SenderAndReceiver();
        pressContinueToPaymentPage.pressContinueToPay();
    }

    @AfterClass
    public static void tearDown() {
        test.log(Status.INFO, "@After test " + "After test method");
        driver.quit();
        extent.flush();
    }
}
