package testcases;

import javax.management.relation.Role;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.LoginPage;
//import pages.AddRole;
import wdMethods.ProjectMethods;


public class TC_Dispute extends ProjectMethods{
	@BeforeTest
	public void setData() {
		testCaseName="Login";
		testDescription="login to Recon Application";
		testNodes="Leads";
		category="Sanity";
		authors="San";
		browserName="chrome";
		dataSheetName="Registernotfound";
	}
	
	@Test(priority = 1, dataProvider="fetchData")
	public void login(String uName,String pwd,String LoginAs,String type,String channel,String Ttype,String Month,String Year,String day,String accntnum,/*String columnname,String seqnum,*/String rcvdamnt,/*String status,String reason,*/String email,String mobileno,String branchname,String filename,String remark) {
		
		
		new LoginPage()
		.clickLogIn()
		.enterUserName(uName)
		.enterPassword(pwd)
		.enterLoginas(LoginAs)
		.clicksubmit();
		/*.clickDispute()
		.clickISS()
		.clickClaimregister()
		.Disputetype(type)
		.deliverychannel(channel)
		.Trantype(Ttype)
		.clickCalender()
		.clickMonth(Month)
		.clickYear(Year)
		.clickDate(day)
		.clickAccNo(accntnum)
		.clicksearch()
		.clicksearchtable()
		.clickcolumn(columnname)
		.clicktextbox(seqnum)
		.clickfind()
		.clickgrid()
		.clickmarkasdisp()
		.clickyesbtn()
		.clickreceivedamt(rcvdamnt)
		.clickproposedstatus(status)
		.clickreasoncode(reason)
		.clickemailid(email)
		.clickmobilenum(mobileno)
		.clickbranch(branchname)
		.clickattach()
		.clickchoosefile()
		.uploadByName(filename)
		. clickupload()
		.clickremarks(remark)
		//.clickalert()
		.clickalert2()
		.clicknextbtn()
		.clickregisterbtn()
		.clickokbtn()*/
		
		
		
		
		
		
	/*	.tranamount(amnt)
		
		
		
		.clicksearch()
		.clickcardnum(cardnumber)
		.clickdisputeamnt(amnt1)
		.clicksegment()
		.clickpriority()
		.clickregister()
		.clickok()
		.clicksearchtab()
		.clickcolumn(data2)
		.clickauthcode(auth)
		.clickfind()
		.clickgrid()
		.clickload()
		.clicksegment(seg)
		.clickpriority(prior)
		.clickproposedstatus(status)
		.clickreasoncode(reason)
		.clicksubmitdisp()*/
		
	}
	
}
	


		
		
	

		
	




