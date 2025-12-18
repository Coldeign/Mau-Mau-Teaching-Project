package maumau.deck;

import maumau.SortingMethod;
import maumau.playingCard.PlayingCard;

public interface Deck {
    PlayingCard pop();
    void shuffle();
    void sort(SortingMethod method);
    void init();
    boolean isEmpty();

}
