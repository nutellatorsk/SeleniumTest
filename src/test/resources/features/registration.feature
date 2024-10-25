Feature: New Supporter Account Creation
  # This feature tests the registration process for creating a new supporter account
  # with different scenarios to verify successful creation and validation errors.

  Scenario: Successful account creation
    #acceptance criteria
    # Scenario where all fields are filled correctly and account creation is successful.
    Given I am on the "New Supporter Account" page
    And I set my date of birth to "04/09/1988"
    And I enter "Lovisa" as my first name
    And I enter "Gustavsson" as my last name
    And I enter "sandra.loorents@gmail.com" as my email address
    And I confirm my email address with "sandra.loorents@gmail.com"
    And I enter "Tjillevippen1" as my password
    And I confirm my password with "Tjillevippen1"
    And I agree to the terms and conditions
    And I verify that I am 18
    And I agree to the code of ethics and conduct
    When I click the "join" button
    Then My registration is successful and verified with "MEMBER DETAILS"
    # Verifies that the account creation was successful by checking for the confirmation message.

  Scenario: Account creation without last name
    # Scenario where the last name is missing, and the system should show an error message.
    Given I am on the "New Supporter Account" page
    And I set my date of birth to "04/09/1988"
    And I enter "Lovisa" as my first name
    # The last name field is intentionally left empty to test validation.
    #And I enter "Gustavsson" as my last name
    And I enter "sandra.loorents@gmail.com" as my email address
    And I confirm my email address with "sandra.loorents@gmail.com"
    And I enter "Tjillevippen1" as my password
    And I confirm my password with "Tjillevippen1"
    And I agree to the terms and conditions
    And I verify that I am 18
    And I agree to the code of ethics and conduct
    When I click the "join" button
    Then My registration should fail with the error message: "Last Name is required"
    # Verifies that the registration fails and shows the correct error message when the last name is missing.

  Scenario: Account creation without confirm password
    # Scenario where the password confirmation is missing, and an error message should be shown.
    Given I am on the "New Supporter Account" page
    And I set my date of birth to "04/09/1988"
    And I enter "Lovisa" as my first name
    And I enter "Gustavsson" as my last name
    And I enter "sandra.loorents@gmail.com" as my email address
    And I confirm my email address with "sandra.loorents@gmail.com"
    And I enter "Tjillevippen1" as my password
    # The confirm password field is intentionally left empty to test validation.
    #And I confirm my password with "Tjillevippen1"
    And I agree to the terms and conditions
    And I verify that I am 18
    And I agree to the code of ethics and conduct
    When I click the "join" button
    Then Registration failure due to missing password confirmation: "Confirm Password is required"
    # Verifies that the registration fails when the password confirmation is missing.

  Scenario: Account creation without terms and conditions
    # Scenario where the user does not accept the terms and conditions, causing the registration to fail.
    Given I am on the "New Supporter Account" page
    And I set my date of birth to "04/09/1988"
    And I enter "Lovisa" as my first name
    And I enter "Gustavsson" as my last name
    And I enter "sandra.loorents@gmail.com" as my email address
    And I confirm my email address with "sandra.loorents@gmail.com"
    And I enter "Tjillevippen1" as my password
    And I confirm my password with "Tjillevippen1"
    # The terms and conditions agreement is skipped to test validation.
    #And I agree to the terms and conditions
    And I verify that I am 18
    And I agree to the code of ethics and conduct
    When I click the "join" button
    Then Registration failure due to missing terms and conditions agreement: "You must confirm that you have read and accepted our Terms and Conditions"
    # Verifies that the registration fails if the terms and conditions are not accepted.
