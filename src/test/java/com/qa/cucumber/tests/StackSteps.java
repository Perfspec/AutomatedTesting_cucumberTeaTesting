package com.qa.cucumber.tests;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.selenium.pages.Checkout;
import com.qa.selenium.pages.GreenTea;
import com.qa.selenium.pages.Menu;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StackSteps {
	
	private String url;
	private WebDriver driver;
	
	@Before
	public void setup() {

		System.setProperty("webdriver.chrome.driver", "C:/Users/Admin/Downloads/chromedriver_win32/chromedriver.exe");

		driver = new ChromeDriver();

		// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.manage().window().maximize();

	}
	
	@After
	public void teardown() throws InterruptedException {
		driver.quit();
	}
	
	@Given("^the correct web address$")
	public void the_correct_web_address() {
		url = "http://www.practiceselenium.com/welcome.html";
	}

	@When("^I navigate to the 'Menu' page$")
	public void i_navigate_to_the_Menu_page() {
	    driver.get(url);
	    Menu menu = PageFactory.initElements(driver, Menu.class);
	    menu.getHyperlink().click();
	}

	@Then("^I can browse a list of the available products\\.$")
	public void i_can_browse_a_list_of_the_available_products() {
	    GreenTea gt = PageFactory.initElements(driver, GreenTea.class);
	    assertEquals(true, gt.getTeaStrong().isDisplayed());
	}

	@When("^I click the checkout button$")
	public void i_click_the_checkout_button() {
	    driver.get(url);
	    Checkout checkout = PageFactory.initElements(driver, Checkout.class);
	    checkout.getHyperlink().click();
	}

	@Then("^I am taken to the checkout page$")
	public void i_am_taken_to_the_checkout_page() {
	    assertEquals("http://www.practiceselenium.com/check-out.html",driver.getCurrentUrl());
	}


}
