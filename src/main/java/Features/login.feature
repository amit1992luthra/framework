Feature: Login to GS1




@Current1
Scenario Outline: 01_GS one Login Scenario
Given user is already on Login Page
Then user enters "<username>" and "<password>"
Then user clicks on login button
Then user is on home page
Then all tabs are displayed on home page


Examples:
	| username | password | 
	| testuser009  | Password@123 |

	

Scenario Outline: 02_GS one Login Scenario
Given user is already on Login Page
Then user enters "<username>" and "<password>"
#Then user clicks on login button
#Then user is on home page


Examples:
	| username | password |
	| testuser009  | Password@123 |	
	
	
	


