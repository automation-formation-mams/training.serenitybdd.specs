Feature: Formation - Advanced Objects

  Scenario: 01 - Gestion des iframes
    Given Common - Lancer URL "https://practice.expandtesting.com/iframe"
    Then Common - Verifier le pathname contient "iframe"
    When Iframe - Switch To Iframe "email-subscribe"
    When Iframe - Sousription avec email "iframe@idemia.com"
    Then Iframe - Verifier le texte "You are now subscribed"

  Scenario: 02 - Gestion des alertes
    Given Common - Lancer URL "https://practice-automation.com/popups/"
    Then Common - Verifier le pathname contient "popups"
    When Alert - Verifier Text dans Alert "Hi there, pal!"
    And Alert - Valider Alert window
    And Alert - Verifier Text dans Confirm "OK or Cancel, which will it be?"
    And Alert - Valider Alert window
    Then Common - Verifier Presence Texte "OK it is!"
    When Alert - Verifier Text dans Confirm "OK or Cancel, which will it be?"
    And Alert - Cancel Alert window
    Then Common - Verifier Presence Texte "Cancel it is!"
    When Alert - Verifier Text dans Prompt "Hi there, what's your name?"
    When Alert - Saisir "Formation Idemia" dans Prompt
    And Alert - Valider Alert window
    Then Common - Verifier Presence Texte "Nice to meet you, Formation Idemia!"

  Scenario: 03 - Gestion des Fenetres
    Given Common - Lancer URL "https://practice-automation.com/window-operations/"
    Then Common - Verifier le pathname contient "window-operations"
    When Fenetre - Ouvrir Nouvel Onglet By "New Tab"
    And Fenetre - Basculer vers l'onglet "Home | automateNow"
    Then Common - Verifier Presence Texte "Start learning"
    Then Common - Verifier Presence Texte "Our latest posts"
    And Fenetre - Fermer l'onglet "Home | automateNow"
    When Fenetre - Basculer vers l'onglet "Window Operations | Practice Automation"
    Then Common - Verifier Presence Texte "Click to open a new browser tab."
    Then Common - Verifier Presence Texte "Click to replace the current page with a new URL."
    Then Common - Verifier Presence Texte "Click to open a new browser window."
    When Fenetre - Ouvrir Nouvel Onglet By "Replace Window"
    Then Common - Verifier Presence Texte "Start learning"
    Then Common - Verifier Presence Texte "Our latest posts"
    Then Common - Verifier le pathname contient "https://automatenow.io/"
    Given Common - Lancer URL "https://practice-automation.com/window-operations/"
    When Fenetre - Ouvrir Nouvel Onglet By "New Window"
    And Fenetre - Basculer vers l'onglet "Home | automateNow"
    Then Common - Verifier Presence Texte "Start learning"
    Then Common - Verifier Presence Texte "Our latest posts"
    And Fenetre - Fermer l'onglet "Home | automateNow"




