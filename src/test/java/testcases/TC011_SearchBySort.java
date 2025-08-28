package testcases;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.SearchPage;
import testbase.BaseClass;

public class TC011_SearchBySort extends BaseClass {

    @Test
    public void sortsearch() throws InterruptedException {
        // Step 1: Search for "mac"
        HomePage obj = new HomePage(driver);
        obj.txtsearch("mac");

        SearchPage obj2 = new SearchPage(driver);
        obj2.icnsearch();

        // Step 2: Locate the "Sort By" dropdown
        WebElement sortDropdown = driver.findElement(By.id("input-sort"));
        Select select = new Select(sortDropdown);

        // Step 3: Get all available options
        List<WebElement> options = select.getOptions();

        // Step 4: Iterate through all sorting options
        for (int i = 0; i < options.size(); i++) {
            // Re-locate the dropdown each time
            WebElement sortDropdown1 = driver.findElement(By.id("input-sort"));
            Select select1 = new Select(sortDropdown1);

            String optionText = select1.getOptions().get(i).getText();
            System.out.println("Testing option: " + optionText);

            // Select the sort option
            select1.selectByIndex(i);

            // Wait for products to reload
            new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='caption']//h4/a")));

            // Re-locate product elements after sorting
            List<WebElement> productElements = driver.findElements(By.xpath("//div[@class='caption']//h4/a"));
            List<String> productNames = new ArrayList<>();
            for (WebElement product : productElements) {
                productNames.add(product.getText().trim());
            }

   

            // ✅ Validation logic (simplified demo)
            if (optionText.contains("Name (A - Z)")) {
                List<String> normalized = new ArrayList<>();
                for (String name : productNames) {
                    normalized.add(name.toLowerCase().trim());
                }

                List<String> sorted = new ArrayList<>(normalized);
                Collections.sort(sorted);

                Assert.assertEquals(normalized, sorted, 
                    "Products are NOT sorted correctly in A-Z order. Expected: " + sorted + " but found: " + normalized);
            }
            else if (optionText.contains("Name (Z - A)")) {
                List<String> normalized = new ArrayList<>();
                for (String name : productNames) {
                    normalized.add(name.toLowerCase().trim());
                }

                List<String> sorted = new ArrayList<>(normalized);
                Collections.sort(sorted, Collections.reverseOrder());

                Assert.assertEquals(normalized, sorted, 
                    "Products are NOT sorted correctly in Z-A order. Expected: " + sorted + " but found: " + normalized);
            }

        }
    }
}

