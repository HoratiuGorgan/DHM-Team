package com.steps;

import java.text.ParseException;

import com.pages.newvacationtestPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class newvacationtestSteps extends ScenarioSteps {

	newvacationtestPage newVtest;

	@Step
	public void setStartDate(int month, int day, int year)
			throws ParseException {
		newVtest.click_StartDate();
		newVtest.settingDateByGivenParameter(month, day, year);
	}

	@Step
	public void setEndDate(int month, int day, int year) throws ParseException {
		newVtest.click_EndDate();
		newVtest.settingDateByGivenParameter(month, day, year);
	}

	@Step
	public void new_vacation_open() {
		newVtest.open_newVacation();
	}

	@Step
	public void createANewVacation() {
		newVtest.create_newVacation();
	}

	@Step
	public void clickVacationTypeCheckbox(String vacationType) {
		newVtest.clickVacantionCheckbox(vacationType);

	}
}
