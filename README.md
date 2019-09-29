# CodeChallenge

# Extra Credit
 1.  Feature:  login with invalid credentials 
     Scenario: User try to login using invalid credentials and Error Message 
     Given user is on the login page of https://conversations.dealerinspire.com
     When user enters invalid credenials and try to login
     Then user sees error message on the page.
     
 2.  Feature:  retrieve login credentials with an invalid username 
     Scenario: User try to retrieve login credentials with an invalid username and recieved error message
     Given user is on the login page of https://conversations.dealerinspire.com/password/email
     When user enters invalid user name and try to retrieve
     Then user sees error message with red text on the page.
