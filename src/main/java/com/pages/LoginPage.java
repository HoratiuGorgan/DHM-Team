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
public class LoginPage extends PageObject {

    @FindBy(id="_58_login")
    private WebElementFacade userInput;
    
    @FindBy(id="_58_password")
    private WebElementFacade passwordInput; 

    @FindBy(css="[type='submit']")
    private WebElementFacade loginButton;

    public void enter_username(String username) {
    	userInput.sendKeys(username);
    }
    public void enter_password(String password) {
        passwordInput.sendKeys(password);
    }
    
    public void login_click() {
        loginButton.click();
    }

}