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

import java.util.List;

import static org.junit.Assert.*;
import static ch.lambdaj.Lambda.convert;

@DefaultUrl("http://192.168.1.68:9090")
public class VacationsReportPage extends PageObject {

	@FindBy(css = "a[href*='http://192.168.1.68:9090/vacation?p_p_id=evovacation_WAR_EvoVacationportlet&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id=column-1&p_p_col_count=1&_evovacation_WAR_EvoVacationportlet_backURL=%2Fvacation&_evovacation_WAR_EvoVacationportlet_menuItem=vacation-report']")
	private WebElementFacade vacationsReport;

	// @FindBy(css="[name='_evovacation_WAR_EvoVacationportlet_exportMonth']")
	// private WebElementFacade exportForMonth;

	@FindBy(css = "[class='aui-datepicker-month']")
	private WebElementFacade exportForMonth;

	@FindBy(css = "[class='aui-datepicker-year']")
	private WebElementFacade exportForYear;

	@FindBy(css = "[id='_evovacation_WAR_EvoVacationportlet_approved']")
	//
	private WebElementFacade statusApproved;

	@FindBy(css = "[id='_evovacation_WAR_EvoVacationportlet_pending']")
	//
	private WebElementFacade statusPending;

	@FindBy(css = "[id='_evovacation_WAR_EvoVacationportlet_CIM']")
	private WebElementFacade includeCIM;

	@FindBy(css = "[id='_evovacation_WAR_EvoVacationportlet_other']")
	private WebElementFacade includeOther;

	@FindBy(css = "[id='_evovacation_WAR_EvoVacationportlet_exportButton']")
	private WebElementFacade exportButton;

	@FindBy(css = "[id='_evovacation_WAR_EvoVacationportlet_inactiveUsersCheckbox']")
	private WebElementFacade showInactiveUsersButton;

	@FindBy(css = "[id='_evovacation_WAR_EvoVacationportlet_reportLastName']")
	private WebElementFacade lastNameTab;

	@FindBy(css = "[id='_evovacation_WAR_EvoVacationportlet_reportFirstName']")
	private WebElementFacade firsttNameTab;

	@FindBy(css = "[id='_evovacation_WAR_EvoVacationportlet_searchButton']")
	//
	private WebElementFacade searchButton;

	@FindBy(css = "a[href$='view-vacations']")
	private WebElementFacade viewVacations;

	public void clicksViewVacations() {
		viewVacations.click();
	}

	@FindBy(css = "[class='content-title']")
	public WebElementFacade pageTitle;

	public void enter_firstName(String firstname) {
		firsttNameTab.sendKeys(firstname);
	}

	public void enter_lastName(String lastname) {
		lastNameTab.sendKeys(lastname);
	}

	public void vacationsReport_click() {
		vacationsReport.click();
	}

	public void exportReport_click() {
		exportButton.click();
	}

/*	public void clickMonth() {
		exportForMonth.click();
	}*/

	public void selectsMonth(String Month) {
		exportForMonth.selectByVisibleText(Month);

	}
	public void selectsYear(String Year){
		 exportForYear.selectByVisibleText(Year); 

	}
/*	public boolean getPageTitle(String compareValue) {
		boolean first = pageTitle.getText().toLowerCase()
				.contains(compareValue.toLowerCase());
		return first;

	}*/

	/*
	 * public void clickSelectedMonth(){ exportForMonth.click(); }
	 * 
	 * public void clickYear(){ exportForYear.click();
	 * 
	 * }
	 * 
	 * public void selectsYear(String Year){
	 * (exportForYear).selectByVisibleText(Year); }
	 */

	public void clickStatusApproved() {
		statusApproved.click();
	}

	public void clickStatusPendingd() {
		statusPending.click();
	}

	public void clickSearch() {
		searchButton.click();
	}

}