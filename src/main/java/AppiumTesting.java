import java.awt.AWTException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

import io.appium.java_client.android.AndroidDriver;

public class AppiumTesting extends Base {
	public static void main(String args[]) throws MalformedURLException, InterruptedException, AWTException
	{
		DesiredCapabilities cap=new DesiredCapabilities();
        cap.setCapability("platformName","Android");
        cap.setCapability("deviceName","d4a4d1d2");
        cap.setCapability("platformVersion","12");
        cap.setCapability("noReset", "true");
        cap.setCapability("fullReset", "false");
        cap.setCapability("udid", "d4a4d1d2");
//        cap.setCapability("automationName", "uiautomator2");
        cap.setCapability("appPackage", "com.flipkart.android");
        cap.setCapability("appActivity", "com.flipkart.android.activity.HomeFragmentHolderActivity");

       
        URL url=new URL("http://0.0.0.0:4723/wd/hub");
        WebDriver driver=new AndroidDriver(url,cap);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Thread.sleep(9000);
        WebElement e= driver.findElement(By.xpath("//android.widget.TextView[@text='Search for products']"));
        e.click();
        Thread.sleep(3000);
        WebElement e1= driver.findElement(By.xpath("//android.widget.EditText[@text='Search for Products, Brands and More']"));
       e1.sendKeys("poco c31");
     //  driver.sendKeyEvent(84);//84 is the enteeer key value
     
       Actions act=new Actions(driver);
       act.sendKeys(Keys.ENTER).build().perform();
       driver.findElement(By.xpath("//*[@text='POCO C31 (Royal Blue, 64 GB)']")).click();     
      System.out.println("Test Purpose it is execute perfect or not");

      

      
      
      
      
   String visibleText="₹8,999"; 
//    	     ((Object) driver).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+visibleText+"\").instance(0))").click();
//   @SuppressWarnings("deprecation")
//MobileElement eTo = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textContains(\"EMI\"))"));



    	    
//   WebElement element=driver.findElement(By.xpath("//*[@bounds='[44,1669][1080,1735]']"));

      Thread.sleep(3000);
      WebElement s= driver.findElement(By.xpath("//*[@text='₹8,999']"));
      String s2=s.getText();
      String s3="";
      s3=s2.substring(1,6);
      String s4="";
      s4=s3.replaceAll(",", "");
      int flipkart=Integer.parseInt(s4);
      System.out.println( "The Flipkart product price is ="+flipkart);
      
       
     
//       driver.findElement(By.xpath("//android.widget.TextView[@text='Buy now']")).click();
//       Thread.sleep(3000);
//       driver.findElement(By.xpath(" //android.widget.TextView[@text='SKIP & CONTINUE']")).click();
      

       ////////////////////////////////////////AMAZON//////////////////////////////////////////////////////
      
     
    // DesiredCapabilities cap1=new DesiredCapabilities();
     cap.setCapability("platformName","Android");
     cap.setCapability("deviceName","d4a4d1d2");
     cap.setCapability("platformVersion","12");
     cap.setCapability("noReset", "true");
     cap.setCapability("fullReset", "false");
     cap.setCapability("udid", "d4a4d1d2");
     cap.setCapability("appPackage", "in.amazon.mShop.android.shopping");
     cap.setCapability("appActivity", "com.amazon.mShop.splashscreen.StartupActivity");

    
//     URL url1=new URL("http://0.0.0.0:4723/wd/hub");
     WebDriver driver1=new AndroidDriver(url,cap);
//     driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	 WebElement ama= driver1.findElement(By.xpath("//*[@text='Search Amazon.in']"));
     ama.click();
	 ama.sendKeys("poco c31 royal blue 64gb");    
     Actions act1=new Actions(driver1);
     act1.sendKeys(Keys.ENTER).build().perform();
     Thread.sleep(10000);
     driver1.findElement(By.xpath("//*[@text='POCO C31 (Royal Blue, 64 GB) (4 GB RAM)']")).click();
     Thread.sleep(9000);
     WebElement val1=driver1.findElement(By.xpath("//*[@text='-14%₹8,590.00']"));
     String rupees=val1.getText();
     System.out.println(rupees);
     String s20="";
     s20=rupees.substring(5,10);
     String s21="";
     s21=s20.replaceAll(",", "");
     int amazon=Integer.parseInt(s21);
     System.out.println("The Amazon product price is="+amazon);
     System.out.println("                      ----------PRICE COMPARE BETWEEN TWO SITE----------");
     System.out.println();
     if(amazon>flipkart)
     {
    	System.out.println("Flipkart price is less so please refer flipkart product");
    	driver1.quit();
    	System.out.println("Final price is="+flipkart);
     }
     else
     {
    	 System.out.println("Amazon price is small so please refer amazon product");   
    	 System.out.println("Final price is="+amazon);
     }
     
     
	}

}
