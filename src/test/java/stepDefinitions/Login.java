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
		//driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
		driver.get("https://practicetestautomation.com/practice-test-login/");
		System.out.println("application launched sucessfully");
	}

	/*
	@When("the user enters valid credentials \\(username: {string}, password: {string})")
	public void enter_UserID_And_Pass(String user, String pwd) {
		
		//driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(user);
		
		//driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(pwd);
		
		//System.out.println("entered valid userID and password");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(user);
		
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pwd);
	    
	}
	*/
	
	@When("the user enters valid credentials \\(username:{string}, password: {string})")
	public void the_user_enters_valid_credentials_username_password(String user, String pwd) {
	    
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(user);
		
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pwd);
	    
	}
	

	@When("the user clicks on the Login button")
	public void click_on_login_button() {
		
		//driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		//System.out.println("clicked on login button");
		driver.findElement(By.xpath("//button[@id='submit']")).click();
		
	}

	@Then("the user should be redirected to the My Account page")
	public void validate_my_account_page() {
		 
		boolean status1=driver.findElement(By
				.xpath("//h1[normalize-space()='Logged In Successfully']")).isDisplayed();
		
		boolean status2=driver.findElement(By
				.xpath("//strong[contains(text(),'Congratulations student. You successfully logged i')]")).isDisplayed();
		
		boolean status3=driver.findElement(By
				.xpath("//a[normalize-space()='Log out']")).isDisplayed();
		 //System.out.println("My Account text is displayed");
		 
		 Assert.assertEquals(status1,true); 
		 Assert.assertEquals(status2,true);
		 Assert.assertEquals(status3,true);
		 
	}

	@Then("the user should see a welcome message")
	public void the_user_should_see_a_welcome_message() {
		
		driver.findElement(By.xpath("//a[normalize-space()='Log out']")).click();
				
		driver.quit();
	}


}
