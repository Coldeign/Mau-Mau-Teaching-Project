package maumau;

import maumau.gamelogic.Game;

public class Main {
    static void main() {
        Game game = Game.getInstance();
        game.play();
    }
}
