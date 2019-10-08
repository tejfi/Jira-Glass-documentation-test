Feature: Counter

  @TestCaseKey=MTP-T789
  Scenario: Counter

    Given user on the site
    And ensure to provide a login form with the following fields USER and PASSWORD
    When Click on PROJECTS from the menu bar
    And Select project from the dropdown menu
    Then project title shown on the  left side bar
    When Select GLASS DUCOMENTATION on the left  side bar
    Then glass-navigation bar will shown

  Scenario: Logout
    Then I log out
    Then I close browser