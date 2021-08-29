package Week4.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnFrames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
		WebElement frame1 = driver.findElementByXPath("//div[@id='iframewrapper']/iframe");
		driver.switchTo().frame(frame1);
		driver.findElementByXPath("//button[text()='Try it']").click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		String text = driver.findElementById("demo").getText();
		if(text.equals("You pressed OK!")) {
			System.out.println("The Action performed was: 'OK'");
		}
		else {
			System.out.println("The Action performed was: 'Cancel'");
		}
		driver.switchTo().defaultContent();
				
	}

}
