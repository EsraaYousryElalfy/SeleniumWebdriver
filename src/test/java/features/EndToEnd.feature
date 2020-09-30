Feature:  automated end2end test
  Description: the porpuse of this feature is to test end 2 end integration
  
  Scenario Outline: customer place an order by purchasing an item from search
  Given the user is on home page
  When he search for "<productName>"
  And choose to buy two items
  And moves to checkout cart and enter personal details on checkout page and place the order
  Then he can view the order and download the invoice
  
  Examples:
  | productName |
  | Apple MacBook Pro 13-inch |