package maumau.deck;

import maumau.playingCard.SortingMethod;
import maumau.playingCard.CardColor;
import maumau.playingCard.CardValue;
import maumau.playingCard.PlayingCard;

import java.util.Random;

public class ArrayDeck implements Deck {
    public static final int DEFAULT_DECK_SIZE = 32;
    private PlayingCard[] deck;

    public ArrayDeck() {
        init();
        shuffle();
    }

    @Override
    public PlayingCard pop() {
        if (isEmpty()) {
            init();
            shuffle();
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
    public void shuffle() {
        // "Algorithm P (Shuffling)" by Richard Durstenfeld (1964)
        // weirdly enough, this is often referred to as the Fisher-Yates-Shuffle even though this is the much
        // more efficient version of it -  O(n) compared to O(n^2)
        // wanna go down this rabbit hole? look it up and figure out the citations

        // implementation from https://stackoverflow.com/questions/1519736/random-shuffling-of-an-array
        Random rnd = new Random();
        for (int i = deck.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            PlayingCard card = deck[index];
            deck[index] = deck[i];
            deck[i] = card;
        }
    }

    @Override
    public void sort(SortingMethod method) {
        method.sort(deck);
    }

    @Override
    public void init() {
        deck = new PlayingCard[DEFAULT_DECK_SIZE];
        int index = 0;
        for (int i = 0; i < CardColor.values().length; i++) {
            for (int j = 0; j < CardValue.values().length; j++) {
                deck[index++] = new PlayingCard(CardColor.values()[i], CardValue.values()[j]);
            }
        }
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
