Feature: delete_a_computer

  @Automated
  Scenario Outline: Delete a computer from the Database
    Given I am on the computer database website
    And I add a new computer with the details "<computer_name>","<introduced>","<discontinued>" and "<company>"
    When I delete the computer "<computer_name>"
    Then the details of the computer "<computer_name>" are removed from Database
    Examples:
      | computer_name | introduced | discontinued | company |
      | AAAAA         | 1980-03-23 | 2020-03-23   | RCA     |