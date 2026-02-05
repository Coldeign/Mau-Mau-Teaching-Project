package maumau.player;

import maumau.deck.Deck;
import maumau.playingCard.PlayingCard;

public class ComPlayer extends AbstractPlayer {
    public final PlayerType playerType = PlayerType.COM;
    public ComPlayer(Deck toHandCardsDrawFrom) {
        super(toHandCardsDrawFrom);
    }

    @Override
    public PlayingCard playCard(PlayingCard topCard) {
        int idx = hand.matchesCardAt(topCard); // plays the first matching card
        PlayingCard toPlay = hand.remove(idx);
        System.out.println(this + ": \"Playing " + toPlay + "...\"");
        return toPlay;
    }

    @Override
    public String toString() {
        return "Player " + id + " (COM)";
    }
}
