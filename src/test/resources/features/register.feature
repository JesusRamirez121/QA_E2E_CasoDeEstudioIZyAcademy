#language: es
Característica: Registro de usuario

  Esquema del escenario: Registro de un nuevo usuario
    Dado que el usuario ingresa a la página web
    Cuando el usuario completa el formulario de registro con los siguientes datos
      | name   | username   | country   | city   | idNumber   | phone   | email   | password   |
      | <name> | <username> | <country> | <city> | <idNumber> | <phone> | <email> | <password> |
    Entonces el usuario debería ser redirigido a la página correcta
    Y el usuario podra ver su username <username>

     Ejemplos:
     | name | username | country | city | idNumber | phone | email | password |
     | Caso prueba Num1 | Prueba | Colombia | Cali | 1087492236 | 612345678 | jesus3.ramirezmin2@jrmail.com | 1234JCP123 |
