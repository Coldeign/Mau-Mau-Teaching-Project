package maumau.player;

import maumau.deck.Deck;

public enum PlayerType {
    HUMAN {
        @Override
        public Player create(Deck deck) {
            return new HumanPlayer(deck);
        }
    },
    COM {
        @Override
        public Player create(Deck deck) {
            return new ComPlayer(deck);
        }
    };

    public abstract Player create(Deck deck);
}
