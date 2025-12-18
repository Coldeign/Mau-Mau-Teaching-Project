package maumau.gamelogic;

import maumau.deck.Deck;
import maumau.player.Player;
import maumau.playingCard.PlayingCard;

public class Game {
    private Deck deck;
    private PlayingCard topCard;
    private Player[] players;

    public Game() {}

    public Game setup() {
        // TODO: setup deck
        //  set topCard to deck.pop()
        //  setup HumanPlayer and one ComPlayer
        //  get user input for ComPlayer creation
        return this;
    }

    public void play() {

    }


}
