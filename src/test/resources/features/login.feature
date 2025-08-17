#language: es

Característica: Iniciar sesión con un usuario válido

  Esquema del escenario: Iniciar sesión con un usuario válido
    Dado que el usuario ingresa a la página web
    Cuando el usuario ingresa usuario y contraseña
    Entonces el usuario debería ser redirigido a la página correcta
    Y el usuario podra ver su username <username>

    Ejemplos:
      | username |
      | Yisus    |