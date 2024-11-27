import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class UploadTask {
    ChromeDriver driver;

    @BeforeEach
    public void setup(){
        System.setProperty("webdriver.chrome.driver",
                "/Users/ergrevegvrg/Downloads/chromedriver-mac-arm64-6/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/upload");
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void uploadTest(){
        WebElement uploadFile = driver.findElement(By.id("file-upload"));
        String fileName = "dog.png";
        uploadFile.sendKeys("/Users/ergrevegvrg/Downloads/" + fileName);
        WebElement uploadButton = driver.findElement(By.id("file-submit"));
        uploadButton.click();

        WebElement header = driver.findElement(By.cssSelector("h3"));
        assertEquals("File Uploaded!", header.getText());

        WebElement uploadedFileName = driver.findElement(By.id("uploaded-files"));
        assertFalse(uploadedFileName.getText().isEmpty());
        assertEquals(fileName,uploadedFileName.getText());
    }

}
