package PROGRESS;

import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class hello {
	static int x,y;
	void m4(int z)
	{
		x=z;	
	}
	void m55(int z1)
	{
		y=z1;
	}
	public int  m1()
	{
		
		System.setProperty("webdriver.chrome.driver", "C:\\browserdrivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize(); 
		driver.get("https://demoqa.com/widgets");
		JavascriptExecutor js=(JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,400)","");
        js.executeScript("window.scrollBy(0,400)","");
        driver.findElement(By.xpath("//span[text()='Slider']")).click();
        WebElement wb3=driver.findElement(By.xpath("//span[@class='range-slider__wrap']"));
        Actions act=new Actions(driver);
        act.dragAndDropBy(wb3, 89, 97).build().perform(); 
        act.dragAndDropBy(wb3, -23, 30).build().perform();
        WebElement wb6=driver.findElement(By.className("form-control"));
        String ss=wb6.getAttribute("value");
        System.out.println("Slider value: "+ss);
        int b=Integer.parseInt(ss);
		return b;
	}	
	@Test
	public void m2()
	{
		hello h1=new hello();
		h1.main(null);
		int excepted=x;
		int actual=y;
		//System.out.println(x);
		assertEquals(actual,excepted);		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub		 
		  hello h=new hello();
		  int va=h.m1(); 
		  h.m4(va);
		  int va1=h.m1();
		  h.m55(va1);
	}

}
