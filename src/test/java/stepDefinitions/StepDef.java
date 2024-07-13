package stepDefinitions;
import PageObjects.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.time.Duration;

public class StepDef extends BaseTest{
    public HomePage homePage;
    @Given("Open Web Page")
    public void openWebpage() throws IOException {
        homePage = launchApplication();
    }

    @When("Logged in with username (.+) and password (.+)$")
    public void loggedInWithUsernameNameAndPasswordPassword(String username, String password) {
        homePage.enterDetails(username, password);
    }

    @Then("message is displayed")
    public void messageIsDisplayed() {
        homePage.clickButton();
    }
    @Then("^\"([^\"]*)\" message is displayed$")
    public void message_displayed_confirmationPage (String string) throws Throwable
    {
        homePage.clickButton();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String text = driver.findElement(By.id("error")).getText();
        String text1 = driver.findElement(By.xpath("//div[@id='error']")).getText();
    }
}
