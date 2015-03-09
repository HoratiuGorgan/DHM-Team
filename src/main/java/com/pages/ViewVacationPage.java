package com.pages;

import ch.lambdaj.function.convert.Converter;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import net.thucydides.core.pages.WebElementFacade;

import net.thucydides.core.annotations.findby.FindBy;

import net.thucydides.core.pages.PageObject;

import java.util.List;

import static ch.lambdaj.Lambda.convert;

@DefaultUrl("http://192.168.1.68:9090")

public class ViewVacationPage extends PageObject {
	@FindBy(css="a[href$='view-vacations']")
	private WebElementFacade clickViewVacations;
	
	@FindBy(css="input[id='_evovacation_WAR_EvoVacationportlet_applyButton']")
	private WebElementFacade clickApply;
	
	@FindBy(css="input[id$='_evovacation_WAR_EvoVacationportlet_viewVacationsLastName']")
	private WebElementFacade inputLastName;
	
	@FindBy(css="input[id$='viewVacationsFirstName']")
	private WebElementFacade inputFirstName;
	
	@FindBy(css="a[href$='orderByCol=status&_evovacation_WAR_EvoVacationportlet_orderByType=asc']")
	private WebElementFacade sortByStatus;
	
	public void click_ViewVacations(){
		clickViewVacations.click();
	}
	public void enter_LastName(String lastname){
		inputLastName.sendKeys(lastname);
	}
	public void enter_FirstName(String firstname){
		inputFirstName.sendKeys(firstname);
	}
	public void apply_search(){
		clickApply.click();
	}
	public void sort_byStatus(){
		sortByStatus.click();
	}
	
}
