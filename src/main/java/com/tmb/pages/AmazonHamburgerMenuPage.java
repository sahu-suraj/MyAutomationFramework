package com.tmb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tmb.driver.DriverManager;
import com.tmb.enums.WaitStrategy;
import com.tmb.utils.DynamicXpathUtils;

public class AmazonHamburgerMenuPage extends BasePage {
	
	
	
	//private String linksubMenu =  "//div[text()='Mobiles, Computers']/parent::a";
	
	
	@FindBy(id ="//div[text()='Mobiles, Computers']/parent::a")
	private WebElement linkMobileAndComputers;
	
	@FindBy(id ="//a[text()='Laptops']")
	private WebElement linkLaptops;
	
	
	private String linkSubMenu = "//a[text()='%s']";
	
	public void clickSubMenu(String menutext) {
		//String newxpath = linkSubMenu.replace("", menutext);
		String newxpath = DynamicXpathUtils.getXpath(linkSubMenu, menutext);
		click(By.xpath(newxpath), WaitStrategy.CLICKABLE, menutext);
	}
	
	public AmazonHamburgerMenuPage() {
		PageFactory.initElements(DriverManager.getDriver(), this);
	}

	
	public AmazonHamburgerMenuPage	clickAmazonHamburgerMenuPage() {
		click(By.xpath("//div[text()='Mobiles, Computers']/parent::a"), WaitStrategy.CLICKABLE, "abc");
		//linkMobileAndComputers.click();
		return this;
	}
	
	public AmazonLaptopPage clickLaptopLink() {
		linkLaptops.click();
		return new AmazonLaptopPage();
	}
	
}
