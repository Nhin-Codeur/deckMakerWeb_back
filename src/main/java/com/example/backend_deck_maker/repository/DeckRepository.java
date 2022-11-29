package com.example.backend_deck_maker.repository;

import com.example.backend_deck_maker.model.Deck;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeckRepository extends JpaRepository<Deck, Integer> {

    List<Deck> findAll();
    Deck findById(int id);




}