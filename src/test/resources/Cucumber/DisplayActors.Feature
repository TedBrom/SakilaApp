Feature: Display a film on load
  Scenario Outline: verify content loads
    Given the application is running
    When the "<page>" loads
    And the api connects
    Then display a single film

    Examples:
    |page|
    | |