#language: es
@CrearNuevaCategoria
Característica: Crear una nueva categoría

  Antecedentes:
    Dado que el usuario ingresa a la página web
    Cuando el usuario ingresa usuario y contraseña
    Entonces el usuario podra ver su username Yisus

  @CrearCategoria @IniciarSesion
  Esquema del escenario: Crear una nueva categoría
    Cuando el usuario es direccionado a la url <urlpost>
    Y el usuario hace clic en el botón Crear nueva categoría
    Y crea una nueva categoría con los siguientes datos
      | nombreCategoria   | descripcion   | dificultad   |
      | <nombreCategoria> | <descripcion> | <dificultad> |
    Entonces el usuario debería ser redirigido a la página de <urlpost>
    Y el usuario podra ver la categoría <nombreCategoria> con descripción <descripcion>

    Ejemplos:
      | nombreCategoria  | descripcion          | dificultad | urlpost                          |
      | Tecnologia-Jesus | Screenplay con Jesus | medium     | https://auto.izyacademy.com/post |

