package maumau.sorting;

import maumau.playingCard.PlayingCard;

import java.util.Random;

public class ArraySort {
    // "Algorithm P (Shuffling)" by Richard Durstenfeld (1964)
    // weirdly enough, this is often referred to as the Fisher-Yates-Shuffle even though this is the much
    // more efficient version of it -  O(n) compared to O(n^2)
    // wanna go down this rabbit hole? look it up and figure out the citations

    // implementation from https://stackoverflow.com/questions/1519736/random-shuffling-of-an-array
    public static <T> void shuffle(T[] toShuffle) {
        Random rnd = new Random();
        for (int i = toShuffle.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            T card = toShuffle[index];
            toShuffle[index] = toShuffle[i];
            toShuffle[i] = card;
        }
    }

    public static <T extends Comparable<T>> void bubble(T[] toSort) {
        for (int i = 0; i < toSort.length; i++) {
            for (int j = 0; j < toSort.length - i - 1; j++) {
                if (toSort[j].compareTo(toSort[j+1]) > 0) {
                    T temp = toSort[j];
                    toSort[j] = toSort[j+1];
                    toSort[j+1] = temp;
                }
            }
        }
    }

    public static <T extends Comparable<T>> void insertion(T[] toSort) {
        for (int i = 1; i < toSort.length; i++) {
            T temp = toSort[i];
            int j = i - 1;
            while (j >= 0 && toSort[j].compareTo(temp) > 0) {
                toSort[j + 1] = toSort[j];
                j = j - 1;
            }
            toSort[j + 1] = temp;
        }
    }

    public static <T extends Comparable<T>> void selection(T[] toSort) {
        for (int i = 0; i < toSort.length - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < toSort.length; j++) {
                if (toSort[j].compareTo(toSort[min_idx]) < 0)
                    min_idx = j;
            }
            T temp = toSort[min_idx];
            toSort[min_idx] = toSort[i];
            toSort[i] = temp;
        }
    }
}
