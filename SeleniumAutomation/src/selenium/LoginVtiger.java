package selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginVtiger 
{
	static
	{
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("manager");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.xpath("//img[@id='jscal_trigger_birthday']")).click();

		String monthYear="December, 2019";
		String day="10";
		while(true)
		{
			String monthYearText= driver.findElement(By.xpath("//div[@class='calendar']/descendant::td[2]")).getText();
			if(monthYearText.equals(monthYear))
			{
				break;
			}
			else
			{
				driver.findElement(By.xpath("//div[@class='calendar']/descendant::tr[@class='headrow']/td[2]")).click();
			}
		}
		Thread.sleep(5000);
		driver.findElement(By.xpath("//tr[@class='daysrow']/td[@class='day'and contains(text(),"+day+")]")).click();



	}
}