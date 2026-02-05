package maumau.player.playerHand;

import maumau.playingCard.PlayingCard;

import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;

/**
 * Helps with sorting in the cards when drawing. Biggest downside is that no duplicates are allowed
 * which can be a problem when the deck gets reshuffled and the same card gets drawn and basically discarded, hence why
 * it's deprecated. Should be implemented with a data structure written from scratch resembling a treeSet having a way
 * of handling duplicates
 */
@Deprecated
public class PlayerHandTreeSet implements PlayerHand {
    private Set<PlayingCard> hand = new TreeSet<>();
    private boolean lastCardPlayed = false;

    public PlayerHandTreeSet(PlayingCard... cards) {
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
        if (!hand.isEmpty()) {
            sb.delete(sb.length() - 2, sb.length());
        }
        return sb.toString();
    }

    public void add(PlayingCard card) {
        hand.add(card);
    }

    public PlayingCard remove(int index) {
        if (index < 0 || index >= hand.size()) {
            throw new IllegalArgumentException("The given index is out of bounds!");
        }
        Iterator<PlayingCard> it = hand.iterator();
        PlayingCard card = null;
        for (int i = 0; i <= index; i++) {
            card = it.next();
        }
        hand.remove(card);
        if (hand.isEmpty()) {
            lastCardPlayed = true;
        }
        return card;
    }

    public boolean isLastCardPlayed() {
        return lastCardPlayed;
    }

    @Override
    public boolean isSecondLastCardPlayed() {
        return false;
    }

    public int containsCardAt(PlayingCard card) {
        int index = 0;
        for (PlayingCard c : hand) {
            if (c.equals(card)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public int matchesCardAt(PlayingCard card) {
        int index = 0;
        for (PlayingCard c : hand) {
            if (card.matches(c)) {
                return index;
            }
            index++;
        }
        return -1;
    }
}

