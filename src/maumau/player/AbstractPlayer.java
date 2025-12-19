package maumau.player;

import maumau.deck.Deck;

public abstract class AbstractPlayer implements Player {
    public static final int DEFAULT_HAND_SIZE = 5;
    private PlayerHand hand = new PlayerHand();

    public AbstractPlayer(Deck toHandCardsDrawFrom) {
        for (int i = 0; i < DEFAULT_HAND_SIZE; i++) {
            draw(toHandCardsDrawFrom);
        }
    }

    @Override
    public void draw(Deck fromDeck) {
        hand.add(fromDeck.pop());
    }
}
