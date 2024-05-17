Feature: Búsqueda en Airbnb

  @test
  Scenario: : Búsqueda de hoteles en Vichayito
    Given que ingreso al sitio web de Airbnb y cierro cualquier ventana emergente
    When ingreso "Hoteles en Vichayito" en el campo Where to?
    And seleccione SKIP en el campo When's your trip?
    And haga click en Search
    Then deberia haber resultados mayores a 1
    And debería ver el mensaje "Over 1,000 places"

