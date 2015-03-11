package com.steps;

import java.text.ParseException;
import com.pages.NewVReqPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class NewVReqSteps extends ScenarioSteps {

NewVReqPage newVReqPage;
	
	@Step	
    public void newVReq_click(){
		newVReqPage.newVReq_click();
    	
    }

    @Step
    public void is_the_vacation_page() {
    	//NewVReq.open();
    }
	
    @Step
    public void comment_click(){
    	newVReqPage.comment_click();
    
    }
    
    @Step
    public void specialVacField_click(){
    	newVReqPage.specialVacField_click();
    	
    }
   
    @Step
    public void specialReason_click(){
    	newVReqPage.specialReason_click();
    	
    	
    }
    
    @Step
    public void selectChild_click(){
    	newVReqPage.selectChild_click();
    }
    	
    
    @Step
    public void enter_comment(String comment) {
    	newVReqPage.enter_comment(comment);
        }
    @Step
    public void submitVacation_click(){
    	newVReqPage.submitVacation_click();
    	
    	
    }
    
    @Step
    public void setStartDate(int month, int day, int year) throws ParseException {
    	newVReqPage.clickStartDate();
    	newVReqPage.settingDateByGivenParameter(month, day, year);
    }
    
    @Step
    public void setEndDate(int month, int day, int year) throws ParseException {
    	newVReqPage.clickEndDate();
    	newVReqPage.settingDateByGivenParameter(month, day, year);
    }
    
    
    	
    }
	
	

