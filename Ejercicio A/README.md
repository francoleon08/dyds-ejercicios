# Sistema para procesar contenido de un blog - Ejercicio A

## Enunciado
Supongamos que como historia de usuario para el sprint actual se quiere extender en qué redes sociales se repostea el contenido. En particular, por ahora, solo se quiere extender para que además de repostearse en Chulogram también se repostee en Tikitaka, luego se agregarán otras redes.
El desarrollador piensa crear una clase ManejadorDeTikitaka y cambiará el método procesar de la clase ProcesadorDeContenidosNuevos para que seguido a ManejadorDeChulogram use a ManejadorDeTikitaka. Si lo implementa de esta manera, ¿qué principio SOLID no estaría cumpliendo? ¿Cómo solucionaría usted esta implementación para que sí lo cumpla? Justifique las respuestas a cada pregunta.

```java
public void procesar(Contenido contenidoNuevo) {
   if (contenidoNuevo.validar() && repo.grabar(contenidoNuevo)) {
      ManejadorDeChulogram.getInstance().postearContenido(contenidoNuevo);
   }
}
```

## Problema
El código no respeta el principio open-close, ya que en el caso de necesitar postear en una nueva red social (extender el código)
se deberia modificar el método procesar(), lo que rompe el princpio mencionado.

## Solución
La solución es crear una jerarquía de herencia "ManagerRedSocial" que contenga un método asbtracto postearContenido() y que cada red social
que implemente la clase asbtracta deba implementar dicho método. Luego, en el método procesar() se deberá recibir un ManagerRedSocial como parámetro
y llamar al método postearContenido() de dicho objeto.

```java
public void procesar(Contenido contenidoNuevo, ManagerRedSocial redSocial) {
   if (contenidoNuevo.validar() && repo.grabar(contenidoNuevo)) {
      redSocial.postearContenido(contenidoNuevo);
   }
}
```
Este código respeta el principio open-close, ya que en el caso de agregar una nueva red social a la jeraquía de herencia, no se deberá modificar el método procesar().

## Ejecución de Pruebas
Se han modificado las pruebas para garantizar que los cambios realizados no afecten la funcionalidad del sistema.

## Autor
* [Franco Leon](https://github.com/francoleon08)

## Licencia
El enunciado y código original fueron provistos por la cátedra Diseño y Desarrollo de Software, del profesor Sebastian Gottifredi.