package com.steps;



import org.junit.Assert;

import com.pages.ViewVacationPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import static ch.lambdaj.Lambda.join;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

public class ViewVacationsSteps extends ScenarioSteps {
	
	ViewVacationPage viewVacation;
	
	@Step
	public void clickViewVacations(){
		viewVacation.click_ViewVacations();
	}
	
	@Step
	public void applySearch(){
		viewVacation.applySearch();
	}
	
	@Step
	public void isTheViewVacationPage(){
		viewVacation.open();
	}
	
	@Step
	public void enterLastName(String lastname){
		viewVacation.enterLastName(lastname);	
	}
	
	@Step
	public void enterFirstName(String firstname){
		viewVacation.enterFirstName(firstname);
	}
	@Step
	public void sortByStatus(){
		viewVacation.sortByStatus();
	}

	@Step
	public void userValidation(){
		
		Assert.assertTrue("The element should not be present!",viewVacation.checkThatElementDoesntExist(viewVacation.messageDisplayed) );
	}
	
	

}
