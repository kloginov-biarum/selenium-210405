import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToDoApp {

    ChromeDriver driver;

    @BeforeEach
    public void setup(){
        System.setProperty("webdriver.chrome.driver",
                "/Users/ergrevegvrg/Downloads/chromedriver-mac-arm64-6/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://crossbrowsertesting.github.io/todo-app.html");
        //driver.manage().timeouts().implicitlyWait(10, java.util.concurrent.TimeUnit.SECONDS);
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void checkElementCrossed(){
        //Check checkbox of fist item in the list
        WebElement checkbox1 = driver.findElement(By.cssSelector("[name=\"todo-1\"]"));
        checkbox1.click();
        //Check that item is crossed out
        WebElement item1 = driver.findElement(By.cssSelector("[name=\"todo-1\"]~span"));
        assertEquals("done-true", item1.getAttribute("class"));
    }

    @Test
    public void checkElementUncrossedAfterUncheck(){
        //Check checkbox of fist item in the list
        WebElement checkbox1 = driver.findElement(By.cssSelector("[name='todo-1']"));
        checkbox1.click();
        WebElement item1 = driver.findElement(By.cssSelector("[name='todo-1']~span"));
        assertEquals("done-true", item1.getAttribute("class"));
        //Uncheck checkbox of fist item in the list
        checkbox1.click();
        //Check that item is not crossed out
        assertEquals("done-false", item1.getAttribute("class"));
    }



    @Test
    public void crossMultipleElements(){
        //Check checkbox of 3rd item in the list
        //Check checkbox of 5th item in the list
        //Check that 3rd and 5th items are crossed out
        WebElement checkbox3 = driver.findElement(By.cssSelector("[name='todo-3']"));
        checkbox3.click();

        WebElement checkbox5 = driver.findElement(By.cssSelector("[name='todo-5']"));
        checkbox5.click();

        WebElement item3 = driver.findElement(By.cssSelector("[name='todo-3']~span"));
        assertEquals("done-true", item3.getAttribute("class"));

        WebElement item5 = driver.findElement(By.cssSelector("[name='todo-5']~span"));
        assertEquals("done-true", item5.getAttribute("class"));
    }


    //1. Check that all tasks are crossed out after clicking checkbox for each task
    @Test
    public void checkAll(){
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("[type='checkbox']"));
        for (WebElement checkbox : checkboxes) {
            checkbox.click();
        }

        List<WebElement> tasks = driver.findElements(By.cssSelector("[type='checkbox']~span"));
        for (WebElement task : tasks) {
            assertEquals("done-true", task.getAttribute("class"));
        }
    }

    //2. Add all neccecary checks for counting of remaining tasks
    @Test
    public void checkUncheckedTasks() {
        WebElement checkbox1 = driver.findElement(By.cssSelector("[name='todo-1']"));
        checkbox1.click();
        WebElement counterString = driver.findElement(By.className("ng-binding"));
        String counter = counterString.getText();
        System.out.println(counter);
        int indexOf = counter.indexOf("of");
        System.out.println(counter.substring(0, indexOf-1));
        assertEquals("4", counter.substring(0, indexOf - 1));
    }
}
