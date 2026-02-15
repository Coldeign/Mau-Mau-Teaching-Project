package maumau.deck;

import maumau.playingCard.PlayingCard;
import util.arrayUtil.ArraySort;

public class ArrayDeck implements Deck {
    private PlayingCard[] deck;

    public ArrayDeck() {
        init();
    }

    @Override
    public PlayingCard pop() {
        if (isEmpty()) {
            init();
        }
        for (int i = 0; i < deck.length; i++) {
            if (deck[i]!= null) {
                PlayingCard card = deck[i];
                deck[i] = null;
                return card;
            }
        }
        throw new RuntimeException("This should never reach?!");
    }


    @Override
    public void init() {
        PlayingCard[] allCards = PlayingCard.getAllCards().clone();
        deck = new PlayingCard[allCards.length];
        System.arraycopy(allCards, 0, deck, 0, allCards.length);
        ArraySort.shuffle(deck);
    }

    @Override
    public boolean isEmpty() {
        for (PlayingCard card : deck) {
            if (card != null) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Deck:");
        for(PlayingCard card : deck) {
            if (card != null) {
                sb.append("\n").append(card);
            }
        }
        return sb.toString();
    }
}
