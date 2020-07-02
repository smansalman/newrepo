Feature: Test Environment

	@TestScenario
  Scenario: Register Account for new User
    Given User is on TEST Environment page
    When User click on MyAccount
    And  User click on Register
    And User fills Register form with below information
    
    # if i uncomment the whole line which is also called header then i have to use map otherwise i will use list of list
    # but here i'm going to uncomment it to use map
    |firstName|LastName|E-mail|Telephone|password|
    |kuggiyakugg|kuggu|kuggikuggi@00723.com|1012027668|kuggikugannar|
    And User select 'yes' for Subscribe 
    And User click privacy and policy button 
    And User click Continue button
    Then User should see message  'Your Account Has Been Created!'