package Hangman;

import java.io.FileNotFoundException;

public class HangmanMain {
    public static void main(String[] args) throws FileNotFoundException {
        HangmanController game = new HangmanController();
        game.start();

    }

}
