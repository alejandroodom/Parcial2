# Parcial2

EJERCICIO 1:
 
1) Los elementos que definen a un objeto son:
b) La identidad, los atributos que representan su estado y los métodos que representan su
comportamiento.

2) El hecho de que un método pueda recibir un número variable de atributos se denomina:
b) Polimorfismo.

3) Imagine que la clase C hereda de la clase B. Y la clase B hereda de la clase A. Cuando se cree
un objeto de la clase C, ¿cuál será la secuencia en que se ejecutarán los constructores?
a) Primero el constructor de C, luego constructor de B y, finalmente, el constructor de A.

4) Para referenciar los atributos de un objeto en un método de la misma clase
a) Debo utilizar la palabra reservada self como prefijo

5) En el paradigma de la programación orientado a objetos:
b) Se favorece la semántica y la reutilización de código en detrimento del rendimiento.


EJERCICIO 2:

La programación orientada a objetos es un tipo de programación basado en la representación y manipulación de datos mediante el uso de clases y objetos(instancias de esas clases). Algunas de las características más importantes de la POO son:

-Herencia: La herencia es un mecanismo que permite crear nuevas clases a partir de clases existentes. La nueva clase hereda todas las propiedades y métodos de la clase base. Además también puede agregar nuevas propiedades y métodos o sobrescribir los existentes.

-Encapsulamiento: La encapsulación se define como el proceso de ocultar los detalles internos de un objeto y exponer solo las interfaces necesarias para interactuar con él. En POO, se logra mediante la definición de clases, que proporcionan una estructura para el almacenamiento y manipulación de datos, y la definición de métodos, que proporcionan las operaciones que se pueden realizar en los datos.

-Polimorfismo: El polimorfismo se refiere a la capacidad de objetos de diferentes clases para responder a un mismo mensaje o método de forma diferente. En POO, se logra mediante la definición de métodos con el mismo nombre en diferentes clases.

-Abstracción: La abstracción es el proceso de identificar los aspectos esenciales de un objeto y dejar de lado los detalles irrelevantes. En POO, se logra mediante la definición de clases abstractas, que proporcionan una plantilla para la creación de nuevas clases, y la definición de interfaces, que describen los métodos que una clase debe implementar.


EJERCICIO 3:

La visibilidad de una variable o un método se refiere al alcance o acceso que tiene una variable o método dentro de una clase o en un programa en general. En general, existen cuatro tipos de visibilidad: pública, privada, protegida y por paquete (o "default" en algunos lenguajes de programación).

Public: las variables o métodos públicos son accesibles desde cualquier lugar, tanto dentro como fuera de la clase. Este tipo de visibilidad se utiliza cuando se desea que una variable o método sea accesible desde cualquier parte del programa.
Private: las variables o métodos privados solo son accesibles dentro de la clase en la que se definen. Este tipo de visibilidad se utiliza para proteger las variables y métodos que no deben ser manipulados o utilizados desde fuera de la clase, ya que podrían alterar su estado interno de manera no deseada.
Protected: las variables o métodos protegidos son accesibles desde la clase que los define y también desde sus subclases. Este tipo de visibilidad se utiliza para permitir que las subclases accedan y manipulen las variables y métodos de la clase padre.
Por paquete o "default" (package-private o default): las variables o métodos con esta visibilidad son accesibles desde cualquier clase dentro del mismo paquete, pero no desde clases fuera del paquete. Este tipo de visibilidad se utiliza para controlar el acceso a las variables y métodos dentro de un paquete, y se utiliza a menudo en Java.

La elección del tipo de visibilidad depende del diseño de la clase y del comportamiento que se desea obtener. En general, se recomienda utilizar el nivel de visibilidad más restrictivo posible para proteger la integridad de los datos y métodos de la clase. En algunos casos, como en los métodos de acceso (getters) y mutadores (setters), es común utilizar la visibilidad pública para permitir que otras clases accedan y modifiquen los valores de las variables de la clase.
