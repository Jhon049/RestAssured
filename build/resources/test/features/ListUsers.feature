Feature: Lista de usuarios
  Como automatizador de pruebas
  Quiero conocer la lista de usuarios validados
  Para validar la existencia en plataforma

  Scenario: Lista de usuarios
    Given Envio el request a la URL definida
    When Hago la peticion del servicio
    Then Espero la respuesta HTTP 200