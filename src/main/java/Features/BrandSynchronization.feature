Feature: Synchronization of Brands and Sub Brands

@Regression-AT
Scenario: Add Additional Brand Names while Adding Product, Validate The Sync With Manage Suggestions
Given user is already on Login Page
Then user login to application using role "ACTIVATE_PORTAL" 
Then user clicks on login button
When user clicks "button" named "Add a new Product"
When user clicks Vcard with option "The product is sold to consumers at point-of-sale" 
When user clicks Vcard with option "Unit price is fixed" 
When user clicks Vcard with option "The product cannot be broken into other products that are sold separately" 
When user clicks "Next" to "create the product"
When user adds new "Brand" name
And Country as "Canada" and Global product category as "10005372"
And creates the product with net content value as "100" Unit of Measure as "Pound" 
#Then verify the barcode generated with "GTIN"
Then verify the product code generated on Recent product on home page
When select Manage Suggestions from My Account dropdown
Then values created above should be visible in "What are the most common brand names of the products you sell"

@Regression-AT
Scenario: Add Additional Sub-Brand Names while Adding Product, Validate The Sync With Manage Suggestions
Given user is already on Login Page
Then user login to application using role "ACTIVATE_PORTAL" 
Then user clicks on login button
When user clicks "button" named "Add a new Product"
When user clicks Vcard with option "The product is sold to consumers at point-of-sale" 
When user clicks Vcard with option "Unit price is fixed" 
When user clicks Vcard with option "The product cannot be broken into other products that are sold separately" 
When user clicks "Next" to "create the product"
When user adds new "Sub-Brand" name
And Country as "Colombia" and Global product category as "10008023"
And creates the product with net content value as "100" Unit of Measure as "Kilogram" 
#Then verify the barcode generated with "GTIN"
Then verify the product code generated on Recent product on home page
When select Manage Suggestions from My Account dropdown
Then values created above should be visible in "What are the most common sub-brand names of the products you sell"

@Regression-AT
Scenario: Add a Brand, Validate That The Brand Is Available For Other Users From The Same Company
Given user is already on Login Page
Then user login to application using role "ACTIVATE_PORTAL" 
Then user clicks on login button
When user clicks "button" named "Add a new Product"
When user clicks Vcard with option "The product is sold to consumers at point-of-sale" 
When user clicks Vcard with option "Unit price is fixed" 
When user clicks Vcard with option "The product cannot be broken into other products that are sold separately" 
When user clicks "Next" to "create the product"
When user adds new "Brand" name
And Country as "Canada" and Global product category as "10005372"
And creates the product with net content value as "100" Unit of Measure as "Pound" 
#Then verify the barcode generated with "GTIN"
Then verify the product code generated on Recent product on home page
When select Manage Suggestions from My Account dropdown
Then values created above should be visible in "What are the most common brand names of the products you sell"
When user logout from the application
Then user login to application using role "ACTIVATE_PORTAL2"
And user clicks on login button
Then user is on home page
When select Manage Suggestions from My Account dropdown
Then values created above should be visible in "What are the most common brand names of the products you sell"

@Regression-AT
Scenario: Add a Sub-Brand, Validate That The Sub-Brand Is Available For Other Users From The Same Company
Given user is already on Login Page
Then user login to application using role "ACTIVATE_PORTAL" 
Then user clicks on login button
When user clicks "button" named "Add a new Product"
When user clicks Vcard with option "The product is sold to consumers at point-of-sale" 
When user clicks Vcard with option "Unit price is fixed" 
When user clicks Vcard with option "The product cannot be broken into other products that are sold separately" 
When user clicks "Next" to "create the product"
When user adds new "Sub-Brand" name
And Country as "Colombia" and Global product category as "10008023"
And creates the product with net content value as "100" Unit of Measure as "Kilogram" 
#Then verify the barcode generated with "GTIN"
Then verify the product code generated on Recent product on home page
When select Manage Suggestions from My Account dropdown
Then values created above should be visible in "What are the most common sub-brand names of the products you sell"
When user logout from the application
Then user login to application using role "ACTIVATE_PORTAL2"
And user clicks on login button
Then user is on home page
When select Manage Suggestions from My Account dropdown
Then values created above should be visible in "What are the most common sub-brand names of the products you sell"
