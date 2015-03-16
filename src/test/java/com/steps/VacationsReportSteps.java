package com.steps;

import org.junit.Assert;

//import com.NewVacationTestTest;
import com.google.protobuf.TextFormat.ParseException;
import com.pages.LoginPage;
import com.pages.VacationsReportPage;
import com.steps.LoginSteps;






import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import static ch.lambdaj.Lambda.join;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

public class VacationsReportSteps extends ScenarioSteps {

    VacationsReportPage vacationsReportPage;

    
    @Step
    public void enterFirstName(String firstname) {
    	vacationsReportPage.enterFirstName(firstname);
    }
    
   

    
    @Step
    public void enterLastName(String lastname) {
    	vacationsReportPage.enterLastName(lastname);
    }
    
    @Step	
    public void clickSearch(){
    	vacationsReportPage.clickSearch();
    	
    }
/*    @Step
    public void clickMonth(){
    	vacationsReportPage.clickMonth();
    }*/
    
    @Step
    public void selectsMonth(String Month) throws ParseException {
    	vacationsReportPage.selectsMonth(Month);
    }
    @Step
    public void selectsYear(String Year) throws ParseException {
    	vacationsReportPage.selectsYear(Year);
    }
    
    @Step
    public void clicksViewVacations(){
    	vacationsReportPage.clicksViewVacations();
    }
    
    @Step
    public void pageTitleCheck(String compareValue){
    	Assert.assertTrue("Aceasta nu este titlul paginii corespunzatoare", vacationsReportPage.pageTitle.getText().toLowerCase().contains(compareValue.toLowerCase()));
    }
    /*@Step
    public void selectsMonth(String Month){
    	vacationsReportPage.selectsMonth(Month);
    }
    /*@Step
    public void clickSelectedMonth(){
    	vacationsReportPage.clickSelectedMonth();
    }*/
    /*@Step
    public void clickYear(){
    	vacationsReportPage.clickYear();
    }
    @Step
    public void selectYear(String Year){
    	vacationsReportPage.selectsYear(Year);
    }*/

    /*@Step
    public void is_the_vacations_report_page() {
    	vacationsReportPage.open();
    }*/
    public void clicksVacationsReport() {
    	vacationsReportPage.vacationsReport_click();
    }
    
    public void clicksExportReport() {
    	vacationsReportPage.exportReport_click();
    }
    

}
