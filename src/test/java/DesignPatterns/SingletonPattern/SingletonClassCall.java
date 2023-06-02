/**
 * 
 */
package DesignPatterns.SingletonPattern;

import org.openqa.selenium.WebDriver;

/**
 * @author Kamaljit_Singh
 *
 */
public class SingletonClassCall {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SingletonBrowserClass sbc1= SingletonBrowserClass.getInstanceOfSingletonBrowserClass();
		WebDriver driver1 = sbc1.getDriver();
		driver1.get("https://www.google.com");
		//driver1.
		
		
		SingletonBrowserClass sbc2= SingletonBrowserClass.getInstanceOfSingletonBrowserClass();
		WebDriver driver2 = sbc2.getDriver();
		driver2.get("https://www.facebook.com");
		
		//Explanation: When you run above program, you will get print “Object created.” only once while you have instantiated class twice.
		//This is because of singleton pattern. It will not create object of class again if already initialized once.

	}

}
