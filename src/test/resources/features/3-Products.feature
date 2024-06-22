Feature: Formation - Products Management

  Scenario: 01 -  Rechercher un Produit par Fixture
    Given Common - Lancer URL "https://magento.softwaretestingboard.com/"
    Then Common - Verifier le pathname contient "softwaretestingboard"
    When Products - Rechercher Produit Par fixture