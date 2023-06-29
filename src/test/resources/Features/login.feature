Feature: Test signin functionality

  @positive_test
  Scenario: Check signin is successful with valid credentials
    Given user is on the login page
    When user enters username "samsulislam30410@gmail.com" and password "4BerggnfP6jpbZ7"
    And click on signin button
    Then user is navigated to home page

  Scenario Outline: Check signin is successful with valid credentials for multiple users
    Given user is on the login page
    When user enters username "<username>" and password "<password>"
    And click on signin button
    Then user is navigated to home page
    Examples:
      |    username                 |   password       |
      | samsulislam30410@gmail.com  | 4BerggnfP6jpbZ7  |
      | abc59476@spectrum.net       | Gamaphone8470    |


    @dataDriven_test
    Scenario: Check signin successful using data table
    Given user is on the login page
    When user click on login button upon entering credentials
    |     username                   |      password    |
    | samsulislam30410@gmail.com     | 4BerggnfP6jpbZ7  |
    Then user is navigated to home page

    @negative_test
    Scenario: Check signin is unsuccessful with invalid credentials
      Given user is on the login page
      When user enters username "samsulislam30410@gmail.com" and password "4BerggnfPZ7"
      And click on signin button
      Then user is failed to login


