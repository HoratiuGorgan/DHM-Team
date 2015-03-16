package com.steps;

import java.awt.List;
import java.text.ParseException;
import java.util.ArrayList;

import org.apache.commons.beanutils.converters.DoubleArrayConverter;
import org.jruby.ir.operands.Array;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import net.thucydides.junit.runners.ThucydidesParameterizedRunner;
import net.thucydides.junit.runners.ThucydidesRunner;

import com.requirements.Application;
import com.steps.NewVacationTestSteps;
import com.requirements.Application;
import com.requirements.Constants;
import com.steps.LoginSteps;
import com.steps.ViewVacationsSteps;
import com.steps.NewVacationTestSteps;

@RunWith(ThucydidesParameterizedRunner.class)
@Story(Application.Search.SearchByKeyword.class)
@UseTestDataFrom("resources/tentimes.csv")
public class TenTimesSteps extends ScenarioSteps {

	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@ManagedPages(defaultUrl = "http://192.168.1.68:9090/login")
	public Pages page;

	@Steps
	public NewVacationTestSteps newVacationTestSteps;

	@Steps
	public LoginSteps loginSteps;
	int s_day, s_month, s_year, e_day, e_month, e_year;

	// String tipDeConcediu;

	// int AvailableFreeDays;

	@Test
	public void pick_a_date() throws ParseException {
		int i;
		int nr_parc = 5;
		ArrayList<Integer> date = new ArrayList<Integer>();
		Integer s_day1 = null, s_month1 = null, s_year1 = null, e_day1 = null, e_month1 = null, e_year1 = null, s_day2, s_month2, s_year2, e_day2, e_month2, e_year2, s_day3, s_month3, s_year3, e_day3, e_month3, e_year3, s_day4, s_month4, s_year4, e_day4, e_month4, e_year4, s_day5, s_month5, s_year5, e_day5, e_month5, e_year5, s_day6, s_month6, s_year6, e_day6, e_month6, e_year6, s_day7, s_month7, s_year7, e_day7, e_month7, e_year7, s_day8, s_month8, s_year8, e_day8, e_month8, e_year8, s_day9, s_month9, s_year9, e_day9, e_month9, e_year9, s_day10, s_month10, s_year10, e_day10, e_month10, e_year10;
		date.add(s_day1);
		date.add(s_month1);
		date.add(s_year1);
		date.add(e_day1);
		date.add(e_month1);
		date.add(e_year1);
		// termin popularea listei

		loginSteps.login("horatiugorgan1", "Evozon.2010");
		loginSteps.opensVacationTab();

		int initialFreeDays = newVacationTestSteps.getFreeDays();
		{
			// parcurg lisa prin indecsi.
			// for
			// (i=0; date.indexOf(30); i++){

		}

		String requestURL = newVacationTestSteps.getBrowserURL();

		newVacationTestSteps.compareFreeDays(initialFreeDays - 2);

		newVacationTestSteps.navigateTo(requestURL);

		newVacationTestSteps.click_WithdrawVacation();
		// newVacationTestSteps.click_MyFreeDays();
		newVacationTestSteps.compareFreeDays(initialFreeDays);
	}

}
