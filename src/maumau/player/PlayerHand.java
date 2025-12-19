package maumau.player;

import maumau.playingCard.SortingMethod;
import maumau.playingCard.PlayingCard;

public class PlayerHand {
    private PlayingCard[] hand = new PlayingCard[0];

    public PlayerHand(PlayingCard... cards) {
        for (PlayingCard card : cards) {
            add(card);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (PlayingCard card : hand) {
            sb.append(card).append(", ");
        }
        sb.delete(sb.length()-2, sb.length()-1);
        return sb.toString();
    }

    public void add(PlayingCard card) {
        PlayingCard[] newHand = new PlayingCard[hand.length+1];
        for (int i = 0; i < hand.length; i++) {
            newHand[i] = hand[i];
        }
        newHand[hand.length] = card;
        hand = newHand;
        SortingMethod.SELECTION.sort(hand);
    }

    public PlayingCard remove(PlayingCard card) {
        int index = containsCardAt(card);
        if (index < 0) {
            return null;
        }
        hand[index] = null;
        hand = reduceSize(hand);
        SortingMethod.SELECTION.sort(hand);
        return card;
    }

    private PlayingCard[] reduceSize(PlayingCard[] hand) {
        PlayingCard[] newHand = new PlayingCard[hand.length-1];
        int nullIndex = -1;
        for (int i = 0; i < newHand.length; i++) {
            if (hand[i] != null) {
                newHand[i] = hand[i];
                continue;
            }
            nullIndex = i;
        }
        if (nullIndex != -1) {
            newHand[nullIndex] = hand[hand.length - 1];
        }
        return newHand;
    }

    private int containsCardAt(PlayingCard card) {
        for (int i = 0; i < hand.length; i++) {
            if (hand[i].equals(card)) {
                return i;
            }
        }
        return -1;
    }
}
