package com.steps;

import com.pages.HomePage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class HomeSteps extends ScenarioSteps {

	HomePage homePage;

	@Step
	public void signInClick() {
		homePage.signInClick();

	}

	@Step
	public void isTheHomePage() {
		homePage.open();
	}

}
