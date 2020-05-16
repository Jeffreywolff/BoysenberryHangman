package Hangman;

public class HangmanView {

    /**
     * Print a welcome message in the terminal
     */
    public static void printWelcome(){
        System.out.println("Starting");
        printDots();
        System.out.println("Welcome to the Hangman game!");
    }

    /**
     * Prints dots a number of times in the terminal
     */
    private static void printDots(){
        try{
            for (int i = 0; i < 3; i++){
                for (int j = 0; j < 3; j++){
                    System.out.print(".");
                    Thread.sleep(500L);
                }
                System.out.print("\b\b\b\b\b");
            }
        }   catch (Exception ex){
            System.out.println("Thread died with the exception: " + ex);
        }
    }

    /**
     * Prints the games rules
     */
    public static void gameRules(){
        System.out.println("Here is the rules of the game: \n");
        System.out.println("This is The Hangman Game, where a random word is chosen and you will have ");
        System.out.println("to guess what the word is, either by entering a letter or try to guess the whole word. \n");
        System.out.println("The goal is to guess the whole word before the man is hanged! That means 7 guesses");
        System.out.println("The random word will be different depending on what difficulty you choose.");
        System.out.println("If you choose Easy(1), the word will be no longer than 5 letters.");
        System.out.println("If you choose Normal(2), the word can be longer than 5 letters, a bit more complicated. ");
        System.out.println("If you choose Hard(3), the word can be as long as 44 letters, it will be really hard!");
        System.out.println("Press 'Enter' to continue");
    }

    public static void printDifficulty(){
        System.out.println("Choose a level of Difficulty: 'Enter a Number' ");
        System.out.println("(1) Easy");
        System.out.println("(2) Normal");
        System.out.println("(3) Hard");
        System.out.println("Enter Number Here: ");
    }

    public static void printCongratulations(){
        System.out.println("You have guessed the correct word, Congratulations!");
    }

    public static void printIncorrectInput(){
        System.out.println("Sorry, but your input is not correct.");
    }

    public static void printStartGameSequence(){
        System.out.println("Let the game begin!");
    }

    public static void printEnterInput(){
        System.out.println("Enter a word or a letter to guess");
    }

    public static void printPlayAgain() {
        System.out.println("Do you want to play again?");
        System.out.println("(1), Yes, please play again.");
        System.out.println("(2), No, exit this piece of shit of a program.");
    }

    public static void printNewLines(){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    public static void exitMessage() {
        System.out.println("Goodbye, have a good day!");
    }

    public static void printGameOverMessage() {
        System.out.println("You have guessed to many times, the man is dead!");
    }

    public static void printContainedInWord() {
        System.out.println("The letter is contained in the secret word");
    }

    public static void printIsNotContainedInWord() {
        System.out.println("That letter is not contained in the word");
    }

    public static void printDifficultyInterval() {
        System.out.println("Sorry, but that number is out of bounds!");
        System.out.println("Please enter a number between 1 - 3!");
    }
}