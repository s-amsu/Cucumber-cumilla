package step_definitions;

import command_providers.ActOn;
import command_providers.AssertThat;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utilities.ReadConfigFiles;

import java.util.List;
import java.util.Map;

public class LoginStep {
    private static final By clickOnSign = By.xpath("//*[@id=\"login-button\"]/button/span");
    private static final By Username = By.id("cc-username");
    private static final By Password = By.id("cc-user-password");
    private static final By Signin = By.xpath("//*[@id=\"main-content-card\"]/ng-component/div/form/button");

    private static final By Makepayment = By.xpath("//*[@id=\"homepage-core-cta-make-a-payment-button\"]/button/span");
    private static final By InvalidPassword = By.xpath("//*[@id='cc-user-password']");

    private static Logger LOGGER = LogManager.getLogger(LoginStep.class);//*[@id="homepage-core-cta-make-a-payment-button"]/button/span
    WebDriver driver;
    @Given("^user is on the login page$")
    public void user_is_on_the_login_page() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origin=*");
        driver = new ChromeDriver(chromeOptions);

        ActOn.browser(driver).openBrowser(ReadConfigFiles.getPropertyValues("SpectrumAppURL"));
        LOGGER.info("User is in the login Page");
    }
    @When("^user enters username \"(.+?)\" and password \"(.+?)\"$")
    public void user_enters_username_and_password(String username, String password) {
        ActOn.element(driver, clickOnSign).click();
        ActOn.element(driver, Username).setValue(username);
        ActOn.element(driver,Password).setValue(password);
        LOGGER.info("User has entered credentials");
    }
    @When("^user click on login button upon entering credentials$")
    public void user_click_on_signin_button_upon_entering_credentials(DataTable table){
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        for (Map<String, String> cells: data) {
            ActOn.element(driver, clickOnSign).click();
            ActOn.element(driver, Username).setValue(cells.get("username"));
            ActOn.element(driver, Password).setValue(cells.get("password"));
            LOGGER.info("User has entered credentials");

            ActOn.element(driver, Signin).click();
            LOGGER.info("User clicked on signin button");
        }
    }
    @And("^click on signin button$")
    public void click_on_login_button() {
        ActOn.element(driver, Signin).click();
        LOGGER.info("User clicked on signin button");
    }
    @Then("^user is navigated to home page$")
    public void user_is_navigated_to_home_page() {
        AssertThat.elementAssertions(driver,Makepayment).elementIsDisplayed();
        LOGGER.info("User is in home page");
        ActOn.browser(driver).closeBrowser();
    }
    @Then("^user is failed to login$")
    public void validateUserIsFailedToLogin(){
        AssertThat.elementAssertions(driver, InvalidPassword).elementIsDisplayed();
        LOGGER.info("User is still on the login page");
        ActOn.browser(driver).closeBrowser();
    }
}
