package maumau.deck;

import maumau.playingCard.PlayingCard;
import maumau.sorting.ArraySort;

public class LinkedStackDeck implements Deck {
    private LinkedStack<PlayingCard> deck = new LinkedStack<>();

    public LinkedStackDeck() {
        init();
    }

    @Override
    public PlayingCard pop() {
        if (deck.isEmpty()) {
            init();
        }
        return deck.pop();
    }

    @Override
    public void init() {
        PlayingCard[] allCards = PlayingCard.getAllCards().clone();
        ArraySort.shuffle(allCards);
        for(PlayingCard card : allCards) {
            deck.add(card);
        }
    }

    @Override
    public boolean isEmpty() {
        return deck.isEmpty();
    }
}
