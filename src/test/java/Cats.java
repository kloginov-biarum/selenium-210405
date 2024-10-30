import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Cats {

    ChromeDriver driver;

    @BeforeEach
    public void setup(){
        System.setProperty("webdriver.chrome.driver",
                "/Users/ergrevegvrg/Downloads/chromedriver-mac-arm64-6/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://suninjuly.github.io/cats.html");
    }

    @Test
    public void headerIsCorrect() {
        WebElement header = driver.findElement(By.cssSelector("[class='jumbotron-heading']"));
        assertEquals("Cat memes", header.getText());
    }

    //Test for cheking that first cat card name is "Bullet cat"
    @Test
    public void nameOfFirstCat(){
        WebElement nameFirstCat = driver.findElement(By.cssSelector(".col-sm-4:first-child .card-text"));
        assertEquals("Bullet cat", nameFirstCat.getText());
    }

    //Check that 9 mins in time of 4th cat card
    @Test
    public void timeOf4thCat(){
        WebElement timeOf4thCat = driver.findElement(By.cssSelector(".col-sm-4:nth-child(4) small"));
        assertEquals("9 mins", timeOf4thCat.getText());

    }
    //Check that Cats album is displayed
    @Test
    public void catsAlbumText(){
        WebElement navBarText = driver.findElement(By.cssSelector(".navbar strong"));
        assertEquals("Cats album", navBarText.getText());
    }

    @Test
    public void imageOfTheFirstCatIsDisplayed(){
        WebElement imageOfFirstCat = driver.findElement(By.id("bullet"));
        assertTrue(imageOfFirstCat.isDisplayed());
    }



}
