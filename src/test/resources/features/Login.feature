Feature: Application Login
  Scenario: Home page default login.
    Given User is on the landing page
    When User logins with username "hello" and password "password"
    Then Home page is displayed "true"

  Scenario: Home page default login.
    Given User is on the landing page
    When User logins with username "rekhin" and password "town"
    Then Home page is displayed "false"