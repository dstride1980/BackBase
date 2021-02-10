Feature: add_a_computer

  @Automated
  Scenario Outline: Add a computer to the Database
    Given I am on the computer database website
    When I add a new computer with the details "<computer_name>","<introduced>","<discontinued>" and "<company>"
    Then the new computer is displayed with the details "<computer_name>","<introduced>","<discontinued>" and "<company>"
    Examples:
      | computer_name | introduced | discontinued | company |
      | AAAAA         | 1980-03-23 | 2020-03-23   | RCA     |

  @Automated
  Scenario Outline: Computer name is mandatory adding a computer
    Given I am on the computer database website
    When I add a new computer with the details "<computer_name>","<introduced>","<discontinued>" and "<company>"
    Then a error is displayed
    And the computer is not created
    Examples:
      | computer_name | introduced | discontinued | company |
      |               | 1980-03-23 | 2020-03-23   | RCA     |