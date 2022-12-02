package com.driver;
import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {

    Map<Integer,Book> bookMap;
    public BookRepository(){
        bookMap=new HashMap<>();
    }

    public Book save(Book book){
        bookMap.put(book.getId(),book);
        return book;
    }

    public Book findBookById(int id){
        Book idBook=bookMap.get(id);
        return idBook;
    }

    public List<Book> findAll(){
        List<Book> newList=new ArrayList<>();
        for(Book book:bookMap.values()){
            newList.add(book);
        }
        return newList;
    }

    public void deleteBookById(int id){
        bookMap.remove(id);
        return;
    }

    public void deleteAll(){
        bookMap=new HashMap<>();
        return;
    }

    public List<Book> findBooksByAuthor(String author){
        List<Book> authorArray=new ArrayList<>();
        for (Book book:bookMap.values()){
            if(book.getAuthor().equals(author)) authorArray.add(book);
        }

        return authorArray;
    }

    public List<Book> findBooksByGenre(String genre){
        List<Book> genreArray=new ArrayList<>();
        for (Book book:bookMap.values()){
            if(book.getGenre().equals(genre)) genreArray.add(book);
        }

        return genreArray;
    }
}
