import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

import static java.lang.Math.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SwitchToTab2 {
    ChromeDriver driver;

    @BeforeEach
    public void setup(){
        System.setProperty("webdriver.chrome.driver",
                "/Users/ergrevegvrg/Downloads/chromedriver-mac-arm64-6/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/browser-windows");
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void switchTest() throws InterruptedException {
        //Push the "New tab" button
        WebElement buttonNewTab = driver.findElement(By.id("tabButton"));
        buttonNewTab.click();
        //Switch to the new tab
        //переходит на другую страницу
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));//переключится
        //Check that the new tab has been opened
        WebElement sampleHeading = driver.findElement(By.id("sampleHeading"));
        assertEquals("This is a sample page", sampleHeading.getText());
    }





}
