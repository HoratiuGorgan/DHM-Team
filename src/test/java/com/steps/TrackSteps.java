package com.steps;

import com.pages.LoginPage;
import com.pages.TrackPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import static ch.lambdaj.Lambda.join;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

public class TrackSteps extends ScenarioSteps {
	
	TrackPage trackPage;
	
	@Step
	public void click_TrackPage(){
		trackPage.click_Track();
	}

}
