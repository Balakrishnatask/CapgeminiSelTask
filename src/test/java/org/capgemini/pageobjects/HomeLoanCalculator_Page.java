package org.capgemini.pageobjects;

import org.capgemini.base.BasePage;
import org.openqa.selenium.By;

public class HomeLoanCalculator_Page extends BasePage {

	public static By applicantType_Single = By.id("application_type_single");
	public static By noOfDependants = By.xpath("//select[@title='Number of dependants']");
	
	public static By startOverButton = By.xpath("//div[@class='result__restart']//button");
	
	public static By annualIncome = By.xpath("//label[text()='Your annual income (before tax)']//parent::div//div//input");

	public static By annualOtherIncome = By.xpath("//label[text()='Your annual other income (optional)']//parent::div//div//input");

	public static By brorrowType_Home = By.id("borrow_type_home");

	public static By monthlyLivingExpenses = By.xpath("//label[text()='Monthly living expenses ']//parent::div//div//input");

	public static By currentHomeLoanMonthly = By.xpath("//label[contains(text(),'Current home loan monthly')]");

	public static By otherLoanMonthlyRepayments = By.xpath("//label[text()='Other loan monthly repayments']//parent::div//div//input");

	public static By otherMonthlyComments = By.xpath("//label[text()='Other monthly commitments']//parent::div//div//input");

	public static By totalCreditCardLimits = By.xpath("//label[text()='Total credit card limits']//parent::div//div//input");

	public static By borrowCalculatorBtn = By.xpath("//button[@id='btnBorrowCalculater']");

	public static By borrowResult = By.id("borrowResultTextAmount");
	
	
	
	public static By borrowErrorText = By.xpath("//div[@class='borrow__error__text']");
	public static void clickApplicantType_Single() {
		click(applicantType_Single);
	}

	public static void selectNoOfDependants(String data) {
		handleDropdown(noOfDependants, data);
	}

	public static void enterAnnualIncome(String data) {
		setText(annualIncome, data);

	}
	
	
	
	public static void enterOtherAnnualIncome(String data) {
		setText(annualOtherIncome, data);

	}

	public static void enterMonthlyLivingExpenses(String data) {
		setText(monthlyLivingExpenses, data);

	}

	public static void clickBorrowType() {
		click(brorrowType_Home);

	}

	public static void enterCurrentHomeLoanMonthly(String data) {
		setText(currentHomeLoanMonthly, data);

	}

	public static void enterOtherLoanMonthlyRepayments(String data) {
		setText(otherLoanMonthlyRepayments, data);
		//enterTextUsingJSScript("//label[text()='Other loan monthly repayments']//parent::div//div//input");

	}

	public static void enterOtherMonthlyCommitments(String data) {
		setText(otherMonthlyComments, data);

	}
	public static void enterCreditCardLimits(String data) {
		setText(totalCreditCardLimits, data);

	}

	public static void clickBorrowCalcluationBtn() {
		click(borrowCalculatorBtn);
	}

	public static String verifyBorrowingEstimate() {
		String totalCredit = BasePage.driver.findElement(borrowResult).getText().replace("$", "");
		return totalCredit;
	}
	
	public static void clickStartOverBtn() {
		click(startOverButton);
	}
	public static String verifyClearDataAfterStartOver() {
		String actAnnualIncome = BasePage.driver.findElement(annualIncome).getAttribute("value");
		return actAnnualIncome;
	}
	
	
	public static String verifyBorrowErrorTextMsg() {
		String actBorrowErrorText = BasePage.driver.findElement(borrowErrorText).getText();
		return actBorrowErrorText;
	}
	


}
