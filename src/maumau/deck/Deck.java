package maumau.deck;

import maumau.playingCard.PlayingCard;

public interface Deck {
    PlayingCard pop();
    void init();
    boolean isEmpty();

}
