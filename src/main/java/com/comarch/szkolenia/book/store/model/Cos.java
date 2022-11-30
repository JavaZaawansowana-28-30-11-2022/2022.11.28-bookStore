package com.comarch.szkolenia.book.store.model;

import javax.persistence.*;

@Entity(name = "tcos")
public class Cos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int a;
    private String b;
    private int c;

    public Cos(int a, String b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Cos() {
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }
}
