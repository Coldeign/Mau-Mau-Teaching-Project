package maumau.deck;

import Prog1Tools.IOTools;

public enum DeckType {
    ARRAY {
        @Override
        public Deck create() {
            return new ArrayDeck();
        }
    },
    LINKED_STACK {
        @Override
        public Deck create() {
            return new LinkedStackDeck();
        }
    };

    public abstract Deck create();

    public static String deckTypeString() {
        StringBuilder sb = new StringBuilder();
        for (DeckType deckType : DeckType.values()) {
            sb.append(deckType).append(", ");
        }
        sb.delete(sb.length()-2, sb.length());
        return sb.toString();
    }

    public static DeckType getDeckTypeFromUserInput() {
        DeckType deckType = null;
        do {
            try {
                deckType = DeckType.valueOf(IOTools.readString("Enter the deck type (" + DeckType.deckTypeString() +  "): ").toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Enter a valid card color!");
            }
        } while (deckType == null);
        return deckType;
    }
}
