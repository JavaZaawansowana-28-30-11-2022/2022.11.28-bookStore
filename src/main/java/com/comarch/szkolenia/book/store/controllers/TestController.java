package com.comarch.szkolenia.book.store.controllers;

import com.comarch.szkolenia.book.store.database.IBookRepository;
import com.comarch.szkolenia.book.store.database.IOrderRepository;
import com.comarch.szkolenia.book.store.database.IUserRepository;
import com.comarch.szkolenia.book.store.model.Book;
import com.comarch.szkolenia.book.store.model.Cos;
import com.comarch.szkolenia.book.store.model.Order;
import com.comarch.szkolenia.book.store.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class TestController {

    @Autowired
    IUserRepository userRepository;

    @Autowired
    IBookRepository bookRepository;

    @Autowired
    IOrderRepository orderRepository;

    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    public String requestParams(@RequestParam String param1,
                                @RequestParam String param2,
                                @RequestParam String param3) {
        System.out.println(param1);
        System.out.println(param2);
        System.out.println(param3);

        return "main";
    }

    @RequestMapping(value = "/test2/{paramter1}/{p2}/{rok}", method = RequestMethod.GET)
    public String pathVariables(@PathVariable int p1,
                                @PathVariable int p2,
                                @PathVariable int rok) {
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(rok);

        return "main";
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String form() {
        return "form";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String form(@RequestParam String login,
                        @RequestParam("pass") String password) {
        System.out.println("Dziala odbieranie formularza");
        System.out.println(login);
        System.out.println(password);
        return "main";
    }


    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public String order() {
        Order order = new Order();
        Optional<User> userBox = this.userRepository.getUserByLogin("admin");
        order.setUser(userBox.get());
        List<Book> books = this.bookRepository.getBooks();
        order.setBooks(books);

        this.orderRepository.persist(order);
        return "asdfgsdf";
    }

    @RequestMapping(value = "/order2", method = RequestMethod.GET)
    public String order2() {
        Order order = this.orderRepository.getOrderById(1);
        System.out.println(order);
        //session.close();
        return "asdfgsdf";
    }

    @RequestMapping(value = "/order3", method = RequestMethod.GET)
    public String order3() {
        Order order = new Order();
        Optional<User> userBox = this.userRepository.getUserByLogin("admin");
        order.setUser(userBox.get());
        List<Book> books = this.bookRepository.getBooks();
        order.setBooks(books);

        order.getCosSet().add(new Cos(0, "asdf", 4));
        order.getCosSet().add(new Cos(0, "sadfas", 5));
        order.getCosSet().add(new Cos(0, "sadfasdfff", 8));
        order.getCosSet().add(new Cos(0, "sdd", 3));
        order.getCosSet().add(new Cos(0, "bnvdfsg", 1234));

        this.orderRepository.persist(order);
        return "asdfgsdf";
    }
}
