package com.steps;

import com.pages.LoginPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import static ch.lambdaj.Lambda.join;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

public class LoginSteps extends ScenarioSteps {

    LoginPage loginPage;

    
    @Step
    public void enter_username(String username) {
    	loginPage.enter_username(username);
    }

    
    @Step
    public void enter_password(String password) {
    	loginPage.enter_password(password);
    }
    
    @Step	
    public void login_click(){
    	loginPage.login_click();
    	
    }

    @Step
    public void is_the_login_page() {
        loginPage.open();
        getDriver().manage().window().maximize();
    }
    
    @Step
    public void opens_vacation_tab(){
    	loginPage.click_vacation_button();
    }
    @StepGroup
    public void login(String username, String password){
    	is_the_login_page();
    	enter_username(username);
    	enter_password(password);
    	login_click();
    }
    
    

}