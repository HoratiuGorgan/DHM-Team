package com.steps;

import java.text.ParseException;
import com.pages.NewVReqPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class NewVReqSteps extends ScenarioSteps {

	NewVReqPage newVReqPage;

	@Step
	public void newVReqClick() {
		newVReqPage.newVReqClick();

	}

	@Step
	public void isTheVacationPage() {
		// NewVReq.open();
	}

	@Step
	public void commentClick() {
		newVReqPage.commentClick();

	}

	@Step
	public void specialVacFieldClick() {
		newVReqPage.specialVacFieldClick();

	}

	@Step
	public void specialReasonClick() {
		newVReqPage.specialReasonClick();

	}

	@Step
	public void selectChildClick() {
		newVReqPage.selectChildClick();
	}

	@Step
	public void enterComment(String comment) {
		newVReqPage.enterComment(comment);
	}

	@Step
	public void submitVacationClick() {
		newVReqPage.submitVacationClick();

	}

	@Step
	public void setStartDate(int month, int day, int year)
			throws ParseException {
		newVReqPage.clickStartDate();
		newVReqPage.settingDateByGivenParameter(month, day, year);
	}

	@Step
	public void setEndDate(int month, int day, int year) throws ParseException {
		newVReqPage.clickEndDate();
		newVReqPage.settingDateByGivenParameter(month, day, year);
	}

}
