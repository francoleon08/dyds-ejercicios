# Sistema facturación - Ejercicio C

## Enunciado
Supongamos que en un sistema facturación tenemos una interfaz común entre la aplicación y una base de datos. Esta se modela a partir la interfaz DAO (Data Acces Object), que se utilizará como interfaz para "mis Facturas”.

```java
public interface IDAO {
    void insert(Object entity);
    void update(Object id, Object entity);
    void delete(Object id);
    Object[] getAll();
    Object getById(Object id);
}
```

```java
public class FacturaDAO implements IDAO{

    void insert(Object entity) {
        //Código..
    }

    void update(Object id, Object entity) {
        //Código..
    }

    void delete(Object id) {
        //Código..
    }

    Object[] getAll() {
        //Código..
    }
    
    Object getById(Object id) {
        //Código..
    }
```
Supongamos que que en el sprint actual se requiere crear una capa de acceso a datos que sólo permita lecturas de facturas, y el equipo de desarrollo propuso resolverlo de la siguiente manera:
    
```java
public class FacturaDAODatosReadOnly implements IOAD {

    void insert(Object entity) {
        throw new ObjAccDatosReadOnlyException();
    }

    void update(Object id, Object entity) {
        throw new ObjAccDatosReadOnlyException();
    }

    void delete(Object id) {
        throw new ObjAccDatosReadOnlyException();
    }

    Object[] getAll() {
        //Código..
    }
    
    Object getById(Object id) {
        //Código..
    }
}
```
Dada esta solución por parte del equipo, indique qué problemas encuentra, y qué principios SOLID no se estaría cumpliendo. Explique cómo resolvería esta situación.

## Problema
El principal problema de este código es que existe una abstracción equivocada, es decir, se quiere representar un tipo de facturación con la interafaz incorrecta.

**Principio de Sustitución de Liskov (Liskov Substitution Principle - LSP):**
   La clase `FacturaDAODatosReadOnly` viola el principio LSP. Este dice que un objeto de una clase heredada no debe romper la aplicación, por lo tanto deberian comportarse de manera compatible respecto a su super clase. En este caso para los tres primeros métodos se utiliza una Exception por lo que el método ya no se comporta como su clase padre, la cual no lanza dichas excepciones.

**Principio de Segregación de interfaces (Interface Segregation Principle - ISP):**
    La interfaz `IDAO` no cumple con este principio, ya que hay clientes que solo necesitan una parte del código de la misma y consecuentemente dependen del resto de la interfaz.

**Principio de Responsabilidad Única (Single Responsibility Principle - SRP):**
    Consecuentemente a los principios mencionados, la clase `FacturaDAODatosReadOnly` tampoco cumple este principio, ya que solamente debería tener los métodos que realmente implementa y por una mala segregación de interfaces debe implementar todos.
   

## Solución
La solución es segregar la interfaz `IDAO` en interfaces más pequeñas y de proposito especifico. Luego cada clase depende de la interfaz que necesite

```java
public interface IDAO {
    void insert(Object entity);
    void update(Object id, Object entity);
    void delete(Object id);
}
```

```java
public interface IDAOReadOnly {
    Object[] getAll();
    Object getById(Object id);
}
```
```java
public class FacturaDAO implements IDAO, IDAOReadOnly{

    void insert(Object entity) {
        //Código..
    }

    void update(Object id, Object entity) {
        //Código..
    }

    void delete(Object id) {
        //Código..
    }

    Object[] getAll() {
        //Código..
    }
    
    Object getById(Object id) {
        //Código..
    }
```
    
```java
public class FacturaDAODatosReadOnly implements IDAOReadOnly {

    Object[] getAll() {
        //Código..
    }
    
    Object getById(Object id) {
        //Código..
    }
}
```

## Autor
* [Franco Leon](https://github.com/francoleon08)

## Licencia
El enunciado y código original fueron provistos por la cátedra Diseño y Desarrollo de Software, del profesor Sebastian Gottifredi.