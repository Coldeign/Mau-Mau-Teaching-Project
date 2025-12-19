package maumau.playingCard;

public enum SortingMethod {
    BUBBLE {
        @Override
        public void sort(PlayingCard[] cards) {
            for (int i = 0; i < cards.length; i++) {
                for (int j = 0; j < cards.length - i - 1; j++) {
                    if (cards[j].compareTo(cards[j+1]) > 0) {
                        PlayingCard temp = cards[j];
                        cards[j] = cards[j+1];
                        cards[j+1] = temp;
                    }
                }
            }
        }
    },
    INSERTION {
        @Override
        public void sort(PlayingCard[] cards) {
            for (int i = 1; i < cards.length; i++) {
                PlayingCard temp = cards[i];
                int j = i - 1;
                while (j >= 0 && cards[j].compareTo(temp) > 0) {
                    cards[j + 1] = cards[j];
                    j = j - 1;
                }
                cards[j + 1] = temp;
            }
        }
    },
    SELECTION {
        @Override
        public void sort(PlayingCard[] cards) {
            for (int i = 0; i < cards.length - 1; i++) {
                int min_idx = i;
                for (int j = i + 1; j < cards.length; j++) {
                    if (cards[j].compareTo(cards[min_idx]) < 0)
                        min_idx = j;
                }
                PlayingCard temp = cards[min_idx];
                cards[min_idx] = cards[i];
                cards[i] = temp;
            }
        }
    };

    public abstract void sort(PlayingCard[] cards);
}
