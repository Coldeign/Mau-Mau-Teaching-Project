package maumau.player;

import maumau.deck.Deck;
import maumau.player.playerHand.PlayerHand;
import maumau.player.playerHand.PlayerHandArray;
import maumau.playingCard.PlayingCard;

import java.util.Objects;

public abstract class AbstractPlayer implements Player {
    public static final int DEFAULT_HAND_SIZE = 5;
    private static int nextId = 0;
    public final int id = nextId++;

    PlayerHand hand = new PlayerHandArray();

    public AbstractPlayer(Deck toHandCardsDrawFrom) {
        for (int i = 0; i < DEFAULT_HAND_SIZE; i++) {
            draw(toHandCardsDrawFrom);
        }
    }

    @Override
    public boolean hasWon() {
        return hand.isLastCardPlayed();
    }

    @Override
    public boolean hasNearlyWon() {
        return hand.isSecondLastCardPlayed();
    }

    @Override
    public boolean canPlayCard(PlayingCard topCard) {
        return hand.matchesCardAt(topCard) != -1;
    }

    public final int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof AbstractPlayer that)) return false;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public void draw(Deck fromDeck) {
        hand.add(fromDeck.pop());
    }
}
