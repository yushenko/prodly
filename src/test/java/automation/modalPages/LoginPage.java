package automation.modalPages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private static final By FIRST_NAME_FIELD = By.name("firstname");
    private static final By LAST_NAME_FIELD = By.name("lastname");
    private static final String GENDER_CHECKBOX = "//input[contains(@name,'sex')][contains(@value,'%s')]";
    private static final String EXP_CHECKBOX = "//input[contains(@name,'exp')][contains(@value,'%s')]";
    private static final By DATE_FIELD = By.xpath("//strong[contains(text(),'Date')]//..//..//input");
    private static final String PROFESSION_CHECKBOX = "//input[contains(@name,'profession')][contains(@value,'%s')]";
    private static final String TOOL_CHECKBOX = "//input[contains(@name,'tool')][contains(@value,'%s')]";
    private static final By CONTINENT_FIELD = By.name("continents");
    private static final String SELECT_DROPDOWN_VALUE_LOCATOR = "//option[text()='%s']";
    private static final By SELENIUM_COMMAND_FIELD = By.name("selenium_commands");
    private static final By SUBMIT_BUTTON = By.name("submit");

    protected final WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void scrollTo() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
    }

    @Step
    public void inputFirstName(String login) {
        driver.findElement(FIRST_NAME_FIELD).sendKeys(login);
    }

    @Step
    public void inputLastName(String login) {
        driver.findElement(LAST_NAME_FIELD).sendKeys(login);
    }

    @Step
    public void chooseGender(String gender) {
        driver.findElement(By.xpath(String.format(GENDER_CHECKBOX, gender))).click();
    }

    @Step
    public void chooseExperience(String exp) {
        scrollTo();
        driver.findElement(By.xpath(String.format(EXP_CHECKBOX, exp))).click();
    }

    @Step
    public void inputDate(String date) {
        driver.findElement(DATE_FIELD).sendKeys(date);
    }

    @Step
    public void chooseProfession(String profession) {
        driver.findElement(By.xpath(String.format(PROFESSION_CHECKBOX, profession))).click();
    }

    @Step
    public void chooseTool(String tool) {
        driver.findElement(By.xpath(String.format(TOOL_CHECKBOX, tool))).click();
    }

    @Step
    public LoginPage chooseDropdownContinentField() {
        driver.findElement(CONTINENT_FIELD).click();
        return this;
    }

    @Step
    public LoginPage chooseDropdownSeleniumCommandField() {
        driver.findElement(SELENIUM_COMMAND_FIELD).click();
        return this;
    }

    @Step
    public void selectValueInSelectedDropdown(String value) {
        driver.findElement(By.xpath(String.format(SELECT_DROPDOWN_VALUE_LOCATOR, value))).click();
    }

    @Step
    public void clickSubmitBtn() {
        driver.findElement(SUBMIT_BUTTON).click();
    }
}
