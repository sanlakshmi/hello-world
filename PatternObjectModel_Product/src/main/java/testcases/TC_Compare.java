package testcases;

import java.io.IOException;

import javax.management.relation.Role;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.NFS_Extraction;
import wdMethods.ProjectMethods;


public class TC_Compare extends ProjectMethods{
	@BeforeTest
	public void setData() {
		testCaseName="NFSExtarction";
		testDescription="login to Recon Application";
		testNodes="Leads";
		category="Sanity";
		authors="San";
		browserName="chrome";
		dataSheetName="Login";
	}
	
	@Test(priority = 1, dataProvider="fetchData")
	public void NFSExtraction(String data1,String data2,String data3) throws InterruptedException, IOException
	{

		new NFS_Extraction()
		.dbcompare(data1, data2, data3);
	
		
	}
	}
	


		
		
	
	
	




