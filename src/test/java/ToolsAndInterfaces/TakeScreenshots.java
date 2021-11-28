//package ToolsAndInterfaces;
//
//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//
//import java.io.File;
//import java.io.IOException;
//
//import static MainTestArea.Tests.driver;
//
//public class TakeScreenshots {
//        public static String takeScreenShot(String ImagesPath) {
//            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
//            File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
//            File destinationFile = new File(ImagesPath+".jpg");
//            try {
//                FileUtils.copyFile(screenShotFile, destinationFile);
//            } catch (IOException e) {
//                System.out.println(e.getMessage());
//            }
//            return ImagesPath+".jpg";
//        }
//}
