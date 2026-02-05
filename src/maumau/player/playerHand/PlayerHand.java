package maumau.player.playerHand;

import maumau.playingCard.PlayingCard;

public interface PlayerHand {
    boolean isLastCardPlayed();
    boolean isSecondLastCardPlayed();
    void add(PlayingCard card);
    PlayingCard remove(int index);
    int containsCardAt(PlayingCard card);
    int matchesCardAt(PlayingCard card);
}
