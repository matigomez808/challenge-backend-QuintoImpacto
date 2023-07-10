# challenge-backend-QuintoImpacto

endpoints:
/alumno
/alumno/{id}
/alumno/eliminar/{id}

/curso
/curso/{id}
/curso/inscripcion/{id}
/curso/asignarProfe/{id}

/profe
/profe/{id}
/profe/eliminar/{id}


ejemplo de Create a /alumno o / profe:
´´j́son
{
	"datosPersonales": {
                      "nombre": "Marta",
	                    "apellido": "Perez",
	                    "dni": "36548785"},
	"contacto": {
	              "direccion":"Calle falsa 123",
	              "ciudad": "Trucha",
	              "telefono": "12345678"}
}
´´´
ejemplo de Update /alumno o / profe:
{
	"datosContacto": {
	"direccion":"Calle falsa 133",
	"ciudad": "Trucha",
	"telefono": "12345678"}
}

ejemplo de Create /curso:
{
	"nombre": "Computacion I",
	"turno": "NOCHE"
}

ejemplo de /curso/asignarProfe/{id} o /curso/inscripcion/{id}
recibe id del curso por url y id de persona en json
{
"id": "2"
}

los endpoints de /eliminar son con POST ya que son deletes logicos, solo cambian el valor del campo "activo" dentro del registro. un campo "activo=false" no aparece cuando se llama GET /{endpoint}

