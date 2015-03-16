package com;

import java.text.ParseException;

import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.annotations.Managed;
import net.thucydides.junit.annotations.UseTestDataFrom;
import net.thucydides.junit.runners.ThucydidesParameterizedRunner;
import net.thucydides.junit.runners.ThucydidesRunner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.pages.AcceptRejectRequstPage;
import com.requirements.Application;
import com.requirements.Constants;
import com.steps.AcceptRejectRequestSteps;
import com.steps.LoginSteps;
import com.steps.ViewVacationsSteps;
import com.steps.NewVacationTestSteps;

@Story(Application.Search.SearchByKeyword.class)
@RunWith(ThucydidesRunner.class)
/*
 * Testeaza daca la sectiunea Inbox(n) unde n=nr de requesturi se adauga 1 dupa
 * ce se face o cerere de concediu
 */
public class InboxRequestsNumberTest {

	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@ManagedPages(defaultUrl = "http://192.168.1.68:9090/login")
	public Pages page;

	@Steps
	public NewVacationTestSteps newVacationTestSteps;

	@Steps
	public LoginSteps loginSteps;

	@Steps
	public AcceptRejectRequestSteps acceptRejectRequestSteps;

	@Test
	public void checkInboxRequestNumber() throws ParseException {

		loginSteps.login("dragoscampean", "Dragos.campean19");
		loginSteps.opensVacationTab();
		int initialInboxNumber = acceptRejectRequestSteps.getInboxNumber();
		acceptRejectRequestSteps.logout();

		loginSteps.login("horatiugorgan1", "Evozon.2010");
		loginSteps.opensVacationTab();
		newVacationTestSteps.newVacationOpen();
		newVacationTestSteps.setStartDate(24, 3, 2015);
		newVacationTestSteps.setEndDate(24, 3, 2015);
		newVacationTestSteps.createANewVacation();
		acceptRejectRequestSteps.logout();
		loginSteps.login("dragoscampean", "Dragos.campean19");
		loginSteps.opensVacationTab();

		// int initialInboxNumber = acceptRejectRequstPage.getInboxNumber();

		// newVacationTestSteps.new_vacation_open();

		/*
		 * newVacationTestSteps.setStartDate(25, 3, 2015);
		 * newVacationTestSteps.setEndDate(27, 3, 2015);
		 * newVacationTestSteps.createANewVacation();
		 */
		// loginSteps.opens_vacation_tab();
		newVacationTestSteps.compareInboxNumber(initialInboxNumber + 1);

	}

}
