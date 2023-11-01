package selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertPopupOkAndcancel 
{
	static
	{
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}
	public static void main(String[] args)
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.automationtesting.in/Alerts.html");
		driver.findElement(By.xpath("//a[text()='Alert with OK & Cancel ']")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().dismiss();
		String text = driver.findElement(By.xpath("//p[text()='You Pressed Cancel']")).getText();
		System.out.println(text);
		driver.close();

	}
}
