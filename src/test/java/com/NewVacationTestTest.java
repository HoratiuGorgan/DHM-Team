package com;

import java.text.ParseException;

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
import com.steps.NewVacationTestSteps;

@Story(Application.Search.SearchByKeyword.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom("resources/tipuriDeConcedii.csv")

public class NewVacationTestTest {
	
	
	
	@Managed(uniqueSession = true)
	public WebDriver webdriver;
	
	@ManagedPages(defaultUrl = "http://192.168.1.68:9090/login")
	public Pages page;
	
	@Steps
	public NewVacationTestSteps newVacationTestSteps;
	
	@Steps
	public LoginSteps loginSteps;
	
	String tipDeConcediu;
	
	@Test
	public void pick_a_date() throws ParseException{
		loginSteps.login("dragoscampean", "Dragos.campean19");
		loginSteps.opens_vacation_tab();
		newVacationTestSteps.new_vacation_open();
		newVacationTestSteps.setStartDate(1, 4, 2016);
		newVacationTestSteps.setEndDate(1, 8, 2016);
		newVacationTestSteps.clickVacationTypeCheckbox(tipDeConcediu);
		newVacationTestSteps.createANewVacation();
	}

}
