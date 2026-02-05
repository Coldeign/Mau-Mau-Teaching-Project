package maumau.playingCard;

import Prog1Tools.IOTools;

public enum CardValue {
    ACE,
    KING,
    QUEEN,
    JACK,
    TEN,
    NINE,
    EIGHT,
    SEVEN;

    public static String valuesString() {
        StringBuilder sb = new StringBuilder();
        for (CardValue color : CardValue.values()) {
            sb.append(color).append(", ");
        }
        sb.delete(sb.length()-2, sb.length());
        return sb.toString();
    }

    public static CardValue getByUserInput() {
        CardValue value = null;
        do {
            try {
                value = CardValue.valueOf(IOTools.readString("Enter the card value (" + CardValue.valuesString() +  "): ").toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Enter a valid card value!");
            }
        } while (value == null);
        return value;
    }
}
