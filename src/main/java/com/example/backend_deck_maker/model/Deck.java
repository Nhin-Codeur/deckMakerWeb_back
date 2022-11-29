package com.example.backend_deck_maker.model;

import javax.persistence.*;


@Entity
@Table(name = "DECK")
public class Deck {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @Column(name = "data")
    private int[] data;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "name")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int[] getData() {
        return data;
    }

    public void setData(int[] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Deck{" +
                "id=" + id +
                ", deck=" + data +
                "name =" + name + '}';
    }

 }
