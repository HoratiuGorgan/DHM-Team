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
	public void click_ViewVacations(){
		viewVacation.click_ViewVacations();
	}
	
	@Step
	public void click_Apply(){
		viewVacation.apply_search();
	}
	@Step
	public void is_the_viewVacation_page(){
		viewVacation.open();
	}
	
	@Step
	public void enter_LastName(String lastname){
		viewVacation.enter_LastName(lastname);	
	}
	
	@Step
	public void enter_FirstName(String firstname){
		viewVacation.enter_FirstName(firstname);
	}
	
	@Step
	public void sort_byStatus(){
		viewVacation.sort_byStatus();
	}
	
	@Step
	public void userValidation(){
		
		Assert.assertTrue("The element should not be present!",viewVacation.checkThatElementDoesntExist(viewVacation.messageDisplayed) );
	}
	
	

}
