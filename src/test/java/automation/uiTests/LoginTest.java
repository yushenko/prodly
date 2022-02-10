package automation.uiTests;

import automation.AbstractTest;
import automation.modalPages.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends AbstractTest {
    public static LoginPage loginPage;

    @BeforeMethod
    public void preconditions() {
        setUp();
    }

    @AfterMethod
    public void tearDown() {
        shoutDown();
    }

    @Test(description = "Practise form")
    public void loginTest() {
        loginPage = new LoginPage(driver);
        loginPage.inputFirstName("Mariia");
        loginPage.inputLastName("Iushchenko");
        loginPage.chooseGender("Female");
        loginPage.chooseExperience("5");
        loginPage.inputDate("09/11/2017");
        loginPage.chooseProfession("Automation Tester");
        loginPage.chooseTool("Selenium Webdriver");
        loginPage.chooseDropdownContinentField().selectValueInSelectedDropdown("Europe");
        loginPage.chooseDropdownSeleniumCommandField().selectValueInSelectedDropdown("Browser Commands");
        loginPage.clickSubmitBtn();
    }
}