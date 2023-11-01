package selenium;


import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertPopup 
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
		driver.findElement(By.xpath("//a[text()='Alert with OK ']")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert a=driver.switchTo().alert();
		String text = a.getText();
		a.accept();
		System.out.println(text);
		driver.close();
	}
}
