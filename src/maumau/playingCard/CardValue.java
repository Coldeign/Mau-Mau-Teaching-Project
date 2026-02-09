package maumau.playingCard;

import Prog1Tools.IOTools;

public enum CardValue {
    SEVEN,
    EIGHT,
    NINE,
    TEN,
    JACK,
    QUEEN,
    KING,
    ACE;

    public static String valuesString() {
        StringBuilder sb = new StringBuilder();
        for (CardValue value : CardValue.values()) {
            sb.append(value).append(" (").append(value.ordinal()).append(")").append(", ");
        }
        sb.delete(sb.length()-2, sb.length());
        return sb.toString();
    }

    public static CardValue getByUserInput() {
        while (true) {
            String input = IOTools.readString("Enter the card color or the index (" + CardValue.valuesString() +  "): ");

            try {
                return CardValue.values()[Integer.parseInt(input)];
            } catch (NumberFormatException e) {
                // input is not a number then, might be the value itself
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Enter a valid index!");
            }

            try {
                return CardValue.valueOf(input.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Enter a valid card color!");
            }
        }
    }
}
