package com.steps;

import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.steps.ScenarioSteps;

import com.steps.NewVacationTestSteps;
public class TestLeftDaysSteps extends ScenarioSteps{
	NewVacationTestSteps nvts;
	 
	@StepGroup
	   public void reqMultipleVac (int req){
		int nr=10;
		for (int i = 1; i<nr; i++){
			//read data from datadriven termina-l!!!!!
			//nvts.setStartDate(day, month, year);
			
			
		}
		
		
	}
	

}
