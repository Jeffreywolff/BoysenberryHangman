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

        }

    }

    private void isInputChar() {
        if (_model.getUserInput().length() > 1){
            //Check if the word is randomWord
            System.out.println(_model.getUserInput().length());
        }
        else if (_model.getUserInput().length() == 1){
            // Check if letter is found in randomWordCharList
            System.out.println("Is Char?");
        }
    }


    public void chooseDifficulty() {
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

    public void getRandomWord(){
        switch (_model.get_difficulty()){
            case 1:
                _model.setrandomWord(easyWords[_random.nextInt(easyWords.length)]);
                System.out.println(_model.getrandomWord());
                break;
            case 2:
                _model.setrandomWord(normalWords[_random.nextInt(normalWords.length)]);
                System.out.println(_model.getrandomWord());
                break;
            case 3:
                _model.setrandomWord(hardWords[_random.nextInt(hardWords.length)]);
                System.out.println(_model.getrandomWord());
                break;
        }
    }

    public void createCharArrayFromWord(){
        for (int i = 0; i<_model.getrandomWord().length(); i++){
            randomWordCharList.add(_model.getrandomWord().charAt(i));
        }
        System.out.println(randomWordCharList);
    }

    public void createUnknownCharArrayFromWord(){
        for (int i = 0;i < _model.getrandomWord().length();i++){
            unknownWordList.add('_');
        }
        System.out.println(unknownWordList);
    }




}
