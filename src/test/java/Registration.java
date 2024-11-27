import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Registration {
    ChromeDriver driver;

    @BeforeEach
    public void setup(){
        System.setProperty("webdriver.chrome.driver",
                "/Users/ergrevegvrg/Downloads/chromedriver-mac-arm64-6/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://suninjuly.github.io/registration1.html");
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void successRegistrationOnlyRequiredFields() throws InterruptedException {
        WebElement firstNameInputField = driver.findElement(
                By.cssSelector("[placeholder='Input your first name']"));
        firstNameInputField.sendKeys("John");
        WebElement lastNameInputField = driver.findElement(
                By.cssSelector("[placeholder='Input your last name']"));
        lastNameInputField.sendKeys("Black");
        WebElement emailInputField = driver.findElement(
                By.cssSelector("[placeholder='Input your email']"));
        emailInputField.sendKeys("john.black@gmaoil.com");
        WebElement submitButton = driver.findElement(By.tagName("button"));
        submitButton.click();
        WebElement congratsHeader = driver.findElement(By.tagName("h1"));
        assertEquals("Congratulations! You have successfully registered!", congratsHeader.getText());
    }

    @Test
    public void successRegistrationAllFields(){
        WebElement firstNameInputField = driver.findElement(
                By.cssSelector("[placeholder='Input your first name']"));
        firstNameInputField.sendKeys("John");
        WebElement lastNameInputField = driver.findElement(
                By.cssSelector("[placeholder='Input your last name']"));
        lastNameInputField.sendKeys("Black");
        WebElement emailInputField = driver.findElement(
                By.cssSelector("[placeholder='Input your email']"));
        emailInputField.sendKeys("john.black@gmaoil.com");
        //Enter phone
        WebElement phoneInputField = driver.findElement(
                By.cssSelector("[placeholder='Input your phone:']"));
        phoneInputField.sendKeys("+380675497854");// заполнить phone
//Enter address
        WebElement addressInputField = driver.findElement(
                By.cssSelector("[placeholder='Input your address:']"));
        addressInputField.sendKeys("address 1");// заполнить address
        WebElement submitButton = driver.findElement(By.tagName("button"));
        submitButton.click();
        WebElement congratsHeader = driver.findElement(By.tagName("h1"));
        assertEquals("Congratulations! You have successfully registered!", congratsHeader.getText());
    }

    @Test
    public void firstNameEmptyField(){
        WebElement lastNameInputField = driver.findElement(
                By.cssSelector("[placeholder='Input your last name']"));
        lastNameInputField.sendKeys("Black");
        WebElement emailInputField = driver.findElement(
                By.cssSelector("[placeholder='Input your email']"));
        emailInputField.sendKeys("john.black@gmaoil.com");
        WebElement submitButton = driver.findElement(By.tagName("button"));
        submitButton.click();
        //Check that "Заполните это поле" is displayed in the first name field of attribute 'validationMessage'
//Check that "Заполните это поле" is displayed in the first name field of attribute 'validationMessage'
        WebElement firstNameInputField = driver.findElement(
                By.cssSelector(("[placeholder='Input your first name']"))); // переменная поля first name
        String validationMessage = firstNameInputField.getAttribute("validationMessage");// переменная validationMessage
        assertEquals("Заполните это поле.", validationMessage);// сравниваем ожидаемый и полученый результат
    }


}


