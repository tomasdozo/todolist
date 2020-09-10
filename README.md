# todolist
Software Requirements:
  Java 11
  
Endpoints:
  localhost:8080/tareas
    -GET devuelve JSON con los items de la lista. 
		
    -POST Crea un nuevo item, recibe un JSON con la key "text" donde recibe el texto de la lista.
	
    -PUT Setea el estado de un item. Recibe dos keys, la key "id" con el int que identifica al item de la lista, y la key "done" con el boolean del estado del checkbox.
		
	

  localhost:8080/tareas/{id} id es el int que identifica al item a trabajar
    -PUT Actualiza el texto de un item. Recibe un JSON con la key "text" donde esta el nuevo texto, e identifica a que item es por el endpoint.
    -DELETE Borra un item. Identifica cual tiene que borrar por el endpoint.
