import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddElementTask {
    ChromeDriver driver;

    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver",
                "/Users/ergrevegvrg/Downloads/chromedriver-mac-arm64-6/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void addElementTest() {
        //1. Click on "Add Element" button 5 times
        WebElement buttonAddElement = driver.findElement(By.cssSelector("button[onclick='addElement()']"));
        int amountOfClicks = 10;
        for (int i = 0; i < amountOfClicks; i++) {
            buttonAddElement.click();
        }

//2. Check that 10 "Delete" buttons are displayed
        List<WebElement> deleteButtons = driver.findElements(By.className("added-manually"));
        assertEquals(amountOfClicks, deleteButtons.size());
    }
}