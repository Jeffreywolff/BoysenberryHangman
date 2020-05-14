package Hangman;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class HangmanController {

    private HangmanModel _model;
    private Scanner _scan;
    private Random _random;
    public ArrayList<Character> randomWordCharList = new ArrayList<Character>();
    public ArrayList<Character> unknownWordList = new ArrayList<Character>();
    public String[] easyWords = {"cars", "neon", "hello", "shark", "men"};
    public String[] normalWords = {"harder", "metal", "clever", "big ounce"};
    public String[] hardWords = {"specially", "women", "catastrophic"};


    public HangmanController(){
        _model = new HangmanModel();
        _scan = new Scanner(System.in);
        _random = new Random();
    }

    public void start() {
        //HangmanView.printWelcome();
        HangmanView.gameRules();
        _scan.nextLine();
        chooseDifficulty();
        getRandomWord();
        createCharArrayFromWord();
        createUnknownCharArrayFromWord();
        playGame();
    }

    public void playGame(){
        System.out.println("Let the game begin!");
        while (true){
            System.out.println("Enter a word or a letter to guess");
            _model.setUserInput(_scan.nextLine());

            isInputChar();
            if (_model.getIsChar() == false){
                checkStringInputRandomWord();
            }
            else{
                checkCharValidInput();
            }


        }

    }

    private void checkCharValidInput() {
        if (randomWordCharList.contains(_model.getUserInput().charAt(0))){ //Checks if the Arraylist contains user char
            System.out.println("The letter is contained in the secret word");//Confirms the above
            for (int i = 0; i < _model.getRandomWord().length(); i++){ //Loops through the randomWords letters.
                if (_model.getUserInput().charAt(0) == _model.getRandomWord().charAt(i)){ //If userChar is equal to randomWords char at i
                    unknownWordList.set(i, _model.getUserInput().charAt(0)); // Sets the index om the iteration to user
                    //char, if the above is.
                }
            }
            System.out.println(unknownWordList);

        }
    }

    private void checkStringInputRandomWord() {
        if (_model.getUserInput().equals(_model.getRandomWord())){
            System.out.println("Congratulations!...!...!");
        }
        else{
            System.out.println("Sorry, but that word is not correct!");
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
        switch (_model.get_difficulty()){
            case 1:
                System.out.println("Difficulty " + _model.get_difficulty() + " has been chosen.");
                System.out.println("Easy word has been chosen!");
                break;
            case 2:
                System.out.println("Difficulty " + _model.get_difficulty() + " has been chosen.");
                break;
            case 3:
                System.out.println("Difficulty " + _model.get_difficulty() + " has been chosen.");
                break;
            default:
                System.out.println("invalid");
        }
    }

    private void getRandomWord(){
        switch (_model.get_difficulty()){
            case 1:
                _model.setRandomWord(easyWords[_random.nextInt(easyWords.length)]);
                System.out.println(_model.getRandomWord());
                break;
            case 2:
                _model.setRandomWord(normalWords[_random.nextInt(normalWords.length)]);
                System.out.println(_model.getRandomWord());
                break;
            case 3:
                _model.setRandomWord(hardWords[_random.nextInt(hardWords.length)]);
                System.out.println(_model.getRandomWord());
                break;
        }
    }

    private void createCharArrayFromWord(){
        for (int i = 0; i<_model.getRandomWord().length(); i++){
            randomWordCharList.add(_model.getRandomWord().charAt(i));
        }
        System.out.println(randomWordCharList);
    }

    private void createUnknownCharArrayFromWord(){
        for (int i = 0;i < _model.getRandomWord().length();i++){
            unknownWordList.add('_');
        }
        System.out.println(unknownWordList);
    }




}
