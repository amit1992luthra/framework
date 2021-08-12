Feature: Add License

@AddLicense
  Scenario: Add new License
	Given user is already on Login Page
	When user enters "testuser009" and "Password@123"		
	When user clicks on login button
	When user clicks on "AddLicense"
	And user inputs License Number "999999999985" Company Name "TestCompany" and License Status "active"
	And Click save button to save the license
	Then user should see popup with Message "The licence is not on the GS1 Registry Platform."
	When user clicks "Add licence" button from the Popup
	Then user should see popup with Message "License Saved Successfully"