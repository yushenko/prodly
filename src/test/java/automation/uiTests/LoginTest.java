package automation.uiTests;

import automation.AbstractTest;
import automation.ConfProperties;
import automation.modalPages.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.nio.file.Paths;

public class LoginTest extends AbstractTest {
    public static String NAME = ConfProperties.getProperty("name");
    public static String EMAIL = ConfProperties.getProperty("email");
    public static String URL = ConfProperties.getProperty("loginpage");


    public static String absolutePath;
    public static LoginPage loginPage;

    @BeforeMethod
    public void preconditions() {
        setUp();
        loginPage = new LoginPage(driver);
        String relativePath = ConfProperties.getProperty("file"); // Пример: ваш файл здесь
        absolutePath = Paths.get(relativePath).toAbsolutePath().toString();
    }

    @AfterMethod
    public void tearDown() {
        shoutDown();
    }

    @Test(description = "Practise form")
    public void loginTest() throws InterruptedException {
        loginPage.inputFirstName(NAME);
        loginPage.inputEmail(EMAIL);
        loginPage.chooseGender("Female");
        loginPage.inputMobile("+79872304241");
        loginPage.inputDate("09/11/2017");
        loginPage.inputSubject("Automation Tester");
        loginPage.uploadPicture(absolutePath);
        loginPage.chooseDropdownContinentField().selectValueInSelectedDropdown("NCR");
        loginPage.chooseDropdownCity().selectValueInSelectedDropdown("Agra");
        loginPage.clickSubmitBtn();
    }
}