package maumau.playingCard;

import util.enumUtil.hasDisplayName;
import util.enumUtil.hasSymbol;

public enum CardValue implements hasDisplayName, hasSymbol {
    SEVEN("Seven", "7"),
    EIGHT("Eight", "8"),
    NINE("Nine", "9"),
    TEN("Ten", "10"),
    JACK("Jack", "J"),
    QUEEN("Queen", "Q"),
    KING("King", "K"),
    ACE("Ace", "A");


    private final String displayName;
    private final String symbol;

    CardValue(String displayName, String symbol) {
        this.displayName = displayName;
        this.symbol = symbol;
    }

    @Override
    public String symbol() {
        return symbol;
    }

    @Override
    public String displayName() {
        return displayName;
    }
}
