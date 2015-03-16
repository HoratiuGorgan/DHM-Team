package com;

import java.text.ParseException;

import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.annotations.Managed;
import net.thucydides.junit.annotations.UseTestDataFrom;
import net.thucydides.junit.runners.ThucydidesParameterizedRunner;
import net.thucydides.junit.runners.ThucydidesRunner;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.pages.AcceptRejectRequstPage;
import com.requirements.Application;
import com.requirements.Constants;
import com.steps.AcceptRejectRequestSteps;
import com.steps.LoginSteps;
import com.steps.ViewVacationsSteps;
import com.steps.NewVacationTestSteps;

//@Story(Application.Search.SearchByKeyword.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom("resources/testIfRequestIsDeletedAfterApprove.csv")


// this test checks whether the approved request disappears from the inbox (after approve)
public class CheckIfRequestIsDeletedFromListAfterApprove {
	
	
	
	@Managed(uniqueSession = true)
	public WebDriver webdriver;
	
	@ManagedPages(defaultUrl = "http://192.168.1.68:9090/login")
	public Pages page;
	
	@Steps
	public NewVacationTestSteps newVacationTestSteps;
	
	@Steps
	public AcceptRejectRequestSteps acceptRejectRequestSteps;
	
	@Steps
	public LoginSteps loginSteps;
	
	//data from the CSV
	String startDate, employeeName;
	
	@Test
	public void testIfRequestIsDeleted(){
		loginSteps.login("dragoscampean", "Dragos.campean19");
		loginSteps.opens_vacation_tab();
		acceptRejectRequestSteps.clickInbox();
		acceptRejectRequestSteps.goThroughRequestsList(employeeName, startDate);
		acceptRejectRequestSteps.clickApprove();
		acceptRejectRequestSteps.checksTheRequestsList(employeeName, startDate);
		
		
	}

}
