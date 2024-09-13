Feature: validate login

Scenario: Successful Login 
	Given the user is on the nopCommerce login page 
	#When the user enters valid credentials (username: "deals4sekhar@gmail.com", password: "password123")
	When the user enters valid credentials (username:"student", password: "Password123") 
	And the user clicks on the Login button 
	Then the user should be redirected to the My Account page 
	And the user should see a welcome message

