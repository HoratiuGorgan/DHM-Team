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
	public ViewVacationsSteps userDo;
	
	@Steps
	public LoginSteps userDo1;
	
	@Test
	public void search_action(){
		userDo1.is_the_login_page();
		userDo1.enter_username("dragoscampean");
		userDo1.enter_password("Dragos.campean19");
		userDo1.login_click();
		userDo1.opens_vacation_tab();
		userDo.click_ViewVacations();
		userDo.enter_LastName(lastname);
		userDo.enter_FirstName(firstname);
		userDo.click_Apply();
		//userDo.sort_byStatus();
		userDo.userValidation();
		//h
	}
}
