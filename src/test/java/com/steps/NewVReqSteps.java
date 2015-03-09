package com.steps;

import com.pages.LoginPage;
import com.pages.homepage;
import com.pages.NewVReqPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import static ch.lambdaj.Lambda.join;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

public class NewVReqSteps extends ScenarioSteps {
	
	NewVReqPage NewVReq;
	
	@Step	
    public void newVReq_click(){
		NewVReq.newVReq_click();
    	
    }

    @Step
    public void is_the_vacation_page() {
    	//NewVReq.open();
    }
	
    @Step
    public void comment_click(){
    	NewVReq.comment_click();
    
    }
    
    @Step
    public void specialVacField_click(){
    	NewVReq.specialVacField_click();
    	
    }
   
    @Step
    public void specialReason_click(){
    	NewVReq.specialReason_click();
    	
    	
    }
    
    @Step
    public void selectChild_click(){
    	NewVReq.selectChild_click();
    }
    	
    	
    	
    
    
    
    @Step
    public void enter_comment(String comment) {
    NewVReq.enter_comment(comment);
        }
    @Step
    public void submitVacation_click(){
    	NewVReq.submitVacation_click();
    	
    	
    }
    
    
    	
    }

