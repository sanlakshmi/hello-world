package testcases;

import java.io.IOException;

import javax.management.relation.Role;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.Database;
import wdMethods.ProjectMethods;


public class TC_Database extends ProjectMethods{
	@BeforeTest
	public void setData() {
		testCaseName="TC_Database";
		testDescription="login to Recon Application";
		testNodes="Leads";
		category="Sanity";
		authors="San";
		browserName="chrome";
		dataSheetName="DBConn";
	}
	
	@Test(dataProvider="fetchData")
	public void login(String Query,String Filename,String file1,String file2,String file3) throws IOException {
		new Database()
		.DBwrite(Query,Filename);
		//.DBcompare(file1,file2,file3);
	}
	
	
	
}