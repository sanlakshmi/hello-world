package wdMethods;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Reporter;

public class SeMethods extends Reporter implements WdMethods{

	public static RemoteWebDriver driver;
	public String sUrl,sHubUrl,sHubPort;
	public Properties prop;
	
	public SeMethods() {
		prop = new Properties();
		try {
			prop.load(new FileInputStream(new File("./src/main/resources/config.properties")));
			sHubUrl = prop.getProperty("HUB");
			sHubPort = prop.getProperty("PORT");
			sUrl = prop.getProperty("URL");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void startApp(String browser, boolean bRemote) {
		try {
			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setBrowserName(browser);
			dc.setPlatform(Platform.WINDOWS);
			// this is for grid run
			if(bRemote)
				try {
					driver = new RemoteWebDriver(new URL("http://"+sHubUrl+":"+sHubPort+"/wd/hub"), dc);
				} catch (MalformedURLException e) {
				}
			else{ // this is for local run
				if(browser.equalsIgnoreCase("chrome")){
					System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
					driver = new ChromeDriver();
				}else {
					System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
					driver = new FirefoxDriver();
				}
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(sUrl);
			reportStep("The browser: "+browser+" launched successfully", "PASS");
		} catch (WebDriverException e) {			
			reportStep("The browser: "+browser+" could not be launched", "FAIL");
		}
	}

	public void startApp(String browser) {
		startApp(browser, false);
	}

	public WebElement locateElement(String locator, String locValue) {
		try {
			switch(locator) {
			case("id"): return driver.findElementById(locValue);
			case("link"): return driver.findElementByLinkText(locValue);
			case("xpath"):return driver.findElementByXPath(locValue);
			case("name"): return driver.findElementByName(locValue);
			case("class"): return driver.findElementByClassName(locValue);
			case("tag"):return driver.findElementByTagName(locValue);
			}
		} catch (NoSuchElementException e) {
			reportStep("The element with locator "+locator+" not found.","FAIL");
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while finding "+locator+" with the value "+locValue, "FAIL");
		}
		return null;
	}

	public WebElement locateElement(String locValue) {
		return driver.findElementById(locValue);
	}

	public void type(WebElement ele, String data) {
		try {
			ele.clear();
			ele.sendKeys(data);
//			String x = ""+ele;
			reportStep("The data: "+data+" entered successfully in the field :"+ele, "PASS");
		} catch (InvalidElementStateException e) {
			reportStep("The data: "+data+" could not be entered in the field :"+ele,"FAIL");
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while entering "+data+" in the field :"+ele, "FAIL");
		}
	}

	public void click(WebElement ele) {
		String text = "";
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(ele));			
			text = ele.getText();
			ele.click();
			reportStep("The element "+text+" is clicked", "PASS");
		} catch (InvalidElementStateException e) {
			reportStep("The element: "+text+" could not be clicked", "FAIL");
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while clicking in the field :", "FAIL");
		} 
	}

	public void clickWithNoSnap(WebElement ele) {
		String text = "";
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(ele));	
			text = ele.getText();
			ele.click();			
			reportStep("The element :"+text+"  is clicked.", "PASS",false);
		} catch (InvalidElementStateException e) {
			reportStep("The element: "+text+" could not be clicked", "FAIL",false);
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while clicking in the field :","FAIL",false);
		} 
	}

	public String getText(WebElement ele) {	
		String bReturn = "";
		try {
			bReturn = ele.getText();
		} catch (WebDriverException e) {
			reportStep("The element: "+ele+" could not be found.", "FAIL");
		}
		return bReturn;
	}
	
	public String getTitle() {		
		String bReturn = "";
		try {
			bReturn =  driver.getTitle();
		} catch (WebDriverException e) {
			reportStep("Unknown Exception Occured While fetching Title", "FAIL");
		} 
		return bReturn;
	}

	public String getAttribute(WebElement ele, String attribute) {		
		String bReturn = "";
		try {
			bReturn=  ele.getAttribute(attribute);
		} catch (WebDriverException e) {
			reportStep("The element: "+ele+" could not be found.", "FAIL");
		} 
		return bReturn;
	}

	public void selectDropDownUsingText(WebElement ele, String value) {
		try {
			new Select(ele).selectByVisibleText(value);
			reportStep("The dropdown is selected with text "+value,"PASS");
		} catch (WebDriverException e) {
			reportStep("The element: "+ele+" could not be found.", "FAIL");
		}

	}

	public void selectDropDownUsingIndex(WebElement ele, int index) {
		try {
			new Select(ele).selectByIndex(index);
			reportStep("The dropdown is selected with index "+index,"PASS");
		} catch (WebDriverException e) {
			reportStep("The element: "+ele+" could not be found.", "FAIL");
		} 

	}

	public boolean verifyTitle(String title) {
		boolean bReturn =false;
		try {
			if(getTitle().equals(title)) {
				reportStep("The title of the page matches with the value :"+title,"PASS");
				bReturn= true;
			}else {
				reportStep("The title of the page:"+driver.getTitle()+" did not match with the value :"+title, "FAIL");
			}
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while verifying the title", "FAIL");
		} 
		return bReturn;
	}

	public void verifyExactText(WebElement ele, String expectedText) {
		try {
			if(getText(ele).equals(expectedText)) {
				reportStep("The text: "+getText(ele)+" matches with the value :"+expectedText,"PASS");
			}else {
				reportStep("The text "+getText(ele)+" doesn't matches the actual "+expectedText,"FAIL");
			}
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while verifying the Text", "FAIL");
		} 

	}

	public void verifyPartialText(WebElement ele, String expectedText) {
		try {
			if(getText(ele).contains(expectedText)) {
				reportStep("The expected text contains the actual "+expectedText,"PASS");
			}else {
				reportStep("The expected text doesn't contain the actual "+expectedText,"FAIL");
			}
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while verifying the Text", "FAIL");
		} 
	}

	public void verifyExactAttribute(WebElement ele, String attribute, String value) {
		try {
			if(getAttribute(ele, attribute).equals(value)) {
				reportStep("The expected attribute :"+attribute+" value matches the actual "+value,"PASS");
			}else {
				reportStep("The expected attribute :"+attribute+" value does not matches the actual "+value,"FAIL");
			}
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while verifying the Attribute Text", "FAIL");
		} 

	}

	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
		try {
			if(getAttribute(ele, attribute).contains(value)) {
				reportStep("The expected attribute :"+attribute+" value contains the actual "+value,"PASS");
			}else {
				reportStep("The expected attribute :"+attribute+" value does not contains the actual "+value,"FAIL");
			}
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while verifying the Attribute Text", "FAIL");
		}
	}

	public void verifySelected(WebElement ele) {
		try {
			if(ele.isSelected()) {
				reportStep("The element "+ele+" is selected","PASS");
			} else {
				reportStep("The element "+ele+" is not selected","FAIL");
			}
		} catch (WebDriverException e) {
			reportStep("WebDriverException : "+e.getMessage(), "FAIL");
		}
	}

	public void verifyDisplayed(WebElement ele) {
		try {
			if(ele.isDisplayed()) {
				reportStep("The element "+ele+" is visible","PASS");
			} else {
				reportStep("The element "+ele+" is not visible","FAIL");
			}
		} catch (WebDriverException e) {
			reportStep("WebDriverException : "+e.getMessage(), "FAIL");
		} 
	}

	public void switchToWindow(int index) {
		try {
			Set<String> allWindowHandles = driver.getWindowHandles();
			List<String> allHandles = new ArrayList<>();
			allHandles.addAll(allWindowHandles);
			driver.switchTo().window(allHandles.get(index));
		} catch (NoSuchWindowException e) {
			reportStep("The driver could not move to the given window by index "+index,"PASS");
		} catch (WebDriverException e) {
			reportStep("WebDriverException : "+e.getMessage(), "FAIL");
		}
	}

	public void switchToFrame(WebElement ele) {
		try {
			driver.switchTo().frame(ele);
			reportStep("switch In to the Frame "+ele,"PASS");
		} catch (NoSuchFrameException e) {
			reportStep("WebDriverException : "+e.getMessage(), "FAIL");
		} catch (WebDriverException e) {
			reportStep("WebDriverException : "+e.getMessage(), "FAIL");
		} 
	}

	public void acceptAlert() {
		String text = "";		
		try {
			Alert alert = driver.switchTo().alert();
			text = alert.getText();
			alert.accept();
			reportStep("The alert "+text+" is accepted.","PASS");
		} catch (NoAlertPresentException e) {
			reportStep("There is no alert present.","FAIL");
		} catch (WebDriverException e) {
			reportStep("WebDriverException : "+e.getMessage(), "FAIL");
		}  
	}

	public void dismissAlert() {
		String text = "";		
		try {
			Alert alert = driver.switchTo().alert();
			text = alert.getText();
			alert.dismiss();
			reportStep("The alert "+text+" is dismissed.","PASS");
		} catch (NoAlertPresentException e) {
			reportStep("There is no alert present.","FAIL");
		} catch (WebDriverException e) {
			reportStep("WebDriverException : "+e.getMessage(), "FAIL");
		} 

	}

	public String getAlertText() {
		String text = "";		
		try {
			Alert alert = driver.switchTo().alert();
			text = alert.getText();
		} catch (NoAlertPresentException e) {
			reportStep("There is no alert present.","FAIL");
		} catch (WebDriverException e) {
			reportStep("WebDriverException : "+e.getMessage(), "FAIL");
		} 
		return text;
	}

	public long takeSnap(){
		long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L; 
		try {
			FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE) , new File("./reports/images/"+number+".jpg"));
		} catch (WebDriverException e) {
			System.out.println("The browser has been closed.");
		} catch (IOException e) {
			System.out.println("The snapshot could not be taken");
		}
		return number;
	}

	public void closeBrowser() {
		try {
			driver.close();
			reportStep("The browser is closed","PASS", false);
		} catch (Exception e) {
			reportStep("The browser could not be closed","FAIL", false);
		}
	}

	public void closeAllBrowsers() {
		try {
			driver.quit();
			reportStep("The opened browsers are closed","PASS", false);
		} catch (Exception e) {
			reportStep("Unexpected error occured in Browser","FAIL", false);
		}
	}
	
	//Db Write
	
	public void DbQueryWrite(WebElement ele, String Query, String filename) {
		{
			Connection con = null;
			ResultSet rs = null;
			Statement stmt = null;
			try {
Driver driver1 = (Driver) Class.forName(
						"oracle.jdbc.driver.OracleDriver").newInstance();
				DriverManager.registerDriver(driver1);
				con = DriverManager.getConnection(
						"jdbc:oracle:thin:@10.44.54.200:1527:ORBOSIT",
						"RECON_V5_TST", "recon_v123#");
				FileWriter fw = new FileWriter(filename);
				BufferedWriter bw = new BufferedWriter(fw);
				stmt = con.createStatement();
				// rs = null;
				rs = stmt.executeQuery(Query);
				ResultSetMetaData rsmd=rs.getMetaData();
				int a=rsmd.getColumnCount();
				//System.out.println("columns: "+rsmd.getColumnCount()); 
				// rs.next();

				// ATUReports.add("Text Present",a, LogAs.PASSED, new
				// CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
				//bw.write(String.format("%20s %20s %20s \r\n", "Role_Id", "Role_name","Description"));
				while (rs.next()) {
					try {
						for(int i=1;i<=a;i++)
						{
							String b = rs.getString(i);	
							if(i==1){
								bw.write(b+"\t");
							}
							else{
								bw.write(String.format("%15s \t",b));
							}
							//bw.write("\t\t");
							//bw.write(String.format("\t",b));
							//bw.newLine();
							//bw.flush();

						}
						/*String a = rs.getString(1);
		
				bw.write(a);
						*/
						bw.newLine();
						bw.flush();
						

					} catch (Exception e) {
						System.out.println("Exception" + e);
					}
				}
				// return null;
				// return rs.getString(1);
				// return rs.getString(2);
				// System.out.println(a);
				// return rs.getString(1);
				// ATUReports.add("Text Present", "", Text, LogAs.PASSED, new
				// CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));

			} catch (Exception e) {
				System.out.println(" got Exception: " + e);
				e.printStackTrace();
				// return;
			} finally {

				try {

					rs.close();
					stmt.close();
					con.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}

			}
		}
	}
	
	//File Compare
	
	public void fileCompare(WebElement ele,String file1, String file2, String Result_File)
			throws IOException {

		try {
			FileWriter fw = new FileWriter(Result_File);
			BufferedWriter bw = new BufferedWriter(fw);
			BufferedReader br1 = null;
			BufferedReader br2 = null;
			String sCurrentLine;
			List<String> list1 = new ArrayList<String>();
			List<String> list2 = new ArrayList<String>();
			br1 = new BufferedReader(new FileReader(file1));
			br2 = new BufferedReader(new FileReader(file2));
			if(! br2.readLine().contains("*")){
			while ((sCurrentLine = br1.readLine()) != null) {
				list1.add(sCurrentLine);
			}}
			//if(! br2.readLine().contains("-") || br2.readLine().contains("SNo")||br2.readLine().contains("REPORT NAME ")||br2.readLine().contains("TRAN DATE")||br2.readLine().contains("PROCESSING DATE")||br2.readLine().contains("PROCESSING DATE")){
			//if(! br2.readLine().contains("-")){
			while ((sCurrentLine = br2.readLine()) != null) {
				list2.add(sCurrentLine);
			}
			
			List<String> tmpList = new ArrayList<String>(list1);
			tmpList.removeAll(list2);
			bw.write("Content from file1 which is not there in file 2");

			for (int i = 0; i < tmpList.size(); i++) {
				bw.newLine();
				bw.write(tmpList.get(i));
				// content from test.txt which is not there in test2.txt
			}
			bw.newLine();
			bw.write("content from file2 which is not there in file1");
			tmpList = list2;
			tmpList.removeAll(list1);
			for (int i = 0; i < tmpList.size(); i++) {
				bw.newLine();
				bw.write(tmpList.get(i));
				// content from test2.txt which is not there in test.txt
			}
			bw.flush();
		} finally {
			try {
			} catch (Exception ex) {
				ex.printStackTrace();
			}

		}
	}
	
	//Execute Query
	
public void  DbExecute(WebElement ele, String Query) {
		
		Connection con = null;
		ResultSet rs = null;
		Statement stmt = null;
		try {
Driver driver1 = (Driver) Class.forName(
					"oracle.jdbc.driver.OracleDriver").newInstance();
			DriverManager.registerDriver(driver1);
			con = DriverManager.getConnection(
							"jdbc:oracle:thin:@10.44.54.200:1527:ORBOSIT",
							"RECON_V5_TST", "recon_v123#");
			
			stmt = con.createStatement();
			rs = stmt.executeQuery(Query);
			ResultSetMetaData rsmd=rs.getMetaData();
			System.out.println("Table Truncated Successfully");
				
		}
			
		 catch (Exception e) {
			System.out.println(" got Exception: " + e);
			e.printStackTrace();
			
		} finally {

			try {

				rs.close();
				stmt.close();
				con.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		}

//Text Compare
	
public void compare (WebElement ele, String fp1,  String fp2, String op) throws IOException
{
	
	String filePath1 = fp1;
	String filePath2 = fp2;
	String outPutFile =op;
	BufferedReader reader1 = new BufferedReader(new FileReader(filePath1));
	BufferedReader reader2 = new BufferedReader(new FileReader(filePath2));
	FileWriter f2  = null;
	f2 = new FileWriter(outPutFile); 
	String line1 = reader1.readLine();
	String line2 = reader2.readLine();
	boolean areEqual = true;
	int lineNum = 1;
	while (line1 != null || line2 != null)
	{
		if(line1 == null || line2 == null)
		{
			areEqual = false;
			
			break;
		}
		else if(! line1.equalsIgnoreCase(line2))
		{
			f2.write("Two files have different content. They differ at line "+lineNum);
			f2.write("\nFILE1 has '"+line1+"' and FILE2 has '"+line2+"' at line "+lineNum);
			f2.write("\n\n ");

		}
		line1 = reader1.readLine();
		line2 = reader2.readLine();
		lineNum++;
	}
	reader1.close();
	reader2.close();
	f2.close();
}

public void date(String a){

	 WebElement Text1=driver.findElementByXPath("//td[text()="+a+"]");
	 Text1.click();

}


}
