package com.pages;

import ch.lambdaj.function.convert.Converter;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Step;

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

public class AcceptRejectRequstPage extends PageObject {

	@FindBy(css = "a[href$='menuItem=inbox']")
	private WebElementFacade clickInbox;

	public void clickInbox() {
		clickInbox.click();
	}

	// Inbox(x) unde x = nr de requesturi

	@FindBy(css = "a[href*='menuItem=inbox'] b")
	public WebElementFacade inboxNumber;
	
	@FindBy(css = "a[href='/c/portal/logout']")
	public WebElementFacade logout;
	
	public void click_logout(){
		logout.click();
	}

	@FindBy(css = "[class='aui-paginator-link aui-paginator-next-link']")
	private WebElementFacade clickNext;

	public void clickNext() {
		clickNext.click();
	}

	@FindBy(css = "div[class='vacation-info-row align-to-left employee-info']:last-child")
	private WebElementFacade textDaysNumber;

	@FindBy(css = "input[value='Approve']")
	private WebElementFacade clickApprove;

	public void clickApprove() {
		clickApprove.click();
	}

	@FindBy(css = "input[name='_evovacation_WAR_EvoVacationportlet_rowIds']")
	private List<WebElement> clickCheckbox;

	/*
	 * public void clickCheckbox(){ clickCheckbox.click(); }
	 */

	public int getInboxNumber() {
		inboxNumber.waitUntilVisible();
		String aString = inboxNumber.getText();
		String nr = aString.substring(1, aString.length() - 1);
		int aInt = Integer.parseInt(nr);
		return aInt;
	}

	// goes through the employee list and clicks the name when it gets a match

	public void goThroughRequestsList(String employeeName, String date) {
		List<WebElement> EmployeeNames = getDriver().findElements(
				By.cssSelector("td[class*='col-employee-name']"));
		for (WebElement name : EmployeeNames) {
			if (name.getText().toLowerCase().equals(employeeName.toLowerCase())) {

				List<WebElement> startDate = getDriver()
						.findElements(
								By.cssSelector("td[class*='col-my.request.column.header.start.date']"));
				for (int i = 0; i < startDate.size(); i++) {
					if (startDate.get(i).getText().toLowerCase()
							.equals(date.toLowerCase())) {
						clickCheckbox.get(i).click();
					}

				}
				break;

			}

		}
	}


	public boolean checksTheRequestsList(String employeeName, String date) {
		//boolean id=true;
		List<WebElement> EmployeeNames = getDriver().findElements(
				By.cssSelector("td[class*='col-employee-name']"));
		for (WebElement name : EmployeeNames) {
			if (name.getText().toLowerCase().equals(employeeName.toLowerCase())) {

				List<WebElement> startDate = getDriver()
						.findElements(
								By.cssSelector("td[class*='col-my.request.column.header.start.date']"));
				for (int i = 0; i < startDate.size(); i++) {
					if (startDate.get(i).getText().toLowerCase()
							.equals(date.toLowerCase())) {
						return false;
					}

				}

			}

		}
		//Assert.assertFalse("mesajul", id);
		return true;
	}

	/*
	 * public void compareDaysNumber(int nrMax) { String
	 * newText=textDaysNumber.getText(); String
	 * nr=newText.replaceAll("^0-9",""); int nrInt=Integer.parseInt(nr);
	 * if(nrInt<nrMax) { clickApprove(); } else { clickReject();
	 * System.out.println("you don't deserve it!"); }
	 * 
	 * }
	 */

}
