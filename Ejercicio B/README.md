# Sistema de Premios por Compras - Ejercicio B

## Enunciado
Consideremos un sistema para una plataforma de comercio electrónico llamado FreeMart, y que tenemos una historia de usuario en el sprint actual para premiar a usuarios gold que hagan compras grandes (temporalmente mas de $50000), por ahora, con una giftcard.
Para cada giftcard el sistema genera un código único (por ahora un simple entero distinto al de todos las giftcards existentes, que se concatena a otro random de 4 dígitos) y se la enviá con un mensaje del sistema de mensajería QuepasApp, para que el usuario la pueda reclamar en la plataforma.

Suponiendo que se desarrollo el siguiente código para esa historia, evalúe y explique qué principio SOLID no se está cumpliendo, y de qué manera podría resolverlo. Modifique el código de manera que solucione el problema y mantenga la correctitud de los tests

## Problemas
El principio que no se cumple es Single Responsability. Esto se debe a que la clase `PremiosPorCompras` es la encargada de llevar a cabo 
la lógica de negocio de las GiftCards y tambien de la entrega de premios. En el método `controlarCompra()` no se cumple el principio 
Dependency inversion, ya que este no solamente conoce la lógica a seguir para poder premiar a un usuario si no que sabe a detalle como hacerlo.

## Solución
1. **SRP (Responsabilidad Única):**
   - Dividir la funcionalidad en clases separadas, cada una con una única responsabilidad.
   - Modificar la clase `PremiosPorCompras` para manejar la lógica de premios solamente.
   - Crear una clase `ManejadorGiftCards` para manejar la generación de giftcards.
   - Crear una clase `ManejadorMensajes` para manejar el envío de mensajes a los usuarios.

2. **DIP (Inversión de Dependencias):**
   - Refactorizar el método `controlarCompra()` para que delegue la generación de giftcards y el envío de mensajes a instancias de las clases correspondientes, en lugar de conocer los detalles de implementación.

## Cambios Realizados
Se realizaron los siguientes cambios en el código para implementar la solución propuesta:
- Se dividió la clase `PremiosPorCompras` en las clases mencionadas anteriormente.
- Se refactorizó el método `controlarCompra()` para delegar la generación de giftcards y el envío de mensajes a las nuevas clases.

## Ejecución de Pruebas
Se han modificado las pruebas para garantizar que los cambios realizados no afecten la funcionalidad del sistema.

## Autor
* [Franco Leon](https://github.com/francoleon08)

## Licencia
El enunciado y código original fueron provistos por la cátedra Diseño y Desarrollo de Software, del profesor Sebastian Gottifredi.