Feature: AddDeleteBrandName

Scenario:
01_ 1.1 Add Brand Name
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
	Then verify the brand name is generated Welcome to Activate Page
	
@Luthra
	Scenario:
	02_ 2.1 Add Sub Brand Name
	Given user is already on Login Page 
	Then user login to application using role "ACTIVATE_PORTAL" 
	Then user clicks on login button 
	When user clicks "button" named "Add a new Product" 
	When user clicks Vcard with option "The product is sold to consumers at point-of-sale" 
	When user clicks Vcard with option "Unit price is fixed" 
	When user clicks Vcard with option "The product cannot be broken into other products that are sold separately" 
	When user clicks "Next" to "create the product" 
	When user clicks "Create a new sub brand" to "create the product"
	When user creates the Sub brand with name "TestGSAuto" net content value as "10" country as "Croatia" and Global product category as "10000027" 
	Then verify the Sub brand name is generated Welcome to Activate Page

	
	
	
		@current
	Scenario:
03_ 3.1 Delete Brand Name
	Given user is already on Login Page 
	Then user login to application using role "ACTIVATE_PORTAL" 
	Then user clicks on login button 
	When user clicks "button" named "Add a new Product" 
	When user clicks Vcard with option "The product is sold to consumers at point-of-sale" 
	When user clicks Vcard with option "Unit price is fixed" 
	When user clicks Vcard with option "The product cannot be broken into other products that are sold separately" 
	When user clicks "Next" to "create the product" 
	When user creates the brand with name "TestGSAuto" net content value as "10" country as "Croatia" and Global product category as "10000027" 
	When user click on my account drop down
	When user clicks on manage suggestions
	Then user delete the brand name
	
	
	Scenario:
04_ 4.1 Delete Sub Brand Name
	Given user is already on Login Page 
	Then user login to application using role "ACTIVATE_PORTAL" 
	Then user clicks on login button 
	When user clicks "button" named "Add a new Product" 
	When user clicks Vcard with option "The product is sold to consumers at point-of-sale" 
	When user clicks Vcard with option "Unit price is fixed" 
	When user clicks Vcard with option "The product cannot be broken into other products that are sold separately" 
	When user clicks "Next" to "create the product" 
	When user creates the brand with name "TestGSAuto" net content value as "10" country as "Croatia" and Global product category as "10000027" 
	When user click on my account drop down
	When user clicks on manage suggestions
	Then user delete the sub brand name
