package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import uiObjects.DisputeObjects;

import wdMethods.ProjectMethods;

public class Dispute extends ProjectMethods{
	
	public Dispute() {		
		PageFactory.initElements(driver,this);
	}	
	
	@FindBy(how=How.XPATH,using = DisputeObjects.Dispute)
	private WebElement Dispute;
	public Dispute clickDispute() {
		click(Dispute);
		return this;
	}
	@FindBy(how=How.XPATH,using = DisputeObjects.ISS)
	private WebElement ISS;
	public Dispute clickISS() {
		click(ISS);
		return this;
	}
	@FindBy(how=How.XPATH,using = DisputeObjects.ClaimRegister)
	private WebElement ClaimRegister;
	public Dispute clickClaimregister() {
		click(ClaimRegister);
		return this;
	}
	@FindBy(how=How.ID,using = DisputeObjects.Disputetype)
	private WebElement Disputetype;
	public Dispute Disputetype(String type) {
		selectDropDownUsingText(Disputetype,type);
		return this;
	}
	@FindBy(how=How.ID,using = DisputeObjects.deliverychannel)
	private WebElement deliverychannel;
	public Dispute deliverychannel(String channel) {
		selectDropDownUsingText(deliverychannel,channel);
		return this;
	}
	@FindBy(how=How.ID,using = DisputeObjects.Trantype)
	private WebElement Trantype;
	public Dispute Trantype(String Ttype) {
		selectDropDownUsingText(Trantype,Ttype);
		return this;
	}
	@FindBy(how=How.ID,using = DisputeObjects.Calender)
	private WebElement Calender;
	public Dispute clickCalender() {
		click(Calender);
		return this;
}
	@FindBy(how=How.NAME,using = DisputeObjects.Month)
	private WebElement Month;
	public Dispute clickMonth(String month) {
		selectDropDownUsingText(Month,month);
		return this;	
}
	@FindBy(how=How.NAME,using = DisputeObjects.Year)
	private WebElement Year;
	public Dispute clickYear(String year) {
		selectDropDownUsingText(Year,year);
		return this;
}
	public Dispute clickDate(String day) {
		date(day);
		return this;
	}
	@FindBy(how=How.ID,using = DisputeObjects.AccNo)
	private WebElement AccNo;
	public Dispute clickAccNo(String accntnum) {
		type(AccNo,accntnum);
		return this;
	}
	@FindBy(how=How.ID,using = DisputeObjects.Search)
	private WebElement search;
	public Dispute clicksearch() {
		click(search);
		return this;
	
	}	
	@FindBy(how=How.XPATH,using = DisputeObjects.searchtable)
	private WebElement searchtable;
	public Dispute clicksearchtable() {
		click(searchtable);
		return this;
	}	
	@FindBy(how=How.XPATH,using = DisputeObjects.columns)
	private WebElement column;
	public Dispute clickcolumn(String columnname) {
		selectDropDownUsingText(column,columnname);
		return this;
		}	
	@FindBy(how=How.ID,using = DisputeObjects.textbox)
	private WebElement textbox;
	public Dispute clicktextbox(String seqnum) {
		type(textbox,seqnum);
		return this;
	}	
	
	@FindBy(how=How.ID,using = DisputeObjects.find)
	private WebElement find;
	public Dispute clickfind() {
		click(find);
		return this;
	}
	@FindBy(how=How.XPATH,using = DisputeObjects.grid)
	private WebElement grid;
	public Dispute clickgrid() {
		click(grid);
		return this;}
	@FindBy(how=How.ID,using = DisputeObjects.markasdisp)
	private WebElement markasdisp;
	public Dispute clickmarkasdisp() {
		click(markasdisp);
		return this;
	}
	
	@FindBy(how=How.ID,using = DisputeObjects.receivedamt)
	private WebElement receivedamt;
	public Dispute clickreceivedamt(String rcvdamnt) {
		type(receivedamt,rcvdamnt);
		return this;
	}	
	
	@FindBy(how=How.ID,using = DisputeObjects.proposed)
	private WebElement proposed;
	public Dispute clickproposedstatus(String status) {
		selectDropDownUsingText(proposed,status);
		return this;
	}

	@FindBy(how=How.ID,using = DisputeObjects.reasoncode)
	private WebElement reasoncode;
	public Dispute clickreasoncode(String reason) {
		selectDropDownUsingText(reasoncode,reason);
		return this;
	}
	@FindBy(how=How.ID,using = DisputeObjects.remarks)
	private WebElement remarks;
	public Dispute clickremarks(String remark) {
		type(remarks,remark);
		return this;
	}	
	@FindBy(how=How.ID,using = DisputeObjects.emailid)
	private WebElement emailid;
	public Dispute clickemailid(String email) {
		type(emailid,email);
		return this;
	}	
	
	@FindBy(how=How.ID,using = DisputeObjects.mobilenum)
	private WebElement mobilenum;
	public Dispute clickmobilenum(String mobileno) {
		type(mobilenum,mobileno);
		return this;
	}	
	
	@FindBy(how=How.ID,using = DisputeObjects.branch)
	private WebElement branch;
	public Dispute clickbranch(String branchname) {
		selectDropDownUsingText(branch,branchname);
		return this;
	}	
	
	
	@FindBy(how=How.ID,using = DisputeObjects.attach)
	private WebElement attach;
	public Dispute clickattach() {
		click(attach);
		return this;}
	
	@FindBy(how=How.ID,using = DisputeObjects.choosefile)
	private WebElement choosefile;
	public Dispute clickchoosefile() {
		click(choosefile);
		// driver.findElement(By.id("posProofFile"));
		return this;
		}

	public Dispute uploadByName(String txt) {
		 driver.findElement(By.name("posProofFile")).sendKeys(txt);;
		
		return this;

	}
	
	
	@FindBy(how=How.ID,using = DisputeObjects.upload)
	private WebElement upload;
	public Dispute clickupload() {
		click(upload);
		return this;
		
	}

	@FindBy(how=How.XPATH,using = DisputeObjects.nextbtn)
	private WebElement nextbtn;
	public Dispute clicknextbtn() {
		click(nextbtn);
		return this;
		
	}
	
	@FindBy(how=How.XPATH,using = DisputeObjects.alert)
	private WebElement alert;
	public Dispute clickalert() {
		click(alert);
		return this;
		
	}	
	@FindBy(how=How.XPATH,using = DisputeObjects.alert2)
	private WebElement alert2;
	public Dispute clickalert2() {
		click(alert2);
		return this;
		
	}	
	
	@FindBy(how=How.ID,using = DisputeObjects.registerbtn)
	private WebElement registerbtn;
	public Dispute clickregisterbtn() {
		click(registerbtn);
		return this;
		
	}	
	
	@FindBy(how=How.XPATH,using = DisputeObjects.okbtn)
	private WebElement okbtn;
	public Dispute clickokbtn() {
		click(okbtn);
		return this;
		
	}	

//REGISTERNOTFOUND
	@FindBy(how=How.XPATH,using = DisputeObjects.yesbtn)
	private WebElement yesbtn;
	public Dispute clickyesbtn() {
		click(yesbtn);
		return this;
		
	}	

@FindBy(how=How.ID,using = DisputeObjects.cardno)
private WebElement cardno;
public Dispute clickcardnum(String cardnumber) {
	type(cardno,cardnumber);
	return this;
}
@FindBy(how=How.ID,using = DisputeObjects.Disputeamnt)
private WebElement dispamnt;
public Dispute clickdisputeamnt(String amnt) {
	type(dispamnt,amnt);
	return this;
}

@FindBy(how=How.ID,using = DisputeObjects.segment)
private WebElement segment;
public Dispute clicksegment(String seg) {
	selectDropDownUsingText(segment,seg);
	return this;
}

@FindBy(how=How.ID,using = DisputeObjects.priority)
private WebElement priority;
public Dispute clickpriority(String prior) {
	selectDropDownUsingText(priority,prior);
	return this;
}

@FindBy(how=How.ID,using = DisputeObjects.register)
private WebElement register;
public Dispute clickregister() {
	click(register);
	return this;
}

@FindBy(how=How.ID,using = DisputeObjects.ok)
private WebElement okbutton;
public Dispute clickok() {
	click(okbutton);
	return this;
}



@FindBy(how=How.XPATH,using = DisputeObjects.load)
private WebElement load;
public Dispute clickload() {
	click(load);
	return this;}


	
	

	
	
	

	


	
	@FindBy(how=How.XPATH,using = DisputeObjects.submitbutton)
	private WebElement submitdisp;
	public Dispute clicksubmitdisp() {
		click(submitdisp);
		return this;
		}
}