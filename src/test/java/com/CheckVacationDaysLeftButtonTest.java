package com;

import java.text.ParseException;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.steps.AcceptRejectRequestSteps;
import com.steps.LoginSteps;
import com.steps.NewVacationTestSteps;
@RunWith(ThucydidesRunner.class)
public class CheckVacationDaysLeftButtonTest {

	
	//this test checks if the blue button from 'New Vacations Request', showing the vacations days left works correctly(days are substracted accordingly after a vacation request)
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
	
	
	String startDate, employeeName;
	
	@Test
	public void testIfRequestIsDeleted() throws ParseException{
		loginSteps.login("dragoscampean", "Dragos.campean19");
		loginSteps.opens_vacation_tab();
		newVacationTestSteps.new_vacation_open();
		newVacationTestSteps.setStartDate(20, 4, 2015);
		newVacationTestSteps.setEndDate(21, 4, 2015);
		newVacationTestSteps.createANewVacation();
		newVacationTestSteps.new_vacation_open();
		loginSteps.daysDifference();
		
	}

}

