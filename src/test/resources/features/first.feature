Feature: Начальный тест для изучение Cucumber

  Scenario: Простой тест без тела

    Scenario: Просто тест с given
      Given Открыт браузер
    Scenario: Простой тест с Given и When
      Given open browser
      When login page is opened

  Scenario: Простой тест со всеми ключевыми словами
    Given open browser
    When login page is opened
    Then username field is displayed

  Scenario: Использование End в Given
    Given open browser
    And login page is opened

  Scenario: Использование End в Given
    Given open browser
    And login page is opened
    Then username field is displayed
