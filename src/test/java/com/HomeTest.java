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
import com.steps.HomeSteps;

@Story(Application.Search.SearchByKeyword.class)
@RunWith(ThucydidesRunner.class)
public class HomeTest {

		@Managed(uniqueSession = true)
	    public WebDriver webdriver;
		
		@ManagedPages(defaultUrl = "http://192.168.1.68:9090")
	    public Pages pages;

		@Steps
	    public HomeSteps homeTest;

	    @Issue("#VACATION-1")

	    @Test 
	    public void signInclick_action(){
	    	homeTest.is_the_home_page();
	    	homeTest.signIn_click();
	    	
	    }




}
