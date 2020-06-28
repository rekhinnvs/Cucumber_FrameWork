Feature: Application Login
  Scenario: Home page default login.
    Given User is on the landing page
    When User logins with username and password
    Then Home page is displayed