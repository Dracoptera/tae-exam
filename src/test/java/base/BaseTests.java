package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pages.HomePage;

public class BaseTests {
    private WebDriver driver;

    // HomePage instance is protected so test classes that inherit from this one will have access to it
    protected HomePage homePage;

    // Run the setup before any Classes execute their Tests
    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.travelocity.com/");
        driver.manage().window().maximize();

        homePage = new HomePage(driver);
    }

//    @AfterClass
//    public void tearDown() {
//        driver.quit();
//    }

}
