package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class QspidersAutosuggestions 
{
	static
	{
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}
	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		driver.findElement(By.name("q")).sendKeys("qspiders");
		Thread.sleep(3000);
		List<WebElement> autoSugg = driver.findElements(By.xpath("//span[contains(text(),'QSpiders')]"));
		int count=autoSugg.size();
		for(int i=0; i<count; i++)
		{
			String text=autoSugg.get(i).getText();
			System.out.println(text);
		}
		autoSugg.get(count-1).click();
	}
}
