package TestLayer;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import BaseLayer.BaseClass;
import PageLayer.RegisterPage;

public class RegisterPageTest extends BaseClass {

	private RegisterPage registerpage;

	@BeforeTest
	@Parameters({ "browser" })
	public void setUp(String abc) {
		BaseClass.initialization(abc);
	}

	@Test
	public void validateRegisterFunctionality() {
		registerpage = new RegisterPage();
		registerpage.enterFirstAndLastName("Ajit", "Patil");
		registerpage.enterUsernameAndPassword(prop.getProperty("uname"), prop.getProperty("pass"));
		registerpage.selectDOB("10", "Dec", "1997");
		registerpage.selectGenderAndClickOnRegisterButton("female");
	}
	
	@AfterTest
	public void tearDown()
	{
		
	}

}
