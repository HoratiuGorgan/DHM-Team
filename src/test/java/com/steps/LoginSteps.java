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

	@Step
	public void enterUsername(String username) {
		loginPage.enterUsername(username);
	}

	@Step
	public void enterPassword(String password) {
		loginPage.enterPassword(password);
	}

	@Step
	public void loginClick() {
		loginPage.loginClick();

	}

	@Step
	public void isTheLoginPage() {
		loginPage.open();
		getDriver().manage().window().maximize();
	}

	@Step
	public void opensVacationTab() {
		loginPage.clickVacationButton();
	}

	@StepGroup
	public void login(String username, String password) {
		isTheLoginPage();
		enterUsername(username);
		enterPassword(password);
		loginClick();
	}

	@Step
	public void daysDifference() {
		Assert.assertEquals(newVacationTestPage.daysDifference(),
				newVacationTestPage.selectVacationDaysLeft());
	}

	@Step
	public void selectsTheRequestedPage(String myPage) {
		loginPage.selectsTheRequestedPage(myPage);
	}

}