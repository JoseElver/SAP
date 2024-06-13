Feature: Testing the jar file

  Scenario Outline: Successfully connection to SAP GUI
    Given Mike is ready to open the connection
      | user   | pass   | server   | port   |
      | <user> | <pass> | <server> | <port> |
    When attemps to connect to SAPLogon with
      | user   | pass   |
      | <user> | <pass> |
    Then will success the connection
    Examples:
      | user     | pass       | server                           | port |
      | yeferari | Contra123* | srvsapconexion.dyndns-server.com | 3200 |
