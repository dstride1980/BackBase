Feature: update_a_computer

  @Automated
  Scenario Outline: update the company field
    Given I am on the computer database website
    And I add a new computer with the details "<computer_name>","<introduced>","<discontinued>" and "<company>"
    When I edit the computer "<computer_name>" company field with "<updated_company>"
    Then the new computer is displayed with the details "<computer_name>","<introduced>","<discontinued>" and "<updated_company>"
    Examples:
      | computer_name | introduced | discontinued | company | updated_company |
      | AAAAA         | 1980-03-23 | 2020-03-23   | RCA     | IBM             |

  @Automated
  Scenario Outline: Computer name is mandatory updating a computer
    Given I am on the computer database website
    And I add a new computer with the details "<computer_name>","<introduced>","<discontinued>" and "<company>"
    When I edit the computer by removing the computer name "<computer_name>"
    Then a error is displayed
    And the computer is displayed with the old details "<computer_name>","<introduced>","<discontinued>" and "<company>"
    Examples:
      | computer_name | introduced | discontinued | company |
      | AAAAA         | 1980-03-23 | 2020-03-23   | RCA     |