package testsuite;

import browserfactory.BaseTest;
import com.google.common.base.Verify;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

/**
 *  BaseUrl = https://demowebshop.tricentis.com/
 *  3. Write down the following test in the ‘LoginTest’ class
 *  1. userShouldNavigateToLoginPageSuccessfully()
 *  * click on the ‘Login’ link
 *  * Verify the text ‘Welcome, Please Sign
 *  In!’
 *  2. userShouldLoginSuccessfullyWithValidCredentials()
 *  * click on the ‘Login’ link
 *  * Enter a valid username
 *  * Enter a valid password
 *  * Click on the ‘Login’ button
 *  * Verify the ‘Welcome to our store’
 *  text is displayed
 *  3. verifyTheErrorMessage()
 *  * click on the ‘Login’ link
 *  * Enter the invalid username
 *Enter the invalid password
 *  * Click on the ‘Login’ button
 *  * Verify the error message ‘Loginwasunsuccessful.
 *  Please correct the errors and try again. No customer account found’
 */

public class LoginTest  extends BaseTest {

    String baseUrl = "https://demowebshop.tricentis.com/";

    //Open Browser
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    //user Should Navigate To Login Page Successfully
    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        //click on login link
        driver.findElement(By.linkText("Log in")).click();

        //* Verify the text ‘Welcome, Please Sign In!’
        String expectedWelcomeText = "Welcome, Please Sign In!";
        String actualWelcomeText = driver.findElement(By.xpath("//h1")).getText();
        Assert.assertEquals("Welcome Message is not displayed", expectedWelcomeText, actualWelcomeText);

    }

    //user Should Login Successfully With Valid Credentials
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //click on login link
        driver.findElement(By.linkText("Log in")).click();

        //enter valid username and password in to Email and Password field.
        driver.findElement(By.id("Email")).sendKeys("mytestac20@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("Rudraa123w");

        //click on login button
        driver.findElement(By.xpath("//div[@class='buttons']/input[@value='Log in']")).click();

        String expectedLoggedInText = "Welcome to our store";
        String actualLoggedInText = driver.findElement(By.xpath("//div[@class='page-body']/div[2]//h2")).getText();
        Assert.assertEquals("content header is not displayed", expectedLoggedInText, actualLoggedInText);
    }


    //verifyTheErrorMessage()
    @Test
    public void verifyTheErrorMessage() {
        // Click on login link
        driver.findElement(By.linkText("Log in")).click();

        // Enter Invalid username and password into Email and Password fields.
        driver.findElement(By.id("Email")).sendKeys("invalidEmail@example.com");
        driver.findElement(By.id("Password")).sendKeys("InvalidPassword");

        // Click on login button
        driver.findElement(By.xpath("//div[@class='buttons']/input[@value='Log in']")).click();

        // Verify the error message
        String expectedErrorMessage = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";
        String actualErrorMessage = driver.findElement(By.xpath("//div[@class='validation-summary-errors']")).getText();
        Assert.assertEquals("Error Message is not displayed", expectedErrorMessage, actualErrorMessage);
    }



    // Close Browser
    @After
    public void tearDown() {
        closeBrowser(); // Using the closeBrowser method from BaseTest
    }
}



