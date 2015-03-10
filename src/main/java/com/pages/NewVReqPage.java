package com.pages;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

public class NewVReqPage extends PageObject{
	//Click for new vacation
		@FindBy(css="a[href$='new-request']")
		 private WebElementFacade newVReqButton;
			
		 	public void newVReq_click() {
		 		newVReqButton.click();
	}		
		 	/*click to select the special vacation field */
		 	
		 	@FindBy(css="[value='CS']")
		 	private WebElementFacade specialVacField;
		 	
		 	public void specialVacField_click(){
		 	specialVacField.click();
		 	}
		 	
		 	/*Select the reason of special vacation box*/
		 	
		 	@FindBy(css="[name='specialReason']")
		 	private WebElementFacade specialReason;
		 	
		 	public void specialReason_click(){
		 		//specialReason.click();
		 		specialReason.selectByVisibleText("Child birth").click();
		 	}		
		 		
		 
		 	
		 	/*Select Child birth case FIX FIXFIXFIXFIXFIXFIX*/
		 	@FindBy(css="[value='CHILD_BIRTH']")
		 	private WebElementFacade childBirth;
		 	
		 	public void selectChild_click(){
		 		
		 	childBirth.selectByIndex('1');

		 		
		 	}
		 	
		 	
		 	/*Click for to show comment field*/
		 	@FindBy(css="[id='_evovacation_WAR_EvoVacationportlet_newVacationComment']")
			private WebElementFacade commentButton;
		 	
		 	public void comment_click(){
		 		commentButton.click();
		 			
		 	}
		 	

		 	/*Introduce the comment*/
		 	@FindBy(css="[name='commentContent']")
		 	private WebElementFacade commentBox;
		 	
		 	public void enter_comment(String comment) {
		    	commentBox.sendKeys(comment);
		    }
		 /*submit vacation*/
		 	@FindBy(css="[id='_evovacation_WAR_EvoVacationportlet_saveButton']")
		 	private WebElementFacade submitVacation;
		 	
		 	public void submitVacation_click(){
		 		
		 		submitVacation.click();
		 		
		 	}
		 		
		 	/*Let's try the calendar HERE */
		 	
		 	
		 	
		 	
		 	
		 	
		 	
		 	
		 	
		 	
		 	}

	 
	
	


