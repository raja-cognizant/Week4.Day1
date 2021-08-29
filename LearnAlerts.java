package Week4.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnAlerts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.leafground.com/pages/Alert.html");
		driver.findElementByXPath("//button[text()='Alert Box']").click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		driver.findElementByXPath("//button[text()='Confirm Box']").click();
		alert.accept();
		String result = driver.findElementById("result").getText();
		if(result.equals("You pressed OK!"))
		{
			System.out.println("OK Button was clicked on the Alert");
		}
		else
		{
			System.out.println("Cancel Button was clicked on the Alert");
		}
		driver.findElementByXPath("//button[text()='Prompt Box']").click();
		alert.sendKeys("cogni");
		alert.accept();
	}

}
