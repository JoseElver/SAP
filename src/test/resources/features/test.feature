Feature: Testing the jar file

  Scenario: Successfully connection to SAP GUI
    Given Mike is ready to open the connection
    When attemps to connect to SAPLogon
    Then will success the connection
