package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


import wdMethods.ProjectMethods;

public class Database extends ProjectMethods{
	
	public Database() {		
		PageFactory.initElements(driver,this);
	}	
	
	
	private WebElement elew;
	public Database DBwrite(String data1,String data2) {
		DbQueryWrite(elew,data1,data2);
		return this;
	}
	
	private WebElement elec;
	public Database DBcompare(String data1,String data2,String data3) throws IOException {
		fileCompare(elec,data1,data2,data3);
		return this;
	}
}
