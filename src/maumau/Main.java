package maumau;

import maumau.deck.ArrayDeck;
import maumau.deck.Deck;
import maumau.gamelogic.Game;

public class Main {
    public static void main(String[] args) {
        //new Game().setup().play();
        Deck deck = new ArrayDeck();
        deck.init();
        System.out.println(deck);
        deck.shuffle();
        System.out.println(deck);
        deck.sort(SortingMethod.SELECTION);
        System.out.println(deck);
    }
}
