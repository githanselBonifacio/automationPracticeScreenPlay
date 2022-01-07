Feature: Accounts administration
  I as a customer
  I want to be able to register and access my account
  To buy products offered by the website

  Scenario: register customer
    Given the customer is on the login page
    When the customer enter his email and send register
    And fill out the registration form with the required fields
    Then the customer must be logged in

    Scenario: successful login
      Given the customer is on the login page
      When the customer enters their credentials and sends
      Then he customer must obtain a successful login
