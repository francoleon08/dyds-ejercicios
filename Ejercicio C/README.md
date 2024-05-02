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
Para resolver este problema, se creará una interfaz Filtro y una interfaz Seleccionador. 
La clase Filtro la cual recibe una lista de personajes y un Seleccionador para poder filtar aquellos que cumplen con el filtro.
La interfaz Seleccionador será implementada por la clase SeleccionadorPersonaje que se encargará de seleccionar los personajes que cumplan con el filtro.
Se implementa un nuevo método getPersonajesConFiltro() en la clase LogicaPersonajes que recibe un filtro y un seleccionador, y devuelve los personajes que cumplen con el filtro.

```java
public List<Personaje> getPersonajesConFiltro(Filtro filtro, Seleccionador seleccionador) {
    return filtro.filtrar(personajes, seleccionador);
}
```
```java
public class Filtro {

   public List<Personaje> filtrar(List<Personaje> personajes, Seleccionador seleccionador) {
      return personajes.stream().filter(seleccionador::seleccionar).collect(Collectors.toList());
   }
}
```
```java
public interface Seleccionador {
    public boolean seleccionar(Personaje personaje);
}
```
Ahora en el caso de necesitar extender los tipos de fitlrado, solamente se deben crear nuevos seleccioadores.

## Ejemplo
Se quiere filtar los personajes que tengan un nivel mayor a 50.
Asuminedo que la clase `LogicaPersonajes` ya fue instanciada y poblada con personajes, el proceso de filtrado se realizaría de la siguiente manera:
```java
Filtro filtro = new Filtro();
Seleccionador seleccionadorNivel = new SeleccionadorPorNivelMayorA(50);
List<Personaje> personajesFiltrados = logicaPersonajes.getPersonajesConFiltro(filtro, seleccionadorNivel);
```
El método `getPersonajesConFiltro()` llama al método `filtrar()` de la clase `Filtro`.
```java
public List<Personaje> filtrar(List<Personaje> personajes, Seleccionador seleccionador) {
   return personajes.stream().filter(seleccionador::seleccionar).collect(Collectors.toList());
}    
```
Este método recorre la lista de personajes y filtra aquellos que cumplan con la condicion provista por el método `seleccionar()` de la clase `Seleccionador`.

```java
public boolean seleccionar(Personaje personaje) {
   return personaje.getNivel() > nivel;
}
```
El método `seleccionar` de la clase SeleccionadorPorNivelMayorA compara el nivel del personaje con el nivel provisto en el constructor.

## Ejecución de Pruebas
Se han modificado las pruebas para garantizar que los cambios realizados no afecten la funcionalidad del sistema.
Se extendio la funcionalidad de las pruebas para cubrir los nuevos casos de uso, ya que se han agregado nuevos filtros. 

## Autor
* [Franco Leon](https://github.com/francoleon08)

## Licencia
El enunciado y código original fueron provistos por la cátedra Diseño y Desarrollo de Software, del profesor Sebastian Gottifredi.