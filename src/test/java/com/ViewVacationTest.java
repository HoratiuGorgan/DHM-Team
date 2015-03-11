package com;

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

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.requirements.Application;
import com.requirements.Constants;
import com.steps.LoginSteps;
import com.steps.ViewVacationsSteps;

@Story(Application.Search.SearchByKeyword.class)
@RunWith(ThucydidesParameterizedRunner.class)
//@UseTestDataFrom("resources/dataTest.csv")
@UseTestDataFrom("resources/dataTest.csv")
//@RunWith(ThucydidesRunner.class)
public class ViewVacationTest {
	
	public String lastname, firstname;

	@Managed(uniqueSession = true)
	public WebDriver webdriver;
	
	@ManagedPages(defaultUrl = "http://192.168.1.68:9090/login")
	public Pages page;
	
	@Steps
	public ViewVacationsSteps viewVacationsSteps;
	
	@Steps
	public LoginSteps loginSteps;
	
	@Test
	public void search_action(){
		loginSteps.login(Constants.USER, Constants.PASSWORD);
		loginSteps.opens_vacation_tab();
		viewVacationsSteps.click_ViewVacations();
		viewVacationsSteps.enter_LastName(lastname);
		viewVacationsSteps.enter_FirstName(firstname);
		viewVacationsSteps.click_Apply();
		viewVacationsSteps.sort_byStatus();
		viewVacationsSteps.userValidation();
		
	}
}
