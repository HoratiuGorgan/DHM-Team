package com;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.requirements.Application;
import com.requirements.Constants;
import com.steps.LoginSteps;
import com.steps.NewVReqSteps;

import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;

@Story(Application.Search.SearchByKeyword.class)
@RunWith(ThucydidesRunner.class)
public class NewVReqTest {

	@Managed(uniqueSession = true)
    public WebDriver webdriver;
	
	@ManagedPages(defaultUrl = "http://192.168.1.68:9090/login")
    public Pages pages;
	@Steps
	public LoginSteps endUser;
	
	@Steps
	public NewVReqSteps nvreqtest;
	
	
	 @Issue("#VACATION-1")

	 @Test 
	    public void signInclick_action(){
		 	endUser.login(Constants.USER, Constants.PASSWORD);
	    	endUser.opens_vacation_tab();
	    	nvreqtest.is_the_vacation_page();
	    	nvreqtest.newVReq_click();
	    	
	    	nvreqtest.specialVacField_click();
	    	nvreqtest.specialReason_click();
	    	nvreqtest.comment_click();
	    	//nvreqtest.selectChild_click();
	    	nvreqtest.enter_comment("I become dad");
	    	nvreqtest.submitVacation_click();
	    	
	    }


}
	
	

