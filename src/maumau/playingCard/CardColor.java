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
            sb.append(color).append(" (").append(color.ordinal()).append(")").append(", ");
        }
        sb.delete(sb.length()-2, sb.length());
        return sb.toString();
    }

    public static CardColor getByUserInput() {
        while (true) {
            String input = IOTools.readString("Enter the card color or the index (" + CardColor.colorsString() +  "): ").toUpperCase();

            try {
                return CardColor.values()[Integer.parseInt(input)];
            } catch (NumberFormatException e) {
                // input is not a number then, might be the color itself
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Enter a valid index!");
            }

            try {
                return CardColor.valueOf(input.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Enter a valid card color!");
            }
        }
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
