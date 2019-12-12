Feature: Test various functionality on the site
@RegularTest
 Scenario Outline: Testing the "http://the-internet.herokuapp.com/"
    Given I am on <url>
    When I click on "link 1"
    Then The page opens and I <verify> text
Examples:
|url                                |verify               |
|http://the-internet.herokuapp.com/ |A/B Test Variation 1 |
|http://the-internet.herokuapp.com/ |Add/Remove Elements  |
@SmokeTest
  Scenario: ReTesting the "http://the-internet.herokuapp.com/"
    Given I am on http://the-internet.herokuapp.com/
    When I click on "link 1"
    Then The page opens and I Add/Remove Elements text