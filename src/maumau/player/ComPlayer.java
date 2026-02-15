package maumau.player;

import maumau.deck.Deck;
import maumau.playingCard.PlayingCard;

public class ComPlayer extends AbstractPlayer {
    public final ComPlayerStrategy strategy = ComPlayerStrategy.RANDOM; // TODO: put this into config
    public ComPlayer(Deck toHandCardsDrawFrom) {
        super(toHandCardsDrawFrom);
    }

    @Override
    public PlayingCard playCard(PlayingCard topCard) {
        int idx = strategy.pickCardIndex(hand, topCard);
        PlayingCard toPlay = hand.remove(idx);
        System.out.println(this + ": \"Playing " + toPlay + "...\"");
        return toPlay;
    }

    @Override
    public String toString() {
        return "Player " + id + " (COM)";
    }
}
