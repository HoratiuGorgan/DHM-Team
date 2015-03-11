package com.pages;

import ch.lambdaj.function.convert.Converter;
import net.thucydides.core.annotations.DefaultUrl;

import org.junit.Assert;
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

import static org.junit.Assert.*;
import static ch.lambdaj.Lambda.convert;

@DefaultUrl("http://192.168.1.68:9090")
public class NewVacationTestPage extends PageObject {

	@FindBy(css = "a[href$='new-request']")
	private WebElementFacade newVacationRequest;

	@FindBy(name = "startDate")
	private WebElementFacade startDateButton;

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

	// lista tipuri de concedii

	@FindBy(css = "[id='_evovacation_WAR_EvoVacationportlet_type_CO']")
	private WebElementFacade VacationType1;

	@FindBy(css = "[id='_evovacation_WAR_EvoVacationportlet_type_CF']")
	private WebElementFacade VacationType2;

	@FindBy(css = "[id='_evovacation_WAR_EvoVacationportlet_type_CS']")
	private WebElementFacade VacationType3;

	@FindBy(css = "[id='_evovacation_WAR_EvoVacationportlet_type_CM']")
	private WebElementFacade VacationType4;

	// lista type strings

	public void clickVacantionCheckbox(String vacationType) {
		List<WebElement> VacationTypes = getDriver().findElements(
				By.cssSelector("div[class='vacationTypeChoice'] label"));
		for (WebElement type : VacationTypes) {
			if (type.getText().toLowerCase().equals(vacationType.toLowerCase()))
				type.click();
		}
	}

	public void settingDateByGivenParameter(int day, int month, int year) throws ParseException {

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

	public void open_newVacation() {
		newVacationRequest.click();
	}

	public void click_EndDate() {
		endDateButton.click();
	}

	public void create_newVacation() {
		submitVacation.click();
	}

}
