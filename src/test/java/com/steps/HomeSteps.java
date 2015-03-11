package com.steps;

import com.pages.HomePage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;




public class HomeSteps extends ScenarioSteps {
	/**
	 * 
	 */
	HomePage homePage;
	
	
	@Step	
    public void signIn_click(){
		homePage.signIn_click();
    	
    }

    @Step
    public void is_the_home_page() {
    	homePage.open();
    }

}
