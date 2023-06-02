package DesignPatterns.FactoryPattern;

public class DriverManagerFactory {

public static DriverManager getManager(DriverType type) {
		DriverManager driverManager = null;

			switch (type) {
				case CHROME:
					driverManager = new ChromeDriverManager(); 
				case FIREFOX:
					//driverManager = new FirefoxDriverManager(); 
					driverManager = new ChromeDriverManager(); 
				case EDGE:
					//driverManager = new EdgeDriverManager(); 
					driverManager = new ChromeDriverManager(); 
				default:
					break;
			}
			return driverManager;
	}
}