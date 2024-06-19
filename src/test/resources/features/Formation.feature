Feature: Formation Serenity BDD

  Scenario: 01 - Se connecter avec Serenity BDD
    Given Lancer URL "https://automationexercise.com/"
    When Cliquer sur le menu "Login"
    Then Verifier le pathname contient "/login"

  Scenario: 02 - Lancer l'application depuis la config
    Given Lancer application web
    When Cliquer sur le menu "Login"
    Then Verifier le pathname contient "/login"

