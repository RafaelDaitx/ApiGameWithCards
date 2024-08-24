package com.daitiks.client.response;

import java.io.Serializable;
import java.util.List;

public class CartaDtoApi implements Serializable {

    private boolean success;
    private String deck_id;
    private List<CardApi> cards;
    private int remaining;

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

    public List<CardApi> getCards() {
        return cards;
    }

    public void setCards(List<CardApi> cards) {
        this.cards = cards;
    }

    public int getRemaining() {
        return remaining;
    }

    public void setRemaining(int remaining) {
        this.remaining = remaining;
    }


}
