package org.example;

public class Main {
    public static void main(String[] args) {
        /*Escribir un algoritmo que permita utilizar tres tablas hash para guardar los datos de barcos, que
        contemple las siguientes actividades:
        a. En la primera tabla hash la función hash debe ser sobre el tipo de barco, en la segunda tabla la
       función hash deberá utilizar el número del barco como clave, mientras que en la tercera el campo
        clave de la función hash será por el nombre del barco.
        b. El tamaño de la primera tabla debe ser lo suficientemente grande como para que pueda
        almacenar todos los distintos tipos de barcos, debe manejar las colisiones con alguna función de
       sondeo.

        d. El algoritmo debe permitir cargar tipos de barcos en la primera tabla y crear su respectiva segunda
        tabla, en el caso de que no exista.
        e. Si el barco es de más de un tipo deberá cargarlo en cada una de las tablas que indiquen estos
        tipos.
        f. Deberá permitir cargar barcos de los cuales se dispone de su número, nombre, tipo y nivel.*/

        // Creación de las tres tablas hash
        BarcosHash tablaTipoBarco = new BarcosHash();
        BarcosHash tablaNumBarco = new BarcosHash();
        BarcosHash tablaNombreBarco = new BarcosHash();
        //c. El tamaño de cada una de las segundas tablas debe ser 15.
        tablaTipoBarco.setTamanioTabla(15);
        tablaNumBarco.setTamanioTabla(15);
        tablaNombreBarco.setTamanioTabla(15);

        // Carga de datos en las tres tablas hash
        tablaTipoBarco.agregarBarco(1, "HMS Victory", "Portaaviones", 1);
        tablaTipoBarco.agregarBarco(2, "HMS Victory", "Portaaviones", 2);
        tablaTipoBarco.agregarBarco(3, "HMS Victory", "Portaaviones", 3);
        tablaTipoBarco.agregarBarco(4, "HMS Victory", "Portaaviones", 4);
        tablaTipoBarco.agregarBarco(5, "HMS Victory", "Portaaviones", 5);
        tablaTipoBarco.agregarBarco(6, "HMS Victory", "Portaaviones", 6);
        tablaTipoBarco.agregarBarco(7, "HMS Victory", "Portaaviones", 7);
        tablaTipoBarco.agregarBarco(8, "HMS Victory", "Portaaviones", 8);
        tablaTipoBarco.agregarBarco(9, "HMS Victory", "Portaaviones", 9);
        tablaTipoBarco.agregarBarco(10, "HMS Victory", "Portaaviones", 10);
        tablaTipoBarco.agregarBarco(11, "HMS Victory", "Portaaviones", 11);

        tablaNumBarco.agregarBarco(1, "HMS Victory", "Portaaviones", 1);
        tablaNumBarco.agregarBarco(2, "HMS Victory", "Portaaviones", 2);



        // Imprimir los datos de las tres tablas hash
        System.out.println("Tabla Tipo Barco");
        tablaTipoBarco.imprimirTabla();
        System.out.println("Tabla Número Barco");
        tablaNumBarco.imprimirTabla();
        System.out.println("Tabla Nombre Barco");
        tablaNombreBarco.imprimirTabla();
    }
}