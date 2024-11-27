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

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToolTip {
    ChromeDriver driver;

    @BeforeEach
    public void setup(){
        System.setProperty("webdriver.chrome.driver",
                "/Users/ergrevegvrg/Downloads/chromedriver-mac-arm64-6/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/tool-tips");
        //driver.manage().timeouts().implicitlyWait(10, java.util.concurrent.TimeUnit.SECONDS);
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void hoverMeToSeeButtonTooltip(){
        //hover over the button "Hover me to see"
        WebElement hoverMeToSeeButton = driver.findElement(By.id("toolTipButton"));
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverMeToSeeButton).perform();
        //check that tooltip text is "You hovered over the Button" (.tooltip-inner)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement tooltip = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("tooltip-inner")));
        assertEquals("You hovered over the Button", tooltip.getText());
    }
}
