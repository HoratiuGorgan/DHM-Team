package com.pages;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.protobuf.TextFormat.ParseException;

@DefaultUrl("http://192.168.1.68:9090")
public class ViewVacationPage extends PageObject {

	@FindBy(css = "a[href$='view-vacations']")
	private WebElementFacade clickViewVacations;

	@FindBy(css = "input[id='_evovacation_WAR_EvoVacationportlet_applyButton']")
	private WebElementFacade clickApply;

	@FindBy(css = "input[id$='_evovacation_WAR_EvoVacationportlet_viewVacationsLastName']")
	private WebElementFacade inputLastName;

	@FindBy(css = "input[id$='viewVacationsFirstName']")
	private WebElementFacade inputFirstName;

	@FindBy(css = "a[href*='orderByCol=status&_evovacation_WAR_EvoVacationportlet_orderByType']")
	private WebElementFacade sortByStatus;

	@FindBy(css = "div[class='portlet-msg-info']")
	public WebElementFacade messageDisplayed;

	public void click_ViewVacations() {
		clickViewVacations.click();
	}

	@FindBy(css = "div[style*='block'] td.dp_caption")
	private WebElementFacade calendarTitle;

	@FindBy(css = "div[style*='block'] td.dp_next")
	private WebElementFacade nextButton;

	@FindBy(css = "div[style*='block'] td.dp_previous")
	private WebElementFacade previousButton;

	@FindBy(name = "startDate")
	private WebElementFacade startDateButton;

	@FindBy(name = "endDate")
	private WebElementFacade endDateButton;

	public void settingDateByGivenParameter(int month, int day, int year)
			throws ParseException, java.text.ParseException {

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

	public void enterLastName(String lastname) {
		inputLastName.sendKeys(lastname);
	}

	public void enterFirstName(String firstname) {
		inputFirstName.sendKeys(firstname);
	}

	public void applySearch() {
		clickApply.click();
	}

	public void sortByStatus() {
		sortByStatus.click();
	}

	public boolean checkThatElementDoesntExist(WebElement element) {
		boolean elementPresent = false;
		try {
			elementPresent = element.isDisplayed();
		} catch (Exception e) {
			elementPresent = false;
		}
		return elementPresent;
	}

	public WebElement expected_boll() {
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		WebElement found = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.cssSelector(".portlet-msg-info")));
		return found;
	}

	public void userValidation() {
		messageDisplayed.waitUntilVisible();
	}

}
