package maumau.gamelogic;

import Prog1Tools.IOTools;
import maumau.config.Config;
import maumau.deck.Deck;
import maumau.player.ComPlayer;
import maumau.player.HumanPlayer;
import maumau.player.Player;
import maumau.playingCard.CardColor;
import maumau.playingCard.CardValue;
import maumau.playingCard.PlayingCard;

/**
 * Using a Singleton Pattern to ensure there only ever exists one Game object.
 */
public class Game {
    private static final Game INSTANCE = new Game();
    private final Config config = Config.getInstance();
    private Deck deck;
    private PlayingCard topCard;
    private Player[] players;
    private Player currentPlayer;
    //private final boolean drawUntilCardPlayable;

    private Game() {
        // TODO: pull gamerule(s) over into config
        // drawUntilCardPlayable = getUserInputDrawGameRule();
    }

    public static Game getInstance() {
        return INSTANCE.setup();
    }

    private Game setup() {
        deck = config.getDeckType().create();
        topCard = deck.pop();
        players = new Player[config.getPlayerTypes().length];
        for (int i = 0; i < players.length; i++) {
            players[i] = config.getPlayerTypes()[i].create(deck);
        }
        return this;
    }

    public void play() {
        boolean eightAccountedFor = false;
        boolean sevenAccountedFor = false;

        do {
            currentPlayer = cyclePlayer(currentPlayer);

            System.out.println("Current topcard: " + topCard);


            if (topCard.value == CardValue.EIGHT && !eightAccountedFor) {
                System.out.println(currentPlayer + ": \"Bummer...\"");
                eightAccountedFor = true;
                continue;
            }

            if (topCard.value == CardValue.SEVEN && !sevenAccountedFor) {
                System.out.println(currentPlayer + ": \"That's mean!\"");
                currentPlayer.draw(deck);
                currentPlayer.draw(deck);
                sevenAccountedFor = true;
            }


            if (/*!drawUntilCardPlayable &&*/ !currentPlayer.canPlayCard(topCard)) {
                System.out.println(currentPlayer + ": \"Can't play a card. I'm drawing.\"");
                currentPlayer.draw(deck);
                continue;
            }
            /*
            while (drawUntilCardPlayable && !currentPlayer.canPlayCard(topCard)) {
                System.out.println(currentPlayer + ": \"Can't play a card. I'm drawing.\"");
                currentPlayer.draw(deck);
            }
             */


            topCard = currentPlayer.playCard(topCard);
            eightAccountedFor = false;
            sevenAccountedFor = false;

            if (currentPlayer.hasNearlyWon()) {
                System.out.println(currentPlayer + ": \"Mau!\"");
            }

            if (currentPlayer.hasWon()) {
                System.out.println(currentPlayer + ": \"Mau Mau!\"");
                break;
            }

            /*
            if (topCard.value == CardValue.JACK) {
                if (currentPlayer instanceof HumanPlayer) {
                    System.out.print("Pick a color! ");
                    topCard = new PlayingCard(CardColor.getByUserInput(), CardValue.JACK);
                } else {
                    topCard = new PlayingCard(CardColor.randomCardColor(), CardValue.JACK);
                }
            }
             */
            if (topCardIsJack()) {
                System.out.println("Card color changed to " + topCard.color);
            }
        } while (true);

        System.out.println(currentPlayer + " has won!");
    }

    private Player cyclePlayer(Player player) {
        int idx;
        if (player == null || player.getId()+1 >= players.length) {
            idx = 0;
        } else {
            idx = player.getId() + 1;
        }
        System.out.println(players[idx] + " turn!");
        return players[idx];
    }

    private boolean topCardIsJack () {
        if (topCard.value != CardValue.JACK) {
            return false;
        }

        if (currentPlayer instanceof HumanPlayer) {
            System.out.print("Pick a color! ");
            topCard = new PlayingCard(CardColor.getByUserInput(), CardValue.JACK);
        } else if (currentPlayer instanceof ComPlayer) {
            topCard = new PlayingCard(CardColor.randomCardColor(), CardValue.JACK);
        }
        return true;
    }

    private boolean getUserInputDrawGameRule() {
        char keepDrawing;
        do {
            keepDrawing  = IOTools.readChar("Want to keep drawing until a card can be played? (y/n) ");
        } while (keepDrawing != 'y' && keepDrawing != 'n');

        return switch (keepDrawing) {
            case 'y' -> true;
            case 'n' -> false;
            default -> throw new IllegalStateException("Unexpected value: " + keepDrawing); // technically unreachable
        };
    }
}
