#language: es
Característica: Caso de estudio IzyAcademy

  Esquema del escenario: Caso de estudio IzyAcademy
    Dado que el usuario ingresa a la página web
    Cuando el usuario completa el formulario de registro con los siguientes datos
      | name   | username   | country   | city   | idNumber   | phone   | email   | password   |
      | <name> | <username> | <country> | <city> | <idNumber> | <phone> | <email> | <password> |
    Entonces el usuario debería ser redirigido a la página correcta
    Y el usuario podra ver su username <username>
    Cuando el usuario es direccionado a la url <urlpost>
    Y el usuario hace clic en el botón Crear nueva categoría
    Y crea una nueva categoría con los siguientes datos
      | nombreCategoria   | descripcion   | dificultad   |
      | <nombreCategoria> | <descripcion> | <dificultad> |
    Entonces el usuario debería ser redirigido a la página de https://auto.izyacademy.com/post
    Y el usuario podra ver la categoría <nombreCategoria> con descripción <descripcion>

     Ejemplos:
     | name | username | country | city | idNumber | phone | email | password | nombreCategoria | descripcion | dificultad | urlPost |
     | Caso prueba Num1 | Prueba | Colombia | Cali | 1087492236 | 612345678 | jesus5.ramirezmin2@jrmail.com | 1234JCP123 | Selenium con Screenplay | Selenium con Screenplay se refiere a un patrón de diseño aplicado a pruebas automatizadas con Selenium, que forma parte de Serenity BDD | medium |  |
