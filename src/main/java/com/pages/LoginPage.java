package com.pages;

import ch.lambdaj.function.convert.Converter;
import net.thucydides.core.annotations.DefaultUrl;

import org.junit.Assert;
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
public class LoginPage extends PageObject {

    @FindBy(id="_58_login")
    private WebElementFacade userInput;
    
    @FindBy(id="_58_password")
    private WebElementFacade passwordInput; 

    @FindBy(css="h1[class='header-title'] span")
    private WebElementFacade newVacationRequest;
    @FindBy(css="div[class='content-title']")
    private WebElementFacade myRequests;
    @FindBy(css="div[class='content-title']")
    private WebElementFacade myFreeDays;
    @FindBy(css="div[class='content-title']")
    private WebElementFacade freeDaysHistory;
    @FindBy(css="div[class='hida']")
    private WebElementFacade track;
    @FindBy(css="li[class=active]:first-child']")
    private WebElementFacade inbox;
    @FindBy(css="div[class='content-title']")
    private WebElementFacade viewVacations;

    @FindBy(css="div[class='aui-fieldset-content aui-column-content']:first-child")
    private WebElementFacade vacationsReport;

	public void selectsTheRequestedPage(String myPage) {
		
		//element(myPages.get(0)).waitUntilVisible();
        List<WebElement> myPages = getDriver().findElements(By.cssSelector("div[class='aui-column-content aui-column-content-first '] ul[class='nav nav-list'] li[class*='menu'] a[href]"));
        for (WebElement page : myPages) {
            //String pageName = page.getText();
            if (page.getText().toLowerCase().contains(myPage.toLowerCase())) {
            	page.click();
            	if(myPage.toLowerCase().contains("New Vacations Request".toLowerCase())){
            		Assert.assertTrue("You Were redirected to the wrong page...Report Bug", newVacationRequest.getText().toLowerCase().contains("Create a new vacation request".toLowerCase()));
            	}
            	else if(myPage.toLowerCase().contains("My Requests".toLowerCase())){
            		Assert.assertTrue("You Were redirected to the wrong page...Report Bug", myRequests.getText().toLowerCase().contains("Filter requests".toLowerCase()));

            	}
            	else if(myPage.toLowerCase().contains("My Free Days".toLowerCase())){
            		Assert.assertTrue("You Were redirected to the wrong page...Report Bug", myFreeDays.getText().toLowerCase().contains("My Free Days".toLowerCase()));

            	}
            	else if(myPage.toLowerCase().contains("Free Days History".toLowerCase())){
            		Assert.assertTrue("You Were redirected to the wrong page...Report Bug", freeDaysHistory.getText().toLowerCase().contains("Filter History".toLowerCase()));

            	}
            	else if(myPage.toLowerCase().contains("Track".toLowerCase())){
            		Assert.assertTrue("You Were redirected to the wrong page...Report Bug", track.getText().toLowerCase().contains("Buildings".toLowerCase()));

            	}
            	else if(myPage.toLowerCase().contains("Inbox".toLowerCase())){
            		Assert.assertTrue("You Were redirected to the wrong page...Report Bug", inbox.getText().toLowerCase().contains("Assigned To Me".toLowerCase()));

            	}
            	else if(myPage.toLowerCase().contains("View Vacations".toLowerCase())){
            		Assert.assertTrue("You Were redirected to the wrong page...Report Bug", viewVacations.getText().toLowerCase().contains("View Vacations".toLowerCase()));

            	}
            	else if(myPage.toLowerCase().contains("Vacations Report".toLowerCase())){
            		Assert.assertTrue("You Were redirected to the wrong page...Report Bug", vacationsReport.getText().toLowerCase().contains("Export Vacations for".toLowerCase()));

            	}
            	break;
            }
            
        }
	}
    @FindBy(css="[type='submit']")
    private WebElementFacade loginButton;
    
    @FindBy(css="a[href*='http://192.168.1.68:9090/vacation']")
    private WebElementFacade clickVacationButton;

    public void enterUsername(String username) {
    	userInput.sendKeys(username);
    }

	public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }
    
    public void loginClick() {
        loginButton.click();
    }
    
    public void clickVacationButton(){
    	clickVacationButton.click();
    }

}