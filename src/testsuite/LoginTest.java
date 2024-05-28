package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class LoginTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    //1. User should navigate to Log in page successfully
    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        //Find the login link element and click on login link element
        WebElement loginLInk = driver.findElement(By.linkText("Log in"));//finding the locator
        loginLInk.click();
        String expectedText = "Welcome, Please Sign In!";
        WebElement welcomeTextElement = driver.findElement(By.xpath("//h1"));
        String actualText = welcomeTextElement.getText();
        Assert.assertEquals("Not redirected to login page", expectedText, actualText);
    }

    //2. Successfully login using valid credentials
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Find the login click and click on login link element
        WebElement loginLink = driver.findElement(By.linkText("Log in"));//finding the locator
        loginLink.click();
        //Find the email field element and type the email address
        WebElement emailField = driver.findElement(By.id("Email"));
        emailField.sendKeys("dhflamingo@gmail.com");
        //Find the password field and type the password into password field.
        driver.findElement(By.name("Password")).sendKeys("flamingo");
        //Find the login button and click on it
        driver.findElement(By.xpath("//button[text() = 'Log in']")).click();
        //Verify the ‘Log out’ text is display
        driver.findElement(By.linkText("Log out")).getText();
    }

    // 3. verify the error message after the invalid credentials.
    @Test
    public void verifyTheErrorMessage() {
        //Click on Login button
        driver.findElement(By.linkText("Log in")).click();
        //Enter valid username
        driver.findElement(By.id("Email")).sendKeys("Prime123@gmail.com");
        //Enter valid password
        driver.findElement(By.name("Password")).sendKeys("Prime123");
        //Click on Login button
        driver.findElement(By.xpath("//button[text() = 'Log in']")).click();
        //Verify the error message "Login was unsuccessful. Please correct the errors and try again. No customer account found."
        String expectedErrorMessage = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";

        String actualErrorMessage = driver.findElement(By.xpath("//div[@class = 'message-error validation-summary-errors']")).getText();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
    }


    @After
    public void tearDown() {
        closeBrowser();
    }


}


