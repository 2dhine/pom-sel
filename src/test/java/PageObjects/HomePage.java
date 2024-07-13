package PageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(id="username")
	WebElement userName;
	
	@FindBy(id="password")
	WebElement passWord;

	@FindBy(id="submit")
	WebElement submitButton;
	
	public void enterDetails(String email,String password)
	{
        userName.sendKeys(email);
		passWord.sendKeys(password);
	}
	public void clickButton()
	{
		submitButton.click();
	}

	public void goTo()
	{
		driver.get("https://practicetestautomation.com/practice-test-login/");
	}

}
