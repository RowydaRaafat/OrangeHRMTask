@smoke
  Feature: Login to OrangeHRM
    Scenario: Login to OrangeHRM successfully
      Given enter username and password
      Then click on login button

      Given press on Admin tab
      Then get number of records
      Then Click on add button
      Then fill required data and save

      When number of records increase 1 add new employee
      Then search with the username for the new user
      Then Delete the new user
      Then Get the number of records after deletion


