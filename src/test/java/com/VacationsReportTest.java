package com;

import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.annotations.Managed;
import net.thucydides.junit.runners.ThucydidesRunner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.requirements.Application;
import com.requirements.Constants;
import com.steps.LoginSteps;
import com.steps.VacationsReportSteps;

@Story(Application.Search.SearchByKeyword.class)
@RunWith(ThucydidesRunner.class)
public class VacationsReportTest {

	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@ManagedPages(defaultUrl = "http://192.168.1.68:9090/login")
	public Pages pages;

	@Steps
	public VacationsReportSteps vacationsReportSteps;
	@Steps
	public LoginSteps loginSteps;

	// @Issue("#VACATION-1")

	@Test
	public void search_vacations_report_action() {
		loginSteps.login(Constants.USER, Constants.PASSWORD);
		loginSteps.opensVacationTab();
		vacationsReportSteps.clicksVacationsReport();
		vacationsReportSteps.enterFirstName("dragos");
		vacationsReportSteps.enterLastName("campean");
		vacationsReportSteps.clickSearch();
		vacationsReportSteps.clicksExportReport();

	}

}