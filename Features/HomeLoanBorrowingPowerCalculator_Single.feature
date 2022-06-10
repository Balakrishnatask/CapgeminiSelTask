Feature: Home Loan Calculator For Single Application Type

  Scenario: Verify Borrowing Estimate Amount for Single Application Type
    Given User should be in loan calculator page
    When User click Application type Single
    And User select number of dependants "0"
    And User click Home to live in
    And User enter income of "80,000"
    And User enter other income "10,000"
    And User enter living expenses "500"
    And User current home loan repayments "0"
    And User enter other loan repayments "100"
    And User enter other commitments "0"
    And User enter total credit card limits "10000"
    And User click workout button
    Then Verify borrowing estimate of "528,000"

  Scenario: Verify startover button that clears the form
    Given User should be in loan calculator page
    When User click Application type Single
    And User enter income of "80,000"
    And User enter other income "10,000"
    And User enter living expenses "500"
    And User enter total credit card limits "10000"
    And User click on startover button
    Then verify clear the form

  Scenario: Verify error message after entering living Expenses
    Given User should be in loan calculator page
    And User enter living expenses "1"
    And User click workout button
    Then verify Error Message "Based on the details you've entered, we're unable to give you an estimate of your borrowing power with this calculator. For questions, call us on 1800 035 500."
