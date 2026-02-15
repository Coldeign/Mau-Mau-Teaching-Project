package maumau.player;

import maumau.player.playerHand.PlayerHand;
import maumau.playingCard.PlayingCard;

import java.util.Random;

public enum ComPlayerStrategy {
    FIRST_MATCH {
        @Override
        public int pickCardIndex(PlayerHand hand, PlayingCard topCard) {
            return hand.matchesCardAt(topCard);
        }
    },
    RANDOM {
        @Override
        public int pickCardIndex(PlayerHand hand, PlayingCard topCard) {
            int TRIES = 50;
            Random rdm = new Random();
            for (int i = 0; i < TRIES; i++) {
                int idx = rdm.nextInt(hand.size());
                if (hand.get(idx).matches(topCard)) {
                    // System.out.println("Randomly chosen card at index " + idx + " is " + hand.get(idx) + ". Current topCard is " + topCard + ".");
                    return idx;
                }
            }
            // fallback if no match found after the tries
            return hand.matchesCardAt(topCard);
        }
    };

    public abstract int pickCardIndex(PlayerHand hand, PlayingCard topCard);
}
