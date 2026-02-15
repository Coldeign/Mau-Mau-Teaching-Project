package maumau.deck;

import util.enumUtil.hasDisplayName;

public enum DeckType implements hasDisplayName {
    ARRAY("Array") {
        @Override
        public Deck create() {
            return new ArrayDeck();
        }
    },
    LINKED_STACK("LinkedStack") {
        @Override
        public Deck create() {
            return new LinkedStackDeck();
        }
    };

    private final String displayName;

    DeckType(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String displayName() {
        return displayName;
    }

    public abstract Deck create();

}
