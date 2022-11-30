package com.comarch.szkolenia.book.store.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "torder")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    @ManyToMany(fetch = FetchType.LAZY)
    /*@JoinTable(name = "order_book",
    joinColumns = { @JoinColumn(name = "order_id")},
    inverseJoinColumns = { @JoinColumn(name = "book_id")}
    )*/
    private List<Book> books = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Cos> cosSet = new HashSet<>();

    @Transient
    int x;

    public Order(int id, User user) {
        this.id = id;
        this.user = user;
    }

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> book) {
        this.books = book;
    }

    public Set<Cos> getCosSet() {
        return cosSet;
    }

    public void setCosSet(Set<Cos> cosSet) {
        this.cosSet = cosSet;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Order{");
        sb.append("id=").append(id);
        sb.append(", user=").append(user);
        sb.append(", books=").append(books);
        sb.append('}');
        return sb.toString();
    }
}
