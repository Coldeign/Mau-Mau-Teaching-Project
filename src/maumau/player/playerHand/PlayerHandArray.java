package maumau.player.playerHand;

import maumau.playingCard.PlayingCard;
import util.arrayUtil.ArraySort;

public class PlayerHandArray implements PlayerHand {
    private PlayingCard[] hand = new PlayingCard[0];
    private boolean lastCardPlayed = false;
    private boolean secondLastCardPlayed = false;

    public PlayerHandArray(PlayingCard... cards) {
        for (PlayingCard card : cards) {
            add(card);
        }
    }

    @Override
    public int size() {
        return hand.length;
    }

    @Override
    public PlayingCard get(int index) {
        try {
            return hand[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }
    }

    public boolean isLastCardPlayed() {
        return lastCardPlayed;
    }

    public boolean isSecondLastCardPlayed() {
        return secondLastCardPlayed;
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
        ArraySort.selection(hand);
        secondLastCardPlayed = false;
    }

    /*
    public PlayingCard remove(PlayingCard card) {
        int index = containsCardAt(card);
        if (index < 0) {
            return null;
        }
        PlayingCard[] tempHand = new PlayingCard[hand.length-1];
        if (tempHand.length - index >= 0) System.arraycopy(hand, index + 1, tempHand, index, tempHand.length - index);
        hand = tempHand;
        return card;
    }
     */

    public PlayingCard remove(int index) {
        if (index < 0 || index >= hand.length) {
            throw new IllegalArgumentException("The given index is out of bounds!");
        }
        PlayingCard card = hand[index];
        PlayingCard[] tempHand = new PlayingCard[hand.length - 1];

        for (int i = 0; i < index; i++) {
            tempHand[i] = hand[i];
        }
        for (int i = index; i < tempHand.length; i++) {
            tempHand[i] = hand[i + 1];
        }
        hand = tempHand;
        if (hand.length == 0) {
            lastCardPlayed = true;
        }
        if (hand.length == 1) {
            secondLastCardPlayed = true;
        }
        return card;
    }

    public int containsCardAt(PlayingCard card) {
        for (int i = 0; i < hand.length; i++) {
            if (hand[i].equals(card)) {
                return i;
            }
        }
        return -1;
    }

    public int matchesCardAt(PlayingCard card) {
        for (int i = 0; i < hand.length; i++) {
            if (hand[i].matches(card)) {
                return i;
            }
        }
        return -1;
    }
}
