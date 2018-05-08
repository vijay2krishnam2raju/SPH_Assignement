
@tag
Feature: User should login to straits times home page and check the main article contents
 

  @LoginTest
  Scenario: Login with valid credentials
    Given User is on straits times home page
    When 	User naviagtes to Login page
    And 	User enters username and password
    Then 	User should logged in straits times login page

  @Articletest
  Scenario Outline: Contents of main article
    Given User is on straits times home page has article with picture or video
    When 	User click on the  article
    Then 	User navigates to the main article and picture/video is present in the article
    
    

    Examples: 
      | username     | password    | status  |
      | digitaltest2 | Password1 	 | success |
      
