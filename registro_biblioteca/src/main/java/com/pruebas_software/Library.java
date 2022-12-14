package com.pruebas_software;

import java.util.ArrayList;

public class Library {

    private ArrayList<Book> bookList;

    public Library(){
        this.bookList = new ArrayList<Book>();
    }

    public Library( ArrayList<Book> bookList){
        this.bookList = bookList;
    }

    public void menu(){
        System.out.println( "---------------------------------------------------------------------------------" );
        System.out.println( "-----------------------        REGISTRO BIBLIOTECA       ------------------------" );
        System.out.println( "---------------------------------------------------------------------------------" );

        boolean flag = true;

        while(flag){
            System.out.println( "\nBienvenido al sistema de registro de biblioteca, por favor seleccione una de las opciones listadas a continuacion: ");
            System.out.println( "1.- Ver listado de libros");
            System.out.println( "2.- Buscar libro");
            System.out.println( "3.- Registrar libro");
            System.out.println( "4.- Cambiar estado de un libro");
            System.out.println( "5.- Editar libro");
            System.out.println( "6.- Eliminar libro");
            System.out.println( "\n0.- Salir");

            int op = opFilter(0, 7);
            // System.out.println(op);
            if (op == 1){
                // ver listado
                displayBooks();
            } else if (op == 2){
                // buscar libro
                System.out.println("buscar libro");
            } else if (op == 3){
                // registrar libro
                System.out.println("registrar libro");
            } else if (op == 4){
                // cambiar estado
                System.out.println("cambiar estado");
            } else if (op == 5){
                // editar libro
                System.out.println("editar libro");
            } else if (op == 6){
                // eliminar libro
                System.out.println("eliminar libro");
            } else {
                flag = false;
                System.out.println("Hasta la proxima!");
            }
            
        }
        
        System.out.println( " ");
    }

    int opFilter(int min_val, int max_val){
        String op = System.console().readLine();
        boolean flag = true;
        int o = 0;
        while (flag){
            try {
                o = Integer.parseInt(op);
                if (o < min_val || o > max_val){
                    throw new NumberFormatException();
                } 
                System.out.println( "---------------------------------------------------------------------------------" );
                return o;
            } catch (NumberFormatException e){
                System.out.println("La opcion ingresada no es valida. Intentelo nuevamente");
                op = System.console().readLine();
            }
        }
        return o;
    }

    void displayBooks(){
        System.out.println("Listado de libros:\n");
        int size = this.bookList.size();
        if (size == 0){
            System.out.println("No hay libros en la biblioteca aun");
        } else {
            Book b;
            for (int i = 0; i < size; i++) {
                b = this.bookList.get(i);
                b.displayLess(i);
            }
        }
    }

}
