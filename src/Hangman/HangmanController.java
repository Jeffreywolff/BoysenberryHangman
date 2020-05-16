package Hangman;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Random;
import java.util.Scanner;

public class HangmanController {

    private HangmanModel _model;
    private Scanner _scan;
    private Random _random;


    /**
     * This is the first method that is called and it creates associations with the other classes in the package
     * It creates the classes and names them with easier names
     */
    public HangmanController(){
        _model = new HangmanModel();
        _scan = new Scanner(System.in);
        _random = new Random();
    }

    /**
     * starts with printing out welcome messages and rukes taken from the HangmanView Class
     * Calls the classes methods in order to play the games.
     */
    public void start() {
        HangmanView.printWelcome();
        HangmanView.gameRules();
        _scan.nextLine();
        chooseDifficulty();
        getRandomWord();
        populate_randomWordCharList();
        populate_unknownWordList();
        playGame();
    }

    /**
     * Checks if the player has won or has lost.
     * It asks the player for its input and then calls methods to check the input
     */
    public void playGame(){
        HangmanView.printStartGameSequence();
        while (true){
            if (_model.getHasWon()){
                HangmanView.printCongratulations();
                break;
            }
            else if (_model.getFailedGuess() > 6){
                HangmanView.printGameOverMessage();
                break;
            }
            else if (isWordComplete()){
                HangmanView.printCongratulations();
                break;
            }
            if (_model.getFailedGuess() > 0){
                System.out.println(_model.HangmanImages[_model.getFailedGuess()-1]);
            }

            HangmanView.printEnterInput();
            _model.setUserInput(_scan.nextLine().toLowerCase());
            isInputChar();
            if (!_model.getIsChar()){
                checkStringInputRandomWord();
            }
            else{
                checkCharValidInput();
            }
        }
        restartGame();
    }

    /**
     * This method asks the player if he/her want to play again
     * It then calls a method to resets all necessary variables
     * After it has reset the variables it calls the start method again
     */
    private void restartGame() {
        HangmanView.printPlayAgain();
        int userChoice = _scan.nextInt();
        switch (userChoice){
            case 1:
                HangmanView.printNewLines();
                break;
            case 2:
                HangmanView.exitMessage();
                System.exit(0);
        }
        resetVariables();
        start();
    }

    /**
     * This method resets all necessary variables to replay the game.
     */
    private void resetVariables() {
        _model.setFailedGuess(0);
        _model.setHasWon(false);
        _model.setRandomWord("");
        _model.setIsChar(false);
        _model.set_difficulty(0);
        _model.setUserInput("");
    }

    /**
     * This method loops through the words letters and looks if the letter the
     * player has given is contained in the word. If the letter is contained it will add the letter to a list at the
     * same place it was in the word. So if you have the same letter twice in the word the method will add the
     * letter to all the places where it is found in the word in their rightful position in the list.
     * It will also call the sound method if you have guessed right or wrong.
     * If the player have guessed wrong the method will add +1 to the FaultGuesses variable
     *
     */
    private void checkCharValidInput() {
        if (_model.randomWordCharList.contains(_model.getUserInput().charAt(0))){ //Checks if the Arraylist contains user char
            HangmanView.printContainedInWord();//Confirms the above
            for (int i = 0; i < _model.getRandomWord().length(); i++){ //Loops through the randomWords letters.
                if (_model.getUserInput().charAt(0) == _model.getRandomWord().charAt(i)){ //If userChar is equal to randomWords char at i
                    _model.unknownWordList.set(i, _model.getUserInput().charAt(0)); // Sets the index om the iteration to user
                    //char, if the above is.
                }
            }
            System.out.println(_model.unknownWordList);
            playCorrectSound(_model.correctSoundFilePath);
        }
        else{
            HangmanView.printIsNotContainedInWord();
            playInCorrectSound(_model.incorrectSoundFilePath);
            _model.incorrectCharList.add(_model.getUserInput().charAt(0));
            System.out.println("Incorrect letters guessed: " + _model.incorrectCharList);
            _model.setFailedGuess(_model.getFailedGuess() + 1);
            System.out.println(_model.getFailedGuess());
        }
    }

    /**
     * If the player/user try to guess a whole word it will check if it is equals to the secret word
     * If it is it will set the boolean variable to true and the method playGame will exit it's while loop
     * Else if the word guessed is wrong the FaultGuessing variable will get +1 added
     * It will play a sound if the player has guessed right or wrong.
     */
    private void checkStringInputRandomWord() {
        if (_model.getUserInput().equals(_model.getRandomWord())){
            playCorrectSound(_model.correctSoundFilePath);
            _model.setHasWon(true);
        }
        else{
            HangmanView.printIncorrectInput();
            playInCorrectSound(_model.incorrectSoundFilePath);
            _model.setFailedGuess(_model.getFailedGuess() + 1);
        }
    }

    /**
     * This method checks if the input by the player is a letter or a word by comparing its length
     * if the input is greater than 1 it's a word
     * if the input is equal to 1 it is a letter
     */
    private void isInputChar() {
        if (_model.getUserInput().length() > 1){//Check if the user input is a word/string
            _model.setIsChar(false);
        }
        else if (_model.getUserInput().length() == 1){ // Check if user input is a Char/letter
            _model.setIsChar(true);
        }
    }

    /**
     * This method is for choosing difficulty of the words
     * Once a difficulty is chosen the program will set the choice in a variable in the model class
     */
    private void chooseDifficulty() {
        HangmanView.printDifficulty();
        while (true) {
            getIntegerInput();
            _scan.nextLine();
            if (isInputOutOfBounds()) {
                HangmanView.printDifficultyInterval();
            } else {
                break;
            }
        }
        System.out.println("Difficulty " + _model.get_difficulty() + " have been chosen!");
    }

    /**
     * This method chooses a random word from the difficulty chosen by randomising a number based on
     * the length of the arrays in the model class. The random word will be set to the index of the list
     */
    private void getRandomWord(){
        switch (_model.get_difficulty()){
            case 1:
                _model.setRandomWord(_model.easyWords[_random.nextInt(_model.easyWords.length)]);
                break;
            case 2:
                _model.setRandomWord(_model.normalWords[_random.nextInt(_model.normalWords.length)]);
                break;
            case 3:
                _model.setRandomWord(_model.hardWords[_random.nextInt(_model.hardWords.length)]);
                break;
        }
    }

    /**
     * This method populates an arraylist by looping through the random word.
     * Each letter it is looped through is added to the arraylist.
     */
    private void populate_randomWordCharList(){
        _model.randomWordCharList.clear();
        for (int i = 0; i<_model.getRandomWord().length(); i++){
            _model.randomWordCharList.add(_model.getRandomWord().charAt(i));
        }
    }

    private void populate_unknownWordList(){
        _model.unknownWordList.clear();
        for (int i = 0;i < _model.getRandomWord().length();i++){
            _model.unknownWordList.add('_');
        }
        System.out.println(_model.unknownWordList);
    }

    private boolean isWordComplete(){
        if (!_model.unknownWordList.contains('_')){
            return true;
        }
        else{
            return false;
        }
    }

    private void getIntegerInput(){
        while(true) {
            try {
                 _model.set_difficulty(_scan.nextInt());
                break;
            }
            catch (Exception InputMismatchException) {
                System.out.println("That's an invalid input, please try again!");
                _scan.next();
            }
        }
    }

    private boolean isInputOutOfBounds(){
        if(_model.get_difficulty() > 3 || _model.get_difficulty() < 1){
            return true;
        }
        else{
            return false;
        }
    }

    private static void playCorrectSound(String filepath){

        InputStream music;
        try{
            music = new FileInputStream(new File(filepath));
            AudioStream audio = new AudioStream(music);
            AudioPlayer.player.start(audio);
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,"Can't find file or it is wrong format");
        }
    }

    private static void playInCorrectSound(String filepath){

        InputStream music;
        try{
            music = new FileInputStream(new File(filepath));
            AudioStream audio = new AudioStream(music);
            AudioPlayer.player.start(audio);
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,"Can't find file or it is wrong format");
        }
    }

}