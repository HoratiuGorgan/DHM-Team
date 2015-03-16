package Utile;

import java.io.IOException;
import java.text.ParseException;

import javax.mail.MessagingException;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import Utile.EmailPage;

import com.LoginTest;
import com.steps.LoginSteps;
import com.steps.NewVacationTestSteps;


@RunWith(ThucydidesRunner.class)
public class MailTest {
	
	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@ManagedPages(defaultUrl = "http://192.168.1.68:9090/login")
	public Pages pages;
	
	@Steps 
	public NewVacationTestSteps newVacationTestSteps;
	
	@Steps
	public LoginSteps loginSteps;
	
	@Steps
	public LoginTest loginTest;
	
	@Steps
	public EmailPage emailPageSteps;
	
	@Test
	public void checkingIfMailWasReceived() throws ParseException, MessagingException, IOException{
		loginTest.login_action();
		newVacationTestSteps.newVacationOpen();
		newVacationTestSteps.setStartDate(6, 4, 2015);
		newVacationTestSteps.setEndDate(8, 4, 2015);
		newVacationTestSteps.createANewVacation();
		
		String startDate="06/04/2015";
		String endDate="08/04/2015";
		
		

		//String body ="Your holiday interval is:" + startDate + " - " + endDate ;
		String body ="Your holiday interval is: <strong>" + startDate + " - " + endDate + "</strong>.";
	//	String body ="Please";
		
		
		emailPageSteps.checkLastEmailSubjectAndBody("You have submitted a new Vacation Request", body);
		
		
		
		}

}