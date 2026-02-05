package maumau.player;

import maumau.deck.Deck;
import maumau.playingCard.PlayingCard;

public interface Player {
    void draw(Deck fromDeck);
    boolean hasWon();
    boolean hasNearlyWon();
    PlayingCard playCard(PlayingCard topCard);
    boolean canPlayCard(PlayingCard topCard);
    int getId();
}
