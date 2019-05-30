package testcases;

import java.io.IOException;

import javax.management.relation.Role;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.LoginPage;
import wdMethods.ProjectMethods;


public class TC_NFS_Extraction extends ProjectMethods{
	@BeforeTest
	public void setData() {
		testCaseName="NFSExtarction";
		testDescription="login to Recon Application";
		testNodes="Leads";
		category="Sanity";
		authors="San";
		browserName="chrome";
		dataSheetName="NFSExtarction";
	}
	
	@Test(priority = 1, dataProvider="fetchData")
	public void NFSExtraction(String uName,String pwd,String LoginAs,String query1, String query2, String query3) throws InterruptedException, IOException {
		
		new LoginPage()
		.clickLogIn()
		.enterUserName(uName)
		.enterPassword(pwd)
		.enterLoginas(LoginAs)
		.clicksubmit()
		.truncate(query1)
		.clickExtraction()
		.clickNFS()
		.clickNFSISS()
		.clickStrt()
		.clickRefresh()
		.truncate(query2)
		.clickExtraction()
		.clickHost()
		.clickNFSHst()
		.clickStrt()
		.clickRefresh()
		.truncate(query3)
		.clickExtraction()
		.clickSwitch()
		.clickTLF()
		.clickStrt()
		.clickRefresh();
	
		
	}
	}
	


		
		
	
	
	




