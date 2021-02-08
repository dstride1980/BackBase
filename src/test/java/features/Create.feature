Feature: Create Feature

  Scenario Outline: Add a computer
    Given I am on the computer database website
    When I add a new computer with the details "<computer_name>","<introduced>","<discontinued>" and "<company>"
    Then the new computer is displayed with the details "<computer_name>","<introduced>","<discontinued>" and "<company>"
    Examples:
    | computer_name | introduced | discontinued | company |
    | daz           |            |              |         |