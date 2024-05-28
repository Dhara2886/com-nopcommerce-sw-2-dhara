package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import java.time.Duration;

public class RegisterTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    //1. User Should Navigate To Register Page Successfully
    @Test
    public void userShouldNavigateToRegisterPageSuccessfully() {
        driver.findElement(By.className("ico-register")).click();
        String actualText = driver.findElement(By.linkText("Register")).getText();
        Assert.assertEquals("Register", actualText);
    }

    //2. User Should Register Account Successfully
    @Test
    public void userSholdRegisterAccountSuccessfully() {
        driver.findElement(By.className("ico-register")).click();
        driver.findElement(By.id("gender-female")).click();
        driver.findElement(By.name("FirstName")).sendKeys("Dhara");
        driver.findElement(By.name("LastName")).sendKeys("Patel");
        driver.findElement(By.name("DateOfBirthDay")).sendKeys("28");
        driver.findElement(By.name("DateOfBirthMonth")).sendKeys("May");
        driver.findElement(By.name("DateOfBirthYear")).sendKeys("1987");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(By.id("Email")).sendKeys("dhara.patel@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("Prime@123");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("Prime@123");
        driver.findElement(By.id("register-button")).click();
        String actualText = driver.findElement(By.xpath("//div[@class='result']")).getText();
        Assert.assertEquals("Your registration completed", actualText);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
