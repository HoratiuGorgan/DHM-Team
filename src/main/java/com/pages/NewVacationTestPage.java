package com.pages;

import ch.lambdaj.function.convert.Converter;
import net.thucydides.core.annotations.DefaultUrl;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import net.thucydides.core.pages.WebElementFacade;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import junit.framework.Assert;
import static org.junit.Assert.*;
import static ch.lambdaj.Lambda.convert;

public class NewVacationTestPage extends PageObject {

	@FindBy(css = "a[href$='new-request']")
	private WebElementFacade newVacationRequest;

	
	//@FindBy(css="[class='section-result'] td:nth-child(2)")


	@FindBy(css = "tr[class='section-result'] td:nth-child(2)")

	private WebElementFacade availableDays;

	@FindBy(css = "div[class='aui-column-content aui-column-content-first vacation-info-column-content '] div:nth-child(5) b:nth-child(3)")
	private WebElementFacade takenDays;

	@FindBy(name = "startDate")
	private WebElementFacade startDateButton;

	@FindBy(css = "a[href$='menuItem=my-free-days']")
	private WebElementFacade myFreeDaysButton;

	@FindBy(css = "input[id='_evovacation_WAR_EvoVacationportlet_withdrawnVacationRequest']")
	private WebElementFacade withdrawButton;

	@FindBy(name = "endDate")
	private WebElementFacade endDateButton;

	@FindBy(css = "div[style*='block'] td.dp_caption")
	private WebElementFacade calendarTitle;

	@FindBy(css = "div[style*='block'] td.dp_next")
	private WebElementFacade nextButton;

	@FindBy(css = "div[style*='block'] td.dp_previous")
	private WebElementFacade previousButton;

	@FindBy(css = "[id='_evovacation_WAR_EvoVacationportlet_saveButton']")
	private WebElementFacade submitVacation;

	@FindBy(css = "[id='_evovacation_WAR_EvoVacationportlet_businessDaysOutput']")
	private WebElementFacade selectedBusinessDays;

	// nr de zile de concediu solicitate
	/*
	 * String daysNr1 = selectedBusinessDays.getText(); int daysNr =
	 * Integer.parseInt(daysNr1);
	 */

	@FindBy(css = "[id='vacDaysLeft']")
	private WebElementFacade vacationDaysLeft;

	private int getDaysLeft() {
		String daysLeft = vacationDaysLeft.getText();

		String str2 = daysLeft.replaceAll("[^0-9.]", "");
		return Integer.parseInt(str2);

	}

	// nr de zile de concediu ramase
	public int selectVacationDaysLeft() {
		/*
		 * String str2=daysLeft.replaceAll("[^0-9.]", ""); int
		 * daysLeftJustNr=Integer.parseInt(str2);
		 */
		return getDaysLeft();
	}

	public int daysDifference() {
		String daysNr1 = selectedBusinessDays.getText();
		int daysNr = Integer.parseInt(daysNr1);

		int c = getDaysLeft() - daysNr+1;
		return c;
	}

	/*
	 * public void compareDays(){ Assert.assertEquals(expected, actual); }
	 */

	// parcurge lista de tipuri de concedii

	public void clickVacantionCheckbox(String vacationType) {
		List<WebElement> VacationTypes = getDriver().findElements(
				By.cssSelector("div[class='vacationTypeChoice'] label"));
		for (WebElement type : VacationTypes) {
			if (type.getText().toLowerCase().equals(vacationType.toLowerCase()))
				type.click();
		}
	}

	public int getFreeDays() {
		String aString = availableDays.getText();
		String nr = aString.replaceAll("^0-9", "");
		int aInt = Integer.parseInt(nr);
		return aInt;
	}

	/*
	 * public boolean checkFreeDays(int freeDaysNumber) { boolean equals=false;
	 * if(getFreeDays()==freeDaysNumber){ equals=true; } return equals; }
	 */

	public void settingDateByGivenParameter(int day, int month, int year)
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

	public void click_StartDate() {
		startDateButton.click();

	}

	public void click_MyFreeDaysButton() {
		myFreeDaysButton.click();
	}

	public void open_newVacation() {
		newVacationRequest.click();
	}

	public void click_EndDate() {
		endDateButton.click();
	}

	public void create_newVacation() {
		submitVacation.click();
	}

	public void click_WithdrawVacation() {
		withdrawButton.click();
	}

}
