package com.example.backend_deck_maker.controller;

import com.example.backend_deck_maker.model.Deck;
import com.example.backend_deck_maker.repository.DeckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DeckController {

    @Autowired
    DeckRepository deckRepository;

    //check the api's working correctly api
    @RequestMapping(value="/ping", method=RequestMethod.GET)
    @ResponseBody
    public String healthCheck() {
        return "This is working well";
    }


    @RequestMapping(value="/decks", method=RequestMethod.GET)
    @ResponseBody
    public List<Deck> getAllDecks() {
        return deckRepository.findAll();
    }

    @RequestMapping(value="/deck/{name}", method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Deck addDeck(@RequestBody int[] ids, @PathVariable String name) {
        Deck deck = new Deck();
        deck.setData(ids);
        deck.setName(name);
        return deckRepository.save(deck);

    }

    @RequestMapping(value="/finddeck", method = RequestMethod.GET)
    @ResponseBody
    public Deck findDeck(@RequestParam("deckId") int deckId) {
        return deckRepository.findById(deckId);
    }

    @RequestMapping(value= "/updatedeck", method = RequestMethod.POST)
    @ResponseBody
    public Deck updateDeck(@RequestBody Deck deck){
        return deckRepository.save(deck);
    }

    @RequestMapping(value="/deletedeck", method = RequestMethod.DELETE)
    @ResponseBody
    public Deck deleteDeck(@RequestParam("deckId") int deckId) {
        Deck deck = deckRepository.findById(deckId);
        deckRepository.deleteById(deckId);
        return deck;
    }
}