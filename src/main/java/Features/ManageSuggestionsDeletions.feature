Feature: ManageSuggestionsDeletions
@Lic1
Scenario: 01_ 1.1 Delete a Brand, The Brand Name Should NOT Be Available For The Product Creation
Given user is already on Login Page
Then user login to application using role "ACTIVATE_PORTAL"
Then user clicks on login button
When user clicks "My Account" and "Manage Suggestions"
When user clicks "Delete" a product
When user clicks on Save button
When user clicks "link" named "Add a new Product"
When user clicks Vcard with option "The product is sold to consumers at point-of-sale"
When user clicks Vcard with option "Unit price varies by product weight or content"
When user clicks Vcard with option "The product cannot be broken into other products that are sold separately"
When user clicks "Next" to "create the product"
Then verify the deleted brand name should NOT be available for product creation

@Regression-AT1
Scenario: 01_ 1.2 Delete A Sub-Brand, The Sub-Brand Name Should NOT Be Available For The Product Creation
Given user is already on Login Page
Then user login to application using role "ACTIVATE_PORTAL"
Then user clicks on login button
When user clicks "My Account" and "Manage Suggestions"
When user clicks "Delete" a sub-product
When user clicks on Save button
When user clicks "link" named "Add a new Product"
When user clicks Vcard with option "The product is sold to consumers at point-of-sale"
When user clicks Vcard with option "Unit price varies by product weight or content"
When user clicks Vcard with option "The product cannot be broken into other products that are sold separately"
When user clicks "Next" to "create the product"
Then verify the deleted sub-brand name should NOT be available for product creation

@Regression-AT1
Scenario: 01_ 1.3 Create A Product with New Brand, Delete The Brand, Validate That The Brand Remain On The Product
Given user is already on Login Page
Then user login to application using role "ACTIVATE_PORTAL"
Then user clicks on login button
When user clicks "button" named "Add a new Product"
When user clicks Vcard with option "The product is sold to consumers at point-of-sale"
When user clicks Vcard with option "Unit price is fixed"
When user clicks Vcard with option "The product cannot be broken into other products that are sold separately"
When user clicks "Next" to "create the product"
When user clicks "Create a new brand" to "create the product"
When user creates the brand with name as "TestGSAuto" net content value as "10" country as "Croatia" and Global product category as "10000027"
Then user clicks "Finalise" to Finalise the Product
When user clicks "My Account" and "Manage Suggestions"
When user clicks "Delete" a brand previously used
When user clicks on Save button
Then verify the product generated has deleted Brand

@Regression-AT1
Scenario: 01_ 1.4 Delete a Brand, Validate That The Brand Is NOT Available For Other Users From The Same Company
Given user is already on Login Page
Then user login to application using role "ACTIVATE_PORTAL"
Then user clicks on login button
When user clicks "My Account" and "Manage Suggestions"
When user clicks "Delete" a product
When user clicks on Save button
When user clicks "link" named "Add a new Product"
When user clicks Vcard with option "The product is sold to consumers at point-of-sale"
When user clicks Vcard with option "Unit price varies by product weight or content"
When user clicks Vcard with option "The product cannot be broken into other products that are sold separately"
When user clicks "Next" to "create the product"
Then verify the deleted brand name should NOT be available for product creation
When user logout from the application
Then user login to application using role "ACTIVATE_PORTAL2"
Then user clicks on login button
When user clicks "button" named "Add a new Product" 
When user clicks Vcard with option "The product is sold to consumers at point-of-sale"
When user clicks Vcard with option "Unit price varies by product weight or content"
When user clicks Vcard with option "The product cannot be broken into other products that are sold separately"
When user clicks "Next" to "create the product"
Then verify the deleted brand name should NOT be available for product creation

@Regression-AT1
Scenario: 01_ 1.2 Delete a Sub-Brand, Validate That The Sub-Brand Is NOT Available For Other Users From The Same Company
Given user is already on Login Page
Then user login to application using role "ACTIVATE_PORTAL"
Then user clicks on login button
When user clicks "My Account" and "Manage Suggestions"
When user clicks "Delete" a sub-product
When user clicks on Save button
When user clicks "link" named "Add a new Product"
When user clicks Vcard with option "The product is sold to consumers at point-of-sale"
When user clicks Vcard with option "Unit price varies by product weight or content"
When user clicks Vcard with option "The product cannot be broken into other products that are sold separately"
When user clicks "Next" to "create the product"
Then verify the deleted sub-brand name should NOT be available for product creation
When user logout from the application
Then user login to application using role "ACTIVATE_PORTAL2"
Then user clicks on login button
When user clicks "button" named "Add a new Product" 
When user clicks Vcard with option "The product is sold to consumers at point-of-sale"
When user clicks Vcard with option "Unit price varies by product weight or content"
When user clicks Vcard with option "The product cannot be broken into other products that are sold separately"
When user clicks "Next" to "create the product"
Then verify the deleted sub-brand name should NOT be available for product creation