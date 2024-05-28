package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class TopMenuTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    //1. User should navigate to Computer page successfully
    @Test
    public void userShouldNavigateToComputerPageSuccessfully() {
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Computers ']")).click();
        //Click on the Computers Tab
        String actualMessage = driver.findElement(By.xpath("//h1[text()='Computers']")).getText(); //Verify the text ‘Computers’
        Assert.assertEquals("Computers", actualMessage);
    }

    //2. User should navigate to Electronics Page successfully
    @Test
    public void userShouldNavigateToElectronicsPageSuccessfully() {
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(), 'Electronics')]")).click(); //Click on the Electronics Tab
        String actualMessage = driver.findElement(By.xpath("//h1[contains(text(), 'Electronics')]")).getText(); //Verify the text 'Electronics'
        Assert.assertEquals("Electronics", actualMessage);
    }

    //3. User should navigate to Apparel Page successfully
    @Test
    public void userShouldNavigateToApparelPageSuccessfully() {
        driver.findElement(By.linkText("Apparel")).click();//Click on the Apparels Tab
        String actualMessage = driver.findElement(By.className("page-title")).getText();//Verify the text 'Apparels'
        Assert.assertEquals("Apparel", actualMessage);
    }

    //4.User Should Navigate To Digital Downloads Page Successfully
    @Test
    public void userShouldNavigateToDigitalDownloadsPageSuccessfully(){
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']")).click();
        String actualMessage = driver.findElement(By.xpath("//h1[text()='Digital downloads']")).getText();
        Assert.assertEquals("Digital downloads", actualMessage);
    }

    //5. User Should Navigate To Books Page Successfully
    @Test
    public void userShouldNavigateToBooksPageSuccessfully(){
        driver.findElement(By.linkText("Books")).click();
        //driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Books']")).click();
        String actualText = driver.findElement(By.xpath("//h1[text()='Books']")).getText();
        Assert.assertEquals("Books",actualText);
    }

    //6. User Should Navigate To Jewelry Page Successfully
    @Test
    public void userShouldNavigateToJewelryPageSuccessfully(){
        driver.findElement(By.linkText("Jewelry")).click();
        //driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Jewelry']")).click();
        String actualText = driver.findElement(By.xpath("//h1[text()='Jewelry']")).getText();
        Assert.assertEquals("Jewelry",actualText);
    }

    //7. User Should Navigate To GiftCards Page Successfully
    @Test
    public void userShouldNavigateToGiftCardsPageSuccessfully(){
        driver.findElement(By.linkText("Gift Cards")).click();
        //driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Gift Cards']")).click();
        String actualText = driver.findElement(By.xpath("//h1[text()='Gift Cards']")).getText();
        Assert.assertEquals("Gift Cards", actualText);
    }
    @After
    public void tearDown() {
        closeBrowser();
    }
}
