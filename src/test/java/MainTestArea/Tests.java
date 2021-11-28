package MainTestArea;

import POM.HomeScreen;
import POM.IntroAndRegistration;
import POM.PickBusiness;
import POM.SenderAndReceiver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static DynamicFiles.Constants.driverLocation;
import static DynamicFiles.Constants.extentReportsLocation;

public class Tests {

    public static WebDriver driver;
    private static ExtentReports extent;
    private static ExtentTest test;


    @BeforeClass
    public static void runOnceBeforeClass() throws Exception {
        String type = getData("browserType");
        if (type.equals("Chrome")) {
            System.setProperty("webdriver.chrome.driver", driverLocation);
            driver = new ChromeDriver();
        } else if (type.equals("FF")){
            System.setProperty("webdriver.firefox.driver", "Path");
            driver = new FirefoxDriver();
        }
        driver.get(getData("url"));
        String cwd = System.getProperty("user.dir");
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(cwd + extentReportsLocation);

        // attach reporter
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        // name your test and add description
        test = extent.createTest("BuymeAutomated Tests", "Buyme Sanity Tests");

        // log results
        test.log(Status.INFO, "@Before class");
        try {
            System.setProperty("webdriver.chrome.driver", driverLocation);
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            test.log(Status.PASS, "Driver established successfully");
        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Driver connection failed! " + e.getMessage());
            throw new Exception("Driver failed");
        }

        driver.get(getData("url"));
    }

    private static String getData (String keyName) throws Exception{
        ClassLoader classLoader = Tests.class.getClassLoader();
        String xmlFilePath = String.valueOf(new File(classLoader.getResource("data.xml").getFile()));
        File fXmlFile = new File(xmlFilePath);
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
        signupButton.clickOnSignuo();
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

//    Press signup, will stay commented out until actual testing

//    @Test (priority = 7)
//    public void signUpToBuyme() {
//        IntroAndRegistration signUpSU = new IntroAndRegistration();
//        signUpSU.signUp();
//    }

//    ***********************
//    End of Intro and Registration Screen Tests
//    ***********************

//    ***********************
//    Start of Login Screen Tests
//    note: not in the SRS, but exists to test login process if needed
//    ***********************
//
//    @Test
//    public void loginButtonTestForLogin() {
//        IntroAndRegistration loginButtonForLogin = new IntroAndRegistration();
//        loginButtonForLogin.clickOnLogin();
//    }
//
//    @Test
//    public void enterLoginEmail() {
//        LoginScreen enterEmailForLogin = new LoginScreen();
//        enterEmailForLogin.enterLoginEmail();
//    }
//
//    @Test
//    public void enterLoginPassword() {
//        LoginScreen enterPasswordForLogin = new LoginScreen();
//        enterPasswordForLogin.enterLoginPassword();
//    }
//
//    @Test
//    public void enterBuymeAsUser() {
//        LoginScreen enterBuyme = new LoginScreen();
//        enterBuyme.clickEnterBuyme();
//    }
//
//    ***********************
//    End of Login Screen Tests
//    ***********************

//    ***********************
//    Start of Home Screen Tests
//    ***********************

    @Test (priority = 7)
    public void priceRangeMenuTest() {
        HomeScreen priceRangeDDMopen = new HomeScreen();
        priceRangeDDMopen.openPriceRangeMenu();
    }

    @Test (priority = 8)
    public void pickPriceRangeTest() {
        HomeScreen priceRangeDDMclick = new HomeScreen();
        priceRangeDDMclick.pickPriceRange();
    }

    @Test (priority = 9)
    public void regionMenuTest() {
        HomeScreen regionMenuDDMopen = new HomeScreen();
        regionMenuDDMopen.openRegionMenu();
    }

    @Test (priority = 10)
    public void pickRegionTest() {
        HomeScreen regionMenuDDMclick = new HomeScreen();
        regionMenuDDMclick.pickRegion();
    }

    @Test (priority = 11)
    public void categoryMenuTest() {
        HomeScreen categoryMenuDDMopen = new HomeScreen();
        categoryMenuDDMopen.openCategoryMenu();
    }

    @Test (priority = 12)
    public void pickCategoryTest() {
        HomeScreen categoryMenuDDMclick = new HomeScreen();
        categoryMenuDDMclick.pickCategory();
    }

    @Test (priority = 13)
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

    @Test (priority = 14)
    public void assertURLtest() {
        PickBusiness assertingURL = new PickBusiness();
        assertingURL.assertUrl();
    }

    @Test (priority = 15)
    public void pickBusinessTest() {
        PickBusiness pickingBusiness = new PickBusiness();
        pickingBusiness.pickBusiness();
    }

    @Test (priority = 16)
    public void enterAmountTest() {
        PickBusiness enteringAmount = new PickBusiness();
        enteringAmount.enterAmount();
    }

    @Test (priority = 17)
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

    @Test (priority = 18)
    public void chooseToSomeoneElseTest() {
        SenderAndReceiver chooseSomeoneElse = new SenderAndReceiver();
        chooseSomeoneElse.toSomeoneElse();
    }

    @Test (priority = 19)
    public void enterReceiverNameTest() {
        SenderAndReceiver enterNameForReceiver = new SenderAndReceiver();
        enterNameForReceiver.enterReceiverName();
    }

    @Test (priority = 20)
    public void openEventListTest() {
        SenderAndReceiver openTheEventList= new SenderAndReceiver();
        openTheEventList.openEventList();
    }

    @Test (priority = 21)
    public void pickEventTest() {
        SenderAndReceiver pickAnEvent = new SenderAndReceiver();
        pickAnEvent.pickEvent();
    }

    @Test (priority = 22)
    public void clearGreetingAreaTest() {
        SenderAndReceiver clearTextAreaGreeting = new SenderAndReceiver();
        clearTextAreaGreeting.clearGreetingArea();
    }

    @Test (priority = 23)
    public void enterGreetingTest() {
        SenderAndReceiver writeGreeting= new SenderAndReceiver();
        writeGreeting.enterGreeting();
    }

    @Test (priority = 24)
    public void uploadImageTest() {
        SenderAndReceiver uploadAnImage = new SenderAndReceiver();
        uploadAnImage.uploadImage();
    }

    @Test (priority = 25)
    public void continueToSecondScreenTest() {
        SenderAndReceiver pressToContinue= new SenderAndReceiver();
        pressToContinue.pressContinue();
    }

//    End of first page of screen
//    Start of second page of screen

    @Test (priority = 26)
    public void chooseToSendNowTest() {
        SenderAndReceiver sendTheGiftNow = new SenderAndReceiver();
        sendTheGiftNow.pressNow();
    }

    @Test (priority = 27)
    public void sendViaSMStest() {
        SenderAndReceiver chooseToSendViaSMS = new SenderAndReceiver();
        chooseToSendViaSMS.chooseSMS();
    }

    @Test (priority = 28)
    public void enterReceiverNumberTest() {
        SenderAndReceiver enterReceiverPhoneNumber = new SenderAndReceiver();
        enterReceiverPhoneNumber.enterReceiverPhone();
    }

    @Test (priority = 29)
    public void enterSenderNameTest() {
        SenderAndReceiver enterTheSenderName = new SenderAndReceiver();
        enterTheSenderName.enterSenderName();
    }

    @Test (priority = 30)
    public void enterSenderNumberTest() {
        SenderAndReceiver enterSenderPhoneNumber = new SenderAndReceiver();
        enterSenderPhoneNumber.enterSenderPhone();
    }

    @Test (priority = 31)
    public void assertPhoneNumbersTest() {
        SenderAndReceiver assertTheNumbers = new SenderAndReceiver();
        assertTheNumbers.assertNumbers();
    }

    @Test (priority = 32)
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

    private static String takeScreenShot(String ImagesPath) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(ImagesPath + ".png");
        try {
            FileUtils.copyFile(screenShotFile, destinationFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return ImagesPath + ".png";
    }
}
