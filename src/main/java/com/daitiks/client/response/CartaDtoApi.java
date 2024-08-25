package com.daitiks.client.response;

import com.daitiks.model.Cartas;

import java.io.Serializable;
import java.util.List;

public class CartaDtoApi implements Serializable {
    private boolean success;
    private String deck_id;
    private List<Cartas> cards;

    // Getters and Setters

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getDeck_id() {
        return deck_id;
    }

    public void setDeck_id(String deck_id) {
        this.deck_id = deck_id;
    }

    public List<Cartas> getCards() {
        return cards;
    }

    public void setCards(List<Cartas> cards) {
        this.cards = cards;
    }

}
