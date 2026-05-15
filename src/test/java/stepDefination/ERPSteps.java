package stepDefination;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ERPSteps {
	WebDriver driver;
	String expected = "";
	String actual = "";
	@Given("User is on the login page")
	public void adminLogin() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://webapp.qedgetech.com/");
		// Write code here that turns the phrase above into concrete actions
		throw new cucumber.api.PendingException();
	}

	@When("User enters username {string} and password {string}")
	public void user_enters_username_and_password(String user, String pass) {
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys(user);
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(pass);
		// Write code here that turns the phrase above into concrete actions
		throw new cucumber.api.PendingException();
	}

	@When("click on Login button")
	public void click_on_Login_button() {
		driver.findElement(By.name("btnsubmit")).click();
		// Write code here that turns the phrase above into concrete actions
		throw new cucumber.api.PendingException();

	}

	@Then("Dashboard should be displayed")
	public void dashboard_should_be_displayed() {
		if (driver.findElement(By.xpath("//span[@id='ewPageCaption']")).isDisplayed()) {
			System.out.println("Dashboard page Displayed");
		}
		// Write code here that turns the phrase above into concrete actions
		throw new cucumber.api.PendingException();
	}

	@When("user should navigate to add supplier page")
	public void user_should_navigate_to_add_supplier_page() throws Throwable {
		driver.findElement(By.xpath("//li[@id='mi_a_suppliers']//a[@href='a_supplierslist.php'][normalize-space()='Suppliers']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='panel-heading ewGridUpperPanel']//span[@class='glyphicon glyphicon-plus ewIcon']")).click();
		Thread.sleep(1000);
		// Write code here that turns the phrase above into concrete actions
		throw new cucumber.api.PendingException();
	}

	@When("user capture supplier number")
	public void user_capture_supplier_number() {
		expected = driver.findElement(By.name("x_Supplier_Number")).getAttribute("value");


		// Write code here that turns the phrase above into concrete actions
		throw new cucumber.api.PendingException();
	}

	@When("User enters Supplier Details {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
	public void user_enters_Supplier_Details(String sname, String address, String city, String country, String cperson, String pnumber, String email, String mnumber, String notes) {
		// Write code here that turns the phrase above into concrete actions

		driver.findElement(By.name("x_Supplier_Name")).sendKeys(sname);
		driver.findElement(By.name("x_Address")).sendKeys(address);
		driver.findElement(By.name("x_City")).sendKeys(city);
		driver.findElement(By.name("x_Country")).sendKeys(country);
		driver.findElement(By.name("x_Contact_Person")).sendKeys(cperson);
		driver.findElement(By.name("x_Phone_Number")).sendKeys(pnumber);
		driver.findElement(By.name("x__Email")).sendKeys(email);
		driver.findElement(By.name("x_Mobile_Number")).sendKeys(mnumber);
		driver.findElement(By.name("x_Notes")).sendKeys(notes);
		throw new cucumber.api.PendingException();
	}

	@When("user click add button")
	public void user_click_add_button() throws Throwable {
		driver.findElement(By.id("btnAction")).click();
		Thread.sleep(1000);
		// Write code here that turns the phrase above into concrete actions
		throw new cucumber.api.PendingException();
	}

	@When("user click confirm ok button")
	public void user_click_confirm_ok_button() {
		driver.findElement(By.xpath("//button[normalize-space()='OK!']")).click();
		// Write code here that turns the phrase above into concrete actions
		throw new cucumber.api.PendingException();
	}

	@When("user click alert ok button")
	public void user_click_alert_ok_button() {
		driver.findElement(By.xpath("//button[@class='ajs-button btn btn-primary']")).click();
		// Write code here that turns the phrase above into concrete actions
		throw new cucumber.api.PendingException();
	}

	@When("user search for supplier number")
	public void user_search_for_supplier_number() throws Throwable {
		if (!driver.findElement(By.xpath("//input[@id='psearch']")).isDisplayed())
			driver.findElement(By.xpath("//button[@class='btn btn-default ewSearchToggle active']")).click();
		driver.findElement(By.xpath("//input[@id='psearch']")).clear();
		driver.findElement(By.xpath("//input[@id='psearch']")).sendKeys(expected);
		driver.findElement(By.xpath("//button[@id='btnsubmit']")).click();
		Thread.sleep(2000);


		// Write code here that turns the phrase above into concrete actions
		throw new cucumber.api.PendingException();
	}

	@Then("user verifies supplier number in table")
	public void user_verifies_supplier_number_in_table() {
		actual = driver.findElement(By.xpath("//table[@class = 'table ewTable']/tbody/tr[1]/td[6]/div/span/span")).getText();
		Reporter.log(expected+"      "+actual,true);
		try {
			Assert.assertEquals(actual, expected, "supplier number not found in table");
		} catch (AssertionError e) {
			Reporter.log(e.getMessage(),true);
			// TODO: handle exception
		}
		// Write code here that turns the phrase above into concrete actions
		throw new cucumber.api.PendingException();
	}

	@When("user close browser")
	public void user_close_browser() {
		driver.quit();
		// Write code here that turns the phrase above into concrete actions
		throw new cucumber.api.PendingException();
	}




}
