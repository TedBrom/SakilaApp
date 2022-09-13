Feature: Display films on load
  Scenario Outline: verify content loads
    Given the application is running
    When the "<page>" loads
    And the api connects
    Then display a list of films

    Examples:
      |page  |
      |Home  |
