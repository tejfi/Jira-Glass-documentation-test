Feature: Workflow

  @TestCaseKey=MTP-T833
  Scenario: Login user
    Given user on the site
    Then ensure to provide a login form with the following fields USER and PASSWORD

    When Click on PROJECTS from the menu bar
    And Select project from the dropdown menu
    Then project title shown on the  left side bar
    When Select PROJECT SETTINGS bottom of the left side
    Then Validate user on the PROJECT SETTINGS page
    When Click on Workflows link on the left side bar

  Scenario Outline: Create the Workflow
    Then Workflow project config Header will shown
    When ADD WORKFLOW button is clicked
    Then import FROM BUNDLE option is shown
    When import FROM BUNDLE option is clicked
    Then SELECTION OF WORKFLOWS are shown
    When select Easy Agile Scrum Workflow for Jira bundle
    And Add name to the Worfklow "<WorkflowName>"
    When click NEXT button
    Then Map Workflow Statuses will be shown
    When click the FINISH button
    Then DIALOG MESSAGE shown contains "<WorkflowName>"
    And select task
    And Click submit button
    And click the PUBLISH button
    When click the Associate button
    Then Workflow has been successfully imported message will shown
    Then check Worflow is avaiable "<WorkflowName>"
    Then DIALOG MESSAGE shown contains "<WorkflowName>"
    And ensure user entered valid password
    And click the FINISH button
    Then check Worflow is avaiable "<WorkflowName>"
    When click the Associate button
    Then Your workflows have been published message shown.
    When click remove <"WorkflowName">  under the actions
    And click the PUBLISH button
    Then <"Publish Workflows">shown will shwon on the left side
    And click the Associate button
    Then Your workflows have been published message shown.


    Examples:
      | WorkflowName  | "Publish Workflows" |
      | kkao   | Publish Workflows   |


  Scenario: Logout
    Then I log out

  Scenario: Close browser
    Then I close browser