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
import com.steps.TrackSteps;
import com.steps.VacationsReportSteps;

@Story(Application.Search.SearchByKeyword.class)
@RunWith(ThucydidesRunner.class)

public class TrackTest {
	  @Managed(uniqueSession = true)
	  public WebDriver webdriver;
	  
	  @ManagedPages(defaultUrl = "http://192.168.1.68:9090/login")
	  public Pages pages;
	  
	  @Steps
	  public TrackSteps user;
	  
	  @Steps
	  public LoginSteps user2;
	  
	  @Test
	  public void check_tracker_menu(){
		  user2.login(Constants.USER, Constants.PASSWORD);
		  user2.opens_vacation_tab();
		  user.click_TrackPage();
		  
	  }
}
