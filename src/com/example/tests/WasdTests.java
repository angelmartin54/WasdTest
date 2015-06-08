package com.example.tests;



//import static org.junit.Assert.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
//import org.junit.Test;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;






import org.junit.Test;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;


public class WasdTests {
	//Variables for Post deploymnet tests
	//can be used across methods.
	private Selenium selenium;
	private String loginUserID = "9854521096";
	private String loginUserID1 = "9601200561";
	private WasdAccountProfile accountProfile = new WasdAccountProfile();
	//private String longPwd = "password";
	//private String pageLoadTime= "50000";
	
	
	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*googlechrome C:/Program Files (x86)/Google/Chrome/Application/chrome.exe" , "http://s0141668.miamidade.gov:9091/#/wasd/paymentHistory");
		selenium.start();
		//get profile configurations from config file. //search google on how to retrieve config settings for unit tests. 
		accountProfile.setLoginUserID("9601200561");
		accountProfile.setAccountNumber("9601200561");
		accountProfile.setAddress("12262 SW 201ST TER");
		accountProfile.setFolio("30-6912-044-0640");
		accountProfile.setPrimaryAccount("N/A");
		accountProfile.setAmountDue("$0.00");
		accountProfile.setPastDueDate("04-20-2015");
		accountProfile.setCurrentCharges("$167.57");
		accountProfile.setLastPaymentReceived("$167.57 on 04-20-2015");
		accountProfile.setServices("Water Service", "Waste Water Service");  
		accountProfile.setLoginUserID1("0005374200");

	}

	
//	@Test
	public void addressBarVarification() throws Exception {
		selenium.open("http://s0141668.miamidade.gov:9091/#/wasd");
		selenium.type("id=account_select", accountProfile.getLoginUserID() );
		selenium.click("css=#sidebar > div.text-center.small-welcome > form.form-horizontal.ng-valid.ng-dirty.ng-valid-parse > div > span > button");
		Thread.sleep(7000);
		assertTrue(selenium.isTextPresent(accountProfile.getAddress()));
		assertTrue(selenium.isTextPresent(accountProfile.getFolio()));
		assertTrue(selenium.isTextPresent("Folio"));
		assertTrue(selenium.isTextPresent(accountProfile.getAccountNumber()));
		assertTrue(selenium.isTextPresent("Account"));
		assertTrue(selenium.isTextPresent(accountProfile.getPrimaryAccount()));
		assertTrue(selenium.isTextPresent("Primary"));
		System.out.println("AddressBarVarification:Done");
	}
	
	
//	@Test
	public void paymentVarification() throws Exception {
		selenium.open("http://s0141668.miamidade.gov:9091/#/wasd");
		selenium.type("id=account_select", accountProfile.getLoginUserID() );
		selenium.click("css=#sidebar > div.text-center.small-welcome > form.form-horizontal.ng-valid.ng-dirty.ng-valid-parse > div > span > button");
		Thread.sleep(7000);
		assertTrue(selenium.isTextPresent(accountProfile.getAmountDue()));
		assertTrue(selenium.isTextPresent("Total Amount Due"));
		assertTrue(selenium.isTextPresent(accountProfile.getPastDueDate()));
		assertTrue(selenium.isTextPresent("Past Due Date"));
		assertTrue(selenium.isTextPresent("Pay Bill"));
		assertTrue(selenium.isTextPresent(accountProfile.getCurrentCharges()));
		assertTrue(selenium.isTextPresent("Current Charges"));
		assertTrue(selenium.isTextPresent("View Current Bill"));
		assertTrue(selenium.isTextPresent(accountProfile.getLastPaymentReceived()));
		assertTrue(selenium.isTextPresent("Last Payment Received"));
		assertTrue(selenium.isTextPresent("Account History"));
		System.out.println("PaymentVarification:Done");
	}

//	@Test
	public void accountDetailsVarification() throws Exception {
		selenium.open("http://s0141668.miamidade.gov:9091/#/wasd");
		selenium.type("id=account_select", accountProfile.getLoginUserID() );
		selenium.click("css=#sidebar > div.text-center.small-welcome > form.form-horizontal.ng-valid.ng-dirty.ng-valid-parse > div > span > button");
		Thread.sleep(7000);
		assertTrue(selenium.isVisible("css=#account-info > div.bottom15 > h5"));	
		assertTrue(selenium.isVisible("css=#account-info > div.bottom15 > div:nth-child(2) > div > p"));
		assertTrue(selenium.isVisible("css=#account-info > div.bottom15 > div:nth-child(2) > div > ul > li:nth-child(1)"));
		assertTrue(selenium.isVisible("css=#account-info > div.bottom15 > div:nth-child(2) > div > ul > li:nth-child(2)"));
		assertTrue(selenium.isVisible("css=#account-info > div.bottom15 > div:nth-child(3) > p.account-label"));
		assertTrue(selenium.isVisible("css=#account-info > div.bottom15 > div:nth-child(3) > p.account-value.ng-binding"));
		assertTrue(selenium.isVisible("css=#account-info > div.bottom15 > div:nth-child(4) > p.account-label"));
		assertTrue(selenium.isVisible("css=#account-info > div.bottom15 > div:nth-child(4) > p.account-value.ng-binding"));
		System.out.println("AccountDetailsVarification:Done");
	}
	
//	@Test
	public void accountHomeMessagesVarification() throws Exception {
		selenium.open("http://s0141668.miamidade.gov:9091/#/wasd");
		selenium.type("id=account_select", accountProfile.getLoginUserID() );
		selenium.click("css=#sidebar > div.text-center.small-welcome > form.form-horizontal.ng-valid.ng-dirty.ng-valid-parse > div > span > button");
		Thread.sleep(7000);
		assertTrue(selenium.isVisible("css=#content_area > ui-view:nth-child(2) > ui-view:nth-child(2) > div > div.panel-heading > h3"));
		System.out.println("AccountHomeMessagesVarification:Done");
	};
	
//	@Test 
	public void currentPeriodVarification() throws Exception {
		selenium.open("http://s0141668.miamidade.gov:9091/#/wasd");
		selenium.type("id=account_select", accountProfile.getLoginUserID() );
		selenium.click("css=#sidebar > div.text-center.small-welcome > form.form-horizontal.ng-valid.ng-dirty.ng-valid-parse > div > span > button");
		Thread.sleep(7000);
		assertTrue(selenium.isVisible("css=#content_area > ui-view:nth-child(2) > ui-view:nth-child(3) > div:nth-child(2) > div.panel-body > div.row.bottom15 > div.col-xs-12.col-sm-4.col-md-4.col-lg-3 > div > p.account-value.ng-binding"));
		assertTrue(selenium.isVisible("css=#content_area > ui-view:nth-child(2) > ui-view:nth-child(3) > div:nth-child(2) > div.panel-body > div.row.bottom15 > div:nth-child(2) > div > p.account-value.ng-binding"));
		assertTrue(selenium.isVisible("css=#content_area > ui-view:nth-child(2) > ui-view:nth-child(3) > div:nth-child(2) > div.panel-body > div.row.bottom15 > div:nth-child(3) > div > p:nth-child(1) > a"));
		assertTrue(selenium.isVisible("css=#content_area > ui-view:nth-child(2) > ui-view:nth-child(3) > div:nth-child(2) > div.panel-body > div.row.bottom15 > div:nth-child(4) > div > p.account-value.ng-binding"));
		assertTrue(selenium.isVisible("css=#content_area > ui-view:nth-child(2) > ui-view:nth-child(3) > div:nth-child(2) > div.panel-body > div.row.bottom15 > div:nth-child(5) > div > p.account-value.ng-binding"));
		assertTrue(selenium.isVisible("css=#content_area > ui-view:nth-child(2) > ui-view:nth-child(3) > div:nth-child(2) > div.panel-body > div.table-responsive.meter-active.meter-base.meter-show > table > tbody > tr > td:nth-child(1)"));
		assertTrue(selenium.isVisible("css=#content_area > ui-view:nth-child(2) > ui-view:nth-child(3) > div:nth-child(2) > div.panel-body > div.table-responsive.meter-active.meter-base.meter-show > table > tbody > tr > td:nth-child(2)"));
		assertTrue(selenium.isVisible("css=#content_area > ui-view:nth-child(2) > ui-view:nth-child(3) > div:nth-child(2) > div.panel-body > div.table-responsive.meter-active.meter-base.meter-show > table > tbody > tr > td:nth-child(3)"));
		assertTrue(selenium.isVisible("css=#content_area > ui-view:nth-child(2) > ui-view:nth-child(3) > div:nth-child(2) > div.panel-body > div.table-responsive.meter-active.meter-base.meter-show > table > tbody > tr > td:nth-child(4)"));
		assertTrue(selenium.isVisible("css=#content_area > ui-view:nth-child(2) > ui-view:nth-child(3) > div:nth-child(2) > div.panel-body > div.table-responsive.meter-active.meter-base.meter-show > table > tbody > tr > td:nth-child(5)"));
		assertTrue(selenium.isVisible("css=#content_area > ui-view:nth-child(2) > ui-view:nth-child(3) > div:nth-child(2) > div.panel-body > div.table-responsive.meter-active.meter-base.meter-show > table > tbody > tr > td:nth-child(6)"));
		assertTrue(selenium.isVisible("css=#content_area > ui-view:nth-child(2) > ui-view:nth-child(3) > div:nth-child(2) > div.panel-body > div.table-responsive.meter-active.meter-base.meter-show > table > tbody > tr > td:nth-child(7)"));
		System.out.println("CurrentPeriodVerification:Done");
	}

//	@Test
	public void accountHistoryVerification() throws Exception {
		selenium.open("http://s0141668.miamidade.gov:9091/#/wasd");
		selenium.type("id=account_select", accountProfile.getLoginUserID() );
		selenium.click("css=#sidebar > div.text-center.small-welcome > form.form-horizontal.ng-valid.ng-dirty.ng-valid-parse > div > span > button");
		Thread.sleep(10000); 
		selenium.click("css=#sidebar > div:nth-child(2) > a:nth-child(4)");
		assertTrue(selenium.isVisible("css=#bill_hist > ui-view:nth-child(3) > div:nth-child(1) > div.panel-heading > h3"));
		assertTrue(selenium.isVisible("css=#bill_hist > ui-view:nth-child(3) > div:nth-child(1) > div.panel-body > div.row.bottom15 > div.col-xs-12.col-sm-4.col-md-4.col-lg-3 > div > p.account-value.ng-binding"));
		assertTrue(selenium.isVisible("css=#bill_hist > ui-view:nth-child(3) > div:nth-child(1) > div.panel-body > div.row.bottom15 > div:nth-child(2) > div > p.account-value.ng-binding"));
		assertTrue(selenium.isVisible("css=#bill_hist > ui-view:nth-child(3) > div:nth-child(1) > div.panel-body > div.row.bottom15 > div:nth-child(3) > div > p.account-value.ng-binding"));
		assertTrue(selenium.isVisible("css=#bill_hist > ui-view:nth-child(3) > div:nth-child(1) > div.panel-body > div.row.bottom15 > div:nth-child(4) > div > p.account-value.ng-binding"));
		assertTrue(selenium.isVisible("css=#bill_hist > ui-view:nth-child(3) > div:nth-child(1) > div.panel-body > div.row.bottom15 > div:nth-child(5) > div > p.account-value.ng-binding"));
		assertTrue(selenium.isVisible("css=#bill_hist > ui-view:nth-child(3) > div:nth-child(2) > div.panel-heading > h3"));
		assertTrue(selenium.isVisible("css=#bill_hist > ui-view:nth-child(3) > div:nth-child(2) > div.panel-body > div.row.bottom15 > div.col-xs-12.col-sm-4.col-md-4.col-lg-3 > div > p.account-value.ng-binding"));
		assertTrue(selenium.isVisible("css=#bill_hist > ui-view:nth-child(3) > div:nth-child(2) > div.panel-body > div.row.bottom15 > div:nth-child(2) > div > p.account-value.ng-binding"));
		assertTrue(selenium.isVisible("css=#bill_hist > ui-view:nth-child(3) > div:nth-child(2) > div.panel-body > div.row.bottom15 > div:nth-child(3) > div > p.account-value.ng-binding"));
		assertTrue(selenium.isVisible("css=#bill_hist > ui-view:nth-child(3) > div:nth-child(2) > div.panel-body > div.row.bottom15 > div:nth-child(4) > div > p.account-value.ng-binding"));
		assertTrue(selenium.isVisible("css=#bill_hist > ui-view:nth-child(3) > div:nth-child(2) > div.panel-body > div.row.bottom15 > div:nth-child(5) > div > p.account-value.ng-binding"));
		assertTrue(selenium.isVisible("css=#bill_hist > ui-view:nth-child(3) > div:nth-child(3) > div.panel-heading > h3"));
		assertTrue(selenium.isVisible("css=#bill_hist > ui-view:nth-child(3) > div:nth-child(3) > div.panel-body > div.row.bottom15 > div.col-xs-12.col-sm-4.col-md-4.col-lg-3 > div > p.account-value.ng-binding"));
		assertTrue(selenium.isVisible("css=#bill_hist > ui-view:nth-child(3) > div:nth-child(3) > div.panel-body > div.row.bottom15 > div:nth-child(2) > div > p.account-value.ng-binding"));
		assertTrue(selenium.isVisible("css=#bill_hist > ui-view:nth-child(3) > div:nth-child(3) > div.panel-body > div.row.bottom15 > div:nth-child(3) > div > p.account-value.ng-binding"));
		assertTrue(selenium.isVisible("css=#bill_hist > ui-view:nth-child(3) > div:nth-child(3) > div.panel-body > div.row.bottom15 > div:nth-child(4) > div > p.account-value.ng-binding"));
		assertTrue(selenium.isVisible("css=#bill_hist > ui-view:nth-child(3) > div:nth-child(3) > div.panel-body > div.row.bottom15 > div:nth-child(5) > div > p.account-value.ng-binding"));
		assertTrue(selenium.isVisible("css=#bill_hist"));
		System.out.println("Bill History Feild Verification:Done");
	}
	
//	@Test
	public void paymentHistoryVerification() throws Exception {
		selenium.open("http://s0141668.miamidade.gov:9091/#/wasd");
		selenium.type("id=account_select", accountProfile.getLoginUserID() );
		selenium.click("css=#sidebar > div.text-center.small-welcome > form.form-horizontal.ng-valid.ng-dirty.ng-valid-parse > div > span > button");
		Thread.sleep(10000);
		selenium.click("css=#sidebar > div:nth-child(2) > a:nth-child(5)");
		assertTrue(selenium.isVisible("css=#pay_hist > div > div > div > table > tbody > tr:nth-child(1)"));
		assertTrue(selenium.isVisible("css=#pay_hist > div > div > div > table > tbody > tr:nth-child(2)"));
		assertTrue(selenium.isVisible("css=#pay_hist > div > div > div > table > tbody > tr:nth-child(3)"));
		assertTrue(selenium.isVisible("css=#pay_hist > div > div > div > table > tbody > tr:nth-child(4)"));
		System.out.println("PaymentHistoryVerification:Done");
		}
		
//	@Test
	public void currentPeriodCompare() throws Exception {
		selenium.open("http://s0141668.miamidade.gov:9091/#/wasd");
		selenium.type("id=account_select", accountProfile.getLoginUserID() );
		selenium.click("css=#sidebar > div.text-center.small-welcome > form.form-horizontal.ng-valid.ng-dirty.ng-valid-parse > div > span > button");
		Thread.sleep(10000);
		String ServicePeriod = selenium.getText("css=#content_area > ui-view > ui-view:nth-child(3) > div:nth-child(2) > div.panel-body > div.row.bottom15 > div.col-xs-12.col-sm-4.col-md-4.col-lg-3 > div > p.account-value.ng-binding");
		String CurrentCharges  = selenium.getText("css=#content_area > ui-view > ui-view:nth-child(3) > div:nth-child(2) > div.panel-body > div.row.bottom15 > div:nth-child(2) > div > p.account-value.ng-binding");
		String Adjustments = selenium.getText("css=#content_area > ui-view > ui-view:nth-child(3) > div:nth-child(2) > div.panel-body > div.row.bottom15 > div:nth-child(3) > div > p:nth-child(1) > a");
		String BillingDate = selenium.getText("css=#content_area > ui-view > ui-view:nth-child(3) > div:nth-child(2) > div.panel-body > div.row.bottom15 > div:nth-child(4) > div > p.account-value.ng-binding");
		String PDDate = selenium.getText("css=#content_area > ui-view > ui-view:nth-child(3) > div:nth-child(2) > div.panel-body > div.row.bottom15 > div:nth-child(5) > div > p.account-value.ng-binding");
		selenium.click("css=#sidebar > div:nth-child(2) > a:nth-child(4)");
		String ServicePeriod2 = selenium.getText("css=#bill_hist > ui-view:nth-child(2) > div:nth-child(2) > div.panel-body > div.row.bottom15 > div.col-xs-12.col-sm-4.col-md-4.col-lg-3 > div > p.account-value.ng-binding");
		String CurrentCharges2 = selenium.getText("css=#bill_hist > ui-view:nth-child(2) > div:nth-child(2) > div.panel-body > div.row.bottom15 > div:nth-child(2) > div > p.account-value.ng-binding");
		String Adjustments2 = selenium.getText("css=#bill_hist > ui-view:nth-child(2) > div:nth-child(2) > div.panel-body > div.row.bottom15 > div:nth-child(3) > div > p:nth-child(1) > a   ");
		String BillingDate2 = selenium.getText("css=#bill_hist > ui-view:nth-child(2) > div:nth-child(2) > div.panel-body > div.row.bottom15 > div:nth-child(4) > div > p.account-value.ng-binding");
		String PDDate2 = selenium.getText("css=#bill_hist > ui-view:nth-child(2) > div:nth-child(2) > div.panel-body > div.row.bottom15 > div:nth-child(5) > div > p.account-value.ng-binding");
		assertTrue(ServicePeriod.toLowerCase().contains(ServicePeriod2.toLowerCase()));
		assertTrue(CurrentCharges.toLowerCase().contains(CurrentCharges2.toLowerCase()));
		assertTrue(Adjustments.toLowerCase().contains(Adjustments2.toLowerCase()));
		assertTrue(BillingDate.toLowerCase().contains(BillingDate2.toLowerCase()));
		assertTrue(PDDate.toLowerCase().contains(PDDate2.toLowerCase()));
	}
		
//	@Test
	public void assertQuarterlyTrue() throws Exception {
		selenium.open("http://s0141668.miamidade.gov:9091/#/wasd");
		selenium.type("id=account_select", accountProfile.getLoginUserID() );
		selenium.click("css=#sidebar > div.text-center.small-welcome > form.form-horizontal.ng-valid.ng-dirty.ng-valid-parse > div > span > button");
		Thread.sleep(10000);
		String Quarterly = selenium.getText("css=#account-info > div.bottom15 > div:nth-child(4) > p.account-value.ng-binding");
		assertTrue(Quarterly.toLowerCase().contains("Quarterly".toLowerCase()));
	}
			
//	@Test 
	public void validationAssert() throws Exception {
		selenium.open("http://s0141668.miamidade.gov:9091/#/wasd/paymentHistory");
		selenium.click("css=#person_id");
		selenium.type("css=#person_id", "CashOnly");
		selenium.click("css=button.btn.btn-default");
		Thread.sleep(7000);
		assertTrue(selenium.isVisible("css=#current_account > ui-view:nth-child(1) > ul > li:nth-child(1)"));
		assertTrue(selenium.isVisible("css=#current_account > ui-view:nth-child(1) > ul > li:nth-child(2)"));
		assertTrue(selenium.isVisible("css=#content_area > ui-view > ui-view:nth-child(1) > div.panel.panel-default.bottom15.ng-scope > div.panel-body > div > div.col-xs-12.col-sm-7.col-md-7.col-lg-7 > div.alert.alert-danger.text-center > h3"));
	}
	
	@Test 
	public void cashOnlyVarification() throws Exception {
		selenium.open("http://s0141668.miamidade.gov:9091/#/wasd");
		selenium.type("id=person_id", "CashOnly");
		selenium.click("css=button.btn.btn-default");
		Thread.sleep(3000);
		selenium.select("id=account_select_list", "label=6722640442");
		selenium.click("css=#account_select_list > option:nth-child(6)");
		selenium.click("xpath=(//a[contains(text(),'Pay Bill')])[2]");
		assertTrue(selenium.isElementPresent("css=div.modal-body > div.alert.alert-danger"));
		assertTrue(selenium.isTextPresent("Pay Bill"));
	}
	
	@After
	public void tearDown() throws Exception {
 	selenium.stop();
	}
}
