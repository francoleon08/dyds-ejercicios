# Sistema filtros juego de rol - Ejercicio C

## Enunciado
Supongamos que que el equipo se encuentra desarrollando diferentes partes de un juego de rol, y en particular viene trabajando en varios sprints las herramientas para seleccionar personajes de una lista según diferentes atributos que se fueron agregando durante el desarrollo. En la actualidad cada personaje esta caracterizado por la siguiente clase:

```java
public class Personaje {
    private String nombre;
    private Profesion profesion;
    private int nivel;
    private int hp;
    
    //Getters y Setters
}
```
En el primer Sprint solo se requería el seleccionar personaje por nombre. Luego fue necesario agregar una forma de seleccionar aquellos que tuvieran cierto nivel. En el último sprint, se agregaron las profesiones a los personajes, por lo tanto como historia de usuario se requería que se seleccionen personajes según su profesión. El equipo de desarrollo fue implementando esto creando un método nuevo por cada selección solicitada utilizando filtros específicos para cada una de ella, de la siguiente manera:
    
```java
public class LogicaPersonajes {

    private FiltrosPersonaje filtro = new FiltrosPersonaje();
    private List<Personaje> personajes =  new ArrayList<Personaje>();

    public List<Personaje> getPersonajesConNombre(String nombre) {
        return filtro.filtroContieneNombre(personajes, nombre);
    }

    public List<Personaje> getPersonajesConNivelMayorA(int nivel) {

        return filtro.filtroSuperaNivel(personajes, nivel);
    }

    public List<Personaje> getPersonajesConProfesion(Profesion profesion) {

        return filtro.filtradoPorProfesion(personajes, profesion);
    }

    public List<Personaje> getPersonajes() { return personajes; }

}
```
explique para este código qué principio SOLID no se está cumpliendo, y de qué manera podría resolverlo. Modifique el código de manera que solucione el problema y mantenga la correctitud de los tests.

## Problema
El código no respeta varios principios importantes de diseño de software, lo que puede llevar a una arquitectura frágil y difícil de mantener a largo plazo:

**Principio de Responsabilidad Única (Single Responsibility Principle - SRP):**
   La clase `LogicaPersonajes` viola el principio SRP al implementar distintos filtros para seleccionar personajes. Esto significa que tiene más de una razón de cambio, ya que si se desea agregar un nuevo filtro, se deberá modificar esta clase.

**Principio Abierto-Cerrado (Open-Closed Principle - OCP):**
   Tampoco se cumple con el principio OCP, ya que para agregar un nuevo filtro, se debe modificar la clase `LogicaPersonajes` en lugar de extenderla o modificarla sin necesidad de cambiar su código existente.

**Principio de Inversión de Dependencias (Dependency Inversion Principle - DIP):**
   La clase `LogicaPersonajes` depende directamente de las clases `FiltrosPersonaje` y `Profesion`, en lugar de depender de abstracciones. Esto viola el principio de inversión de dependencias.


## Solución
Para resolver este problema, se puede utilizar el patrón Strategy. Se creará una interfaz Filtro, 
que será implementada por las clases FiltroNombre, FiltroNivel y FiltroProfesion implementando cada una el filtro correspondiente. 
Luego, se modificará la clase LogicaPersonajes para que reciba un filtro en su constructor y la lista de personajes, y eliminando los 
métodos getPersonajesConNombre(), getPersonajesConNivelMayorA() y getPersonajesConProfesion().
Se implementa un nuevo método getPersonajesConFiltro() que recibe un filtro de tipo Object permitiendo recibir cualquier filtro que implemente la interfaz Filtro.
De esta forma si se añaden mas filtros a la aplicación, no será necesario modificar la clase LogicaPersonajes.

```java
public LogicaPersonajes(List<Personaje> personajes, Filtro filtro) {
    this.personajes = personajes;
    this.filtro = filtro;
}
```
```java
public List<Personaje> getPersonajesConFiltro(Object filtro) {
    return this.filtro.filtrar(personajes, filtro);
}
```
```java
public interface Filtro {
    List<Personaje> filtrar(List<Personaje> personajes, Object filtro);
}
```

## Ejecución de Pruebas
Se han modificado las pruebas para garantizar que los cambios realizados no afecten la funcionalidad del sistema.

## Autor
* [Franco Leon](https://github.com/francoleon08)

## Licencia
El enunciado y código original fueron provistos por la cátedra Diseño y Desarrollo de Software, del profesor Sebastian Gottifredi.