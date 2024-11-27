import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Hover {

    ChromeDriver driver;

    @BeforeEach
    public void setup(){
        System.setProperty("webdriver.chrome.driver",
                "/Users/ergrevegvrg/Downloads/chromedriver-mac-arm64-6/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://crossbrowsertesting.github.io/hover-menu.html#");
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void checkSecondaryPage() throws InterruptedException {
        WebElement dropdown = driver.findElement(By.xpath("(//a[@class='dropdown-toggle'])[1]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(dropdown).perform();
        WebElement secondaryMenu = driver.findElement(By.className("secondary-dropdown"));
        actions.moveToElement(secondaryMenu).perform();
        sleep(3000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement secondaryAction =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[onclick=\"handleSecondaryAction()\"]")));
               // driver.findElement(By.cssSelector("[onclick=\"handleSecondaryAction()\"]"));
        secondaryAction.click();
        WebElement headerSecondary = driver.findElement(By.cssSelector(".secondary-clicked h1"));
        assertEquals("Secondary Page", headerSecondary.getText());
    }
}
