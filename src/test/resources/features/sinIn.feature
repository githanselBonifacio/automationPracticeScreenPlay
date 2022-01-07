Feature: Accounts administration

  Scenario: Register customer
    Given the customer is on the login page
    When the customer enter his email and send register
    And fill out the registration form with the required fields
    Then the customer must be logged in

    Scenario: successful login
      Given the customer is on the login page
      When the customer enters their credentials and sends
      Then he customer must obtain a successful login
