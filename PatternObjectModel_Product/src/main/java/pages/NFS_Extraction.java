package pages;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import uiObjects.NFSExtractionObjects;
import uiObjects.LoginPageObjects;
import wdMethods.ProjectMethods;

public class NFS_Extraction extends ProjectMethods {
	public NFS_Extraction() {		
		PageFactory.initElements(driver,this);
	}
	private WebElement trun;
	public NFS_Extraction truncate(String data1) {
		DbExecute(trun, data1);
		return this;
	}
	
	@FindBy(how=How.XPATH,using = NFSExtractionObjects.Extraction)
	private WebElement Extract;
	
	public NFS_Extraction clickExtraction() {
		click(Extract);
		return this;	
	}
	
	@FindBy(how=How.XPATH,using = NFSExtractionObjects.NFS)
	private WebElement NFS1;
	public NFS_Extraction clickNFS() {
		click(NFS1);
		return this;	
	}
	
	@FindBy(how=How.XPATH,using = NFSExtractionObjects.NFSISS)
	private WebElement NFS2;	
	public NFS_Extraction clickNFSISS() {
		click(NFS2);
		return this;		
	}
	
	@FindBy(how=How.ID,using = NFSExtractionObjects.Start)
	private WebElement EProcess;	
	public NFS_Extraction clickStrt() {
		click(EProcess);
		return this;		
	}
	
	@FindBy(how=How.XPATH,using = NFSExtractionObjects.Refresh)
	private WebElement Refresh;	
	public NFS_Extraction clickRefresh() throws InterruptedException {
		click(Refresh);
		Thread.sleep(5000);
		click(Refresh);
		Thread.sleep(5000);
		click(Refresh);
		Thread.sleep(5000);
		click(Refresh);
		Thread.sleep(5000);
		click(Refresh);
		Thread.sleep(5000);
		click(Refresh);
		return this;	
	}
	private WebElement elew;
	public NFS_Extraction dbcompare(String data1,String data2,String data3) throws IOException {
		compare(elew, data1,data2,data3);
		return this;
	}
	
	@FindBy(how=How.XPATH,using = NFSExtractionObjects.Host)
	private WebElement Host;	
	public NFS_Extraction clickHost() {
		click(Host);
		return this;	
	}
	
	@FindBy(how=How.XPATH,using = NFSExtractionObjects.NFSHost)
	private WebElement NFSHst;
	public NFS_Extraction clickNFSHst() {
		click(NFSHst);
		return this;	
	}

	@FindBy(how=How.XPATH,using = NFSExtractionObjects.TLF)
	private WebElement TLF;	
	public NFS_Extraction clickTLF() {
		click(TLF);
		return this;		
	}
	@FindBy(how=How.XPATH,using = NFSExtractionObjects.Switch)
	private WebElement Swtch;
	public NFS_Extraction clickSwitch() {
		click(Swtch);
		return this;
	}	
	
}
