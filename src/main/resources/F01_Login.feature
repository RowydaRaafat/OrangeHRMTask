@smoke
  Feature: Login to OrangeHRM
    Scenario: Login to OrangeHRM successfully
      Given enter username and password
      Then click on login button

      Given press on Admin tab
      Then get number of records
      Then Click on add button

