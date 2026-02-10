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

    public static String formattedString() {
        StringBuilder sb = new StringBuilder();
        for (CardValue value : CardValue.values()) {
            sb.append(value).append(" (").append(value.ordinal()).append(")").append(", ");
        }
        sb.delete(sb.length()-2, sb.length());
        return sb.toString();
    }

    public static CardValue getByUserInput() {
        while (true) {
            String input = IOTools.readString("Enter the card color or the index (" + CardValue.formattedString() +  "): ");

            try {
                return CardValue.values()[Integer.parseInt(input)];
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Enter a valid index!");
            } catch (NumberFormatException e) {
                return CardValue.valueOf(input.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Enter a valid card color!");
            }
        }
    }
}
