Feature: Generate Barcode 
@AKKI1
Scenario: 01_ 1.1 Add Base Unit Product to Activate(Sold to consumer, Fixed level)
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
	#Then verify the barcode generated for "GTIN"
	Then verify the barcode generated with "GTIN" 
  Then verify the product generated on Recent product on home page

	
@AKKI
Scenario: 02_ 1.1 Add Base Unit Product to Activate(Sold to consumer, Variable level) 
	Given user is already on Login Page 
	Then user login to application using role "ACTIVATE_PORTAL" 
	Then user clicks on login button 
	When user clicks "button" named "Add a new Product" 
	When user clicks Vcard with option "The product is sold to consumers at point-of-sale" 
	When user clicks Vcard with option "Unit price varies by product weight or content" 
	When user clicks Vcard with option "The product cannot be broken into other products that are sold separately" 
	When user clicks "Next" to "create the product" 
	When user clicks "Create a new brand" to "create the product" 
	When user creates the brand with name as "TestGSAuto" net content value as "10" country as "Croatia" and Global product category as "10000027" 
	Then verify the product generated on Recent product on home page 
	
@AKKI
Scenario: 03_ 1.1 Add Base Unit Product to Activate(Not Sold to consumer, Fixed level)
	Given user is already on Login Page 
	Then user login to application using role "ACTIVATE_PORTAL" 
	Then user clicks on login button 
	When user clicks "button" named "Add a new Product" 
	When user clicks Vcard with option "The product is not sold to consumers at point-of-sale" 
	When user clicks Vcard with option "Unit price is fixed" 
	When user clicks Vcard with option "The product cannot be broken into other products that are sold separately" 
	When user clicks "Next" to "create the product" 
	When user clicks "Create a new brand" to "create the product" 
	When user creates the brand with name as "TestGSAuto" net content value as "10" country as "Croatia" and Global product category as "10000027" 
	Then verify the barcode generated with "GTIN" 
	Then verify the product generated on Recent product on home page 
	
@AKKI
Scenario: 04_ 1.1 Add Base Unit Product to Activate(Not Sold to consumer, Variable level)
	Given user is already on Login Page 
	Then user login to application using role "ACTIVATE_PORTAL" 
	Then user clicks on login button 
	When user clicks "button" named "Add a new Product"
	When user clicks Vcard with option "The product is not sold to consumers at point-of-sale" 
	When user clicks Vcard with option "Unit price varies by product weight or content" 
	When user clicks Vcard with option "The product cannot be broken into other products that are sold separately" 
	When user clicks "Next" to "create the product" 
	When user clicks "Create a new brand" to "create the product" 
	When user creates the brand with name as "TestGSAuto" net content value as "10" country as "Croatia" and Global product category as "10000027" 
	Then verify the product generated on Recent product on home page 
	
	
@AKKI
Scenario: 05_ 1.1 Create a Products with Image Upload as URL
	Given user is already on Login Page 
	Then user login to application using role "ACTIVATE_PORTAL" 
	Then user clicks on login button 
	When user clicks "button" named "Add a new Product" 
	When user clicks Vcard with option "The product is not sold to consumers at point-of-sale" 
	When user clicks Vcard with option "Unit price varies by product weight or content" 
	When user clicks Vcard with option "The product cannot be broken into other products that are sold separately" 
	When user clicks "Next" to "create the product" 
	When user clicks "Add product image URLs" to "add image URL" 
	When user uploads product image URL as "https://upload.wikimedia.org/wikipedia/en/1/18/Morphing_3D_graph.gif" and Language as "Afar"
	When user uploads product image URL as "http://pngimg.com/uploads/tom_and_jerry/tom_and_jerry_PNG31.png" and Language as "Abkhazian"
	When user uploads product image URL as "http://pngimg.com/uploads/tom_and_jerry/tom_and_jerry_PNG31.png" and Language as "Afrikaans"
	When user uploads product image URL as "http://pngimg.com/uploads/tom_and_jerry/tom_and_jerry_PNG31.png" and Language as "Akan"
	When user clicks "Create a new brand" to "create the product" 
	When user creates the brand with name as "TestGSAuto" net content value as "10" country as "Croatia" and Global product category as "10000027" 
	Then verify the product generated on Recent product on home page with images

	
@Regression-AT2
Scenario: 05_ 1.1 Create a Products with Image Upload from Local Machine 
	Given user is already on Login Page 
	Then user login to application using role "ACTIVATE_PORTAL" 
	Then user clicks on login button 
	When user clicks "button" named "Add a new Product" 
	When user clicks Vcard with option "The product is not sold to consumers at point-of-sale" 
	When user clicks Vcard with option "Unit price varies by product weight or content" 
	When user clicks Vcard with option "The product cannot be broken into other products that are sold separately" 
	When user clicks "Next" to "create the product" 
	When user uploads product image as "Image1"
	And  User enters language "Afar"
  When user clicks "Create a new brand" to "create the product" 
	When user creates the brand with name as "TestGSAuto" net content value as "10" country as "Croatia" and Global product category as "10000027" 
  Then verify the image "Image1" is uploaded successfully
    
    
    
    