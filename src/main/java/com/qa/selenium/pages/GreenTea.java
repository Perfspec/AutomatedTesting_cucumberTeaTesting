package com.qa.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GreenTea {

	@FindBy(xpath="//*[@id=\"wsb-element-00000000-0000-0000-0000-000453230000\"]/div/p/span/span/strong")
	private WebElement teaStrong;

	public WebElement getTeaStrong() {
		return teaStrong;
	}
}
