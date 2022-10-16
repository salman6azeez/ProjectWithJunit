package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import projectWithJunit.DashboardPage;
import projectWithJunit.ListOfCheckBoxPage;
import util.BrowserFactory;

	
public class RemoveSingleItemTest {
	
	
		WebDriver driver;
		DashboardPage dashboardPage;
		
		ListOfCheckBoxPage listOfCheckBoxPage;
		
		@Before
		public void removeSingleItemTest() {
			driver = BrowserFactory.init();
			listOfCheckBoxPage = PageFactory.initElements(driver, ListOfCheckBoxPage.class);
			
		}
		
		@Test
		public void clickOneItemToRemove() {
			listOfCheckBoxPage.clickItemTodo();
			try {
				Thread.sleep(3000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			listOfCheckBoxPage.clickRemoveButton();
			Assert.assertTrue("the Item was   removed Successfully", true);
			
		}
	
	
	}
