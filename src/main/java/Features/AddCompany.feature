Feature: AddCompany

@AddCompany
Scenario Outline: 01_Perform actions on comapny
Given user is already on Login Page
Then user enters "<username>" and "<password>"
When user clicks on login button
Then user is on home page
Then all tabs are displayed on home page
When enter a "<companyname>" and "<country>" combination
Then company should be added successfully
When enter the same combination again
Then system should display an error message
When click on View Existing Company
Then existing company should be displayed with same details
When change the duplicate company to new "<newcountry>" and save
Then new company should get saved

Examples:
	| username | password | companyname | country | newcountry | 
	| testuser009  | Password@123 | Automation Solution | Canada | ADM Solution |