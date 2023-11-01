package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrintAutosuggestions 
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
		driver.findElement(By.name("q")).sendKeys("java");
		Thread.sleep(3000);
		List<WebElement> list = driver.findElements(By.xpath("//span[contains(text(),'java')]"));
		int count = list.size();
		for(int i=0; i<count; i++)
		{
			String text=list.get(i).getText();
			System.out.println(text);
		}
		list.get(0).click();
	}
}
