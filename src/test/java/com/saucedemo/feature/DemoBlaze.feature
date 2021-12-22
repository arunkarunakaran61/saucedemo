@saucedemo
Feature: Sauce Demo Automation Test Script

Scenario: Verify Login functionality and checkout the product
When User on Sauce demo application
And User login application with credentials 'standard_user' and 'secret_sauce'
Then User verify Product Listing Page has products
When User select any product to cart and verify same product added
And User navigate to shopping cart page
And User verify the product added is correct
And User add a product from cart to checkout page
And User enter checkout information 'FirstName', 'LastName' and '1234'
And User click on place order and verify the success message

Scenario: Veirfy Invalid Login functionality
When User on Sauce demo application
And User login application with credentials 'locked_out_user' and 'secret_sauce'
Then User should see error message for invalid user

Scenario: Verify Expected Product is added to bag
When User on Sauce demo application
And User login application with credentials 'standard_user' and 'secret_sauce'
And User select a product 'Sauce Labs Bolt T-Shirt' to add in cart bag

Scenario: Verify PLP product prices matching with individual product price
When User on Sauce demo application
And User login application with credentials 'standard_user' and 'secret_sauce'
And User get all inventory price from Plp and remove dollar symbol
Then User click on individual page and verify the price same