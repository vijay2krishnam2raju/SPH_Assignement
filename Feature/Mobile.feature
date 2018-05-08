
@tag
Feature: User should login to straits times home page and check the main article contents 
  

  @tag1
  Scenario: Login in mobile app 
    Given Open the straitstimes application and Open drawer menu
    When User tap on user icon
    And User enters username and password in Mobile
    Then User should logged in straits times mobile login page 

  @tag2
  Scenario Outline: Contents of main article in mobile
    Given User is on straits times mobile home page has article with picture or video
    When 	Tap on the “latest” tab and tap on the first article
    Then 	Verify that the article is loading successfully with images/videos

    Examples: 
      | name  | value | status  |
      | name1 |     5 | success |
      | name2 |     7 | Fail    |
