package pl.coderslab.order;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ConfirmOrder {
    private final WebDriver driver;

    public ConfirmOrder(WebDriver driver) {
        this.driver = driver;
    }

    public void takeScreenshot() {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(srcFile, new File("order_confirmation.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}