package automation.uiTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class SimpleTest {

    //объявляем аннотацию тест и его имя
    @Test(description = "Practise form")
    //название метода
    public void loginTest() {
        //указать путь до хромдрайвера
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

        //запустить браузер
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //перейти на страницу в браузере
        driver.get("https://www.tutorialspoint.com/selenium/selenium_automation_practice.htm");

        //ввести имя пользователя
        driver.findElement(By.name("name")).sendKeys(("Masha Kot"));
        //ввести email
        driver.findElement(By.name("email")).sendKeys(("test@mail.ru"));
        //ввести пол
        driver.findElement(By.xpath("//label[text()='Female']/preceding-sibling::input")).click();

        assertEquals(driver.findElement(By.xpath("//h1")).getText(), "Selenium - Automation Practice Form");
        //закрыть браузер
        driver.quit();
    }
}
