package MainTestArea;

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

public class Tests {

    public static WebDriver driver;
    private static ExtentReports extent;
    private static ExtentTest test;


    @BeforeClass
    public static void runOnceBeforeClass() throws Exception {
        String type = getData("browserType");
        if (type.equals("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\ITAMAR\\IdeaProjects\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (type.equals("FF")){
            System.setProperty("webdriver.firefox.driver", "Path");
            driver = new FirefoxDriver();
        }
        driver.get(getData("url"));
        String cwd = System.getProperty("user.dir");
        String reportPath = "C:\\Users\\ITAMAR\\IdeaProjects\\QA Experts\\BuymeAutomated\\report\\extent.html";
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(cwd + reportPath);

        // attach reporter
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        // name your test and add description
        test = extent.createTest("BuymeAutomated Tests", "Buyme Sanity Tests");

        // log results
        test.log(Status.INFO, "@Before class");
        try {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\ITAMAR\\IdeaProjects\\chromedriver.exe");
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

    @Test

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
