@positive_test
Feature: Test Your Services options

  Scenario: Check validate Internet
    Given user is on the spectrum home page
    When user click on your services button
    And user click on Internet button
    Then user click on View Plan Details button

  Scenario: Check validate Home Phone
    Given user is on the spectrum home page
    When user click on your services button
    And user click on Home Phone button
    Then user click on ShopPhones button

  Scenario: Check validate TV options
    Given user is on the spectrum home page
    When user click on your services button
    And user click on TV button
    Then user click on view  Channel Lineup button

  Scenario: Check validate Mobile options
    Given user is on the spectrum home page
    When user click on your services button
    And user click on Mobile button
    Then user click on See My Deals button

  Scenario: Check validate Billing options
    Given user is on the spectrum home page
    When user click on billing option
    And user click on Payment Methods button
    Then user click on Add Payment Method button









