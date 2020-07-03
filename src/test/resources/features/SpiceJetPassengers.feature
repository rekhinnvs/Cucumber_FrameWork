Feature: Spicejet passenger selection.
  Scenario: Select the number of adult and child passengers.
    Given I am on spicejet homepage
    When I select 2 adult passengers
    And I select 3 child passengers
    Then 2 adult passengers are selected
    And 3 child passengers are selected
