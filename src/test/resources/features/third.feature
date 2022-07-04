Feature: Параметризированные тесты

  Scenario: Простая параметризация
    Given open browser
    * login page is opened
    When user with email"atrostynko@mail.com" and psw "Americana#1" logged in
    Then add project button is displayed
    And username is "Alex Tros"
    And projects count is 15
    And project is true

  Scenario Outline: Таблицы
    Given open browser
    * login page is opened
    When user with email"<email>" and psw "<psw>" logged in
    Then username is "<visibleText>"
    Examples:
      |email|psw|visibleText|
      | atrostynko@mail.com|Americana#1| Alex Tros|
      | test@mail.com|123| 123|