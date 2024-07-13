package stepDefinitions;
import PageObjects.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;
import java.time.Duration;

public class BaseTest {

	public WebDriver driver;

	public WebDriver initializeDriver() throws IOException
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		driver = new ChromeDriver(options);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;

	}@BeforeMethod(alwaysRun=true)
	public HomePage launchApplication() throws IOException
	{

		driver = initializeDriver();
		HomePage homePage = new HomePage(driver);
		homePage.goTo();
		return homePage;


	}
	@AfterMethod(alwaysRun=true)
	public void tearDown()
	{
		driver.close();
	}
}
