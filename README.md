# registro_biblioteca_poc

## Requisitos:

Para poder ejecutar esta aplicación se necesita tener [Java](oracle.com/java/technologies/javase/jdk17-archive-downloads.html)  y [Maven](https://maven.apache.org/download.cgi) instalado.

## Compilacion:

Para compilar el proyecto primero hay que acceder a la carpeta del mismo, con el comando:

    cd registro_biblioteca

Luego, para compilar:

    mvn compile

Si se deseara obtener un artefacto .jar, se puede usar:

    mvn package

y luego para ejecutar la aplicación desde ese archivo, primero nos movemos a la carpeta target:

    cd target

y luego ejecutamos con java:

    java -jar registro_biblioteca-1.0.0.jar


## Uso

La aplicación de registro de biblioteca se usa por consola, instrucciones están incluídas en la misma aplicación.

## Repositorio

El proyecto está alojado en el siguiente [enlace](https://github.com/RaimundoGross/registro_biblioteca_poc).

