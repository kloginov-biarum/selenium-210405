import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestPage {
    ChromeDriver driver;

    @BeforeEach
    public void setup(){
        System.setProperty("webdriver.chrome.driver",
                "/Users/ergrevegvrg/Downloads/chromedriver-mac-arm64-6/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://crossbrowsertesting.github.io/selenium_example_page.html");
        //driver.manage().timeouts().implicitlyWait(10, java.util.concurrent.TimeUnit.SECONDS);
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }




    @Test
    public void checkListHas4Elements(){
        List<WebElement> list = driver.findElements(By.cssSelector(".list li"));
        assertEquals(4, list.size());
    }
    @Test
    public void followTheLinkPage2(){
        //click on link
        WebElement linkPage2 =
                driver.findElement(By.xpath("//a[@href='selenium_example_page2.html']"));
        linkPage2.click();
        //check that we are on page 2
        System.out.println(driver.getCurrentUrl());
        //assertEquals("https://crossbrowsertesting.github.io/selenium_example_page2.html",
        //        driver.getCurrentUrl());
        //Check that URL contains "page2"
        assertTrue(driver.getCurrentUrl().contains("page2"));
        //Check that page header is "Selenium Test Example Page 2"
        WebElement headerP2 = driver.findElement(By.tagName("h2"));
        assertTrue(headerP2.getText().contains("Selenium Example Page 2"));
    }
    @Test
    public void showMessageTest() {
        //Click on Show Message button
        //Check that message "I am the message!!" is displayed
        WebElement showMessage = driver.findElement(By.id("btn"));
        showMessage.click();

        //Check that message "I am the message!!" is displayed
        WebElement showMessageText = driver.findElement(By.id("button-message"));
        assertEquals("I am the message!!",showMessageText.getText() );
    }


}
