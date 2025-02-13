package automation.modalPages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private static final By FIRST_NAME_FIELD = By.name("name");
    private static final By EMAIL_FIELD = By.name("email");
    private static final By MOBILE_FIELD = By.name("mobile");
    private static final By PICTURE_UPLOAD_BTN = By.name("picture");
    private static final String genderCheckBox = "//label[text()='%s']/preceding-sibling::input";
    private static final By SUBJECT_FIELD = By.name("subjects");
    private static final By DATE_FIELD = By.name("dob");
    private static final By STATE_DROPDOWN = By.name("state");
    private static final String country = "//option[@value='%s']";
    private static final String PROFESSION_CHECKBOX = "//input[contains(@name,'profession')][contains(@value,'%s')]";
    private static final String TOOL_CHECKBOX = "//input[contains(@name,'tool')][contains(@value,'%s')]";
    private static final By CONTINENT_FIELD = By.name("continents");
    private static final String SELECT_DROPDOWN_VALUE_LOCATOR = "//option[text()='%s']";
    private static final By CITY = By.name("city");
    private static final By SUBMIT_BUTTON = By.xpath("//input[@type='submit']");

    protected final WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void scrollTo() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, -10000)");
    }

    @Step
    public void inputFirstName(String login) {
        driver.findElement(FIRST_NAME_FIELD).sendKeys(login);
    }

    @Step
    public void inputEmail(String email) {
        driver.findElement(EMAIL_FIELD).sendKeys(email);
    }

    @Step
    public void inputMobile(String mobile) {
        driver.findElement(MOBILE_FIELD).sendKeys(mobile);
    }

    @Step
    public void uploadPicture(String path) {
        driver.findElement(PICTURE_UPLOAD_BTN).sendKeys(path);
    }

    @Step
    public void inputSubject(String value) {
        driver.findElement(SUBJECT_FIELD).sendKeys(value);
    }

    @Step
    public void chooseGender(String gender) {
        driver.findElement(By.xpath(String.format(genderCheckBox, gender))).click();
    }

    @Step
    public void chooseCountry(String value) {
        driver.findElement(By.xpath(String.format(country, value))).click();
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
    public LoginPage chooseDropdownContinentField() throws InterruptedException {
        scrollTo();
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
        Thread.sleep(100);
        driver.findElement(STATE_DROPDOWN).click();
        return this;
    }

    @Step
    public LoginPage chooseDropdownCity() {
        driver.findElement(CITY).click();
        return this;
    }

    @Step
    public void selectValueInSelectedDropdown(String value) {
        driver.findElement(By.xpath(String.format(country, value))).click();
    }

    @Step
    public void clickSubmitBtn() {
        driver.findElement(SUBMIT_BUTTON).click();
    }
}
