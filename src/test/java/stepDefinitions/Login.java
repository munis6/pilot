package stepDefinitions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {
	
	WebDriver driver;
	
	@Given("the user is on the nopCommerce login page")
	public void navigate_To_login_page() {
		
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
		System.out.println("application launched sucessfully");
	}

	@When("the user enters valid credentials \\(username: {string}, password: {string})")
	public void enter_UserID_And_Pass(String user, String pwd) {
		
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(user);
		
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(pwd);
		
		System.out.println("entered valid userID and password");
	    
	}

	@When("the user clicks on the Login button")
	public void click_on_login_button() {
		
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		System.out.println("clicked on login button");
	}

	@Then("the user should be redirected to the My Account page")
	public void validate_my_account_page() {
		
		 boolean status=driver.findElement(By.xpath("//*[@id=\"content\"]/h2[1]")).isDisplayed();
		 
		 System.out.println("My Account text is displayed");
		 
		 Assert.assertEquals(status,true);   
	}

	@Then("the user should see a welcome message")
	public void the_user_should_see_a_welcome_message() {
		
		driver.findElement(By.xpath("//*[@id='column-right']/div/a[13]")).click();
		
		System.out.println("clicked on logout button");
		
		driver.quit();
	}


}
