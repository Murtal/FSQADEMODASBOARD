package Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoDashboard {

	private WebDriver driver;

	public void testLinks() throws InterruptedException {

		//instantiate chrome as browser
		System.setProperty("webdriver.chrome.driver","/opt/Libraries/chromedriver");
		driver = new ChromeDriver();
		
		Actions action = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		//go to:
		driver.get("https://dashboard.fullscreen.net/");
		WebDriverWait wait = new WebDriverWait(driver, 30);

		//maximize window
		driver.manage().window().maximize(); 

		// log in
		driver.findElement(By.id("user_email")).sendKeys("fsstaff01@mail.com");
		driver.findElement(By.id("user_password")).clear();
		driver.findElement(By.id("user_password")).sendKeys("fstester");
		driver.findElement(By.name("commit")).click();

		Thread.sleep(5000);
		
		//click apps
		driver.findElement(By.id("fs-tour-tools")).click();

		js.executeScript(" alert( 'Testing Gorilla!' );");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath("//*[@id='fs-content']/div/ul[1]/li[1]/a/img")).click();

		// click My campaigns
		Thread.sleep(5000);
		driver.findElement(By.linkText("My Campaigns")).click();
		Thread.sleep(5000);
		driver.findElement(By.linkText("Top Gorilla Videos")).click();
		
		/// play a video
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='fs-main-content']/div[2]/div[2]/div[6]/a/img[1]")).click();
		
		//focus on video frame
		String mainwindow = driver.getWindowHandle();
		WebElement container = driver.findElement(By.className("fancybox-inner"));
		WebElement frame = container.findElement(By.tagName("iframe"));

		driver.switchTo().frame(frame);
		Thread.sleep(3000);
		js.executeScript("return document.player1.mute();");
		Thread.sleep(3000);
		js.executeScript("return document.player1.pauseVideo();");
		Thread.sleep(3000);
		// close frame
		driver.switchTo().window(mainwindow);
		driver.findElement(By.xpath("html/body/div[6]/div/div/a")).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".fancybox-overlay.fancybox-overlay-fixed")));

		//go back to main window
		driver.switchTo().window(mainwindow);
		js.executeScript(" alert( 'Gorilla Success!' );");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		
		// go back to apps
		driver.findElement(By.id("fs-tour-tools")).click();
		
		// click audio library
		Thread.sleep(5000);
		js.executeScript(" alert( 'Audio Library!' );");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath("//*[@id='fs-content']/div/ul[1]/li[2]/a/img")).click();
		Thread.sleep(5000);
		
		// play song
		driver.findElement(By.xpath("//*[@id='am-splash-column-1']/li[4]/div[2]/a")).click();
		Thread.sleep(5000);
		js.executeScript(" alert( 'Audio Library Success !' );");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		
		// go back to apps
		driver.findElement(By.id("fs-tour-tools")).click();

		// click facebook app
		Thread.sleep(3000);
		js.executeScript(" alert( 'FaceBook Tab!' );");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Thread.sleep(5000);

		driver.findElement(By.xpath("//*[@id='fs-content']/div/ul[1]/li[3]/a/img")).click();
		Thread.sleep(3000);
		js.executeScript(" alert( 'Facebook Tab: Success!' );");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Thread.sleep(5000);

		driver.findElement(By.linkText("fs staff")).click();
		Thread.sleep(5000);

		// log out
		WebElement toElement = driver.findElement(By.xpath("//*[@id='fs-session-nav']/li[3]/a"));
		action.moveToElement(toElement);
		action.build().perform();
		WebElement toElement1 = driver.findElement(By.xpath("//*[@id='fs-session-nav-dropdown-logout']/a"));

		action.moveToElement(toElement1).click();
		action.build().perform();

		//close browser
		js.executeScript(" alert( 'Done! Browser will be closed' );");
		Thread.sleep(5000);
		driver.switchTo().alert().accept();
		driver.quit();

	}
}



// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='//*[@id='fs-content']/div/ul[1]']"))).isDisplayed();

