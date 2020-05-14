package Hangman;

public class HangmanView {

    public static void printWelcome(){
        System.out.println("Starting");
        printDots(3, 3);
        System.out.println("Welcome to the Hangman game!");
    }

    private static void printDots(int numberOfDots, int timesToRepeat){
        try{
            for (int i = 0; i < timesToRepeat; i++){
                for (int j = 0; j < numberOfDots; j++){
                    System.out.println(".");
                    Thread.sleep(500L);
                }
                System.out.println("\b\b\b\b\b");
            }
        }   catch (Exception ex){
            System.out.println("Thread died with the exception: " + ex);
            return;
        }
    }

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



}
