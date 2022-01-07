Feature: send message to team
  I as a customer
  I want to be able to send messages to the customer service team
  To let you know my opinions

  Background:
    Given the customer is in the form to send message to customer service

  Scenario: send messages with required fields
    When the client fill in all the required fields and send
    Then the customer should see a shipping confirmation message

  Scenario: send empty message body
    When the client fill in all the required fields except the message and send
    Then the customer should see a shipping error message