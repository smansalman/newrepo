Feature: Login to Test Environment 

Background:
	Given User is on TEST Environment page
	
	
	Scenario: Login to MyAccount
	When User click on MyAccount
	And  User click on Login
	And  User enters username 'sdet@tekschool.us' and Password 'sdet'
	And  User click on Login button 
	Then User Should be logged in to user Dashboard