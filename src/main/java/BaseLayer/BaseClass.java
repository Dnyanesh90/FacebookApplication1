package BaseLayer;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	protected static WebDriver driver;
	protected static Properties prop;

	public BaseClass() {
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\java\\ConfigLayer\\config.properties");
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected static void initialization(String browser) {
		
		
		if (browser.equals("chrome")) {
//			System.setProperty("webdriver.chrome.driver",
//					System.getProperty("user.dir") + "\\AllBrowserDrivers\\chromedriver.exe");
//			driver = new ChromeDriver();
			ChromeDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);

		} 
		else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} 
//		else if (browser.equals("opera")) {
//			WebDriverManager.operadriver().setup();
//			driver = new OperaDriver();}
	 else {
			System.out.println("Please Enter valid browser name");
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		String url = prop.getProperty("url");

		driver.get(url);
	}

}
