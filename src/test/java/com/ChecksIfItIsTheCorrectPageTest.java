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
import com.steps.VacationsReportSteps;

@Story(Application.Search.SearchByKeyword.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom("resources/dataDriven.csv")
// checks if we are on the correct page after clicking it
public class ChecksIfItIsTheCorrectPageTest {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages(defaultUrl = "http://192.168.1.68:9090/login")
    public Pages pages;

    @Steps
    public VacationsReportSteps vacationReportSteps;
    @Steps
    public LoginSteps loginSteps;

    public String username,password,pageTitle;
   // @Issue("#VACATION-1")
    
    @Test 
    public void search_vacations_report_action() throws InterruptedException{
    	loginSteps.login(Constants.USER, Constants.PASSWORD);

    	loginSteps.opens_vacation_tab();
    	vacationReportSteps.clicksViewVacations();
    	vacationReportSteps.pageTitleCheck(pageTitle);


    	
    }
    
 
} 