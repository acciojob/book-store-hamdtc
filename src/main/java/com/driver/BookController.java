package com.driver;

import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("books")
public class BookController {
    @Autowired
    BookService bookService;

    // One example controller, make the rest by yourself
    @PostMapping("/create-book")
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        Book newbook = bookService.createBook(book);
        return new ResponseEntity<>(newbook, HttpStatus.CREATED);
    }
    //by using book id
    @GetMapping("/get-book-by-id/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") String id){
        Book idBook=bookService.findBookById(id);
        return new ResponseEntity<>(idBook,HttpStatus.ACCEPTED);
    }

    //to get all the books
    @GetMapping("/get-all-books")
    public ResponseEntity<List<Book>> getAllBooks(){
       return new ResponseEntity<>(bookService.findAllBooks(),HttpStatus.CREATED);
    }

    // get by the author name
    @GetMapping("/get-books-by-author")
    public ResponseEntity<List<Book>> getBookByAuthor(@RequestParam String author){
        return new ResponseEntity<>(bookService.findBooksByAuthor(author),HttpStatus.CREATED);
    }
     // get by genre
     @GetMapping("/get-books-by-genre")
     public ResponseEntity<List<Book>> getBookByGenre(@RequestParam String genre){
         return new ResponseEntity<>(bookService.findBooksByGenre(genre),HttpStatus.CREATED);
     }

     //to delete and object by id
    @DeleteMapping("delete-book-by-id/{id}")
    public ResponseEntity deleteBookById(@PathVariable("id") String id){
        bookService.deleteBookById(id);
        return new ResponseEntity("book deleted",HttpStatus.ACCEPTED);
    }

    //to delete all the books
    @DeleteMapping("delete-all-books")
    public ResponseEntity deleteAllBook(){
        bookService.deleteAllBooks();
        return new ResponseEntity("All book deleted",HttpStatus.ACCEPTED);
    }
}
