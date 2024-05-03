# Clean Code - Ejercicio E

## Enunciado
En el Sprint actual se esta trabajando en dos partes, por ahora separadas, de una aplicación en desarrollo. Este sprint el equipo esta focalizado en tareas para mejorar la calidad interna del código siguiendo practicas de Clean Code. Por lo tanto, para ambas partes, se busca analizar el código fuente adjunto, identificando que porciones no son "Clean Code" y explicando porqué no lo son. Luego hacer refactoring para que ambas partes cumplan con Clean Code y hacer que el código resultante mantenga la correctitud de los tests (en caso de tener que cambiar los tests por que no compilan, hay que mantener lo que buscan testear).

**Parte 1:** Esta parte se corresponde al modulo con la logica para hacer busquedas en la API a wikipedia (por ahora la llamada al servicio es simulada). Utilizar el test implementado para referencia y pruebas. Como suele ser usual en este tipo de servicios la respuestas son en formato json (https://en.wikipedia.org/wiki/JSON).

**Parte 2:** El objetivo de la porción de código es simular la obtención de información de Clubes deportivos mediante el acceso a un servicio remoto, y guardando su info localmente. Los datos se piden al servicio sólo si no existen localmente, o si la copia local es demasiada antigua. Por ahora el acceso al servicio remoto es simulado, mas adelante se utilizará el modulo de la parte 1. Utilizar el test implementado para referencia y pruebas.

# Solución Parte 1

**Clase Result**
- EL nombre de la clase no es significativo, se cambio por `PagesResult`.
- El atributo `result` es mas significativo si se cambia a `pages`, ya que hace referencia a un arreglo de páginas.

**Clase SearchInfo**
- El nombre de la clase se cambia por `SearchQuery`, ya que contiene todo lo necesario para realizar una consulta.
- El constructor recibe 3 argumentos, los primeros dos referidos a la informacion de un tema en particular, por lo tanto se encapsulan en una clase llamada `SearchInfo`. Por lo tanto el constructor ahora tiene 2 parametros.
- El segundo parametro (`baseURL`) ahora es una clase que contiene todo lo necesario para construir la URL para consumir la API, por lo tanto se encapsula en una clase llamada `BaseURL`.
- Hay un comentario en el constructor en el atributo "baseURL" el cual no es necesario.

**Clase SearchLogic**
- El nombre de la clase se cambia por `SearchRequestHandler`, el cual explica mejor la funcionalidad de la misma.
- El metodo `srch()` implica un mapeo mental, por lo tanto se cambia a `executeHttpRequest()`.
- Se dividieron las responsabilidades del método `executeHttpRequest()` en:
    * Construir la URL
    * Enviar la consulta HTTP
    * Procesar el resultado
- Para construir la URL se creo una nueva clase `URLBuilder` que mediante el metodo `buildUrl()` genera la url correspondiente.
- Para enviar la consulta HTTP se creo un metodo `sendHttpRequest()` ubicado en la misma clase que utiliza los servicios provistos de `ServiceProvider`.
- Para procesar el resultado se creo una clase `JsonResultProcessor` que mediante el metodo `processJsonResult()` genera la lista de paginas respectiva.
- Las nuevas clases se ubican en un paquete llamado `utils`.

**Interfaz ServiceProvider**
- Se mueve a un paquete llamado `service`.

## Autor
* [Franco Leon](https://github.com/francoleon08)

## Licencia
El enunciado y código original fueron provistos por la cátedra Diseño y Desarrollo de Software, del profesor Sebastian Gottifredi.
