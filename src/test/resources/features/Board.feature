@wip
Feature: As a user I should create a board

  Background:
    Given the user is on the login page
    When the user enters with valid credentials
    Then the user is on Board Page

  Scenario: The user verify 2 cards
    And Verify there are 2 cards on the board

  Scenario: The user verify the card with comment
    And verify there is a card with comment

  Scenario: The user add new comment
    And clicks on the card
    And writes a comment inside the card as "Comment"
    And clicks the save button
    And Should be seen added comment as "Comment"

  Scenario: The user set the card as DONE
    And drag and drop the card to Done
    And the card should be seen in Done




