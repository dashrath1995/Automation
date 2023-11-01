package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GenderRadioButtonAlignment 
{
	static
	{
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com");
		driver.findElement(By.xpath("//a[text()='Create new account']")).click();
		Thread.sleep(5000);
		int f=driver.findElement(By.xpath("//label[text()='Female']")).getLocation().getY();
		int m=driver.findElement(By.xpath("//label[text()='Male']")).getLocation().getY();
		int c=driver.findElement(By.xpath("//label[text()='Custom']")).getLocation().getY();
		if(f==m && m==c && c==f)
		{
			System.out.println("gender button is properly aligned");
		}
		else
		{
			System.out.println("Not aligned");
		}
		driver.close();
	}
}
