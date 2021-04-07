Feature: Test that the get country API works correctly

  Scenario Outline: Test a basic get request
    Given this is test case <testCase>
    When I submit a request to get the country for the country code <countryCode>
    Then I validate the appropriate <country> is returned in the response
    Examples:
      |  testCase | countryCode | country     |
      | "TC01"    | "AF"          | "Afghanistan" |
      | "TC02"    | "CA"          | "Canada" |