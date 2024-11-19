package browserfactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

/**
 *  Project-1- ProjectName : com-tricentis-sw-2
 *  BaseUrl = https://demowebshop.tricentis.com/
 *  1. Create the package ‘browserfactory’ and create the
 *  class with the name ‘BaseTest’ inside the
 *  ‘browserfactory’ package. And write the browser setup
 *  code inside the class ‘BaseTest’.
 */

public class BaseTest {
    //instance to share among all the classes
    public static WebDriver driver;

    //method to setup browser
    public void openBrowser(String baseUrl){
        //initilized chromedriver
        driver = new ChromeDriver();
        //navigate to baseUrl
        driver.get(baseUrl);
        //to maximize the opened window
        driver.manage().window().maximize();
        // set up implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    // method to close browser
    public void closeBrowser(){
        // close browser
        driver.quit();
    }

}
