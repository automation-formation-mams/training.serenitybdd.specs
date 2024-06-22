Feature: Formation - Advanced Objects

  Scenario: 01 - Gestion des iframes
    Given Common - Lancer URL "https://practice.expandtesting.com/iframe"
    Then Common - Verifier le pathname contient "iframe"
    When Iframe - Switch To Iframe "email-subscribe"
    When Iframe - Sousription avec email "iframe@idemia.com"
    Then Iframe - Verifier le texte "You are now subscribed"