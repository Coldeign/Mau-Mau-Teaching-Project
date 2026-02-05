package maumau.player;

import Prog1Tools.IOTools;
import maumau.deck.Deck;

public enum PlayerType {
    HUMAN {
        @Override
        public Player create(Deck deck) {
            return new HumanPlayer(deck);
        }
    },
    COM {
        @Override
        public Player create(Deck deck) {
            return new ComPlayer(deck);
        }
    };

    public abstract Player create(Deck deck);

    public static String playerTypeString() {
        StringBuilder sb = new StringBuilder();
        for (PlayerType playerType : PlayerType.values()) {
            sb.append(playerType).append(", ");
        }
        sb.delete(sb.length()-2, sb.length());
        return sb.toString();
    }

    public static PlayerType getPlayerTypeFromUserInput() {
        PlayerType playerType = null;
        do {
            try {
                playerType = PlayerType.valueOf(IOTools.readString("Enter the player type (" + PlayerType.playerTypeString() +  "): ").toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Enter a valid card color!");
            }
        } while (playerType == null);
        return playerType;
    }
}
