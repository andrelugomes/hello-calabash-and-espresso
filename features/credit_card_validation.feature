Feature: Credit card validation.
  Credit card numbers must be exactly 16 characters.

  Scenario: Credit card number is too long
    Given I wait for the "MainActivity" screen to appear
    When I enter "99999999999999999" into input field number 1
    And I press "validateButton"
    Then I should see "Credit card number is too long."

  Scenario: Credit card number is too short
    Given I wait for the "MainActivity" screen to appear
    When I enter "999" into input field number 1
    And I press "validateButton"
    Then I should see "Credit card number is too short."

  Scenario: Credit card number is valid
    Given I wait for the "MainActivity" screen to appear
    When I enter "1234567890123456" into input field number 1
    And I press "validateButton"
    Then I should see "The credit card number is valid!"