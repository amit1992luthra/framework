Feature: Manage Suggestions

Scenario: 01_Verify the Manage suggestions button
Given user is already on Login Page
Then user enters "test@gs1go-01.com" and "Password@123"
Then user clicks on login button
When user click on my account drop down
When user clicks on manage suggestions
Then verify the "Welcome to Activate" page
@Regression-AT
Scenario Outline: 02_Add six Brand names From Manage Suggestions Page, Brands Should Be Available While Product Creation
Given user is already on Login Page
Then user login to application using role "ACTIVATE_PORTAL"
Then user clicks on login button
When user clicks "My Account" and "Manage Suggestions"
Then add brand "<brandname>" in field
Then click on save button
Then verify the "Thank you" message for adding sub brand
Then click on "Start Using Activate" button
When user clicks "button" named "Add a new Product"
When user clicks Vcard with option "The product is sold to consumers at point-of-sale"
When user clicks Vcard with option "Unit price varies by product weight or content"
When user clicks Vcard with option "The product cannot be broken into other products that are sold separately"
When user clicks "Next" to "create the product"
Then Verify the Values add in "Brand" from manage suggestions
Examples:
|brandname|
|BN012345|

@Regression-AT
Scenario Outline: 03_Add six Sub-Brand names From Manage Suggestions Page, Sub-Brands Should Be Available While Product Creation
Given user is already on Login Page
Then user login to application using role "ACTIVATE_PORTAL"
Then user clicks on login button
When user clicks "My Account" and "Manage Suggestions"
Then add sub brand "<subbrandname>" in field
Then click on save button
Then verify the "Thank you" message for adding sub brand
Then click on "Start Using Activate" button
Then user clicks "button" named "Add a new Product"
Then user clicks Vcard with option "The product is sold to consumers at point-of-sale"
Then user clicks Vcard with option "Unit price varies by product weight or content"
Then user clicks Vcard with option "The product cannot be broken into other products that are sold separately"
Then user clicks "Next" to "create the product"
Then Verify the subbrand add in "Sub-brand" from manage suggestions
Examples:
|subbrandname|
|SB012345|

