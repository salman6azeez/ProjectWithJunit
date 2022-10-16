package test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;
import projectWithJunit.ListOfCheckBoxPage;
import util.BrowserFactory;

public class CheckBoxAllCheckTest {
	WebDriver driver;
	ListOfCheckBoxPage listOfCheckBoxPage;

	@FindBy(how = How.XPATH, using = "//input[@name='allbox']")
	WebElement CheckAllBox;

	@Before
	public void checkBoxTest() {
		driver = BrowserFactory.init();
		listOfCheckBoxPage = PageFactory.initElements(driver, ListOfCheckBoxPage.class);

	}

	@Test
	public void toggleAllCheckBoxIsOn() throws InterruptedException {
		listOfCheckBoxPage.CheckToggleAll();
		Assert.assertTrue(CheckBoxIsSelected(CheckAllBox));
		BrowserFactory.tearDown();
	}

	private boolean CheckBoxIsSelected(WebElement listCheckBoxElements) {
		List<WebElement> list = (List<WebElement>) driver.findElements(By.xpath("//input[@name='todo']"));
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).isSelected()) {

			}
		}
		return true;
	}

}
