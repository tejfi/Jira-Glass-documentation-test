Feature: Login

  Scenario: Login user
    Given user on the site
    Then ensure to provide a login form with the following fields USER and PASSWORD

  Scenario: Logout
    Then I log out
  Scenario: Close browser
    Then I close browser