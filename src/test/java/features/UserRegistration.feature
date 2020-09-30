Feature:  User Registration
  Description: i want to check that the user can register in our e-commerce website
  
  Scenario Outline: User Registration
  Given the user in the home page
  When i click on register link
  And i entered the "<firstName>" , "<lastName>" , "<email>" , "<password>"
  Then the registration page displayed successfully
  
  Examples:
  | firstName | lastName | email | password |
  | Esraa | Elalfy | esraa16a353ss@gmail.com | 123456789 |
  | Esraa | Elalfy | esraa193a2ss@gmail.com | 123456789 |