package com.pages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.WebElement;

import net.thucydides.core.annotations.findby.By;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

public class NewVReqPage extends PageObject {
	// Click for new vacation
	@FindBy(css = "a[href$='new-request']")
	private WebElementFacade newVReqButton;

	@FindBy(css = "div[style*='block'] td.dp_caption")
	private WebElementFacade calendarTitle;

	@FindBy(css = "div[style*='block'] td.dp_next")
	private WebElementFacade nextButton;
	@FindBy(css = "div[style*='block'] td.dp_previous")
	private WebElementFacade previousButton;

	@FindBy(css = "[name='startDate']")
	private WebElementFacade click_StartDate;

	@FindBy(css = "[name='endDate']")
	private WebElementFacade click_EndDate;

	public void clickStartDate() {
		click_StartDate.click();
	}

	public void clickEndDate() {
		click_EndDate.click();
	}

	public void newVReqClick() {
		newVReqButton.click();
	}

	public void settingDateByGivenParameter(int month, int day, int year)
			throws ParseException {

		Calendar calNew = Calendar.getInstance();
		SimpleDateFormat sdfNew = new SimpleDateFormat("dd/MM/yyyy");
		calNew.setTime(sdfNew.parse("1/" + String.valueOf(month) + "/"
				+ String.valueOf(year)));

		Calendar cal = Calendar.getInstance();

		do {
			// get calendar title and create calendar value
			element(calendarTitle).waitUntilVisible();
			String MandY = calendarTitle.getText();
			SimpleDateFormat sdf = new SimpleDateFormat("MMM, yyyy dd");
			cal.setTime(sdf.parse(MandY + " 1"));

			// go previous or next based on comparison
			if (cal.compareTo(calNew) == -1) {
				nextButton.click();
			}
			if (cal.compareTo(calNew) == 1) {
				previousButton.click();
			}

		} while (cal.compareTo(calNew) != 0);
		// until month and year are as expected

		// select day
		List<WebElement> days = getDriver().findElements(
				By.cssSelector("div[style*='block'] td"));
		for (WebElement currentDay : days) {
			if (currentDay.getText().contentEquals(String.valueOf(day)))
				currentDay.click();
		}

	}

	/* click to select the special vacation field */

	@FindBy(css = "[value='CS']")
	private WebElementFacade specialVacField;

	public void specialVacFieldClick() {
		specialVacField.click();
	}

	/* Select the reason of special vacation box */

	@FindBy(css = "[name='specialReason']")
	private WebElementFacade specialReason;

	public void specialReasonClick() {
		// specialReason.click();
		specialReason.selectByVisibleText("Child birth").click();
	}

	/* Select Child birth case FIX FIXFIXFIXFIXFIXFIX */
	@FindBy(css = "[value='CHILD_BIRTH']")
	private WebElementFacade childBirth;

	public void selectChildClick() {

		childBirth.selectByIndex('1');

	}

	/* Click for to show comment field */
	@FindBy(css = "[id='_evovacation_WAR_EvoVacationportlet_newVacationComment']")
	private WebElementFacade commentButton;

	public void commentClick() {
		commentButton.click();

	}

	/* Introduce the comment */
	@FindBy(css = "[name='commentContent']")
	private WebElementFacade commentBox;

	public void enterComment(String comment) {
		commentBox.sendKeys(comment);
	}

	/* submit vacation */
	@FindBy(css = "[id='_evovacation_WAR_EvoVacationportlet_saveButton']")
	private WebElementFacade submitVacation;

	public void submitVacationClick() {

		submitVacation.click();

	}

	/* Let's try the calendar HERE */

}
