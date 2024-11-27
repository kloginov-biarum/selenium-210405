import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UplodFile {
    ChromeDriver driver;

    @BeforeEach
    public void setup(){
        System.setProperty("webdriver.chrome.driver",
                "/Users/ergrevegvrg/Downloads/chromedriver-mac-arm64-6/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://suninjuly.github.io/file_input.html");
        //driver.manage().timeouts().implicitlyWait(10, java.util.concurrent.TimeUnit.SECONDS);
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void uploadFile() throws InterruptedException {
        //1. Enter First name
        WebElement firstNameInputField = driver.findElement(By.cssSelector("[name='firstname']"));
        firstNameInputField.sendKeys("Taisiia");

    //2. Enter Last name
        WebElement lastNameInputField = driver.findElement(By.cssSelector("[name='lastname']"));
        lastNameInputField.sendKeys("Bogdanova");

    //3. Enter email
        WebElement emailInputField = driver.findElement(By.cssSelector("[name='email']"));
        emailInputField.sendKeys("taisiia@gmail.com");


        WebElement uploadFileInput = driver.findElement(By.id("file"));
        uploadFileInput.sendKeys("/Users/ergrevegvrg/Downloads/dog.png");
        //4. Click on submit button
        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();

//5. Check that alert contains text "Congrats, you've passed the task!"
        Alert alert = driver.switchTo().alert();
        assertTrue(alert.getText().contains("Congrats, you've passed the task!"));
        //5. Check that alert contains text "Congrats, you've passed the task!"
    }

}
