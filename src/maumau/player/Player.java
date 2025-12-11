package maumau.player;

import maumau.deck.Deck;

public interface Player {
    void draw(Deck fromDeck);
    void playCard();
}
