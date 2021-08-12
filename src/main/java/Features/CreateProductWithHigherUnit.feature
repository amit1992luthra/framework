Feature: Create Product with Higher Unit

@ProductBarcodex
Scenario: 01_ 1.1 Add Higher Unit Product to Activate (Sold To Customer and Fixed level)
Given user is already on Login Page
Then user login to application using role "ACTIVATE_PORTAL"
Then user clicks on login button
When user clicks "button" named "Add a new Product"
When user clicks Vcard with option "The product is sold to consumers at point-of-sale"
When user clicks Vcard with option "Unit price is fixed"
When user clicks Vcard with option "The product can be broken down into other products that are sold separately"
When user clicks "Next" to "create the product"
When user selects "3" products from the list and clicks "Next"
And enters the quantity as "2,2,1" for products
And enters the Pack Name as "HU Pack" and clicks "Next" and "Finalise"
Then verify the barcode generated with "GTIN"
Then verify the product generated on Recent product on home page

@ProductBarcodex
Scenario: 02_ 1.1 Add Higher Unit Product to Activate (Sold To Customer and Variable level)
Given user is already on Login Page
Then user login to application using role "ACTIVATE_PORTAL"
Then user clicks on login button
When user clicks "button" named "Add a new Product"
When user clicks Vcard with option "The product is sold to consumers at point-of-sale"
When user clicks Vcard with option "Unit price varies by product weight or content"
When user clicks Vcard with option "The product can be broken down into other products that are sold separately"
When user clicks "Next" to "create the product"
When user selects "2" products from the list and clicks "Next"
And enters the quantity as "2,4" for products
And enters the Pack Name as "HU Pack" and clicks "Next" and "Finalise"
Then verify the product generated on Recent product on home page

@ProductBarcodex
Scenario: 03_ 1.1 Add Higher Unit Product to Activate (Not Sold To Customer and Fixed level)
Given user is already on Login Page
Then user login to application using role "ACTIVATE_PORTAL"
Then user clicks on login button
When user clicks "button" named "Add a new Product"
When user clicks Vcard with option "The product is not sold to consumers at point-of-sale"
When user clicks Vcard with option "Unit price is fixed"
When user clicks Vcard with option "The product can be broken down into other products that are sold separately"
When user clicks "Next" to "create the product"
When user selects "2" products from the list and clicks "Next"
And enters the quantity as "2,3" for products
And enters the Pack Name as "HU Pack" and clicks "Next" and "Finalise"
Then verify the barcode generated with "GTIN"
Then verify the product generated on Recent product on home page


@ProductBarcodex
Scenario: 04_ 1.1 Add Higher Unit Product to Activate (Not Sold To Customer and Variable level)
Given user is already on Login Page
Then user login to application using role "ACTIVATE_PORTAL"
Then user clicks on login button
When user clicks "button" named "Add a new Product"
When user clicks Vcard with option "The product is not sold to consumers at point-of-sale"
When user clicks Vcard with option "Unit price varies by product weight or content"
When user clicks Vcard with option "The product can be broken down into other products that are sold separately"
When user clicks "Next" to "create the product"
When user selects "2" products from the list and clicks "Next"
And enters the quantity as "4,5" for products
And enters the Pack Name as "HU Pack" and clicks "Next" and "Finalise"
Then verify the product generated on Recent product on home page