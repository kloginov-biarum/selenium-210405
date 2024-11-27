import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Cats {

    ChromeDriver driver;

    @BeforeEach
    public void setup(){
        System.setProperty("webdriver.chrome.driver",
                "/Users/ergrevegvrg/Downloads/chromedriver-mac-arm64-6/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://suninjuly.github.io/cats.html");
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
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

    //Check that Edit button of 3rd cat card is displayed



    //Check that subheader is displayed
    @Test
    public void subheaderIsDisplayed(){
        WebElement moto = driver.findElement(By.id("moto"));
        assertTrue(moto.isDisplayed());//assertTrue проверяет соответствие True
    }

    @Test
    public void checkCardQuantity(){
        List<WebElement> cards = driver.findElements(By.cssSelector(".col-sm-4"));
        assertEquals(6,  cards.size());
    }

    //Check that quantity of images is 6
    @Test
    public void checkImageCard(){
        List<WebElement> imgCards = driver.findElements(By.cssSelector("img"));
        assertEquals(6,  imgCards.size());
    }

    //Check that all cards are displayed
    @Test
    public void allCardsAreDisplayed() {
        List<WebElement> cards = driver.findElements(By.cssSelector(".col-sm-4"));
    /*    for (int i = 0; i < cards.size(); i++) {
            assertTrue(cards.get(i).isDisplayed());
        }*/
        for (WebElement card: cards){
            assertTrue(card.isDisplayed());
        }
    }

    //Check that all cards names are displayed
    @Test
    public void allCardsNamesAreDisplayed(){
        List<WebElement> cardNames = driver.findElements(By.cssSelector(".card-text"));
        for(WebElement name: cardNames){
            assertTrue(name.isDisplayed());
        }
    }




    //Check that all cards have no empty names
    @Test
    public void allCardsNamesAreNotEmpty(){
        List<WebElement> cardNames = driver.findElements(By.cssSelector(".card-text"));
        for(WebElement name: cardNames) {
                assertFalse(name.getText().isEmpty());
        }
    }


    //Check that each card name contains "cat"
    @Test
    public void eachCardNameContainsCat() {
        List<WebElement> cardNames = driver.findElements(By.cssSelector(".card-text"));
        for (WebElement name : cardNames) {
            assertTrue(name.getText().contains("cat"));
        }
    }

    //Check that time value for each card is "9 mins"
    @Test
    public void allCardsTimeContainsValue() {
        List<WebElement> cardTime = driver.findElements(By.cssSelector("small"));
        for (WebElement name : cardTime) {
            assertTrue(name.getText().contains("9 mins")); // contains - включает в себя
        }
    }

    //For the page http://suninjuly.github.io/cats.html create the following tests:
    //1. Check that there are 6 "Edit" buttons on the page
    //2. Check that subHeader contains word "cat"
    //3. Check that photo icon is displayed (left of "Cats album")


}
