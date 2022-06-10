package org.capgemini.stepdefinition;

import org.capgemini.base.BasePage;
import org.capgemini.pageobjects.HomeLoanCalculator_Page;
import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomeLoanCalculatorForSingleApplicationType_Steps {
	
	
	
	
	@Given("User should be in loan calculator page")
	public void user_should_be_in_loan_calculator_page() {
	   BasePage.invokeBrowserAndEnterUrl();
	}

	@When("User click Application type Single")
	public void user_click_application_type_single() {
		HomeLoanCalculator_Page.clickApplicantType_Single();
	}

	@And("User select number of dependants {string}")
	public void user_select_number_of_dependants(String dependants) {
		HomeLoanCalculator_Page.selectNoOfDependants(dependants);
	}
	

	@And("User click Home to live in")
	public void user_click_home_to_live_in() {
		HomeLoanCalculator_Page.clickBorrowType();
	}

	@And("User enter income of {string}")
	public void user_enter_income_of(String data) {
		HomeLoanCalculator_Page.enterAnnualIncome(data);
	}

	@And("User enter other income {string}")
	public void user_enter_other_income(String data) {
		HomeLoanCalculator_Page.enterOtherAnnualIncome(data);
	}
	
	

	@And("User enter living expenses {string}")
	public void user_enter_living_expenses(String data) {
		HomeLoanCalculator_Page.enterMonthlyLivingExpenses(data);
	}

	@And("User current home loan repayments {string}")
	public void user_current_home_loan_repayments(String data) {
		//HomeLoanCalculator_Page.enterCurrentHomeLoanMonthly(data);
	}

	@And("User enter other loan repayments {string}")
	public void user_enter_other_loan_repayments(String data) {
		HomeLoanCalculator_Page.enterOtherLoanMonthlyRepayments(data);
	}

	@And("User enter other commitments {string}")
	public void user_enter_other_commitments(String data) {
		HomeLoanCalculator_Page.enterOtherMonthlyCommitments(data);
	}

	@And("User enter total credit card limits {string}")
	public void user_enter_total_credit_card_limits(String data) {
		HomeLoanCalculator_Page.enterCreditCardLimits(data);
	}
	 
	
	@And("User click workout button")
	public void user_click_workout_button() {
		HomeLoanCalculator_Page.clickBorrowCalcluationBtn();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("Verify borrowing estimate of {string}")
	public void verify_borrowing_estimate_of(String totalExpCredit) {
	String totalActCredit=HomeLoanCalculator_Page.verifyBorrowingEstimate();
	System.out.println("Total Actual Credit is ::" + totalActCredit);
	Assert.assertEquals(totalActCredit, totalExpCredit);
	BasePage.driver.close();
	}
	
	
	@And("User click on startover button")
	public void user_click_on_startover_button() {
		HomeLoanCalculator_Page.clickStartOverBtn();
	}

	@Then("verify clear the form")
	public void verify_clear_the_form() {
	String 	actAnnualIncome=HomeLoanCalculator_Page.verifyClearDataAfterStartOver();
	int price= Integer.parseInt(actAnnualIncome);
	System.out.println("Actual Annual Income is ::" + price);
	Assert.assertEquals(price, 0);
	BasePage.driver.close();
	}
	
	

	@Then("verify Error Message {string}")
	public void verify_error_message(String expBorrowErrorMsg) {
		
		String actBorrowErrorMsg=HomeLoanCalculator_Page.verifyBorrowErrorTextMsg();
		System.out.println("Actual Borrow ErrorMsg is ::" + actBorrowErrorMsg);
		Assert.assertEquals(actBorrowErrorMsg, expBorrowErrorMsg);
		BasePage.driver.close();
	}
	
	
	
}
