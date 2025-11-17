package FLIPKART;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;





public class FLIPKARTPROJECT {
	
	public static void main(String[] args) throws InterruptedException {
		


	System.setProperty("webdriver.firefox.logfile", "/dev/null");// remove logs
	System.setProperty("webdriver.gecko.driver","C:\\Users\\Vinitha\\Selenium\\geckodriver.exe");
	WebDriver driver = new FirefoxDriver();
	
			//----------Task 1: Browser Launch and Page Navigation-----------------
	
			 driver.manage().window().maximize();
				System.out.println("\n--- Task 1 ---"); 
		     driver.get("https://www.flipkart.com");
		
		     System.out.println("Page Title: " + driver.getTitle());
		
		     Thread.sleep(1000);
		     
		     

		  // ---------------Task 2: Handle Login Popup ---------------------
		     System.out.println("\n---- Task 2: Handle Login Popup ----");
		
		     try {
		    	    WebDriverWait wait = new WebDriverWait(driver, 10);
		    	    WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span._30XB9F")));
		    	    closeBtn.click();
		    	    System.out.println("Login popup closed.");
		    	} catch (Exception e) {
		    	    System.out.println("Login popup not displayed or already closed.");
		    	}
		     
		     
		  // Task 3: Search Product
		     System.out.println("\n---- Task 3: Product Search ----");
		   driver.findElement(By.name("q")).sendKeys("mobile"+Keys.ENTER);
		   System.out.println("Searched for: mobile");
		   
		   
		
		   // ----------------Task 4: Capture product listings---------------------
		   
				   System.out.println("\n---- Task 4: Capture Product Listings ----");
				
				// Scroll to load more results
				for (int i = 0; i < 3; i++) {
				    ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 600);");
				    Thread.sleep(1500);
				}
				
				// Strong locator for product titles
				By productTitles = By.xpath("//div[contains(@class,'KzDlHZ') or contains(@class,'_4rR01T')]");
				
				List<WebElement> products = driver.findElements(productTitles);
				
				System.out.println("Total products found: " + products.size());
				
				System.out.println("First 5 product names:");
				for (int i = 0; i < Math.min(5, products.size()); i++) {
				    System.out.println((i + 1) + ". " + products.get(i).getText());
				}
	
				
//				//-----Task 5: Mouse Hover on Electronics-----
				
				System.out.println("\n---- Task 5: Mouse Hover on Electronics ----");

		        driver.get("https://www.flipkart.com/");

		        // Close login popup if it appears
		        try {
		            List<WebElement> popups = driver.findElements(By.cssSelector("span._30XB9F"));
		            if (popups.size() > 0) {
		                popups.get(0).click();
		                System.out.println("Login popup closed.");
		            } else {
		                System.out.println("No login popup appeared.");
		            }
		        } catch (Exception e) {
		            System.out.println("No login popup appeared.");
		        }

		        WebDriverWait wait = new WebDriverWait(driver, 20);

		     // Locate Electronics menu using your recorded CSS
		        WebElement electronicsMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(
		                By.cssSelector("._1ch8e_:nth-child(7) ._3ETuFY")
		        ));

		     // Scroll into view and perform hover
		        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", electronicsMenu);
		        Actions actions = new Actions(driver);
		        actions.moveToElement(electronicsMenu).perform();
		        
		     // Small delay to ensure dropdown stays visible
		        Thread.sleep(2000);


		        // Optional: wait for a submenu item to appear
		        wait.until(ExpectedConditions.visibilityOfElementLocated(
		                By.xpath("//a[contains(@href,'/televisions')]") // example subcategory
		        ));

		        System.out.println("Mouse hover on BEAUTY,FOOD... successful, dropdown visible.");
				
				
				
		   
		     // ----- Task 6: Click on First Product from Search Results -----
		        System.out.println("\n---- Task 6: Click on First Product ----");

		
		     // ----- Click on search box and enter 'mobile' -----
		        WebDriverWait wait1 = new WebDriverWait(driver, 20);
		        WebElement searchBox = wait1.until(ExpectedConditions.elementToBeClickable(By.name("q")));
		        searchBox.click();
		        searchBox.sendKeys("mobile");
		        searchBox.submit();
		        System.out.println("Search submitted for 'mobile'.");
		     // ----- -----Click on the specific product -----
	            WebElement productDiv = wait.until(ExpectedConditions.visibilityOfElementLocated(
	                    By.xpath("//div[@class='KzDlHZ' and text()='IQOO Z10X 5G (Titanium, 128 GB)']"))
	            );

	            // Get parent <a> and its URL
	            WebElement productLink = productDiv.findElement(By.xpath("./ancestor::a"));
	            String productUrl = productLink.getAttribute("href");

	            // Open product in new tab
	            ((JavascriptExecutor) driver).executeScript("window.open(arguments[0], '_blank');", productUrl);
	            System.out.println("Opened product in a new tab: " + productDiv.getText());

	            // ----- Step 4: Switch to the new tab -----
	            String parentWindow = driver.getWindowHandle();
	            Set<String> allWindows = driver.getWindowHandles();
	            for (String window : allWindows) {
	                if (!window.equals(parentWindow)) {
	                    driver.switchTo().window(window);
	                    System.out.println("Switched to product details tab");
	                    break;
	                }
	            }

				
				//-------- TASK 7: Verify Product Details ------ 


				//// Reuse existing wait from Task 6
				System.out.println("\n-------- TASK 7: Verify Product Details --------");

				// Product Name
				WebElement productName = wait1.until(ExpectedConditions.visibilityOfElementLocated(
				        By.cssSelector("span.VU-ZEz")
				));

				// Product Price
				WebElement productPrice = wait1.until(ExpectedConditions.visibilityOfElementLocated(
				        By.cssSelector("div.Nx9bqj.CxhGGd")
				));

				// Print details
				System.out.println("Product Name: " + productName.getText());
				System.out.println("Product Price: " + productPrice.getText());

				
				
				
				// -------- Task 8: Take Screenshot --------
				
				System.out.println("\n--------Take Screenshot  --------");
				
				try {
				    TakesScreenshot ts = (TakesScreenshot) driver;
				    File source = ts.getScreenshotAs(OutputType.FILE);

				    Files.copy(source.toPath(),
				               Paths.get("C:\\Users\\admin\\Desktop\\PROJECT FILE\\flipkart_search.png"),
				               java.nio.file.StandardCopyOption.REPLACE_EXISTING);

				    System.out.println("Screenshot saved successfully!");
				} catch (IOException e) {
				    System.out.println("Error saving screenshot: " + e.getMessage());
				}

				
				
				
				// -------- Task 9: Close Browser --------
				System.out.println("\n-------- TASK 9: Close Browser --------");

				// Close the current browser window
				driver.close();  

				// Quit the WebDriver session completely
				driver.quit();  

				System.out.println("Browser closed and WebDriver session quit successfully!");

				}

	}





