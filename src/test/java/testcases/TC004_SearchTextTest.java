package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.SearchPage;
import testbase.BaseClass;
import utilities.DataProviders;

public class TC004_SearchTextTest extends BaseClass{
	@Test(dataProvider="dp1",dataProviderClass=DataProviders.class)
	public void validatesearchtext(String item, String res) {
		try {
		logger.info("----Test Started----");
	    HomePage obj = new HomePage(driver);
	    obj.clearsearch(); // Clear previous search before typing
	    logger.info("----Item Entered----");
	    obj.txtsearch(item);

	    SearchPage obj1 = new SearchPage(driver);
	    obj1.icnsearch();
	    
	    logger.info("----Validation Started-----");
	    if (res.equalsIgnoreCase("valid")) {
	        boolean img = obj1.disimage(); // Only check image
	        Assert.assertEquals(img, true);
	    } else if (res.equalsIgnoreCase("invalid")) {
	        boolean txt = obj1.distext(); // Only check text
	        Assert.assertEquals(txt, true);
	    }
	    logger.info("----Validation ended-----");
	    obj.clearsearch(); // Clear after validation
		}
		
		catch(Exception e) {
			Assert.fail();;
		}
		logger.info("----Test completed----");
	}
	}