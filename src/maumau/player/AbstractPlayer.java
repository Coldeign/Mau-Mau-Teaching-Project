package maumau.player;

import maumau.deck.Deck;

public abstract class AbstractPlayer implements Player {
    private PlayerHand hand = new PlayerHand();

    public AbstractPlayer(Deck toHandCardsDrawFrom) {
        for (int i = 0; i < 6; i++) {
            draw(toHandCardsDrawFrom);
        }
    }

    @Override
    public void draw(Deck fromDeck) {
        hand.add(fromDeck.pop());
    }
}
