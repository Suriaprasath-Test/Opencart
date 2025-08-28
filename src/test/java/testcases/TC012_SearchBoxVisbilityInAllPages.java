package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.SearchPage;
import testbase.BaseClass;

public class TC012_SearchBoxVisbilityInAllPages extends BaseClass{
	@Test
	public void searchboxvalidation() {
		try {
		SearchPage obj=new SearchPage(driver);
		String [] urls= {
				"https://tutorialsninja.com/demo/index.php?route=product/category&path=57",
				"https://tutorialsninja.com/demo/index.php?route=product/category&path=17",
				"https://tutorialsninja.com/demo/index.php?route=product/category&path=24",
				"https://tutorialsninja.com/demo/index.php?route=product/category&path=33"
		};
		
		HomePage obj1=new HomePage(driver);
		
		for(String url:urls) {
			driver.get(url);
			boolean box=obj1.issearchboxdisplayed();
			boolean button=obj.issearchbuttondisplayed();
			Assert.assertEquals(box, true);
			Assert.assertEquals(button, true);
		}
		}
		catch(Exception e) {
			Assert.fail();
		}
		}
		
	}

