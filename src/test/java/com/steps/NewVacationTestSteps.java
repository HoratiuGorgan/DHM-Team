package com.steps;

import java.text.ParseException;

import com.pages.NewVacationTestPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class NewVacationTestSteps extends ScenarioSteps {

	NewVacationTestPage newVacationTestPage;

	@Step
	public void setStartDate(int month, int day, int year)
			throws ParseException {
		newVacationTestPage.click_StartDate();
		newVacationTestPage.settingDateByGivenParameter(month, day, year);
	}

	@Step
	public void setEndDate(int month, int day, int year) throws ParseException {
		newVacationTestPage.click_EndDate();
		newVacationTestPage.settingDateByGivenParameter(month, day, year);
	}

	@Step
	public void new_vacation_open() {
		newVacationTestPage.open_newVacation();
	}

	@Step
	public void createANewVacation() {
		newVacationTestPage.create_newVacation();
	}

	@Step
	public void clickVacationTypeCheckbox(String vacationType) {
		newVacationTestPage.clickVacantionCheckbox(vacationType);

	}
}
