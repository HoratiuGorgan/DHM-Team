package com.steps;

import com.pages.LoginPage;
import com.pages.homepage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import static ch.lambdaj.Lambda.join;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;


public class homeSteps extends ScenarioSteps {
	homepage HomePage;
	
	
	@Step	
    public void signIn_click(){
    	HomePage.signIn_click();
    	
    }

    @Step
    public void is_the_home_page() {
        HomePage.open();
    }

}
