import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ModalWindowTask {
    ChromeDriver driver;

    @BeforeEach
    public void setup(){
        System.setProperty("webdriver.chrome.driver",
                "/Users/ergrevegvrg/Downloads/chromedriver-mac-arm64-6/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/entry_ad");
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void modalWindowTest(){
//1. Check that header of modal window is "THIS IS A MODAL WINDOW"
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement description = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"modal\"]/div[2]/div[1]/h3")));
// visibilityOfElementLocated - элемент виден на странице
        assertEquals("THIS IS A MODAL WINDOW", description.getText());
        WebElement lincClose = driver.findElement(By.xpath("//*[@id=\"modal\"]/div[2]/div[3]/p"));
        lincClose.click();
    }

}
