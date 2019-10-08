Feature: Workflow
  @TestCaseKey=MTP-T833
  Scenario: Workflow

    Given user on the site
    And ensure to provide a login form with the following fields USER and PASSWORD
    When Click on PROJECTS from the menu bar
    And Select project from the dropdown menu
    Then project title shown on the left side bar
    When Select bottom of the left side
    Then Validate user on the PROJECT SETTINGS page
    When Click on Workflows link on the left side bar

    Then Workflow project config Header will shown
    When ADD WORKFLOW button is clicked
    Then import FROM BUNDLE option is shown
    When import FROM BUNDLE option is clicked
    Then SELECTION OF WORKFLOWS are shown
    When selectEasy Agile Scrum Workflow for Jira bundle
    And Add name to the Worfklow "<WowkFlowName>"
    When click NEXT button
    Then Map Workflow Statuses will be shown
    When click NEXT button
    Then Preview of Import will shown
    When click next button
    Then ADMINISTRATOR ACCES will shown
    And ensure user entered valid password
    And clicked the Submit button
    Then Workflow has been successfully imported message will shown
    And click the FINISH button
    Then DIALOG MESSAGE shown contains "<WowkFlowName>"
    And select task
    And Click submit button
    And check Worflow is avaiable