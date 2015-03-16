package com.steps;



import org.junit.Assert;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.steps.ScenarioSteps;

import com.google.protobuf.TextFormat.ParseException;
import com.pages.LoginPage;
import com.pages.NewVacationTestPage;

public class LoginSteps extends ScenarioSteps {

    LoginPage loginPage;
    NewVacationTestPage newVacationTestPage;
    NewVacationTestPage daysLeft;
    
    @Step
    public void enter_username(String username) {
    	loginPage.enter_username(username);
    }

    @Step
    public void enter_password(String password) {
    	loginPage.enter_password(password);
    }

/*    public void compareDays(){
    	Assert.assertEquals("The two are no equal ^_^", daysNr, daysLeftJustNr);
    }*/
    
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
    
    
/*    @Step
	public int selectVacationDaysLeft(){
	
	String str2=daysLeft1.replaceAll("[^0-9.]", "");
	int daysLeftJustNr=Integer.parseInt(str2);
	return daysLeftJustNr;
	
	}*/
    
    @Step
    public void daysDifference(){
    	Assert.assertEquals(newVacationTestPage.daysDifference(), newVacationTestPage.selectVacationDaysLeft());
    }

    @Step
    public void selectsTheRequestedPage(String myPage){
    	loginPage.selectsTheRequestedPage(myPage);
    }
    
    

}