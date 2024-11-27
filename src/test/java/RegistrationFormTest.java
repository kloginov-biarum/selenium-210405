import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegistrationFormTest {
    ChromeDriver driver;

    @BeforeEach
    public void setup(){
        System.setProperty("webdriver.chrome.driver",
                "/Users/ergrevegvrg/Downloads/chromedriver-mac-arm64-6/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/data-types.html");
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void successSubmitFormTest(){
        //Using Page Object Model pattern
        //1. Fill in the form with valid data
        //2. Submit the form
        //3. Check that the form is submitted
    }
}
