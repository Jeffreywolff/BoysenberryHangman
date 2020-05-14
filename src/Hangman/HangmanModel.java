package Hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class HangmanModel {




    private String _listChosen;

    public void set_listChosen(String list){
        this._listChosen = list;
    }

    public String get_listChosen(){
        return _listChosen;
    }

    private int _difficulty;

   // public void createList() throws FileNotFoundException {
 //       Scanner listScanner = new Scanner(new File(_listChosen));
//
  //      while (listScanner.hasNextLine()){
    //        gameWordsList.add((listScanner.nextLine()));
      //  }
    //}

    public int get_difficulty(){
        return this._difficulty;
    }

    public void set_difficulty(int num){
        this._difficulty = num;
    }

    private int _randomNumber;

    public void set_randomNumber(int num){
        this._randomNumber = num;
    }

    public int get_randomNumber(){
        return _randomNumber;
    }

    private String randomWord;

    public void setrandomWord(String word){
        this.randomWord = word;
    }

    public String getrandomWord(){
        return randomWord;
    }

    private String userInput;

    public String getUserInput(){
        return userInput;
    }

    public void setUserInput(String input){
        this.userInput = input;
    }

    private boolean isChar;

    public boolean getIsChar(){
        return isChar;
    }

    public void setIsChar(boolean state){
        this.isChar = state;
    }


    private int failedGuess;

    public int getFailedGuess(){
        return failedGuess;
    }

    public void setFailedGuess(int guess){
        this.failedGuess = guess;
    }
}
