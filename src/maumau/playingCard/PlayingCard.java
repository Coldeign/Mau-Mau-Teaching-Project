package maumau.playingCard;

public class PlayingCard implements Comparable<PlayingCard> {
    public final CardColor color;
    public final CardValue value;

    public PlayingCard(CardColor color, CardValue value) {
        this.color = color;
        this.value = value;
    }

    @Override
    public String toString() {
        return value + " of " + color;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof PlayingCard)) {
            return false;
        }

        // could also just be:
        // return compareTo((PlayingCard) obj) == 0;

        boolean sameValue = ((PlayingCard) obj).value == this.value;
        boolean sameColor = ((PlayingCard) obj).color == this.color;
        return sameValue && sameColor;
    }

    @Override
    public int compareTo(PlayingCard o) {
        if (color.compareTo(o.color) == 0) {
            return value.compareTo(o.value);
        }
        return color.compareTo(o.color);
    }
}
