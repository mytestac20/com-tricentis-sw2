package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

/*5. Write down the following test in the ‘RegisterTest’
class
 1. userShouldNavigateToRegisterPageSuccessfully()
 * click on the ‘Register’ link
 * Verify the text ‘Register’
        2. userSholdRegisterAccountSuccessfully
 * click on the ‘Register’ link
 * Select the gender radio button
 * Enter the First name
* Enter the Last name
 * Enter Email address
 * Enter Password
 * Enter Confirm password
 * Click on the ‘Register’ button
 * Verify the text 'Your registration completed
 */

public class RegisterTest extends BaseTest {
    String baseUrl = "https://demowebshop.tricentis.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    //user Should Navigate To Register Page Successfully
    @Test
    public void userShouldNavigateToRegisterPageSuccessfully() {
        //click on registration link
        driver.findElement(By.linkText("Register")).click();

        //Verify the text as registered
        String expectedText = "Register";
        String actualText = driver.findElement(By.xpath("//h1")).getText();
        Assert.assertEquals("Register text is not displayed", expectedText, actualText);
    }

    @Test
    public void userShouldRegisterAccountSuccessfully() {
        //click on registration link
        driver.findElement(By.linkText("Register")).click();

        //Select the gender radio button
        driver.findElement(By.id("gender-female")).click();

        //Enter the First name
        driver.findElement(By.id("FirstName")).sendKeys("Manmeet");

        //Enter the Last name
        driver.findElement(By.id("LastName")).sendKeys("kaur");

        //Enter Email address
        driver.findElement(By.id("Email")).sendKeys("mytestac20@gmail.com");

        //Enter Password
        driver.findElement(By.id("Password")).sendKeys("Rudraa123w");

        //Enter Confirm password
        driver.findElement(By.id("ConfirmPassword")).sendKeys("Rudraa123w");

        //Click on register button
        driver.findElement(By.id("register-button")).click();

        //Verify the text
        String expectedText= "Your registration completed";
        String actualText=driver.findElement(By.xpath("//div[@class='result']")).getText();
        Assert.assertEquals("Register completed message is not displayed",  expectedText,actualText);

    }


    @After
    public void tearDown() {
        closeBrowser();
    }
}


