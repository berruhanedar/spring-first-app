package com.berrucodes.spring_first_app;


import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


@RequestMapping("/books")
@RestController
public class BookController {

    //Kitap isimlerini tutmak için liste
    private List<String> bookList = new ArrayList<>();

    public BookController() {
        bookList.add("1984 - George Orwell");
        bookList.add("A Tale of Two Cities");
        bookList.add("Le Petit Prince");
        bookList.add("Harry Potter and the Philosopher's Stone");
        bookList.add("The Hobbit");
        bookList.add("The Da Vinci Code");
    }

    //GetMapping tüm kitapları listelemeyi sağlayacak endpoint
    @GetMapping
    public List<String> getAllBooks() {
        return bookList;
    }

    //Listeye yeni kitap eklememizi sağlar
    @PostMapping
    public String addBook(@RequestBody String book) {
        bookList.add(book);
        return book;
    }

    // Mevcut bir kitabı güncelleyen endpoint - index gireceğiz
    @PutMapping("/{index}")
    public String updateBook(@PathVariable int index, @RequestBody String book) {
            String oldBook = bookList.set(index, book);
            return book;
    }

    // Belirli bir kitabı silen endpoint - index gireceğiz
    @DeleteMapping("/{index}")
    public String deleteBook(@PathVariable int index) {
            String removedBook = bookList.remove(index);
            return  removedBook;
    }






}
