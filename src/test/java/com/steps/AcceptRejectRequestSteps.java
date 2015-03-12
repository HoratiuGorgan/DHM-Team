package com.steps;

import org.junit.Assert;

import net.thucydides.core.annotations.Step;

import com.pages.AcceptRejectRequstPage;

public class AcceptRejectRequestSteps {
	
	AcceptRejectRequstPage acceptRejectRequstPage;
	@Step
	public void clickApprove(){
		acceptRejectRequstPage.clickApprove();
	}
	
	@Step
	public void clickInbox(){
		acceptRejectRequstPage.clickInbox();
	}
	@Step
	public void goThroughRequestsList(String employeeName, String date){
		acceptRejectRequstPage.goThroughRequestsList(employeeName, date);
	}
	
	@Step
	public void checksTheRequestsList(String employeeName, String date){
		Assert.assertFalse("mesajul", acceptRejectRequstPage.checksTheRequestsList(employeeName, date));
	}
}
