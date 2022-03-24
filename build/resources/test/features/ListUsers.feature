Feature: Lista de usuarios
  Como automatizador de pruebas
  Quiero conocer la lista de usuarios validados
  Para validar la existencia en plataforma

  @List
  Scenario: Lista de usuarios
    Given Envio el request a la URL definida
    When Hago la peticion del servicio
    Then Espero la respuesta HTTP 200

  @Login
  Scenario: Login de usuario
    Given Se envia el request del Login
    When Hago la peticion post del servicio
    Then Espero que retorne el token