package maumau.player;

import maumau.deck.Deck;
import maumau.playingCard.PlayingCard;

public class HumanPlayer extends AbstractPlayer {
    public final PlayerType playerType = PlayerType.HUMAN;
    public HumanPlayer(Deck toHandCardsDrawFrom) {
        super(toHandCardsDrawFrom);
    }

    @Override
    public PlayingCard playCard(PlayingCard topCard) {
        PlayingCard cardToPlay;
        int idx;
        do {
            printHand();
            System.out.println("Pick a card to play: ");
            cardToPlay = PlayingCard.getByUserInput();
            idx = hand.containsCardAt(cardToPlay);
        } while (!topCard.matches(cardToPlay) && idx != -1);

        return hand.remove(idx);
    }

    public void printHand() {
        System.out.println("Your hand:");
        System.out.println(hand);
    }

    @Override
    public String toString() {
        return "Player " + id;
    }
}
