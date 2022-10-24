package nextbatch;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Flightscom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.gecko.driver", "executable path");
		//Launch the browser
		WebDriver driver=new FirefoxDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.get("http://flights.qedgetech.com/");
		// click on  Registration
		driver.findElement(By.linkText("Register")).click();
		//Enter the registration details
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Allu");
		driver.findElement(By.xpath("//input[@placeholder=\"Contact Number\"]")).sendKeys("9665732521");
		driver.findElement(By.xpath("//input[@placeholder=\"Email\"]")).sendKeys("billadhanunjaya8247@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder=\"Password\"]")).sendKeys("Allu@0666");
		Select df=new Select(driver.findElement(By.name("gender")));
		df.selectByIndex(1);
		//Select the date of birth
	driver.findElement(By.xpath("//input[@id='popupDatepicker']")).click();
		Select month=new Select(driver.findElement(By.xpath("//select[@data-handler=\"selectMonth\"]")));
		month.selectByVisibleText("Sep");
		Select year=new Select(driver.findElement(By.xpath("//select[@data-handler=\"selectYear\"]")));
		year.selectByValue("1999");
		String date="14";
		List<WebElement>alldates=driver.findElements(By.xpath("//table[@class=\"ui-datepicker-calendar\"]/tbody"));
		for(WebElement ele:alldates)
		{
			String dt=ele.getText();
			if(dt.equals(date))
			{
				ele.click();
				break;
			}
		}
		//check the check box
		driver.findElement(By.xpath("//input[@class=\"form-check-input\"]")).click();
		//click on regestration
		driver.findElement(By.name("submit")).click();
	}

}
