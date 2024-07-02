package myProject;
import java.util.*;  

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;	


public class MyClass {

	 @Test
	 public void testHomePage()throws InterruptedException, AWTException {
//	public static void main(String[] args) throws InterruptedException, AWTException {

		Map<String, String> mobileEmulation = new HashMap<>();
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\A15930\\Documents\\Selenium\\drivers\\chromedriver.exe");

		mobileEmulation.put("deviceName", "Nexus 5");

		ChromeOptions chromeOptions = new ChromeOptions();

		chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
		
//		WebDriver chrome = new ChromeDriver();
		WebDriver chrome = new ChromeDriver(chromeOptions);
		
		Robot robot = new Robot();
		
//     	go to Aakash Homepage
		chrome.get("https://www.aakash.ac.in");
		chrome.manage().window().maximize();
		
//     	click on Login Button on Homepage
		
//		chrome.findElement(By.cssSelector("#block-useraccountmenu-3 > ul > li:nth-child(1) > a")).click();
		
		chrome.findElement(By.cssSelector("#block-useraccountmenu-3")).click();
		
		chrome.findElement(By.cssSelector("#block-myaccountblock-2 > div > a:nth-child(1)")).click();
		
     
//     	Filling the User Details (userName And Password)
		chrome.findElement(By.cssSelector("#psid_or_mobile")).sendKeys("8178486066");
		chrome.findElement(By.cssSelector("#password")).sendKeys("Abhinav");
     
//     	Click on login button on Login Page
		chrome.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div[3]/form/button")).click();
     
//    	wait 
		Thread.sleep(7000);
     
//		chrome.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div[1]/div/div/a/picture/img")).click();
		chrome.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div[2]/div[1]/div/div[1]")).click();
		Thread.sleep(1000);
		
		chrome.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div[2]/div/div/a/picture/img")).click();
		
		Thread.sleep(3000);
		
//		chrome.switchTo().alert().dismiss();
		
		robot.mouseMove(50, 195);
		Thread.sleep(1000);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	
		
//		 for(int i=0;i<2500;i++) {
//		        ((JavascriptExecutor) chrome).executeScript("window.scrollBy(0,2)", "");
//		    }	
     
	}
}
