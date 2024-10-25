package stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class MyStepDefs {

    private WebDriver driver;

    // Navigates to the New Supporter Account page
    @Given("I am on the {string} page")
    public void iAmOnThePage(String pageUrl) {
        driver = new ChromeDriver();
        // Uses the full URL instead of the variable pageUrl
        driver.get("https://membership.basketballengland.co.uk/NewSupporterAccount");
    }

    // Sets the user's date of birth
    @And("I set my date of birth to {string}")
    public void iSetMyDateOfBirthTo(String date) {
        driver.findElement(By.id("dp")).sendKeys(date);
    }

    // Enters the first name
    @And("I enter {string} as my first name")
    public void iEnterAsMyFirstName(String name) {
        driver.findElement(By.id("member_firstname")).sendKeys(name);
    }

    // Enters the last name
    @And("I enter {string} as my last name")
    public void iEnterAsMyLastName(String lastname) {
        driver.findElement(By.id("member_lastname")).sendKeys(lastname);
    }

    // Enters the email address
    @And("I enter {string} as my email address")
    public void iEnterAsMyEmailAddress(String email) {
        driver.findElement(By.id("member_emailaddress")).sendKeys(email);
    }

    // Confirms the email address
    @And("I confirm my email address with {string}")
    public void iConfirmMyEmailAddressWith(String confirmEmail) {
        driver.findElement(By.id("member_confirmemailaddress")).sendKeys(confirmEmail);
    }

    // Enters the password
    @And("I enter {string} as my password")
    public void iEnterAsMyPassword(String password) {
        driver.findElement(By.id("signupunlicenced_password")).sendKeys(password);
    }

    // Confirms the password
    @And("I confirm my password with {string}")
    public void iConfirmMyPasswordWith(String confirmPassword) {
        driver.findElement(By.id("signupunlicenced_confirmpassword")).sendKeys(confirmPassword);
    }

    // Agrees to the terms and conditions
    @And("I agree to the terms and conditions")
    public void iAgreeToTheTermsAndConditions() {
        driver.findElement(By.cssSelector(".md-checkbox > .md-checkbox:nth-child(1) .box")).click();
    }

    // Verifies that the user is 18 years old
    @And("I verify that I am {int}")
    public void iVerifyThatIAm(int age) {
        driver.findElement(By.cssSelector(".md-checkbox:nth-child(2) > label > .box")).click();
    }

    // Agrees to the code of ethics and conduct
    @And("I agree to the code of ethics and conduct")
    public void iAgreeToTheCodeOfEthicsAndConduct() {
        driver.findElement(By.cssSelector(".md-checkbox:nth-child(7) .box")).click();
    }

    // Clicks the specified button
    @When("I click the {string} button")
    public void iClickTheButton(String buttonName) {
        driver.findElement(By.name(buttonName)).click();
    }

    // Verifies that the registration was successful
    @Then("My registration is successful and verified with {string}")
    public void myRegistrationIsSuccessfulAndVerifiedWith(String confirmationText) {
        String actualText = driver.findElement(By.cssSelector(".bold:nth-child(1)")).getText();
        assertThat(actualText, is(confirmationText));
        driver.quit();
    }

    // Verifies that the registration fails with the expected error message
    @Then("My registration should fail with the error message: {string}")
    public void myRegistrationShouldFailWithTheErrorMessage(String errorMessage) {
        String actualText = driver.findElement(By.cssSelector(".warning > span")).getText();
        assertThat(actualText, is(errorMessage));
        driver.quit();
    }

    // Verifies that registration fails because the password confirmation is missing
    @Then("Registration failure due to missing password confirmation: {string}")
    public void registrationFailureDueToMissingPasswordConfirmation(String errorMessage) {
        String actualText = driver.findElement(By.cssSelector(".warning > span")).getText();
        assertThat(actualText, is(errorMessage));
        driver.quit();
    }

    // Verifies that registration fails due to missing terms and conditions agreement
    @Then("Registration failure due to missing terms and conditions agreement: {string}")
    public void registrationFailureDueToMissingTermsAndConditionsAgreement(String errorMessage) {
        String actualText = driver.findElement(By.cssSelector(".warning > span")).getText();
        assertThat(actualText, is(errorMessage));
        driver.quit();
    }
}
