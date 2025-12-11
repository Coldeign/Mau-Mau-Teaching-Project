package maumau.player;

import maumau.deck.Deck;
import maumau.playingCard.PlayingCard;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractPlayer implements Player {
    private List<PlayingCard> handCards = new ArrayList<>();

    public AbstractPlayer(Deck toHandCardsDrawFrom) {
        for (int i = 0; i < 6; i++) {
            draw(toHandCardsDrawFrom);
        }
    }

    @Override
    public void draw(Deck fromDeck) {
        handCards.add(fromDeck.pop());
    }
}
