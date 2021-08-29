package Week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Irctc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.irctc.co.in/");
		driver.findElementByXPath("//button[text()='OK']").click();
		driver.findElementByXPath("(//div[@class='h_container_sm']/div)[2]/a").click();
		driver.findElementByXPath("//label[text()='FLIGHTS']").click();
		Set<String> wHandles = driver.getWindowHandles();
		List<String> listOfHandles = new ArrayList<String>(wHandles);
		driver.switchTo().window(listOfHandles.get(1));
		String text = driver.findElementByXPath("//a[contains(text(),'flights@irctc.co.in')]").getText();
		System.out.println(text);
		driver.switchTo().window(listOfHandles.get(0));
		driver.close();
	}

}
