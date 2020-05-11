package Hangman;

import java.util.Scanner;

public class HangmanController {

    private HangmanModel _model;
    private Scanner _scan;

    public HangmanController(){
        _model = new HangmanModel();
        _scan = new Scanner(System.in);

    }

    public void start(){
        HangmanView.printWelcome();
        HangmanView.gameRules();
        System.out.println("Press 'Enter' to continue");
        _scan.nextLine();
        playGame();
    }

    public void playGame(){
        HangmanView.printDifficulty();
        _model.set_Difficulty(_scan.nextInt());
        switch(_model.get_Difficulty()){
            case 1:

        }
    }



}
