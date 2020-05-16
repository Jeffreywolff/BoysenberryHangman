package Hangman;

import java.util.Random;
import java.util.Scanner;

public class HangmanController {

    private HangmanModel _model;
    private Scanner _scan;
    private Random _random;



    public HangmanController(){
        _model = new HangmanModel();
        _scan = new Scanner(System.in);
        _random = new Random();
    }

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

    public void playGame(){
        HangmanView.printStartGameSequence();
        while (true){
            if (_model.getHasWon()){
                HangmanView.printCongratulations();
                break;
            }
            else if (_model.getFailedGuess() > 6){
                HangmanView.printGameOverMessage();
            }
            else if (wordComplete()){
                HangmanView.printCongratulations();
                break;
            }
            HangmanView.printEnterInput();
            _model.setUserInput(_scan.nextLine());
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

    private void resetVariables() {
        _model.setFailedGuess(0);
        _model.setHasWon(false);
        _model.setRandomWord("");
        _model.setIsChar(false);
        _model.set_difficulty(0);
        _model.setUserInput("");
    }

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
        }
        else{
            HangmanView.printIsNotContainedInWord();
            _model.incorrectCharList.add(_model.getUserInput().charAt(0));
            System.out.println("Incorrect letters guessed: " + _model.incorrectCharList);
            _model.setFailedGuess(_model.getFailedGuess() + 1);
            System.out.println(_model.getFailedGuess());
        }
    }

    private void checkStringInputRandomWord() {
        if (_model.getUserInput().equals(_model.getRandomWord())){
            HangmanView.printCongratulations();
            _model.setHasWon(true);
        }
        else{
            HangmanView.printIncorrectInput();
            _model.setFailedGuess(_model.getFailedGuess() + 1);
        }
    }

    private void isInputChar() {
        if (_model.getUserInput().length() > 1){//Check if the user input is a word/string
            _model.setIsChar(false);
        }
        else if (_model.getUserInput().length() == 1){ // Check if user input is a Char/letter
            _model.setIsChar(true);
        }
    }

    private void chooseDifficulty() {
        HangmanView.printDifficulty();
        _model.set_difficulty(_scan.nextInt());
        _scan.nextLine();
        System.out.println("Difficulty " + _model.get_difficulty() + " have been chosen!");
    }

    private void getRandomWord(){
        switch (_model.get_difficulty()){
            case 1:
                _model.setRandomWord(_model.easyWords[_random.nextInt(_model.easyWords.length)]);
                System.out.println(_model.getRandomWord());
                break;
            case 2:
                _model.setRandomWord(_model.normalWords[_random.nextInt(_model.normalWords.length)]);
                System.out.println(_model.getRandomWord());
                break;
            case 3:
                _model.setRandomWord(_model.hardWords[_random.nextInt(_model.hardWords.length)]);
                System.out.println(_model.getRandomWord());
                break;
        }
    }

    private void populate_randomWordCharList(){
        _model.randomWordCharList.clear();
        for (int i = 0; i<_model.getRandomWord().length(); i++){
            _model.randomWordCharList.add(_model.getRandomWord().charAt(i));
        }
        System.out.println(_model.randomWordCharList);
    }

    private void populate_unknownWordList(){
        _model.unknownWordList.clear();
        for (int i = 0;i < _model.getRandomWord().length();i++){
            _model.unknownWordList.add('_');
        }
        System.out.println(_model.unknownWordList);
    }

    private boolean wordComplete(){
        return !_model.unknownWordList.contains('_');
    }

}
