package PageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import BaseLayer.BaseClass;
import UtilsLayer.HandleDropDown;

public class RegisterPage extends BaseClass {

	@FindBy(name = "firstname")
	private WebElement fname;

	@FindBy(name = "lastname")
	private WebElement lname;

	@FindBy(name = "reg_email__")
	private WebElement uname;

	@FindBy(name = "reg_passwd__")
	private WebElement pass;

	@FindBy(name = "birthday_day")
	private WebElement date;

	@FindBy(name = "birthday_month")
	private WebElement month;

	@FindBy(name = "birthday_year")
	private WebElement year;

	@FindBy(xpath = "//input[@value='1']")
	private WebElement femaleRadioButton;

	@FindBy(xpath = "//input[@value='2']")
	private WebElement maleRadioButton;

	public RegisterPage() {
		PageFactory.initElements(driver, this);
	}

	public void enterFirstAndLastName(String firstname, String lastname) {
		fname.sendKeys(firstname);
		lname.sendKeys(lastname);
	}

	public void enterUsernameAndPassword(String username, String password) {
		uname.sendKeys(username);
		pass.sendKeys(password);
	}

	public void selectDOB(String Date, String Month, String Year) {

		HandleDropDown.selectByVisibleText(date, Date);
		HandleDropDown.selectByVisibleText(month, Month);
		HandleDropDown.selectByVisibleText(year, Year);

	}

	public void selectGenderAndClickOnRegisterButton(String value) {

		if (value.equals("female")) {
			femaleRadioButton.click();
		} else if (value.equals("male")) {
			maleRadioButton.click();
		}

	}

}
