Feature: Formation - Account Management

  Scenario: 01 - Créer un nouveau compte
    Given Common - Lancer URL "https://magento.softwaretestingboard.com/"
    Then Common - Verifier le pathname contient "softwaretestingboard"
    When Menu Bar - Acceder page via link "Create an Account"
    Then Common - Verifier le pathname contient "/customer/account/create/"
    When Authentication - Créer un compte
      | Firstname | Lastname | email                 | password     | ConfirmPassword |
      | John      | Doe      | form_$Random@auto.com | password@123 | password@123    |
    Then Common - Verifier Presence Texte "Thank you for registering with Main Website Store"

    @TestTag
  Scenario: 02 - Se Connecter Avec un Login Valid
    Given Common - Lancer URL "https://magento.softwaretestingboard.com/"
    Then Common - Verifier le pathname contient "softwaretestingboard"
    When Menu Bar - Acceder page via link "Sign In"
    Then Common - Verifier le pathname contient "/login/referer/"
    Then Common - Verifier Presence Texte "Customer Login"
    When Authentication - Se Connecter à LUMA
      | email                         | password      |
      | formation.idemia@serenity.com | Password@2024 |
    Then Common - Verifier Presence Texte "Welcome, Formation Idemia!"

