package Hangman;

import java.util.ArrayList;


public class HangmanModel {

    public ArrayList<Character> randomWordCharList = new ArrayList<>();
    public ArrayList<Character> unknownWordList = new ArrayList<>();
    public ArrayList<Character> incorrectCharList = new ArrayList<>();
    public String[] easyWords = {"cars", "neon", "hello", "shark", "men"};
    public String[] normalWords = {"harder", "metal", "clever", "streets"};
    public String[] hardWords = {"specially", "women", "catastrophic"};
    public String correctSoundFilePath = "C:\\Users\\Jeffrey.wolff\\Documents\\GitHub\\BoysenberryHangman\\" +
            "src\\Sounds\\CorrectSound.wav";
    public String incorrectSoundFilePath = "C:\\Users\\Jeffrey.wolff\\Documents\\GitHub\\BoysenberryHangman\\" +
            "src\\Sounds\\incorrectSound.wav";

    public String[] HangmanImages = {" +---+\n" +
            "  |   |\n" +
            "      |\n" +
            "      |\n" +
            "      |\n" +
            "      |\n" +
            "=========", "  +---+\n" +
            "  |   |\n" +
            "  O   |\n" +
            "      |\n" +
            "      |\n" +
            "      |\n" +
            "=========", "  +---+\n" +
            "  |   |\n" +
            "  O   |\n" +
            "  |   |\n" +
            "      |\n" +
            "      |\n" +
            "=========", "  +---+\n" +
            "  |   |\n" +
            "  O   |\n" +
            " /|   |\n" +
            "      |\n" +
            "      |\n" +
            "=========", "  +---+\n" +
            "  |   |\n" +
            "  O   |\n" +
            " /|\\  |\n" +
            "      |\n" +
            "      |\n" +
            "=========", "  +---+\n" +
            "  |   |\n" +
            "  O   |\n" +
            " /|\\  |\n" +
            " /    |\n" +
            "      |\n" +
            "=========", "  +---+\n" +
            "  |   |\n" +
            "  O   |\n" +
            " /|\\  |\n" +
            " / \\  |\n" +
            "      |\n" +
            "========="};

    // A variable that keeps the users input of what difficulty is chosen.
    private int _difficulty;

    public int get_difficulty(){
        return this._difficulty;
    }

    public void set_difficulty(int num){
        this._difficulty = num;
    }

    // A variable for the randomized word.
    private String randomWord;

    public void setRandomWord(String word){
        this.randomWord = word;
    }

    public String getRandomWord(){
        return randomWord;
    }

    // Users input
    private String userInput;

    public String getUserInput(){
        return userInput;
    }

    public void setUserInput(String input){
        this.userInput = input;
    }

    // A variable that changes depending on the users input.
    private boolean isChar;

    public boolean getIsChar(){
        return isChar;
    }

    public void setIsChar(boolean state){
        this.isChar = state;
    }

    // A variable that keeps track on how many incorrect guesses the user have done
    private int failedGuess = 0;

    public int getFailedGuess(){
        return failedGuess;
    }

    public void setFailedGuess(int guess){
        this.failedGuess = guess;
    }

    // A boolean variable that saves either true or false if the user has won.
    private boolean hasWon = false;

    public boolean getHasWon(){
        return hasWon;
    }

    public void setHasWon( boolean state){
        this.hasWon = state;
    }

}
