package a.martindeguise.apprendsavecmoi;


/**
 * Created by martin on 10/03/2018.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class Word{

    private String word = "", secretWord = "";
    private char[] tabChar;
    private int error = 0;
    private int nbreCoup = 0;

    public Word(){
        initWord();
    }

    public void initWord(){

        int i = (int)(Math.random() * 100000);
        while(i > 336529){
            i /= 2;
        }

        try {
            LineNumberReader fnr = new LineNumberReader(new FileReader(new File("dictionnaire.txt")));
            int carac;
            this.word = "";
            this.secretWord= "";
            while((carac = fnr.read()) != -1){
                if(fnr.getLineNumber() == (i+1))
                    break;

                else{
                    if(fnr.getLineNumber() == i){
                        this.word += (char)carac;
                    }
                }
            }

            this.word = this.word.trim().toUpperCase();

            for(int j = 0; j < this.word.length(); j++)
            {
                this.secretWord += (this.word.charAt(j) != '\'' && this.word.charAt(j) != '-') ? "*" : this.word.charAt(j);
            }

            fnr.close();
            this.nbreCoup = 0;
        } catch (FileNotFoundException e) {
            System.out.println("Erreur de chargement depuis le fichier de mots !");
        } catch (IOException e) {
            System.out.println("Erreur de chargement depuis le fichier de mots !");        }

        this.tabChar = this.secretWord.toCharArray();
        this.error = 0;
    }

    public int verifyWord(char c){

        boolean bok = false;

        for(int i = 0; i < this.word.length(); i++){

            if(this.word.toUpperCase().charAt(i) == c){
                this.tabChar[i] = c;
                bok = true;
            }
        }
        ++this.nbreCoup;
        this.secretWord = new String(this.tabChar);
        System.out.println("Mot secret = " + this.word);
        return (bok == true) ? 1 : -1;
    }

    public int verifyWord(char[] tc){

        boolean bok = false;

        for(char c : tc)
        {
            for(int i = 0; i < this.word.length(); i++){

                if(this.word.toUpperCase().charAt(i) == c){
                    this.tabChar[i] = c;
                    System.out.println("OK !");
                    bok = true;
                }
            }
        }
        ++this.nbreCoup;
        this.secretWord = new String(this.tabChar);
        System.out.println("Mot secret = " + this.word);

        return (bok == true) ? 1 : -1;
    }

    public boolean isFinished(){

        for(char c : this.tabChar){
            if(c == '*')
                return false;
        }
        return true;
    }

    public String getWord() {
        return word;
    }

    public String getSecretWord() {
        return secretWord;
    }

    public int getNombreErreur(){
        return this.error;
    }

    public void setNombreErreur(int nbre){
        this.error = nbre;
    }

    public int getNombreCoup() {
        return nbreCoup;
    }
}