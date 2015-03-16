package com.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

@DefaultUrl("http://192.168.1.68:9090/vacation")
public class HomePage extends PageObject{
	
	@FindBy(css="[id='sign-in']")
    private WebElementFacade signInButton;
	
	
	public void signInClick() {
		signInButton.click();
    }

}
