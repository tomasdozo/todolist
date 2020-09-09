# todolist
Software Requirements:
  Java 11
  
Endpoints:
  localhost:8080/tareas
    -GET devuelve los items de la lista
    -POST key text String. Crea un nuevo item con con el el texto de la key text
    -PUT key done boolean, key id int. Setea el estado del item con id de la key id a el valor de la key done

  localhost:8080/tareas/{id} id es el id del item a trabajar
    -PUT key text String. Actualiza el texto del item con id id con el valor de text
    -DELETE Borra el item con id id
