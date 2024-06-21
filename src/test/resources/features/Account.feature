Feature: Formation - Account Management

  Scenario: 01 - Créer un nouveau compte
    Given Common - Lancer URL "https://magento.softwaretestingboard.com/"
    Then Common - Verifier le pathname contient "softwaretestingboard"
    When Menu Bar - Acceder page via link "Create an Account"
    Then Common - Verifier le pathname contient "/customer/account/create/"
    When Authentication - Créer un compte
      | Firstname | Lastname | email              | password     | ConfirmPassword |
      | John      | Doe      | formation@auto.com | password@123 | password@123    |
    Then Common - Verifier Presence Texte "My Account"

