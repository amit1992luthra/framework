Feature: LicenseNotifications
@Lic1
Scenario: 01_ 1.1 Single ACTIVE Licence is Available, No Notification Appears
Given user is already on Login Page
Then user login to application using role "ACTIVATE_PORTAL_SINGLE_LICENCE"
Then user clicks on login button
When user clicks "link" named "Add a new Product"
Then verify that the user is navigated to "Tell us about your product" page

@Lic
Scenario: 01_ 1.2 Two or More Licences are Available, User Must Choose the Licence to activate (Notification “Licence”)
Given user is already on Login Page
Then user login to application using role "ACTIVATE_PORTAL"
Then user clicks on login button
When user clicks "link" named "Add a new Product"
Then verify that "You need to activate a licence first" message appears
When user clicks on "Activate licence" button
Then verify that the user is navigated to "Your licences" page
Then user Activate a Licence with capacity available
Then user clicks on the "Link_Home" link in the menu
When user clicks "link" named "Add a new Product"
Then verify that the user is navigated to "Tell us about your product" page

@Lic
Scenario: 01_ 1.6 Licence Capacity has Exhausted, More Than One Licence Available, Check for Activate Licence Notification 
Given user is already on Login Page
Then user login to application using role "ACTIVATE_PORTAL_CAP_EXH_ML"
Then user clicks on login button
When user clicks "link" named "Add a new Product"
Then verify that "You need to activate a licence first" message appears
When user clicks on "Activate licence" button
Then verify that the user is navigated to "Your licences" page

@Lic
Scenario: 01_ 1.3 Licence Capacity has Exhausted, Only One Licence Available, Check for Contact GS1 Notification
Given user is already on Login Page
Then user login to application using role "ACTIVATE_PORTAL_CAP_EXH_SL"
Then user clicks on login button
When user clicks "link" named "Add a new Product"
Then verify that "You need a new GS1 licence to add more products" message appears
When user clicks on "Contact GS1" button
Then verify that the user is navigated to "Support" page

@Lic
Scenario: 01_ 1.4 Available Licence is Inactive, Only One Licence Available, Check for Contact GS1 Notification
Given user is already on Login Page
Then user login to application using role "ACTIVATE_PORTAL_INACTIVE_LICENCE"
Then user clicks on login button
When user clicks "link" named "Add a new Product"
Then verify that "You need a new GS1 licence to add more products" message appears
When user clicks on "Contact GS1" button
Then verify that the user is navigated to "Support" page

@Lic
Scenario: 01_ 1.5 NO Available Licence, Check for Contact GS1 Notification
Given user is already on Login Page
Then user login to application using role "ACTIVATE_PORTAL_NO_LICENCE"
Then user clicks on login button
When user clicks "link" named "Add a new Product"
Then verify that "You need a new GS1 licence to add more products" message appears
When user clicks on "Contact GS1" button
Then verify that the user is navigated to "Support" page

@Lic
Scenario: 01_ 1.7 User Wants to Finalize the Draft but Licence Capacity Exhausted. No More Licences Available.
Given user is already on Login Page
Then user login to application using role "ACTIVATE_PORTAL_DRAFT_NO_LICENCE"
Then user clicks on login button
When user clicks draft product named "Draft Product F 121 ptl"
When user clicks on Finalise button
Then verify that "You need a new GS1 licence to add more products" message appears
When user clicks on "Contact GS1" button
Then verify that the user is navigated to "Support" page

@Lic
Scenario: 01_ 1.8 User Wants to Finalize the Draft but Licence Capacity Exhausted. One or More Licences Available.
Given user is already on Login Page
Then user login to application using role "ACTIVATE_PORTAL_DRAFT_LICENCE"
Then user clicks on login button
When user clicks draft product named "Draft with Multiple licence 121 dmq"
When user clicks on Finalise button
Then verify that "You need a new GS1 licence to add more products" message appears
When user clicks on "Activate licence" button
Then verify that the user is navigated to "Your licences" page

@Lic
Scenario: 01_ 1.9 (PS)Licence Capacity has Exhausted, More Than One Licence Available, Check for Activate Licence Notification 
Given user is already on Login Page
Given user login to application using role "ACTIVATE_PORTAL_CAP_EXH_ML"
Then user clicks on login button
Then user clicks on the "Link_Products" link in the menu
When user clicks button named "+ Add a new product"
Then verify that "You need to activate a licence first" message appears
When user clicks on "Activate licence" button
Then verify that the user is navigated to "Your licences" page

@Lic
Scenario: 01_ 1.10 (PS)Licence Capacity has Exhausted, Only One Licence Available, Check for Contact GS1 Notification
Given user is already on Login Page
Then user login to application using role "ACTIVATE_PORTAL_CAP_EXH_SL"
Then user clicks on login button
Then user clicks on the "Link_Products" link in the menu
When user clicks button named "+ Add a new product"
Then verify that "You need a new GS1 licence to add more products" message appears
When user clicks on "Contact GS1" button
Then verify that the user is navigated to "Support" page

@Lic
Scenario: 01_ 1.11 (PS)Available Licence is Inactive, Only One Licence Available, Check for Contact GS1 Notification
Given user is already on Login Page
Then user login to application using role "ACTIVATE_PORTAL_INACTIVE_LICENCE"
Then user clicks on login button
Then user clicks on the "Link_Products" link in the menu
When user clicks button named "+ Add a new product"
Then verify that "You need a new GS1 licence to add more products" message appears
When user clicks on "Contact GS1" button
Then verify that the user is navigated to "Support" page

@Lic
Scenario: 01_ 1.12 (PS)NO Available Licence, Check for Contact GS1 Notification
Given user is already on Login Page
Then user login to application using role "ACTIVATE_PORTAL_NO_LICENCE"
Then user clicks on login button
Then user clicks on the "Link_Products" link in the menu
When user clicks button named "+ Add a new product"
Then verify that "You need a new GS1 licence to add more products" message appears
When user clicks on "Contact GS1" button
Then verify that the user is navigated to "Support" page

@Lic
Scenario: 01_ 1.13 (PS)Single ACTIVE Licence is Available, No Notification Appears
Given user is already on Login Page
Then user login to application using role "ACTIVATE_PORTAL_SINGLE_LICENCE"
Then user clicks on login button
Then user clicks on the "Link_Products" link in the menu
When user clicks button named "+ Add a new product"
Then verify that the user is navigated to "Tell us about your product" page

@Lic
Scenario: 01_ 1.14 (PS)User Wants to Finalize the Draft but Licence Capacity Exhausted. No More Licences Available.
Given user is already on Login Page
Then user login to application using role "ACTIVATE_PORTAL_DRAFT_NO_LICENCE"
Then user clicks on login button
Then user clicks on the "Link_Products" link in the menu
Then user search the product "Draft Product F 121 ptl"
When user clicks on Finalise button
Then verify that "You need a new GS1 licence to add more products" message appears
When user clicks on "Contact GS1" button
Then verify that the user is navigated to "Support" page

@Lic
Scenario: 01_ 1.15 (PS)User Wants to Finalize the Draft but Licence Capacity Exhausted. One or More Licences Available.
Given user is already on Login Page
Then user login to application using role "ACTIVATE_PORTAL_DRAFT_LICENCE"
Then user clicks on login button
Then user clicks on the "Link_Products" link in the menu
Then user search the product "Draft with Multiple licence 121 dmq"
When user clicks on Finalise button
Then verify that "You need a new GS1 licence to add more products" message appears
When user clicks on "Activate licence" button
Then verify that the user is navigated to "Your licences" page