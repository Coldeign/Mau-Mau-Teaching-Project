package maumau.playingCard;

import util.enumUtil.EnumUtils;

public class PlayingCard implements Comparable<PlayingCard> {
    public static final boolean SHORT_STRING = true;

    private static final PlayingCard[] ALL_CARDS = new PlayingCard[CardValue.values().length * CardColor.values().length];
    public final CardColor cardColor;
    public final CardValue cardValue;

    public PlayingCard(CardColor cardColor, CardValue cardValue) {
        this.cardColor = cardColor;
        this.cardValue = cardValue;
    }

    static {
        initAllCards();
    }

    public static PlayingCard[] getAllCards() {
        return ALL_CARDS;
    }

    /**
     * Initializes all card values in all card colors once to save. The only purpose for this is to do it once now
     */
    private static void initAllCards() {
        int index = 0;
        for (int i = 0; i < CardColor.values().length; i++) {
            for (int j = 0; j < CardValue.values().length; j++) {
                ALL_CARDS[index++] = new PlayingCard(CardColor.values()[i], CardValue.values()[j]);
            }
        }
    }

    @Override
    public String toString() {
        if (SHORT_STRING)
            return cardColor.symbol() + cardValue.symbol();
        return cardValue.displayName() + " of " + cardColor.displayName();
    }

    /**
     * A card matches another when either its color or its value is the same.
     *
     * @param other PlayingCard to compare to
     * @return true when either the color OR the value is the same
     */
    public boolean matches(PlayingCard other) {
        if (other == null) {
            return false;
        }
        if (this.cardValue == CardValue.JACK) {
            return true;
        }
        return cardColor == other.cardColor || cardValue == other.cardValue;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof PlayingCard card)) {
            return false;
        }
        return card.cardValue == this.cardValue && card.cardColor == this.cardColor;
    }

    @Override
    public int compareTo(PlayingCard o) {
        if (cardColor.compareTo(o.cardColor) == 0) {
            return cardValue.compareTo(o.cardValue);
        }
        return cardColor.compareTo(o.cardColor);
    }

    public static PlayingCard getByUserInput() {
        CardValue value = EnumUtils.getFromUserInput(CardValue.class); // for no particular reason other than the order
        return new PlayingCard(EnumUtils.getFromUserInput(CardColor.class), value);
    }
}
