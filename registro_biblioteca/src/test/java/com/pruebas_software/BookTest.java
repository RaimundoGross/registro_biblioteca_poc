package com.pruebas_software;

import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class BookTest {
    
    @Test
    public void addAuthorTest(){
        Location location = new Location();
        Book book = new Book("titulo", "autor 1", "1/1/2000", 200, "editorial", "genero", "1234-5678", location, State.AVAIBLE, "desc");

        book.addAuthor("autor 2");

        ArrayList<String> listaAutores = new ArrayList<String>();
        listaAutores.add("autor 1");
        listaAutores.add("autor 2");

        assertEquals(book.getAuthors(), listaAutores);
    }

    @Test
    public void addAuthorsTest(){
        Location location = new Location();
        Book book = new Book("titulo", "autor 1", "1/1/2000", 200, "editorial", "genero", "1234-5678", location, State.AVAIBLE, "desc");
        ArrayList<String> nuevaListaAutores = new ArrayList<String>();
        nuevaListaAutores.add("autor 2");
        nuevaListaAutores.add("autor 3");

        book.addAuthors(nuevaListaAutores);

        ArrayList<String> listaAutores = new ArrayList<String>();
        listaAutores.add("autor 1");
        listaAutores.add("autor 2");
        listaAutores.add("autor 3");

        assertEquals(book.getAuthors(), listaAutores);
    }

    @Test
    public void addAuthorsEmptyTest(){
        Location location = new Location();
        Book book = new Book("titulo", "autor 1", "1/1/2000", 200, "editorial", "genero", "1234-5678", location, State.AVAIBLE, "desc");
        ArrayList<String> nuevaListaAutores = new ArrayList<String>();

        book.addAuthors(nuevaListaAutores);

        ArrayList<String> listaAutores = new ArrayList<String>();
        listaAutores.add("autor 1");

        assertEquals(book.getAuthors(), listaAutores);
    }
}
