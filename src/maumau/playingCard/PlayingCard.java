package maumau.playingCard;

public class PlayingCard implements Comparable<PlayingCard> {
    private static final PlayingCard[] ALL_CARDS = new PlayingCard[CardValue.values().length * CardColor.values().length];
    public final CardColor color;
    public final CardValue value;

    public PlayingCard(CardColor color, CardValue value) {
        this.color = color;
        this.value = value;
    }

    static {
        int index = 0;
        for (int i = 0; i < CardColor.values().length; i++) {
            for (int j = 0; j < CardValue.values().length; j++) {
                ALL_CARDS[index++] = new PlayingCard(CardColor.values()[i], CardValue.values()[j]);
            }
        }
    }

    public static PlayingCard[] getAllCards() {
        return ALL_CARDS;
    }

    @Override
    public String toString() {
        return value + " of " + color;
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
        if (other.value == CardValue.JACK) {
            return true;
        }
        return color == other.color || value == other.value;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof PlayingCard card)) {
            return false;
        }
        return card.value == this.value && card.color == this.color;
    }

    @Override
    public int compareTo(PlayingCard o) {
        if (color.compareTo(o.color) == 0) {
            return value.compareTo(o.value);
        }
        return color.compareTo(o.color);
    }

    public static PlayingCard getByUserInput() {
        CardValue value = CardValue.getByUserInput(); // for no particular reason other than the order
        return new PlayingCard(CardColor.getByUserInput(), value);
    }
}
