package maumau.playingCard;

import util.enumUtil.hasDisplayName;
import util.enumUtil.hasSymbol;

import java.awt.*;
import java.util.*;
import java.util.List;

public enum CardColor implements hasDisplayName, hasSymbol {
    CLUBS("Clubs", "♣", Color.BLACK),
    SPADES("Spades", "♠", Color.BLACK),
    HEARTS("Hearts", "♥", Color.RED),
    DIAMONDS("Diamonds", "♦", Color.RED);

    private final String displayName;
    private final String symbol;
    private final Color color;

    CardColor(String displayName, String symbol, Color color) {
        this.displayName = displayName;
        this.symbol = symbol;
        this.color = color;
    }

    @Override
    public String displayName() {
        return displayName;
    }

    @Override
    public String symbol() {
        return symbol;
    }

    public Color color() {
        return color;
    }

    public static CardColor randomCardColor(CardColor except) {
        CardColor[] values = CardColor.values();
        List<CardColor> options = new ArrayList<>(Arrays.asList(values));
        options.remove(except);
        return options.get(new Random().nextInt(options.size()));
    }

    public static CardColor randomCardColor() {
        CardColor[] arr = CardColor.values();
        return arr[new Random().nextInt(arr.length)];
    }
}
