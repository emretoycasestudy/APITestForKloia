Feature: Case For Kloia
  @Case1
  Scenario: Add new one pet information to the list
    Given the user goes to the API
    When the user create new dog information
    Then the user verify the response
  @Case2
  Scenario: Get new pets information
    Given the user goes to the API
    When the user get request of new pets info
    Then the user verify get response body
  @Case3
  Scenario: Delete new pets information
    Given the user goes to the API
    When  the user use delete request for deleting
    Then the user verify the delete new pets info
