package com.comarch.szkolenia.book.store.controllers.rest;

import com.comarch.szkolenia.book.store.model.Book;
import com.comarch.szkolenia.book.store.model.Cos;
import com.comarch.szkolenia.book.store.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SimpleRestController {

    @RequestMapping(value = "/rest", method = RequestMethod.GET)
    public User user() {
        User user = new User();
        user.setId(10);
        user.setLogin("Zbyszek");
        user.setPassword("Kowalski");

        return user;
    }

    @RequestMapping(value = "/rest2", method = RequestMethod.POST)
    public User user2(@RequestBody Cos cos) {
        System.out.println(cos.getA());
        System.out.println(cos.getB());
        System.out.println(cos.getC());

        User user = new User();
        user.setId(15);
        user.setLogin("Janusz");
        user.setPassword("Malinowski");

        return user;
    }

    @RequestMapping(value = "/rest3", method = RequestMethod.PUT)
    public Cos rest3(@RequestHeader("jakis-header1") String h1,
                     @RequestHeader("jakis-header2") String h2,
                     @RequestHeader("jakis-header3") String h3) {
        System.out.println(h1);
        System.out.println(h2);
        System.out.println(h3);

        Cos cos = new Cos();
        cos.setA(34534);
        cos.setB("kasjhdgfkhjasd");
        cos.setC(345);

        return cos;
    }

    @RequestMapping(value = "/rest4/{liczba1}/{string}/{liczba2}",
            method = RequestMethod.POST)
    public Book rest4(@PathVariable int liczba1,
                      @PathVariable String string,
                      @PathVariable int liczba2,
                      @RequestBody User user,
                      @RequestParam int wiek,
                      @RequestParam int wzrost,
                      @RequestHeader String header123) {
        System.out.println(liczba1);
        System.out.println(string);
        System.out.println(liczba2);
        System.out.println(user);
        System.out.println(wiek);
        System.out.println(wzrost);
        System.out.println(header123);

        Book book = new Book();
        book.setId(15);
        book.setAuthor("Janusz");
        book.setTitle("Tytul");
        book.setIsbn("234-234-444-2236-45");
        book.setPrice(40.44);

        return book;
    }

    @RequestMapping(value = "/rest5", method = RequestMethod.GET)
    public ResponseEntity<User> rest5() {
        User user = new User();
        user.setId(15);
        user.setLogin("Karol");
        user.setPassword("haslo");

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .header("naglowek1", "wartosc naglowka 1")
                .header("naglowek2", "wartosc naglowka 2")
                .body(user);
    }
}
