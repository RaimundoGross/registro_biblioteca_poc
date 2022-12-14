package com.pruebas_software;

import java.util.ArrayList;
import java.util.Date;

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
                System.out.println("Listado de libros:\n");
                displayBooks(this.bookList, "No hay libros en la biblioteca aun.");
                System.out.println( "---------------------------------------------------------------------------------" );
            } else if (op == 2){
                // buscar libro
                System.out.println("buscar libro");
                searchBook();
                System.out.println( "---------------------------------------------------------------------------------" );
            } else if (op == 3){
                // registrar libro
                System.out.println("registrar libro");
                registerBook();
                System.out.println( "---------------------------------------------------------------------------------" );
            } else if (op == 4){
                // cambiar estado
                System.out.println("cambiar estado");
                changeState();
                System.out.println( "---------------------------------------------------------------------------------" );
            } else if (op == 5){
                // editar libro
                System.out.println("editar libro");
            } else if (op == 6){
                // eliminar libro
                System.out.println("eliminar libro");
                deleteBook();
                System.out.println( "---------------------------------------------------------------------------------" );
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

    void displayBooks(ArrayList<Book> displayBookList, String emptyListMsg){
        
        int size = displayBookList.size();
        if (size == 0){
            System.out.println(emptyListMsg);
        } else {
            Book b;
            for (int i = 0; i < size; i++) {
                b = displayBookList.get(i);
                b.displayLess(i+1);
            }
        }
    }

    void registerBook(){
        System.out.println("Registro de libros:\n");
        System.out.println("Ingrese titulo: ");
        String title = System.console().readLine();
        System.out.println("Ingrese autor. En el caso que sean mas de uno separar por comas: ");
        String authors = System.console().readLine();
        System.out.println("Ingrese fecha edicion en formato DD/MM/YYYY: ");
        String dateStr = System.console().readLine();
    
        System.out.println("Ingrese numero de paginas: ");
        String pagesStr = System.console().readLine();
        int pages = Integer.parseInt(pagesStr);
        System.out.println("Ingrese editorial: ");
        String publisher = System.console().readLine();
        System.out.println("Ingrese genero: ");
        String genre = System.console().readLine();
        System.out.println("Ingrese isbn: ");
        String isbn = System.console().readLine();
        
        // location
        System.out.println("Ingrese numero de piso: ");
        String floorStr = System.console().readLine();
        int floor = Integer.parseInt(floorStr);
        System.out.println("Ingrese numero de pasillo: ");
        String hallwayStr = System.console().readLine();
        int hallway = Integer.parseInt(hallwayStr);
        System.out.println("Ingrese numero de estante: ");
        String shelfStr = System.console().readLine();
        int shelf = Integer.parseInt(shelfStr);
        System.out.println("Ingrese posicion x: ");
        String xPosStr = System.console().readLine();
        int xPos = Integer.parseInt(xPosStr);
        System.out.println("Ingrese posicion y: ");
        String yPosStr = System.console().readLine();
        int yPos = Integer.parseInt(yPosStr);

        Location location = new Location(floor, hallway, shelf, xPos, yPos);

        // state
        System.out.println("Seleccione estado:\n1.-Disponible\n2.-Prestado\n3.-Perdido");    
        String stateStr = System.console().readLine();
        int stateOp = Integer.parseInt(stateStr);
        State state;
        if (stateOp == 1) state = State.AVAIBLE;
        else if (stateOp == 2) state = State.BORROWED;
        else state = State.MISSING;

        System.out.println("Ingrese descripcion: ");
        String description = System.console().readLine();

        Book b = new Book(title, authors, dateStr, pages, publisher, genre, isbn, location, state, description);
        this.bookList.add(b);
        System.out.println("Libro registrado correctamente");
        b.displayLess();
    }   

    ArrayList<Book> bookFilter(int filterType, String filter){
        ArrayList<Book> filteredBookList = new ArrayList<Book>();
        if (filterType == 1){
            System.out.println("filtro: " + filter);
            for (Book book : this.bookList) {  
                if (book.getTitle().contains(filter)) filteredBookList.add(book); 
            }
        } else if (filterType == 3){
            for (Book book : this.bookList) {
                if (book.getISBN().contains(filter)) filteredBookList.add(book); 
            }
        } else {
            for (Book book : this.bookList) {
                for (String author : book.getAuthors()) {
                    if (author.contains(filter)) filteredBookList.add(book);
                }
            }
        }
        return filteredBookList;
    }

    void searchBook(){
        System.out.println("Buscar libro:\n");
        boolean flag = true;
        while (flag){
            System.out.println("Seleccione el tipo de busqueda:\n1.- Por titulo\n2.- Por autor\n3.- Por isbn\n4.- Salir");
            int op = opFilter(1, 4);

            if (op == 1) System.out.println("\nIngrese titulo:");
            else if (op == 2) System.out.println("\nIngrese autor:");
            else if (op == 3) System.out.println("\nIngrese isbn:");
            else flag = false;

            if (flag){
                String filter = System.console().readLine();

                ArrayList<Book> results = bookFilter(op, filter);

                System.out.println("Resultados: ");
                displayBooks(results, "No hay libros que coincidan con su busqueda");
            }
        }
    }

    void changeState(){
        System.out.println("Cambio de Estado\n");
        int size = this.bookList.size();
        if (size == 0) {
            System.out.println("No hay libros en la biblioteca aun.\n");
        } else {
            
            System.out.println("Ingrese el indice del libro al que quiera cambiar el estado (si no recuerda los indices puede ingresar 0 para ver la lista completa de libros): ");
            int op = opFilter(0, this.bookList.size());
            if (op == 0) {
                displayBooks(this.bookList, "No hay libros en la biblioteca aun.\n");
                System.out.println("Ingrese el indice del libro al que quiera cambiar el estado: ");
                op = opFilter(1, this.bookList.size());
            }
            System.out.println("Se ha seleccionado el siguiente libro:");
            Book b = this.bookList.get(op-1);
            b.displayLess();
            System.out.println("Su estado actual es: " + b.getState().toString());
            System.out.println("Seleccione nuevo estado:\n1.-Disponible\n2.-Prestado\n3.-Perdido\n4.- Cancelar");    
            String stateStr = System.console().readLine();
            int stateOp = Integer.parseInt(stateStr);
            String msg = "Se ha actualizado el estado del libro";
            if (stateOp == 1) b.setState( State.AVAIBLE );
            else if (stateOp == 2) b.setState( State.BORROWED );
            else if (stateOp == 3) b.setState( State.MISSING );
            else msg = "Operacion cancelada";
            System.out.println(msg);
        }
        
    }

    void editBook(){}

    void deleteBook(){
        System.out.println("Cambio de Estado\n");

        int size = this.bookList.size();
        if (size == 0) {
            System.out.println("No hay libros en la biblioteca aun.\n");
        } else {
            System.out.println("Ingrese el indice del libro al que quiera cambiar el estado (si no recuerda los indices puede ingresar 0 para ver la lista completa de libros): ");
            int op = opFilter(0, this.bookList.size());
            if (op == 0) {
                displayBooks(this.bookList, "No hay libros en la biblioteca aun.\n");
                System.out.println("Ingrese el indice del libro al que quiera cambiar el estado: ");
                op = opFilter(1, this.bookList.size());
            }
            System.out.println("Se ha seleccionado el siguiente libro:");
            Book b = this.bookList.get(op-1);
            b.displayLess();
            boolean flag = true;
            String response = "";
            while(flag){
                System.out.println("¿Esta seguro de querer eliminar el libro? [y/n]");
                response = System.console().readLine();
                if (response != "y" && response != "Y" && response != "n" && response != "N") System.out.println("La opcion ingresada no es valida. Intentelo nuevamente");
                else flag = false;
            }

            if (response == "y" || response == "Y") {
                this.bookList.remove(op);
                System.out.println("El libro ha sido removido con exito");
            }
        }
    }

}
