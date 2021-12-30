Feature: Registro Exitoso
  Yo como un nuevo cliente de la página de la direccion https://reqres.in/ quiero registrarme exitosamente


  Scenario: Registro con exito
    Given el Cliente está en la Url https://reqres.in/ y digita su usuario "eve.holt@reqres.in" y contraseña "pistol"
    When cuando el cliente realiza la peticion de creacion de usuario
    Then el cliente deberá ver un codigo de respuesta éxitoso y los datos creados

