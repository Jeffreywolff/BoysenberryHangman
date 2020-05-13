package Hangman;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class HangmanController {

    private HangmanModel _model;
    private Scanner _scan;
    private Random _random;
    public ArrayList<String> gameEasyWordsList = new ArrayList<String>();
    public String[] easyWords = {"cars", "neon", "hello", "shark"};
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
        System.out.println("Press 'Enter' to continue");
        _scan.nextLine();
        chooseDifficulty();
        getRandomWord();
    }

    public void playGame(){


    }


    public void chooseDifficulty() {
        HangmanView.printDifficulty();
        _model.set_difficulty(_scan.nextInt());
        switch (_model.get_difficulty()){
            case 1:
                //_model.set_listChosen("EasyWordsList.txt");

                System.out.println("Difficulty " + _model.get_difficulty() + " has been chosen.");
                System.out.println("Easy word has been chosen!");
            case 2:
                //_model.set_listChosen("NormalWordsList.txt");
                System.out.println("Difficulty " + _model.get_difficulty() + " has been chosen.");

            case 3:
                //_model.set_listChosen("HardWordsList.txt");
                System.out.println("Difficulty " + _model.get_difficulty() + " has been chosen.");

        }
    }


    public void getRandomWord(){
        switch (_model.get_difficulty()){
            case 1:
                _model.set_randomWord(easyWords[_random.nextInt(easyWords.length)]);
                System.out.println(_model.get_randomWord());
            case 2:
                _model.set_randomWord(normalWords[_random.nextInt(normalWords.length)]);
            case 3:
                _model.set_randomWord(hardWords[_random.nextInt(hardWords.length)]);
        }
    }




}
