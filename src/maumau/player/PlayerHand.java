package maumau.player;

import maumau.SortingMethod;
import maumau.playingCard.PlayingCard;

public class PlayerHand {
    private PlayingCard[] hand = new PlayingCard[0];

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (PlayingCard card : hand) {
            sb.append(card).append(", ");
        }
        return sb.toString();
    }

    public void add(PlayingCard card) {
        PlayingCard[] newHand = new PlayingCard[hand.length+1];
        newHand[hand.length] = card;
        hand = newHand;
        sort(SortingMethod.SELECTION);
    }

    public PlayingCard remove(PlayingCard card) {
        int index = containsCard(card);
        if (index < 0) {
            return null;
        }
        hand[index] = null;
        hand = resize(hand);
        sort(SortingMethod.SELECTION);
        return card;
    }

    private PlayingCard[] resize(PlayingCard[] hand) {
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

    private int containsCard(PlayingCard card) {
        for (int i = 0; i < hand.length; i++) {
            if (hand[i].equals(card)) {
                return i;
            }
        }
        return -1;
    }

    public void sort(SortingMethod method) {
        switch (method) {
            case BUBBLE -> bubbleSort();
            case INSERTION -> insertionSort();
            case SELECTION -> selectionSort();
        }
    }

    private void bubbleSort() {
        for (int i = 0; i < hand.length; i++) {
            for (int j = 0; j < hand.length - i - 1; j++) {
                if (hand[j].compareTo(hand[j+1]) > 0) {
                    PlayingCard card = hand[j];
                    hand[j] = hand[j+1];
                    hand[j+1] = card;
                }
            }
        }
    }

    private void insertionSort() {
        for (int i = 1; i < hand.length; i++) {
            PlayingCard card = hand[i];
            int j = i - 1;
            while (j >= 0 && hand[j].compareTo(card) > 0) {
                hand[j + 1] = hand[j];
                j = j - 1;
            }
            hand[j + 1] = card;
        }
    }

    private void selectionSort() {
        for (int i = 0; i < hand.length - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < hand.length; j++) {
                if (hand[j].compareTo(hand[min_idx]) < 0)
                    min_idx = j;
            }
            PlayingCard temp = hand[min_idx];
            hand[min_idx] = hand[i];
            hand[i] = temp;
        }
    }
}
