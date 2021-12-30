Feature: Usuario no Encontrado
  Yo como un nuevo cliente de la página de la direccion https://reqres.in/ quiero registrarme exitosamente


  Scenario: Usuario no encontrado
    Given el Cliente está en la Url https://reqres.in/ y Busca el usuario Veintitres.
    When cuando el cliente realiza la peticion de busqueda  de usuario
    Then el cliente deberá ver un codigo de respuesta de usuario no encontrado