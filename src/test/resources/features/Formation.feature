Feature: Formation Serenity BDD

  Scenario: 01 - Se connecter à l'application
    Given Lancer URL "https://magento.softwaretestingboard.com/"
    Then Verifier le pathname contient "softwaretestingboard"

  Scenario: 02 - Lancer l'application depuis la config
    Given Lancer application web
    Then Verifier le pathname contient "magento"

