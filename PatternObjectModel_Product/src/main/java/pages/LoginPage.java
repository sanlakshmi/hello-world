package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import uiObjects.LoginPageObjects;
import wdMethods.ProjectMethods;

public class LoginPage extends ProjectMethods{
	
	public LoginPage() {
		PageFactory.initElements(driver,this);
	}
		
	@FindBy(how=How.LINK_TEXT,using = LoginPageObjects.Login)
	private WebElement Log;
	
	public LoginPage clickLogIn() {
		click(Log);
		return this;	
	
	}
	
	@FindBy(how=How.NAME,using = LoginPageObjects.UserName)
	private WebElement eleUserName;
	
	public LoginPage enterUserName(String data) {
		type(eleUserName, data);
		return this;
	}
	
	
	@FindBy(how=How.NAME,using = LoginPageObjects.Password)
	private WebElement elePassword;
	
	public LoginPage enterPassword(String data) {
		type(elePassword, data);
		return this;
	}
	
	@FindBy(how=How.NAME,using = LoginPageObjects.LoginAs)
	private WebElement eleLoginas;
	
	public LoginPage enterLoginas(String data) {
		type(eleLoginas, data);
		return this;
	}
	
	
	@FindBy(how=How.XPATH,using = LoginPageObjects.LoginSubmit)
	private WebElement eleSubmit;
	
	public NFS_Extraction clicksubmit() {
		click(eleSubmit);
		return new NFS_Extraction();		
	}
	
/*public LoginPage clickLogInForFailer() {
		click(eleLogin);
		return this;		
	}
	
	@FindBy(how=How.ID,using="errorDiv")
	private WebElement eleErrorMsg;
	
	public LoginPage verifyErrorMsg(String data) {
	verifyPartialText(eleErrorMsg, data);
		return this;		
	} */
	
	
}
