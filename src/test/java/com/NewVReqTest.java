package com;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.text.ParseException;
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
	public LoginSteps loginSteps;

	@Steps
	public NewVReqSteps newVReqSteps;

	@Issue("#VACATION-1")
	@Test
	public void signInclick_action() throws ParseException {
		loginSteps.login(Constants.USER, Constants.PASSWORD);
		loginSteps.opensVacationTab();
		newVReqSteps.isTheVacationPage();
		newVReqSteps.newVReqClick();
		newVReqSteps.setStartDate(04, 12, 2015);
		newVReqSteps.setEndDate(05, 01, 2015);
		/*
		 * nvreqtest.specialVacField_click(); nvreqtest.specialReason_click();
		 * nvreqtest.comment_click(); //nvreqtest.selectChild_click();
		 * nvreqtest.enter_comment("I became a dad");
		 */
		newVReqSteps.submitVacationClick();

	}

}
