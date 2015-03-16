package com.steps;

import java.text.ParseException;

import org.junit.Assert;

import com.pages.AcceptRejectRequstPage;
import com.pages.NewVacationTestPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class NewVacationTestSteps extends ScenarioSteps {

	NewVacationTestPage newVacationTestPage;

	AcceptRejectRequstPage acceptRejectTestPage;

	@Step
	public void setStartDate(int day, int month, int year)
			throws ParseException {
		newVacationTestPage.click_StartDate();
		newVacationTestPage.settingDateByGivenParameter(day, month, year);
	}

	@Step
	public void setEndDate(int day, int month, int year) throws ParseException {
		newVacationTestPage.click_EndDate();
		newVacationTestPage.settingDateByGivenParameter(day, month, year);
	}

	@Step
	public void new_vacation_open() {
		newVacationTestPage.open_newVacation();
	}

	@Step
	public void compareFreeDays(int FreeDays) {
		System.out.println(FreeDays);
		newVacationTestPage.click_MyFreeDaysButton();
		Assert.assertEquals(newVacationTestPage.getFreeDays(), FreeDays);
	}

	//
	//
	//
	@Step
	public int getInboxNumber() {
		return acceptRejectTestPage.getInboxNumber();
	}

	//
	//
	//
	@Step
	public void compareInboxNumber(int InboxNumber) {

		// acceptRejectTestPage.click_Inbox();
		Assert.assertEquals(acceptRejectTestPage.getInboxNumber(), InboxNumber);
	}

	//
	//
	//

	@Step
	public int getFreeDays() {
		newVacationTestPage.click_MyFreeDaysButton();
		return newVacationTestPage.getFreeDays();
	}

	@Step
	public void click_logout() {
		acceptRejectTestPage.click_logout();
	}

	@Step
	public void click_WithdrawVacation() {
		newVacationTestPage.click_WithdrawVacation();
	}

	/*
	 * @Step public void click_MyFreeDays(){
	 * newVacationTestPage.click_MyFreeDaysButton(); }
	 */

	@Step
	public void createANewVacation() {
		newVacationTestPage.create_newVacation();
	}

	@Step
	public void clickVacationTypeCheckbox(String vacationType) {
		newVacationTestPage.clickVacantionCheckbox(vacationType);

	}

	@Step
	public String getBrowserURL() {
		return newVacationTestPage.getDriver().getCurrentUrl();
	}

	public void navigateTo(String requestURL) {
		newVacationTestPage.openAt(requestURL);
	}

}
