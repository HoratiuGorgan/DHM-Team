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
import com.steps.LoginSteps;
import com.steps.VacationsReportSteps;

@Story(Application.Search.SearchByKeyword.class)
@RunWith(ThucydidesRunner.class)
public class VacationsReportTestFilterByMonthYear {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages(defaultUrl = "http://192.168.1.68:9090/login")
    public Pages pages;

    @Steps
    public VacationsReportSteps endUser;
    @Steps
    public LoginSteps endUser1;

   // @Issue("#VACATION-1")
    
    @Test 
    public void search_vacations_report_action() throws InterruptedException{
    	endUser1.is_the_login_page();
    	//getDriver().manage().window().maximize();
    	endUser1.enter_username("dragoscampean");
    	endUser1.enter_password("Dragos.campean19");
    	endUser1.login_click();

    	endUser1.opens_vacation_tab();
    	endUser.clicksViewVacations();
    	endUser.pageTitleCheck("View Vacations");
    	/*endUser.clicksVacationsReport();
    	endUser.clickMonth();
    	endUser.selectsMonth("June");*/
    	//endUser.selectsMonth("May");
    	//endUser.clickSelectedMonth();
    	//endUser.clickYear();
    	//endUser.selectYear("2010");
    	//endUser.clicksYearh("2012");
    	//endUser.clickSearch();
    	//endUser.clicksExportReport();

    	
    }
    
 
} 