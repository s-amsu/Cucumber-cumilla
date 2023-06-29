package step_definitions;

import command_providers.ActOn;
import command_providers.AssertThat;
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

public class ValidateYourServices {
    private static final By clickOnSign = By.xpath("//*[@id=\"login-button\"]/button/span");
    private static final By Username = By.id("cc-username");
    private static final By Password = By.id("cc-user-password");
    private static final By Signin = By.xpath("//*[@id=\"main-content-card\"]/ng-component/div/form/button");
    private static final By YourService = By.xpath("//*[@id=\"spectrum-container\"]/spectrum-header/div/div[2]/spectrum-local-nav/div/div/spectrum-nav-item[3]/div/a/span");
    private static final By Internet = By.xpath("//button[@id='internet-tab']");
    private static final By ViewPlanDetails = By.xpath("//span[contains(text(),'View Plan Details')]");
    private static final By HomePhone = By.xpath("//*[@id=\"voice-tab-np\"]"); //*[@id="card-ele-17"]/div[3]/kite-button[1]/button/span
    private static final By ShopPhones = By.xpath("//span[contains(text(),'Shop Phones')]");
    private static final By TV = By.xpath("//*[@id='tv-tab']");
    private static final By ViewChannelLineup = By.xpath("//*[contains(text(),'View Channel Lineup')]");
    private static final By Mobile = By.xpath("//*[@id='mobile-tab-np']");
    private static final By SeeMyDeals = By.xpath("//*[contains(text(),'See My Deals')]");
    private static final By Billing = By.xpath("//spectrum-header/div[1]/div[2]/spectrum-local-nav[1]/div[1]/div[1]/spectrum-nav-item[2]/div[1]/a[1]/span[1]");
    private static final By PaymentMethods = By.xpath("//button[@id='paymentMethodsTab']");
    private static final By AddPaymentMethod = By.xpath("//button[@id='add-payment-method-btn']");

    private static Logger LOGGER = LogManager.getLogger(ValidateYourServices.class);
    WebDriver driver;
    @Given("^user is on the spectrum home page$")
    public void user_is_on_the_spectrum_home_page() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origin=*");
        driver = new ChromeDriver(chromeOptions);

        ActOn.browser(driver).openBrowser(ReadConfigFiles.getPropertyValues("SpectrumAppURL"));
        LOGGER.info("User is in the Home Page");
    }
    @When("^user click on your services button$")
    public void user_click_on_you_services_button() {
        ActOn.element(driver, clickOnSign).click();
        ActOn.element(driver, Username).setValue("samsulislam30410@gmail.com");
        ActOn.element(driver, Password).setValue("4BerggnfP6jpbZ7");
        ActOn.element(driver, Signin).click();
        ActOn.element(driver,YourService).click();
        LOGGER.info("User has entered credentials");
    }
    @When("^user click on billing option$")
    public void user_click_on_shop_phones_option() {
        ActOn.element(driver, clickOnSign).click();
        ActOn.element(driver, Username).setValue("samsulislam30410@gmail.com");
        ActOn.element(driver, Password).setValue("4BerggnfP6jpbZ7");
        ActOn.element(driver, Signin).click();

        ActOn.element(driver, Billing).click();
        LOGGER.info("User has entered credentials");
    }
    @And("^user click on Internet button$")
    public void user_click_on_home_phones_button() {
        ActOn.element(driver, Internet).click();
        LOGGER.info("User clicked on Internet button");
    }
    @And("^user click on Home Phone button$")
    public void user_click_on_home_phone_button() {
        ActOn.element(driver, HomePhone).click();
        LOGGER.info("User clicked on Home Phones button");
    }
    @And("^user click on TV button$")
    public void user_click_on_tv_button() {
        ActOn.element(driver, TV).click();
        LOGGER.info("User clicked on TV button");
    }
    @And("^user click on Mobile button$")
    public void user_click_on_mobile_button() {
        ActOn.element(driver, Mobile).click();
        LOGGER.info("User clicked on Mobile button");
    }
    @And("^user click on Payment Methods button$")
    public void user_click_on_plans_button () {
        ActOn.element(driver, PaymentMethods).click();
        LOGGER.info("User clicked on Payment Methods button");
    }
    @Then("^user click on View Plan Details button$")
    public void user_click_on_view_plan_details_button() {
        AssertThat.elementAssertions(driver, ViewPlanDetails).elementIsDisplayed();
        LOGGER.info("User clicked on View Plan Details button");
        ActOn.browser(driver).closeBrowser();
    }
    @Then("^user click on ShopPhones button$")
    public void user_click_on_shop_phones_button() {
        AssertThat.elementAssertions(driver, ShopPhones).elementIsDisplayed();
        LOGGER.info("User clicked on Shop Phones button");
        ActOn.browser(driver).closeBrowser();
    }
    @Then("^user click on view  Channel Lineup button$")
    public void user_clicked_on_view_plan_details_options() {
        AssertThat.elementAssertions(driver, ViewChannelLineup).elementIsDisplayed();
        LOGGER.info("User clicked on View Channel Lineup button");
        ActOn.browser(driver).closeBrowser();
    }
    @Then("^user click on See My Deals button$")
    public void user_click_on_see_my_deals_button() {
        AssertThat.elementAssertions(driver, SeeMyDeals).elementIsDisplayed();
        LOGGER.info("User clicked on See My Deals button");
        ActOn.browser(driver).closeBrowser();
    }
    @Then("^user click on Add Payment Method button$")
    public void user_click_on_shop_now_button() {
        AssertThat.elementAssertions(driver, AddPaymentMethod).elementIsDisplayed();
        LOGGER.info("User Add Payment Method Button");
        ActOn.browser(driver).closeBrowser();
    }
}
