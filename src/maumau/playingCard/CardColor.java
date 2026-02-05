package maumau.playingCard;

import Prog1Tools.IOTools;

import java.util.*;

public enum CardColor {
    CLUBS,
    SPADES,
    HEARTS,
    DIAMONDS;

    public static String colorsString() {
        StringBuilder sb = new StringBuilder();
        for (CardColor color : CardColor.values()) {
            sb.append(color).append(", ");
        }
        sb.delete(sb.length()-2, sb.length());
        return sb.toString();
    }

    public static CardColor getByUserInput() {
        CardColor color = null;
        do {
            try {
                color = CardColor.valueOf(IOTools.readString("Enter the card color (" + CardColor.colorsString() +  "): ").toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Enter a valid card color!");
            }
        } while (color == null);
        return color;
    }

    public static CardColor randomCardColor(CardColor except) {
        CardColor[] values = CardColor.values();
        List<CardColor> options = new ArrayList<>(Arrays.asList(values));
        options.remove(except);
        return options.get(new Random().nextInt(options.size()));
    }

    public static CardColor randomCardColor() {
        return CardColor.values()[new Random().nextInt(4)];
    }
}
